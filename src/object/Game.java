package object;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JLabel;
import javax.swing.JTable;

public class Game {
	//Initialize variables
	private String virusName;
    private boolean endGame = false;
    private final int totalNumberOfDays = 300;
    private int day = 0;
    private int msBetweenDay = 1500; // Millisecond until next day
    private Calendar cal = Calendar.getInstance();
	private SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    private String currentDate = "";  // new date
    public MainTableModel mainTableModel = new MainTableModel();
    public Thread gameThread;
    public boolean gameStop = false;
    private final AtomicBoolean running = new AtomicBoolean(false);
    
    //UI Components
    public JLabel mainCurrentDateLabel, mainFinDateLabel; 
    public JTable mainInfoTable; 
    
    
    //Functions
    public Game() {
    	setCurrentDate(getTodayDate());
    }
    
	public String getVirusName() {
		return virusName;
	}
	
	public void setVirusName(String virusName) {
		this.virusName = virusName;
	}
	
	public boolean isEndGame() {
		return endGame;
	}
	
	public void setEndGame(boolean endGame) {
		this.endGame = endGame;
	}
	
	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public int getTotalNumberOfDays() {

		return totalNumberOfDays;
	}
	
	//Get the real date of today
	public String getTodayDate() {
		return formatDate.format(cal.getTime());
	}

	public Calendar getCal() {
		return cal;
	}

	public void setCal(Calendar cal) {
		this.cal = cal;
	}
	
	//Add n days to current date
	public void addDayToCalendar(int n) {
		//Store number of day passed
    	setDay(getDay() + n);
    	
    	//Store the current date
		cal.add(Calendar.DATE, n);
		setCurrentDate(formatDate.format(cal.getTime()));  
	}
	
	//Get the current date in game
	public String getCurrentDate() {

		return currentDate;
	}

	public String getEndGameDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, getTotalNumberOfDays());
		return formatDate.format(cal.getTime());
	}
	
	//Set the current date in game
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public void pauseGame() {
		running.set(false);
	}
	
	public void resumeGame() {
		running.set(true);
		gameThread.interrupt();
	}
	
	//The game logic
	public void gameStart() {
		running.set(true);

		//Use thread to run so the loop won't block the UI
		gameThread = new Thread(new Runnable() {
		    @Override
		    public void run() {    
		    	
	    		 //Loop for each day
		        while (!isEndGame()) {
		        	
		        	//Check if game is paused
		        	 if(!running.get()) {
			        	try {
				             System.out.println("Game Paused");
				             Thread.sleep(999999);
			        		 
			            } catch (InterruptedException ex) {
			                 //handle the exception
			            	 Thread.currentThread().interrupt();
			                 System.out.println("Game Resumed");
			            }
			        }
		        	
					//Sleep for 1 second before going to next day			
		        	try{
		        		Thread.sleep(msBetweenDay);
		    		}catch(InterruptedException ex){
		    		  //do stuff
		    		}
		        	
		        	
		        	//Update the current date in main panel
		        	try {
		        		mainCurrentDateLabel.setText("Current Date: " + getCurrentDate());
		        		//getEndGameDate()
		        	} catch (Exception e) {
		        		
		        	}
		        	
		        	
		        	if(getDay() == 5)
		        	{
		        		mainInfoTable.getModel().setValueAt("10", 0, 1);
		        	}
		        	
		        	//Increment 1 day
					addDayToCalendar(1); 
					
	      	
		        	//Check if the game has ended
		        	if(getDay() > getTotalNumberOfDays())
		        	{
		        		setEndGame(true);
		        	}
		        }
		        
		       
		    	
		       
		    }
		});  
		gameThread.start();
		
	}
    
    
}
