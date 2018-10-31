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
	static Game game;
	
	public static void main(String[] args) {
		//Create game object
		 game = new Game();
		

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
                
        		//Initialize game objects
        		game.initGameObjects();

                //Create game start UI
                JPanel panel = GameStart.createAndShowGUI(game);


                //Add content to the window
                frame.add(panel , BorderLayout.CENTER);
                
                //Display the window.
                frame.pack();
                frame.setVisible(true);

            }
        });

	}
	
	//The game logic
	public static void gameStart() {
		game.getGameRunning().set(true);

		//Use thread to run so the loop won't block the UI
		game.gameThread = new Thread(new Runnable() {
		    @Override
		    public void run() {    
		    	
		    	//Delay a bit so the UI is initialized
		    	try {
		    		Thread.sleep(1000);
		    		game.setLabel(game.mainTitleLabel, game.getVirusName() + " has started to spread in " + game.getBornCountry());
	        	} catch (Exception e) {}
		    	
		    	
	    		 //Loop for each day
		        while (!game.isEndGame()) {
		        	
		        	//Check if game is paused/resumed
		        	if(!game.getGameRunning().get()) {
			        	try {
				             System.out.println("Game Paused");
				             Thread.sleep(999999);
			        		 
			            } catch (InterruptedException ex) {
			            	 Thread.currentThread().interrupt();
			                 System.out.println("Game Resumed");
			            }
			        }
		        	
					//Sleep for 1 second before going to next day			
		        	try{
		        		Thread.sleep(game.getMsBetweenDay());
		    		} catch(InterruptedException ex){}
		        	
		        	
		        	//Update the current date in main panel
		        	game.setLabel(game.mainCurrentDateLabel, "Current Date: " + game.getCurrentDate());
		   
		        	//Killing, Infecting logic etc...
		        	//Testing logic
		        	if(game.getDay() == 2)
		        	{
		        		game.updateMainCountryVal("Hong Kong", "Infect", 100);
		        	}
		        	
		        	if(game.getDay() == 4)
		        	{
		        		game.updateMainCountryVal("Hong Kong", "Infect", 100);
		        		game.updateMainCountryVal("Hong Kong", "Death", 10);
		        		game.updateMainCountryVal("China", "Infect", 150);
		        	}
		        	
		        	if(game.getDay() == 6)
		        	{
		        		game.updateMainCountryVal("Hong Kong", "Infect", 100);
		        		game.updateMainCountryVal("Hong Kong", "Death", 10);
		        		game.updateMainCountryVal("China", "Infect", 150);
		        		game.updateMainCountryVal("Chian", "Death", 50);
		        	}
		        	
		        	//Summary for today
		        	game.setLabel(game.totalInfectLabel, "Total Infect: " + game.getTotalInfectedPopulation());
		        	game.setLabel(game.totalDeathLabel, "Total Death: " + game.getTotalDeathPopulation());
		        	
		        	//Increment 1 day
		        	game.addDayToCalendar(1); 
		        					
	      	
		        	//Check if the game has ended
		        	if(game.getDay() > game.getTotalNumberOfDays())
		        	{
		        		game.setLabel(game.mainTitleLabel, "Game Over");
		        		game.setEndGame(true);
		        	}
		        }
		    }
		});  
		game.gameThread.start();
		
	}
	
	//Print
	public static void print(Object o) 
	{
		System.out.println(o);
	}
	

}
