package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
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
import object.VirusSymptom;

public class ConfigSymptomPanel{
	
	ArrayList<VirusSymptom> symptom_list;
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
//        JLabel filler = new JLabel("Symptom Panel");
//        filler.setHorizontalAlignment(JLabel.CENTER);
//        panel.setLayout(new GridLayout(1, 1));
        generateSymptomContent(panel);

		System.out.println("ConfigSymptomPanel");
//        panel.add(filler);
        return panel;
    }
	
	void generateDate() {
		virusNameStr = game.getVirusName();
		symptom_list = game.getVirus().getSymptomList();
	}
	
	void generateConfigureTitle(JPanel configurePanel) {
		JPanel title_panel = new JPanel();
		title_panel.setPreferredSize(new Dimension(configureView_width, configureView_height));
		
		String label_arr [] = { Constants.att_name, Constants.cost, Constants.status, Constants.up_lv, Constants.info };
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
      
		for(int i = 0; i < symptom_list.size(); i ++) {
      		JPanel att_panel = new JPanel();
      		att_panel.setPreferredSize(new Dimension(configureView_width, configureView_height));
      		
      		JLabel att_name_label = new JLabel(symptom_list.get(i).getAtt_name());
      		att_name_label.setPreferredSize(new Dimension(att_name_field_width, configureView_height));
      		att_panel.add(att_name_label);
      		
      		JLabel cost_label = new JLabel(""+symptom_list.get(i).getCost());
      		cost_label.setPreferredSize(new Dimension(att_cost_field_width, configureView_height));
      		att_panel.add(cost_label);
      		
      		JLabel statusLabel;
      		if(symptom_list.get(i).getStatus()) {
      			statusLabel = new JLabel(Constants.researched);
      		}else {
      			statusLabel = new JLabel("X");
      		}
      		statusLabel.setName("label"+i);
      		statusLabel.setPreferredSize(new Dimension(att_level_field_width, configureView_height));
      		att_panel.add(statusLabel);
      		
      		JButton upLevelBtn = new JButton("+");
      		upLevelBtn.setPreferredSize(new Dimension(att_add_field_width, configureView_height));
      		upLevelBtn.setName("" + i);
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
      		    				if(game.getUpgradePoint() - symptom_list.get(pos).getCost() < 0) {
      		    					System.out.println(Constants.no_enough_cost);
      		    					break;
      		    				}
      		    				else {
      		    					game.calUpgradePoint(1, symptom_list.get(pos).getCost());
      		    					game.updateCurrentPoint();
      		    					symptom_list.get(pos).setStatus(true);
      		    					symptom_list.get(pos).setResearched(true);
      		    					
      		    					if(symptom_list.get(pos).getStatus()) {
      		    						((JLabel)att_panel.getComponent(k)).setText(Constants.researched);
      		    						((JButton) e.getSource()).setEnabled(false);
      		    		      		}
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
      		    				descriptionLabel.setText(symptom_list.get(pos).getDescription());
      		    			}
      		    		}
      		    }
      		});
      		if(!symptom_list.get(i).getStatus()) {
      			upLevelBtn.setEnabled(true);
      		}else {
      			upLevelBtn.setEnabled(false);
      		}
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
        game.setSymptom_currcostLabel(currcostLabel);
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
				    }
				});
  		    }
  		});
        backButtonPanel.add(backButton);
        backButtonPanel.setPreferredSize(new Dimension(details_item_width, details_height));
        
        backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
				    @Override
				    public void run() {
				    	MainController.frame.getContentPane().removeAll();
						MainController.frame.getContentPane().add(Main.createAndShowGUI(game));
						MainController.frame.revalidate();
						
						//resume the game
						game.resumeGame();
				    }
				});
			}
		});
        
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
	
	public void generateSymptomContent(JPanel mainPanel) {
		
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
	}

}
