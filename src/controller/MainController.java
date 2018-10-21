package controller;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import ui.Main;
import ui.VirusConfigMainPanel;

public class MainController {
	
	public static void main(String[] args) {
	

		//Schedule a job for the event dispatch thread:
        //creating and showing config application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            	//For testing your UI
            	 //Create and set up the window.
                JFrame frame = new JFrame("Virus Outbreak");
                int height = 540;
                int width = 960;

                // set the jframe height and width
                frame.setPreferredSize(new Dimension(width, height));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                //Change new JPanel() to the UI class you want to try
                JPanel panel = Main.createAndShowGUI();
                
                //Add content to the window
                frame.add(panel , BorderLayout.CENTER);
                
                //Display the window.
                frame.pack();
                frame.setVisible(true);

            }
        });
	}

}