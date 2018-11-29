package test.object;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.*;

import object.Country;
import object.CountryClimate;
import object.Game;
import object.Virus;
import object.VirusAbility;
import object.VirusSymptom;
import object.VirusTransmission;

public class TestGame {
    private SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    private Calendar calendar = Calendar.getInstance();
    Game t_Game1;
    
    /**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@setUpBeforeClass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@tearDownAfterClass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("@setUp");
		t_Game1 = new Game();
		t_Game1.initGameObjects();
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("@tearDown");
	}    
	
	/**
	 * Test method for getCurrentDate
	 */
    @Test
    public void testGetCurrentDate() {
    	String expectedResult = formatDate.format(calendar.getTime());
    	String result = t_Game1.getCurrentDate();
    	assertEquals(expectedResult,result);
    }
    
    /**
	 * Test method for getCountryByName
	 */
    @Test
    public void testGetConuntryByName1() {
    	Country e_c = new Country("Hong Kong", 7450269, 0.9, CountryClimate.Wet);
    	assertEquals(e_c.getName(),t_Game1.getCountryByName("Hong Kong").getName());
    }
    
    /**
	 * Test method for getCountryByName (Null)
	 */
    @Test
    public void testGetConuntryByName2() {
    	assertNull(t_Game1.getCountryByName("BlackWater"));
    }
    
    /**
	 * Test method for getSelectedRowCountryName
	 */
    @Test
    public void testGetSelectedRowCountryName() {
    	String expectedResult = "Hong Kong";
    	t_Game1.setSelectedRowCountryName(expectedResult);
    	String result = t_Game1.getSelectedRowCountryName();
    	assertEquals(expectedResult,result);
    }
    
    /**
	 * Test method for SetSelectedRowCountryName
	 */
    @Test
    public void testSetSelectedRowCountryName() {
    	String expectedResult = "Hong Kong";
    	t_Game1.setSelectedRowCountryName(expectedResult);
    	String result = t_Game1.getSelectedRowCountryName();
    	assertEquals(expectedResult,result);
    }
    
    /**
   	 * Test method for initVirus
   	 */
    @Test
    public void testInitVirus() {
       	Game t_Game2 = new Game();
       	t_Game2.initVirus();
       	//assertEquals(t_Game1.getVirus(),t_Game2.getVirus());
       	assertEquals(t_Game1.getVirus().getName(),t_Game2.getVirus().getName());
       	//assertTrue(t_Game2.getVirus().getTransmissionList().equals(t_Game1.getVirus().getTransmissionList()));
       	
    }
    
    /**
   	 * Test method for infectOtherCountryProbability when no update;
   	 */
    @Test
    public void testInfectOtherCountryProbability1() {
       	double expectedResult = 0;
       	//assertThat(t_Game1.infectOtherCountryProbability(),greaterThan(0) );
       	assertEquals(expectedResult,t_Game1.infectOtherCountryProbability());
    }
    
    /**
   	 * Test method for infectOtherCountryProbability when updated;
   	 */
    @Test
    public void testInfectOtherCountryProbability2() {
       	double prob;
       	boolean result = false;
       	for (VirusTransmission vt : t_Game1.getVirus().getTransmissionList()) {
       		vt.upLevel();;
        }
       	for (VirusAbility va : t_Game1.getVirus().getAbilityList()) {
            va.upLevel();
        }
       	prob = t_Game1.infectOtherCountryProbability();
       	if(prob > 0)
       		result = true;
       	assertTrue(result);
       	
    }
    
    /**
   	 * Test method for getVirusName;
   	 */
    @Test
    public void testGetVirusName() {
       	String expectedResult = "name";
       	assertEquals(expectedResult,t_Game1.getVirusName());
    }
    
    /**
   	 * Test method for setVirusName;
   	 */
    @Test
    public void testSetVirusName() {
       	String expectedResult = "T-Virus";
       	t_Game1.setVirusName("T-Virus");
       	assertEquals(expectedResult,t_Game1.getVirusName());
    }
    
