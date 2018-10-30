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
import object.Game;
import object.VirusAbility;
import object.VirusTransmission;

public class ConfigTransmissionPanel {
	
	ArrayList<VirusTransmission> att_list;
	final int full_width = 960;
	final int details_height = 120;
	final int details_item_width = 320;
	final int scrollView_width = 760;
	final int scrollView_height = 410;
	final int configureView_width = 760;
	final int configureView_height = 50;
	final int att_name_field_width = 250;
	final int att_cost_field_width = 100;
	final int att_level_field_width = 150;
	final int att_add_field_width = 100;
	final int att_info_field_width = 100;
	final int descriptionView_width = 200;
	final int descriptionView_height = 410;
	
	int curr_cost = 100;
	JLabel descriptionLabel;
	JLabel currcostLabel;
	JLabel virusName;
	

	public static Game game;
	
	public JComponent makeTextPanel(Game gm) {
		game = gm;
		generateDate();
        JPanel panel = new JPanel(false);
//        JLabel filler = new JLabel("Transmission Panel");
//        filler.setHorizontalAlignment(JLabel.CENTER);
//        panel.setLayout(new GridLayout(1, 1));
        generateTransmissionContent(panel);
//        panel.add(filler);
        return panel;
    }
	
	void generateDate() {
		att_list = new ArrayList<VirusTransmission>();
		att_list.add(new VirusTransmission("att_1_name", 1, "att_1_decription",30));
		att_list.add(new VirusTransmission("att_2_name", 1, "att_2_decription",30));
		att_list.add(new VirusTransmission("att_3_name", 1, "att_3_decription",30));
		att_list.add(new VirusTransmission("att_4_name", 1, "att_4_decription",30));
		att_list.add(new VirusTransmission("att_5_name", 1, "att_5_decription",30));
		att_list.add(new VirusTransmission("att_6_name", 1, "att_6_decription",30));
		att_list.add(new VirusTransmission("att_7_name", 1, "att_7_decription",30));
		att_list.add(new VirusTransmission("att_8_name", 1, "att_8_decription",30));
		att_list.add(new VirusTransmission("att_9_name", 1, "att_9_decription",30));
		att_list.add(new VirusTransmission("att_10_name", 1, "att_10_decription",30));
		att_list.add(new VirusTransmission("att_11_name", 1, "att_11_decription",30));
		att_list.add(new VirusTransmission("att_12_name", 1, "att_12_decription",30));
		att_list.add(new VirusTransmission("att_13_name", 1, "att_13_decription",30));
		att_list.add(new VirusTransmission("att_14_name", 1, "att_14_decription",30));
		att_list.add(new VirusTransmission("att_15_name", 1, "att_15_decription",30));
		att_list.add(new VirusTransmission("att_16_name", 1, "att_16_decription",30));
		att_list.add(new VirusTransmission("att_17_name", 1, "att_17_decription",30));
	}
	
	void generateConfigureTitle(JPanel configurePanel) {
		JPanel title_panel = new JPanel();
		title_panel.setPreferredSize(new Dimension(configureView_width, configureView_height));
		JLabel name_title_label = new JLabel("Attributes Name");
		name_title_label.setPreferredSize(new Dimension(att_name_field_width, configureView_height));
		JLabel cost_title_label = new JLabel("Cost");
		cost_title_label.setPreferredSize(new Dimension(att_cost_field_width, configureView_height));
		JLabel level_title_label = new JLabel("Level");
		level_title_label.setPreferredSize(new Dimension(att_level_field_width, configureView_height));
		JLabel upLevel_title_label = new JLabel("Up Level");
		upLevel_title_label.setPreferredSize(new Dimension(att_add_field_width, configureView_height));
		JLabel info_title_label = new JLabel("Info");
		info_title_label.setPreferredSize(new Dimension(att_info_field_width, configureView_height));
		title_panel.add(name_title_label);
		title_panel.add(cost_title_label);
		title_panel.add(level_title_label);
		title_panel.add(upLevel_title_label);
		title_panel.add(info_title_label);
		configurePanel.add(title_panel);
	}
	
	void updateCurrCost() {
		currcostLabel.setText("Current Cost : " + curr_cost);
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
      		    				if(curr_cost - att_list.get(pos).getCost() < 0) {
      		    					System.out.println("No enough Cost");
      		    					break;
      		    				}
      		    				else {
      		    					curr_cost = curr_cost - att_list.get(pos).getCost();
      		    					updateCurrCost();
      		    					att_list.get(pos).setLevel(att_list.get(pos).getLevel() + 1);
          		    				((JLabel)att_panel.getComponent(k)).setText("Level " + att_list.get(pos).getLevel());
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
        updateCurrCost();
        resumPanel.add(currcostLabel);
        resumPanel.setPreferredSize(new Dimension(details_item_width, details_height));

        JPanel virusNamePanel = new JPanel();
        virusName = new JLabel("virusName");
        virusNamePanel.add(virusName);
        virusNamePanel.setPreferredSize(new Dimension(details_item_width, details_height));

        JPanel backButtonPanel = new JPanel();
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
  		    @Override
  		    public void actionPerformed(ActionEvent e) {
  		    		EventQueue.invokeLater(new Runnable() {
				    @Override
				    public void run() {
				    		MainController.frame.getContentPane().removeAll();
						MainController.frame.getContentPane().add(GameStart.createAndShowGUI(game));
						MainController.frame.revalidate();
						MainController.frame.repaint();
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
		descriptionLabel = new JLabel("Description", SwingConstants.CENTER);
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
