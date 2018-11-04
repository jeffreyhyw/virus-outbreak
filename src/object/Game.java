package object;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JLabel;
import javax.swing.JTable;

public class Game {
	//Initialize variables
	private String bornCountry;
	
    private boolean endGame = false;
    private final int totalNumberOfDays = 300;
    private int day = 0;
    private int msBetweenDay = 1000; // Millisecond until next day
    private Calendar calendar = Calendar.getInstance();
	private SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    private String currentDate = "";  // new date
    public MainTableModel mainTableModel;
    public Thread gameThread;
    public boolean gameStop = false;
    private final AtomicBoolean running = new AtomicBoolean(false);
    private ArrayList<Country> countries = new ArrayList<Country>();
    private Virus virus;
    private boolean halfPopulationDead = false;
    private boolean halfPopulationInfected = false;
    private int evoPoint = 30;
    public boolean newGame = true;
    
    private String selectedRowCountryName = "";
    
    //UI Components
    //Main UI
    public JLabel mainCurrentDateLabel, mainFinDateLabel, mainTitleLabel, 
    			  totalInfectLabel, totalDeathLabel,
    			  totalCountryPopLabel, totalInfectedLabel, totalDeathPopLabel, worldTotalPopulation,
    			  evoPointLabel, researchLabel; 
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

	public Country getCountryByName(String name) {
		for (Country c : countries) {
		   if(c.getName() == name)
		   {
			   return c;
		   }
		}
		return null;
	}
    
    public String getSelectedRowCountryName() {
		return selectedRowCountryName;
	}

	public void setSelectedRowCountryName(String selectedRowCountryName) {
		this.selectedRowCountryName = selectedRowCountryName;
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
    public void initVirus() {
    	ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>();
		ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>();
		ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>();
		
		//tmp
		transmissionList.add(new VirusTransmission("Rodent", 2, "description", 0.15, 0,30));
		transmissionList.add(new VirusTransmission("Air I", 2, "description", 0.1, 0,30));
		transmissionList.add(new VirusTransmission("Air II", 2, "description", 0.25, 0,30));
		transmissionList.add(new VirusTransmission("Water I", 2, "description", 0.1, 0,30));
		transmissionList.add(new VirusTransmission("Water II", 2, "description", 0.25, 0,30));
		
		symptomList.add(new VirusSymptom("Nausea", 3, "description", 0.1, 0.15, 30, false));
		symptomList.add(new VirusSymptom("Coughing", 3, "description", 0.2, 0.1, 30, false));
		symptomList.add(new VirusSymptom("Cysts", 3, "description", 0.15, 0.15, 30, false));
		symptomList.add(new VirusSymptom("Insomnia", 3, "description", 0, 0.15, 30, false));
		symptomList.add(new VirusSymptom("Rash", 3, "description", 0.15, 0.05, 30, false));
		symptomList.add(new VirusSymptom("Anaemia", 3, "description", 0, 0.05, 30, false));
		

		
    	
    	virus = new Virus("name", transmissionList, symptomList, abilityList);
    }
    
    public double infectOtherCountryProbability() {
    	
    	double infectionProbability = 0; 
    	
    	for (VirusTransmission vt : virus.getTransmissionList()) {
    		infectionProbability += vt.getInfectionRate() * vt.getLevel();
 		}
    	for (VirusAbility va : virus.getAbilityList()) {
    		infectionProbability += va.getInfectionRate() * va.getLevel();
 		}
    	
    	//Half the probability to prevent it spreading too fast
    	return infectionProbability / 45;
    }
    
	public String getVirusName() {
		return virus.getName();
	}
	
	public void setVirusName(String virusName) {
		virus.setName(virusName); 
	}
	
	public Virus getVirus() {
		return virus;
	}

	public void setVirus(Virus virus) {
		this.virus = virus;
	}

	
	/* For Countries */
	public void initCountries() {
		Country c;
		c = new Country("America", 327508189);
		c.setMedicalSystem(0.9);
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
	
	public boolean checkHalfPopulationDead() {
		if(getTotalDeathPopulation() >= (getWorldTotalPopulation() / 2))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public boolean isHalfPopulationDead() {
		return halfPopulationDead;
	}

	public void setHalfPopulationDead(boolean halfPopulationDead) {
		this.halfPopulationDead = halfPopulationDead;
	}
	
	public boolean checkHalfPopulationInfected() {
		if(getTotalInfectedPopulation() >= (getWorldTotalPopulation() / 2))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean isHalfPopulationInfected() {
		return halfPopulationInfected;
	}

	public void setHalfPopulationInfected(boolean halfPopulationInfected) {
		this.halfPopulationInfected = halfPopulationInfected;
	}

	public String getBornCountry() {
		return bornCountry;
	}

	public void setBornCountry(String bornCountry) {
		this.bornCountry = bornCountry;
	}
	
	public long getWorldTotalPopulation() {
		long sum = 0;
		for (Country c : countries) {
			sum += c.getPopulation();
		}
		return sum;
	}
	
	//Get the sum of dead people for all countries
	public long getTotalDeathPopulation() {
		long tmpTotalDeathPop = 0;
		for (Country c : countries) {
		   tmpTotalDeathPop += c.getDeathPopulation();
		}
		return tmpTotalDeathPop;
	}
	
	//Get the sum of dead people for all countries
	public long getTotalInfectedPopulation() {
		long tmpTotalInfectPop = 0;
		for (Country c : countries) {
			tmpTotalInfectPop += c.getInfectedPopulation();
		}
		return tmpTotalInfectPop;
	}
	
	public ArrayList<Country> getUninfectedCountries() {
		ArrayList<Country> uninfectedCountries = new ArrayList<Country>();
		for (Country c : countries) {
		   if(c.getInfectedPopulation() < 1)
		   {
			   uninfectedCountries.add(c);
		   }
		}
		return uninfectedCountries;
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
		
		//Create the virus
		initVirus();
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
	
	public ArrayList<Country> getCountries(){
		return countries;
	}

	public void pauseGame() {
		running.set(false);
	}
	
	public void resumeGame() {
		running.set(true);
		gameThread.interrupt();
	}
	
	public void addEvoPoint(int point) {
		this.evoPoint += point;
	}

	public void deleteEvoPoint(int point) {
		this.evoPoint -= point;
	}

	
	
	
    
    
}
