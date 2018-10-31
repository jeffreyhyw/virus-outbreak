package object;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JLabel;
import javax.swing.JTable;

public class Game {
	//Initialize variables
	private String virusName;
	private String bornCountry;
	
    private boolean endGame = false;
    private final int totalNumberOfDays = 10;
    private int day = 0;
    private int msBetweenDay = 1000; // Millisecond until next day
    private Calendar calendar = Calendar.getInstance();
	private SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    private String currentDate = "";  // new date
    public MainTableModel mainTableModel;
    public Thread gameThread;
    public boolean gameStop = false;
    private final AtomicBoolean running = new AtomicBoolean(false);
    public static ArrayList<Country> countries = new ArrayList<Country>();
    
    //UI Components
    //Main UI
    public JLabel mainCurrentDateLabel, mainFinDateLabel, mainTitleLabel, 
    			  totalInfectLabel, totalDeathLabel; 
    public JTable mainInfoTable; 
    
    
    //Functions
    public Game() {
    	setCurrentDate(getTodayDate());
    }
    
    /* For UI */
    public void setLabel(JLabel label, String text) {
    	try {
    		label.setText(text);
    	} catch (Exception e) {
    		System.out.println("Exception from Game.setLabel: " + e);
    	}
    }
    
    //Change Infect / Death number
    public void updateMainCountryVal(String countryName, String colName, int val)
    {
    	int row = getRowByCountryName(countryName);
    	int col = getColByColName(colName);
    	
    	if(row != -1 && col != -1) 
    	{
        	mainInfoTable.getModel().setValueAt(val, row, col);
    	}
    }
    
    /* For Virus */
	public String getVirusName() {
		return virusName;
	}
	
	public void setVirusName(String virusName) {
		this.virusName = virusName;
	}
	
	/* For Countries */
	public void initCountries() {
		Country c;
		c = new Country("America", 327508189);
		countries.add(c);
		
		c = new Country("Beligum", 11498519);
		countries.add(c);
		
		c = new Country("China", 1416818963);
		countries.add(c);
		
		c = new Country("Denmark", 5754356);
		countries.add(c);
		
		c = new Country("Egypt", 99375741);
		countries.add(c);
		
		c = new Country("France", 65233271);
		countries.add(c);
		
		c = new Country("Germany", 82353077);
		countries.add(c);
		
		c = new Country("Hong Kong", 7450269);
		countries.add(c);
		
		c = new Country("India", 1354051854);
		countries.add(c);
		
		c = new Country("Japan", 127086134);
		countries.add(c);
		
		c = new Country("Sweden", 10006742);
		countries.add(c);
		
		c = new Country("Thailand", 69231623);
		countries.add(c);
	}
	
	public String getBornCountry() {
		return bornCountry;
	}

	public void setBornCountry(String bornCountry) {
		this.bornCountry = bornCountry;
	}
	
	//Get the sum of dead people for all countries
	public int getTotalDeathPopulation() {
		int tmpTotalDeathPop = 0;
		for (Country c : countries) {
		   tmpTotalDeathPop += c.getDeathPopulation();
		}
		return tmpTotalDeathPop;
	}
	
	//Get the sum of dead people for all countries
	public int getTotalInfectedPopulation() {
		int tmpTotalInfectPop = 0;
		for (Country c : countries) {
			tmpTotalInfectPop += c.getInfectedPopulation();
		}
		return tmpTotalInfectPop;
	}
	
	public int getRowByCountryName(String name) {
		int i=0;
		for (Country c : countries) {
			if(name == c.getName())
			{
				return i;
			}
			i++;
		}
		return -1;
	}
	
	public int getColByColName(String name) {
		//"Country","Infect","Death" must be the same as the att array in Main 
		if(name == "Country")
		{
			return 0;
		}
		else if(name == "Infect")
		{
			return 1;
		}
		else if(name == "Death")
		{
			return 2;
		}
		else 
		{
			return -1;
		}
	}
	
	
	/* For Game System */
	public void initGameObjects() {
		//Create Countries
		initCountries();
		mainTableModel = new MainTableModel(countries);
	}
	
	public int getMsBetweenDay() {
		return msBetweenDay;
	}

	public AtomicBoolean getGameRunning() {
		return running;
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
		return formatDate.format(calendar.getTime());
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar cal) {
		this.calendar = cal;
	}
	
	//Add n days to current date
	public void addDayToCalendar(int n) {
		//Store number of day passed
    	setDay(getDay() + n);
    	
    	//Store the current date
		calendar.add(Calendar.DATE, n);
		setCurrentDate(formatDate.format(calendar.getTime()));  
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
	
	public static ArrayList<Country> getCountries(){
		return countries;
	}

	public void pauseGame() {
		running.set(false);
	}
	
	public void resumeGame() {
		running.set(true);
		gameThread.interrupt();
	}


	
	
	
    
    
}
