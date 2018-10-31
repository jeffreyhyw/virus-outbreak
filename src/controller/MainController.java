package controller;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import object.Country;
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
		    		
		    		//Infect the first country
		    		game.updateMainCountryVal(game.getBornCountry(), "Infect", 1);
		    		
		    		
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
		        	for (Country c : game.getCountries()) {
		        		
		    			//Only infect countries with > 1 infected people
		        		if(c.getInfectedPopulation() > 0) 
		        		{
		        			game.updateMainCountryVal(c.getName(), "Infect", game.getVirus().getInfectPerDay(c));
		        		}
		        		
		        		
		    		}
		        	
		        	
		        	//Pick a random country to infect 1 people
		        	int sizeOfUnifectCountries = game.getUninfectedCountries().size();
		        	if(sizeOfUnifectCountries > 0)
		        	{
			        	Random r = new Random();
			        	int index = 0;
			        	if(sizeOfUnifectCountries != 1) 
			        	{
			        		index = r.nextInt(game.getUninfectedCountries().size() - 1);
			        	}
			    		double chance = Math.random();
			    		if(chance < game.infectOtherCountryProbability()) 
			    		{
			    			Country c = game.getUninfectedCountries().get(index);
			    			c.addInfectedPopulation(1);
			    			game.setLabel(game.mainTitleLabel, game.getVirusName() + " has started to spread in " + c.getName());
			    		}
			    		print("chance: " + chance + ", " + " prob: " + game.infectOtherCountryProbability());
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
