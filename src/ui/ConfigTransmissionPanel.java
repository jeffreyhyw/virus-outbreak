package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import controller.MainController;
import object.Constants;
import object.Game;
import object.VirusAbility;
import object.VirusTransmission;

public class ConfigTransmissionPanel {
	
	ArrayList<VirusTransmission> att_list;
	final int full_width = Constants.full_width;
	final int details_height = Constants.details_height;
	final int details_item_width = Constants.details_item_width;
	final int scrollView_width = Constants.scrollView_width;
	final int scrollView_height = Constants.scrollView_height;
	final int configureView_width = Constants.configureView_width;
	final int configureView_height = Constants.configureView_height;
	final int att_name_field_width = Constants.att_name_field_width;
	final int att_cost_field_width = Constants.att_cost_field_width;
	final int att_level_field_width = Constants.att_level_field_width;
	final int att_add_field_width = Constants.att_add_field_width;
	final int att_info_field_width = Constants.att_info_field_width;
	final int descriptionView_width = Constants.descriptionView_width;
	final int descriptionView_height = Constants.descriptionView_height;
	
	JLabel descriptionLabel;
	JLabel currcostLabel;
	JLabel virusName;
	String virusNameStr;
	

	public static Game game;
	
	public JComponent makeTextPanel(Game gm) {
		game = gm;
		generateDate();
        JPanel panel = new JPanel(false);
//        JLabel filler = new JLabel("Transmission Panel");
//        filler.setHorizontalAlignment(JLabel.CENTER);
//        panel.setLayout(new GridLayout(1, 1));
        generateTransmissionContent(panel);
		System.out.println("ConfigTransmissionPanel");
//        panel.add(filler);
        return panel;
    }
	
	void generateDate() {
		virusNameStr = game.getVirusName();
		att_list = game.getVirus().getTransmissionList();
	}
	
	void generateConfigureTitle(JPanel configurePanel) {
		JPanel title_panel = new JPanel();
		title_panel.setPreferredSize(new Dimension(configureView_width, configureView_height));
		
		String label_arr [] = { Constants.att_name, Constants.cost, Constants.lv, Constants.up_lv, Constants.info };
		int widths [] = { att_name_field_width, att_cost_field_width, att_level_field_width, att_add_field_width, att_info_field_width };
		
		for(int i = 0; i < label_arr.length; i ++) {
			JLabel label = new JLabel(label_arr[i]);
			label.setPreferredSize(new Dimension(widths[i], configureView_height));
			title_panel.add(label);
		}
		
		configurePanel.add(title_panel);
	}
	
