package controller;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import object.Game;
import ui.GameStart;
import ui.Main;
import ui.VirusConfigMainPanel;

public class MainController {
	
	//Initialize variable
	public static JFrame frame;
	
	public static void main(String[] args) {
		//Create game object
		 Game game = new Game();
		

		//Schedule a job for the event dispatch thread:
        //creating and showing config application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            	 //Create and set up the window.
                frame = new JFrame("Virus Outbreak");
                int height = 540;
                int width = 960;

                // set the jframe height and width
                frame.setPreferredSize(new Dimension(width, height));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                
                //Game start Panel
                JPanel panel = GameStart.createAndShowGUI(game);

                //Add content to the window
                frame.add(panel , BorderLayout.CENTER);
                
                //Display the window.
                frame.pack();
                frame.setVisible(true);
                
            }
        });

	}
	
	

}
