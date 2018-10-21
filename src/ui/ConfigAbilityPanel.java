package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import object.VirusAttribute;


public class ConfigAbilityPanel {
	public JComponent makeTextPanel() {
        JPanel panel = new JPanel(false);
//        JLabel filler = new JLabel("Ability Panel");
//        filler.setHorizontalAlignment(JLabel.CENTER);
//        panel.setLayout(new GridLayout(1, 1));
        generateAbilityContent(panel);
//        panel.add(filler);
        return panel;
    }
	public void generateAbilityContent(JPanel mainPanel) {
		ArrayList<VirusAttribute> att_list = new ArrayList<VirusAttribute>();
		att_list.add(new VirusAttribute("att_1_name", 1, "att_1_decription"));
		att_list.add(new VirusAttribute("att_2_name", 1, "att_2_decription"));
		att_list.add(new VirusAttribute("att_3_name", 1, "att_3_decription"));
		att_list.add(new VirusAttribute("att_4_name", 1, "att_4_decription"));
		att_list.add(new VirusAttribute("att_5_name", 1, "att_5_decription"));
		
		
		JPanel configurePanel = new JPanel();
        configurePanel.setLayout(new BoxLayout(configurePanel, BoxLayout.PAGE_AXIS));
//        configurePanel.add(Box.createRigidArea(new Dimension(0,15)));
        
        for(int i = 0; i < att_list.size(); i ++) {
        		JPanel att_panel = new JPanel();
        		att_panel.add(new JLabel(att_list.get(i).getAtt_name()));
        		
        		JLabel levelLabel = new JLabel("Level " + att_list.get(i).getLevel());
        		levelLabel.setName("label"+i);
        		att_panel.add(levelLabel);
        		
        		JButton upLevelBtn = new JButton("+");
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
        		    				att_list.get(pos).setLevel(att_list.get(pos).getLevel() + 1);
        		    				((JLabel)att_panel.getComponent(k)).setText("Level " + att_list.get(pos).getLevel());
        		    				break;
        		    			}
        		    		}
        		    }
					
        		});
        		att_panel.add(upLevelBtn);
        		configurePanel.add(att_panel);
        }


        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.X_AXIS));
        
        JPanel resumPanel = new JPanel();
        JLabel resumLabel = new JLabel("jlabel");
        resumPanel.add(resumLabel);

        JPanel virusNamePanel = new JPanel();
        JLabel virusName = new JLabel("virusName");
        virusNamePanel.add(virusName);

        JPanel backButtonPanel = new JPanel();
        JButton backButton = new JButton("Back");
        backButtonPanel.add(backButton);
        
        descriptionPanel.add(resumPanel);
        descriptionPanel.add(virusNamePanel);
        descriptionPanel.add(backButtonPanel);
        

        // The container panel.
        JPanel containerPanel = new JPanel(new BorderLayout());
        containerPanel.add(configurePanel, BorderLayout.WEST);
        containerPanel.add(descriptionPanel,  BorderLayout.SOUTH);

        mainPanel.add(containerPanel);
        
        // Show it.
//        JFrame t = new JFrame("Button Layout Demo");
//        t.setContentPane(containerPanel);
//        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        t.setSize(400, 240);
//        t.setVisible(true);
		
	}
}
