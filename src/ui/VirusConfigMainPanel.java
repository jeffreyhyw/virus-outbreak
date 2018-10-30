package ui;


import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import controller.MainController;
import object.Game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

public class VirusConfigMainPanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6208462680830995778L;


	public VirusConfigMainPanel(Game gm) {
        super(new GridLayout(1, 1));
        
        JTabbedPane tabbedPane = new JTabbedPane();
        UIFactory uiFactory = new UIFactory();
        uiFactory.game = gm;
        
        //Add the panel into tab
        try {
            JComponent panel = uiFactory.makePanel("symptom");
            tabbedPane.addTab("Symptoms", null, panel,"Does nothing");
            tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        } catch (Exception e) {
        	System.out.println(e);
        }
        
        //Add the panel into tab
        try {
        	JComponent panel = uiFactory.makePanel("transmission");
            tabbedPane.addTab("Transmission", null, panel,"Does nothing");
            tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        } catch (Exception e) {
        	System.out.println(e);
        }
        
        //Add the panel into tab
        try {
            JComponent panel = uiFactory.makePanel("ability");
            tabbedPane.addTab("Ability", null, panel,"Does nothing");
            tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
        } catch (Exception e) {
        	System.out.println(e);
        }
        
        //Add the tabbed pane to this panel.
        add(tabbedPane);
        
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }
    

    /** Returns an ImageIcon, or null if the path was invalid. */
//    protected static ImageIcon createImageIcon(String path) {
//        java.net.URL imgURL = VirusConfigMainPanel.class.getResource(path);
//        if (imgURL != null) {
//            return new ImageIcon(imgURL);
//        } else {
//            System.err.println("Couldn't find file: " + path);
//            return null;
//        }
//    }
    //
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from
     * the event dispatch thread.
     */
    public static JPanel createAndShowGUI(Game game) {
    	
    	/*
        //Create and set up the window.
        JFrame frame = new JFrame("Virus Outbreak");
        
        int height = 540;
        int width = 960;

        // set the jframe height and width
        frame.setPreferredSize(new Dimension(width, height));
     
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Add content to the window.
        frame.add(new VirusConfigMainPanel(), BorderLayout.CENTER);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        */
    	return new VirusConfigMainPanel(game);
    }
    
}