    /**
   	 * Test method for setVirus;
   	 */
    @Test
    public void testSetVirus() {
    	ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("Rodent", "<html>Factors Affecting the Transmission of Rodent Ultrasounds in Natural Environments.</html>", 0.15, ""));
            add(new VirusTransmission("Air I", "<html>Airborne transmission occurs when bacteria or viruses travel on dust particles.</html>", 0.2, ""));
            add(new VirusTransmission("Air II", "<html>Power up the air transimission.</html>", 0.3, "Air I"));
            add(new VirusTransmission("Water I", "<html>Water transmission occurs from water pollution.</html>", 0.2, ""));
            add(new VirusTransmission("Water II", "<html>Power up the water transimission.</html>", 0.3, "Water II"));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("Nausea", "<html>Nausea is pronounced stomach discomfort and the sensation of wanting to vomit.</html>", 0.1, 0.6));
            add(new VirusSymptom("Coughing", "<html>A cough is a common reflex action that clears the throat of mucus or foreign irritants.</html>", 0.2, 0.8));
            add(new VirusSymptom("Cysts", "<html>A cyst is a sac-like pocket of membranous tissue that contains fluid, air, or other substances.</html>", 0.15, 0.4));
            add(new VirusSymptom("Insomnia", "<html>Insomnia can be caused by psychiatric and medical conditions, unhealthy sleep habits, specific substances, and/or certain biological factors.</html>", 0, 0.6));
            add(new VirusSymptom("Rash", "<html>A rash is a change of the human skin which affects its color, appearance, or texture. </html>", 0.15, 0.4));
            add(new VirusSymptom("Anaemia", "<html>Anaemia is a condition in which the blood has a decreased number of red blood cells.</html>", 0, 0.5));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("Cold Resistance I", "<html>The virus can alive at cold environment.</html>", CountryClimate.Cold));
            add(new VirusAbility("Heat Resistance I", "<html>The virus can alive at hot environment.</html>", CountryClimate.Hot));
            add(new VirusAbility("Bacterial Resilience I", "<html>Make the virus stronger.</html>", CountryClimate.Wet));
            add(new VirusAbility("Drug Resistance I", "<html>Increase the alive rate facing the research increasing.</html>", CountryClimate.Dry));
        }};
        
        Virus t_Virus = new Virus("testingVirus", transmissionList, symptomList, abilityList);
        
       	t_Game1.setVirus(t_Virus);
       	assertEquals(t_Virus,t_Game1.getVirus());
    }
    
    /**
   	 * Test method for getVirus;
   	 */
    @Test
    public void testGetVirus() {
    	ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("Rodent", "<html>Factors Affecting the Transmission of Rodent Ultrasounds in Natural Environments.</html>", 0.15, ""));
            add(new VirusTransmission("Air I", "<html>Airborne transmission occurs when bacteria or viruses travel on dust particles.</html>", 0.2, ""));
            add(new VirusTransmission("Air II", "<html>Power up the air transimission.</html>", 0.3, "Air I"));
            add(new VirusTransmission("Water I", "<html>Water transmission occurs from water pollution.</html>", 0.2, ""));
            add(new VirusTransmission("Water II", "<html>Power up the water transimission.</html>", 0.3, "Water II"));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("Nausea", "<html>Nausea is pronounced stomach discomfort and the sensation of wanting to vomit.</html>", 0.1, 0.6));
            add(new VirusSymptom("Coughing", "<html>A cough is a common reflex action that clears the throat of mucus or foreign irritants.</html>", 0.2, 0.8));
            add(new VirusSymptom("Cysts", "<html>A cyst is a sac-like pocket of membranous tissue that contains fluid, air, or other substances.</html>", 0.15, 0.4));
            add(new VirusSymptom("Insomnia", "<html>Insomnia can be caused by psychiatric and medical conditions, unhealthy sleep habits, specific substances, and/or certain biological factors.</html>", 0, 0.6));
            add(new VirusSymptom("Rash", "<html>A rash is a change of the human skin which affects its color, appearance, or texture. </html>", 0.15, 0.4));
            add(new VirusSymptom("Anaemia", "<html>Anaemia is a condition in which the blood has a decreased number of red blood cells.</html>", 0, 0.5));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("Cold Resistance I", "<html>The virus can alive at cold environment.</html>", CountryClimate.Cold));
            add(new VirusAbility("Heat Resistance I", "<html>The virus can alive at hot environment.</html>", CountryClimate.Hot));
            add(new VirusAbility("Bacterial Resilience I", "<html>Make the virus stronger.</html>", CountryClimate.Wet));
            add(new VirusAbility("Drug Resistance I", "<html>Increase the alive rate facing the research increasing.</html>", CountryClimate.Dry));
        }};
        
        Virus t_Virus = new Virus("testingVirus", transmissionList, symptomList, abilityList);
        
       	t_Game1.setVirus(t_Virus);
       	assertEquals(t_Virus,t_Game1.getVirus());
    }
    
    /**
     * Test method for initCountries
     */
    @Test
    public void testinitCountries() {
    	t_Game1.initCountries();
    	assertNotNull(t_Game1.getCountries());
    }
    
    
    /**
     * Test method for getTotalDeathPopulation
     */
    @Test
    public void testGetTotalDeathPopulation() {
    	long expectedResult = 0;
    	for (Country c : t_Game1.getCountries()) {
    		c.addDeathPopulation(1);
    		expectedResult += c.getDeathPopulation();
        }
    	assertEquals(expectedResult, t_Game1.getTotalDeathPopulation());
    }
    
   
    /**
     * Test method for getWorldTotalPopulation
     */
    @Test
    public void testGetWorldTotalPopulation() {
    	
    	class StubTGameV3 extends Game{
    		public void initCountries() {
    			countries = new ArrayList<Country>() {{
    	            add(new Country("America", 32700, 0.8, CountryClimate.Cold));
    	            add(new Country("Beligum", 11400, 0.5, CountryClimate.Dry));
    	            add(new Country("China", 13000, 0.4, CountryClimate.Wet));
    	            add(new Country("Hong Kong", 700, 0.9, CountryClimate.Wet));    	            
    	        }};
    		}

    	}
    	StubTGameV3 t_Game3 = new StubTGameV3();
    	t_Game3.initGameObjects();
    	long expectedResult = 32700+11400+13000+700;
    	//System.out.println("t_Game3.worldTotalPopulation : " + t_Game3.getWorldTotalPopulation());
    	assertEquals(expectedResult, t_Game3.getWorldTotalPopulation());
    	
    }   
    
    
    /**
     * Test method for checkHalfPopulationDead (only few dead)
     */
    @Test
    public void testCheckHalfPopulationDead1() {
    	assertFalse(t_Game1.checkHalfPopulationDead());
    }
    
    /**
     * Test method for isHalfPopulationDead (only few dead)
     */
    @Test
    public void testIsHalfPopulationDead1() {
    	assertFalse(t_Game1.isHalfPopulationDead());
    }
    
    /**
     * Test method for checkHalfPopulationDead (only many dead)
     */
    @Test
    public void testCheckHalfPopulationDead2() {
    	for (Country c : t_Game1.getCountries()) {
    		c.addInfectedPopulation(999999999);
    		c.addDeathPopulation(999999999);
        }
    	//System.out.println("TotalDeathPopulation : " + t_Game1.getTotalDeathPopulation() + " WorldTotalPopulation() / 2" + t_Game1.getWorldTotalPopulation() / 2);
    	assertTrue(t_Game1.checkHalfPopulationDead());
    }
    
    /**
     * Test method for isHalfPopulationDead (only many dead)
     */
    @Test
    public void testIsHalfPopulationDead2() {
    	t_Game1.setHalfPopulationDead(true);
    	assertTrue(t_Game1.isHalfPopulationDead());
    }
    
    /**
     * Test method for checkHalfPopulationInfected (False)
     */
    @Test
    public void testCheckHalfPopulationInfected1() {
    	assertFalse(t_Game1.checkHalfPopulationInfected());
    }  
        
    /**
     * Test method for checkHalfPopulationInfected (True)
     */
    @Test
    public void testCheckHalfPopulationInfected2() {
    	class StubTGameV3 extends Game{
    		public void initCountries() {
    			countries = new ArrayList<Country>() {{
    	            add(new Country("America", 32700, 0.8, CountryClimate.Cold));
    	            add(new Country("Beligum", 11400, 0.5, CountryClimate.Dry));
    	            add(new Country("China", 13000, 0.4, CountryClimate.Wet));
    	            add(new Country("Hong Kong", 700, 0.9, CountryClimate.Wet));    	            
    	        }};
    		}

    	}
    	StubTGameV3 t_Game4 = new StubTGameV3();
    	t_Game4.initGameObjects();
    	for (Country c : t_Game4.getCountries()) {
    		c.addInfectedPopulation(999999999);
    		c.addDeathPopulation(999999999);
        }
    	assertTrue(t_Game4.checkHalfPopulationInfected());
    }  
        
    /**
	 * Test method for shouldResearchStart
	 */
    @Test
    public void testShouldResearchStart1() {
    	assertFalse(t_Game1.shouldResearchStart());
    }
    
    /**
	 * Test method for shouldResearchStart(True)
	 */
    @Test
    public void testShouldResearchStart2() {
    	class StubTGameV3 extends Game{
    		public void initCountries() {
    			countries = new ArrayList<Country>() {{
    	            add(new Country("America", 32700, 0.8, CountryClimate.Cold));
    	            add(new Country("Beligum", 11400, 0.5, CountryClimate.Dry));
    	            add(new Country("China", 13000, 0.4, CountryClimate.Wet));
    	            add(new Country("Hong Kong", 700, 0.9, CountryClimate.Wet));    	            
    	        }};
    		}    		
    	}
    	StubTGameV3 t_Game5 = new StubTGameV3();
    	t_Game5.initGameObjects();
    	for (Country c : t_Game5.getCountries()) {
    		c.addInfectedPopulation(999999999);
    		c.addDeathPopulation(999999999);
        }
    	assertTrue(t_Game5.shouldResearchStart());
    }
    
    /**
	 * Test method for isHalfPopulationInfected
	 */
    @Test
    public void testIsHalfPopulationInfected() {
    	assertFalse(t_Game1.isHalfPopulationInfected());
    }
    
    /**
	 * Test method for setHalfPopulationInfected(True)
	 */
    @Test
    public void testSetHalfPopulationInfected() {
    	t_Game1.setHalfPopulationInfected(true);
    	assertTrue(t_Game1.isHalfPopulationInfected());
    }
    
    /**
	 * Test method for Born Country
	 */
    @Test
    public void testBornCountry() {
    	String expectedResult = "Hong Kong";
    	t_Game1.setBornCountry(expectedResult);
    	assertEquals(expectedResult,t_Game1.getBornCountry());
    }
	
    /**
	 * Test method for getHighestInfectCountry(True)
	 */
    @Test
    public void testGetHighestInfectCountry() {
    	Country expectedResult = new Country("Beligum", 11400, 0.5, CountryClimate.Dry);
    	Country fakeResult = new Country("Hong Kong", 700, 0.9, CountryClimate.Wet);
    	class StubTGameV3 extends Game{
    		public void initCountries() {
    			countries = new ArrayList<Country>() {{
    	            add(new Country("America", 32700, 0.8, CountryClimate.Cold));
    	            add(expectedResult);
    	            add(new Country("China", 13000, 0.4, CountryClimate.Wet));
    	            add(fakeResult);    	            
    	        }};
    		}    		
    	}
    	StubTGameV3 t_Game6 = new StubTGameV3();
    	t_Game6.initGameObjects();
    	t_Game6.getCountryByName("Beligum").addInfectedPopulation(9000);    	
    	t_Game6.getCountryByName("Hong Kong").addInfectedPopulation(500);
    	assertEquals(expectedResult,t_Game6.getHighestInfectCountry());
    }
    
    /**
	 * Test method for gettUninfectedCountries
	 */
    @Test
    public void testGetUninfectedCountries() {
    	 ArrayList<Country> expectedResult = new ArrayList<Country>();
    	Country c1 = new Country("Beligum", 11400, 0.5, CountryClimate.Dry);
    	Country c2 = new Country("Hong Kong", 700, 0.9, CountryClimate.Wet);
    	Country c3 = new Country("America", 32700, 0.8, CountryClimate.Cold);
    	Country c4 = new Country("China", 13000, 0.4, CountryClimate.Wet);
    	expectedResult.add(c3);
    	expectedResult.add(c4);
    	class StubTGameV3 extends Game{
    		public void initCountries() {
    			countries = new ArrayList<Country>() {{
    	            add(c3);
    	            add(c1);
    	            add(c4);
    	            add(c2);    	            
    	        }};
    		}    		
    	}
    	StubTGameV3 t_Game6 = new StubTGameV3();
    	t_Game6.initGameObjects();
    	t_Game6.getCountryByName("Beligum").addInfectedPopulation(9000);    	
    	t_Game6.getCountryByName("Hong Kong").addInfectedPopulation(500);
    	assertThat(expectedResult,is(t_Game6.getUninfectedCountries()));
    }
    
    /**
   	 * Test method for getRowByCountryName (found)
   	 */
    @Test
    public void testGetRowByCountryName1() {
    	int expectedResult = 0;
    	assertEquals(expectedResult,t_Game1.getRowByCountryName("America"));
    }
    
    /**
   	 * Test method for getRowByCountryName (found)
   	 */
    @Test
    public void testGetRowByCountryName2() {
    	int expectedResult = -1;
    	assertEquals(expectedResult,t_Game1.getRowByCountryName("SinCity"));
    }
    
    /**
   	 * Test method for getColByColName (country)
   	 */
    @Test
    public void testGetColByColName1() {
    	int expectedResult = 0;
    	assertEquals(expectedResult,t_Game1.getColByColName("Country"));
    }
    
    /**
   	 * Test method for getColByColName (Infect)
   	 */
    @Test
    public void testGetColByColName2() {
    	int expectedResult = 1;
    	assertEquals(expectedResult,t_Game1.getColByColName("Infect"));
    }
    
    /**
   	 * Test method for getColByColName (Infect)
   	 */
    @Test
    public void testGetColByColName3() {
    	int expectedResult = 2;
    	assertEquals(expectedResult,t_Game1.getColByColName("Death"));
    }
    
    /**
   	 * Test method for getColByColName (default)
   	 */
    @Test
    public void testGetColByColName4() {
    	int expectedResult = -1;
    	assertEquals(expectedResult,t_Game1.getColByColName("default"));
    }
    
    /**
   	 * Test method for getMsBetweenDay (default)
   	 */
    @Test
    public void testGetMsBetweenDay() {
    	int expectedResult = 1000;
    	assertEquals(expectedResult,t_Game1.getMsBetweenDay());
    }
    
    /**
   	 * Test method for EndGame
   	 */
    @Test
    public void testIsEndGame() {
    	t_Game1.setEndGame(false);
    	assertFalse(t_Game1.isEndGame());
    }
    
    /**
   	 * Test method for Day
   	 */
    @Test
    public void testGetDay() {
    	t_Game1.setDay(36);
    	assertEquals(36,t_Game1.getDay());
    }
    
    /**
   	 * Test method for TotalNumberOfDays
   	 */
    @Test
    public void testGetTotalNumberOfDays() {
    	assertEquals(520,t_Game1.getTotalNumberOfDays());
    }
    
    /**
   	 * Test method for Calendar
   	 */
    @Test
    public void testCalendar() {
    	Calendar expectedResult = Calendar.getInstance();
    	t_Game1.setCalendar(expectedResult);
    	t_Game1.addDayToCalendar(1);
    	assertEquals(expectedResult,t_Game1.getCalendar());
    }
    
    
    /**
   	 * Test method for getEndGameDate
   	 */
    @Test
    public void testGetEndGameDate() {
    	Calendar expectedResult = Calendar.getInstance();
    	t_Game1.setCalendar(expectedResult);
    	expectedResult.add(Calendar.DATE, 520);
    	assertEquals(formatDate.format(expectedResult.getTime()),t_Game1.getEndGameDate());
    }
    
    /**
   	 * Test method for upgradePointGainPerDay
   	 */
    @Test
    public void testUpgradePointGainPerDay() {
    	int expectedResult = 1;
    	assertEquals(expectedResult,t_Game1.upgradePointGainPerDay());
    }
    
    /**
   	 * Test method for upgradePoint
   	 */
    @Test
    public void testUpgradePoint() {
    	int expectedResult = 121;
    	t_Game1.calUpgradePoint(0,1);    	
    	//System.out.println("Point: " + t_Game1.getUpgradePoint());
    	assertEquals(expectedResult,t_Game1.getUpgradePoint());
    }
    
    /**
   	 * Test method for upgradePoint (Pay cost)
   	 */
    @Test
    public void testUpgradePoint2() {
    	int expectedResult = 119;
    	t_Game1.calUpgradePoint(3,1);    	
    	//System.out.println("Point: " + t_Game1.getUpgradePoint());
    	assertEquals(expectedResult,t_Game1.getUpgradePoint());
    }
    
    
}