	void generateConfigurePanel(JPanel configurePanel) {
		configurePanel.setLayout(new BoxLayout(configurePanel, BoxLayout.PAGE_AXIS));
		generateConfigureTitle(configurePanel);
      
		for(int i = 0; i < att_list.size(); i ++) {
      		JPanel att_panel = new JPanel();
      		att_panel.setPreferredSize(new Dimension(configureView_width, configureView_height));
      		
      		JLabel att_name_label = new JLabel(att_list.get(i).getAtt_name());
      		att_name_label.setPreferredSize(new Dimension(att_name_field_width, configureView_height));
      		att_panel.add(att_name_label);
      		
      		JLabel cost_label = new JLabel(""+att_list.get(i).getCost());
      		cost_label.setPreferredSize(new Dimension(att_cost_field_width, configureView_height));
      		att_panel.add(cost_label);
      		
      		JLabel levelLabel = new JLabel("Level " + att_list.get(i).getLevel());
      		levelLabel.setName("label"+i);
      		levelLabel.setPreferredSize(new Dimension(att_level_field_width, configureView_height));
      		att_panel.add(levelLabel);
      		
      		JButton upLevelBtn = new JButton("+");
      		upLevelBtn.setPreferredSize(new Dimension(att_add_field_width, configureView_height));
      		upLevelBtn.setName("" + i);
      		if(att_list.get(i).getLevel() >= 5) {
      			upLevelBtn.setEnabled(false);
      		}
      		upLevelBtn.addActionListener(new ActionListener() {
      		    @Override
      		    public void actionPerformed(ActionEvent e) {
      		    		JButton o = (JButton)e.getSource();
      		    		String checkLabelName = "label" + o.getName();
      		        //your actions
      		    		for(int k = 0; k < att_panel.getComponentCount(); k ++) {
      		    			if(att_panel.getComponent(k).getName() == null) {
      		    				continue;
      		    			}
      		    			else if(att_panel.getComponent(k).getName().equals(checkLabelName)) {
      		    				int pos = Integer.parseInt(o.getName());
      		    				if(!att_list.get(pos).checkLevel()) {
      		    					System.out.println("Max Level");
      		    				}
      		    				else if(game.getUpgradePoint() - att_list.get(pos).getCost() < 0) {
      		    					System.out.println("No enough Cost");
      		    				}
      		    				else if(!att_list.get(pos).getReferenAttName().equals("")) {
      		    					for(int q = 0; q < att_list.size(); q ++) {
      		    						if(att_list.get(q).getAtt_name().equals(att_list.get(pos).getReferenAttName())) {
      		    							if(att_list.get(q).getLevel() != 5) {
      		    								System.out.println("Please Upgrade the Preview Transmission first");
      		    							}
      		    							else {
      		    								game.calUpgradePoint(1, att_list.get(pos).getCost());
      		      		    					att_list.get(pos).setResearched(true);
      		      		    					game.updateCurrentPoint();
      		      		    					att_list.get(pos).upLevel();
      		          		    				((JLabel)att_panel.getComponent(k)).setText("Level " + att_list.get(pos).getLevel());
      		          		    				if(att_list.get(pos).getLevel() >= 5)
      		          		    	      			upLevelBtn.setEnabled(false);
      		          		    				break;
      		    							}
      		    						}
      		    					}
      		    				}
      		    				else {
      		    					game.calUpgradePoint(1, att_list.get(pos).getCost());
      		    					att_list.get(pos).setResearched(true);
      		    					game.updateCurrentPoint();
      		    					att_list.get(pos).upLevel();
          		    				((JLabel)att_panel.getComponent(k)).setText("Level " + att_list.get(pos).getLevel());
          		    				if(att_list.get(pos).getLevel() >= 5)
          		    	      			upLevelBtn.setEnabled(false);
          		    				break;
      		    				}
      		    			}
      		    		}
      		    }
      		});
      		
      		JButton infoBtn = new JButton("Info");
      		infoBtn.setPreferredSize(new Dimension(att_info_field_width, configureView_height));
      		infoBtn.setName("" + i);
      		infoBtn.addActionListener(new ActionListener() {
      		    @Override
      		    public void actionPerformed(ActionEvent e) {
      		    		JButton o = (JButton)e.getSource();
      		    		String checkLabelName = "label" + o.getName();
      		        //your actions
      		    		for(int k = 0; k < att_panel.getComponentCount(); k ++) {
      		    			if(att_panel.getComponent(k).getName() == null) {
      		    				continue;
      		    			}
      		    			else if(att_panel.getComponent(k).getName().equals(checkLabelName)) {
      		    				int pos = Integer.parseInt(o.getName());
      		    				descriptionLabel.setText(att_list.get(pos).getDescription());
      		    			}
      		    		}
      		    }
      		});
      		
      		att_panel.add(upLevelBtn);
      		att_panel.add(infoBtn);
      		configurePanel.add(att_panel);
      }
	}
	void generateDetailsPanel(JPanel detailsPanel) {
		detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.X_AXIS));
        detailsPanel.setPreferredSize(new Dimension(full_width, details_height));
        detailsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        JPanel resumPanel = new JPanel();
        currcostLabel = new JLabel("", SwingConstants.CENTER);
        currcostLabel.setVerticalAlignment(SwingConstants.CENTER);
        currcostLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resumPanel.add(currcostLabel);
        resumPanel.setPreferredSize(new Dimension(details_item_width, details_height));
        game.setTransmission_currcostLabel(currcostLabel);
        game.updateCurrentPoint();

        JPanel virusNamePanel = new JPanel();
        virusName = new JLabel(virusNameStr);
        virusNamePanel.add(virusName);
        virusNamePanel.setPreferredSize(new Dimension(details_item_width, details_height));

        JPanel backButtonPanel = new JPanel();
        JButton backButton = new JButton(Constants.back);
        backButton.addActionListener(new ActionListener() {
  		    @Override
  		    public void actionPerformed(ActionEvent e) {
  		    		EventQueue.invokeLater(new Runnable() {
				    @Override
				    public void run() {
				    		MainController.frame.getContentPane().removeAll();
						MainController.frame.getContentPane().add(Main.createAndShowGUI(game));
						MainController.frame.revalidate();
						MainController.frame.repaint();
						
						//resume the game
						game.resumeGame();
				    }
				});
  		    }
  		});
        backButtonPanel.add(backButton);
        backButtonPanel.setPreferredSize(new Dimension(details_item_width, details_height));
        
        detailsPanel.add(resumPanel);
        detailsPanel.add(virusNamePanel);
        detailsPanel.add(backButtonPanel);
        
	}
	void generateDescriptionPanel(JPanel descriptionPanel) {
		descriptionLabel = new JLabel(Constants.desc, SwingConstants.CENTER);
		descriptionLabel.setVerticalAlignment(SwingConstants.CENTER);
		descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		descriptionPanel.add(descriptionLabel);
		descriptionPanel.setPreferredSize(new Dimension(descriptionView_width, descriptionView_height));
		descriptionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	void initDetails() {
		
	}
	
	public void generateTransmissionContent(JPanel mainPanel) {
		
		JPanel configurePanel = new JPanel();
		generateConfigurePanel(configurePanel);
//		configurePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JScrollPane scrollPane = new JScrollPane(configurePanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(50, 30, 300, 50);
        scrollPane.setPreferredSize(new Dimension(scrollView_width, scrollView_height));
		
		JPanel descriptionPanel = new JPanel(new BorderLayout());
		generateDescriptionPanel(descriptionPanel);
		

        JPanel detailsPanel = new JPanel();
        generateDetailsPanel(detailsPanel);

     // The container panel.
        JPanel containerPanel = new JPanel(new BorderLayout());
        containerPanel.add(scrollPane, BorderLayout.WEST);
        containerPanel.add(descriptionPanel, BorderLayout.EAST);
        containerPanel.add(detailsPanel,  BorderLayout.SOUTH);

        mainPanel.add(containerPanel);
        
        // Show it.
//        JFrame t = new JFrame("Button Layout Demo");
//        t.setContentPane(containerPanel);
//        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        t.setSize(400, 240);
//        t.setVisible(true);
		
	}
}
