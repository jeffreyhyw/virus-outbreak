package object;

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
    private final int totalNumberOfDays = 520;
    private int day = 0;
    private int msBetweenDay = 100; // Millisecond until next day
    private Calendar calendar = Calendar.getInstance();
    private SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    private String currentDate = "";  // new date
    public MainTableModel mainTableModel;
    public Thread gameThread;
    public boolean gameStop = false;
    private final AtomicBoolean running = new AtomicBoolean(false);
    private ArrayList<Country> countries;
    private Virus virus;
    private boolean halfPopulationDead = false;
    private boolean halfPopulationInfected = false;
    public boolean newGame = true;
    private int upgradePoint = 120;
    private long infectPerUpgradePoint = 5000000;
    private long prevInfect = 0;
    private long gainedInfectPop = 0;
    private long deadPerUpgradePoint = 100000;
    private long gainedDeathPop = 0;
    private Research research = new Research();

    private String selectedRowCountryName = "";

    //UI Components
    //Main UI
    public JLabel mainCurrentDateLabel, mainFinDateLabel, mainTitleLabel,
            totalInfectLabel, totalDeathLabel,
            totalCountryPopLabel, totalInfectedLabel, totalDeathPopLabel, worldTotalPopulation,
            evoPointLabel, researchLabel;
    public JTable mainInfoTable;

    public JLabel transmission_currcostLabel;
    public JLabel symptom_currcostLabel;
    public JLabel ability_currcostLabel;

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
            if (c.getName().equals(name)) {
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
    public void updateMainCountryVal(String countryName, String colName, int val) {
        int row = getRowByCountryName(countryName);
        int col = getColByColName(colName);

        if (row != -1 && col != -1) {
            mainInfoTable.getModel().setValueAt(val, row, col);
        }
    }

    /* For Virus */
    public void initVirus() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>(){{
            add(new VirusTransmission("Rodent", "description", 0.15));
            add(new VirusTransmission("Air I", "description", 0.2));
            add(new VirusTransmission("Air II", "description", 0.3));
            add(new VirusTransmission("Water I", "description", 0.2));
            add(new VirusTransmission("Water II", "description", 0.3));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>(){{
            add(new VirusSymptom("Nausea", "description", 0.1, 0.6));
            add(new VirusSymptom("Coughing", "description", 0.2, 0.8));
            add(new VirusSymptom("Cysts","description", 0.15, 0.4));
            add(new VirusSymptom("Insomnia", "description", 0, 0.6));
            add(new VirusSymptom("Rash", "description", 0.15, 0.4));
            add(new VirusSymptom("Anaemia",  "description", 0, 0.5));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>(){{
            add(new VirusAbility("Cold Resistance I", "description",0, CountryClimate.Cold));
            add(new VirusAbility("Heat Resistance I", "description",0, CountryClimate.Hot));
            add(new VirusAbility("Bacterial Resilience I", "description",15, CountryClimate.Wet));
            add(new VirusAbility("Drug Resistance I", "description", 25, CountryClimate.Dry));
        }};

        //tmp
//        transmissionList.add(new VirusTransmission("Rodent", 0, "description", 0.15, 0, 30));
//        transmissionList.add(new VirusTransmission("Air I", 0, "description", 0.2, 0, 30));
//        transmissionList.add(new VirusTransmission("Air II", 0, "description", 0.3, 0, 30));
//        transmissionList.add(new VirusTransmission("Water I", 0, "description", 0.2, 0, 30));
//        transmissionList.add(new VirusTransmission("Water II", 0, "description", 0.3, 0, 30));

//        symptomList.add(new VirusSymptom("Nausea", 0, "description", 0.1, 0.6, 30, false));
//        symptomList.add(new VirusSymptom("Coughing", 0, "description", 0.2, 0.8, 30, false));
//        symptomList.add(new VirusSymptom("Cysts", 0, "description", 0.15, 0.4, 30, false));
//        symptomList.add(new VirusSymptom("Insomnia", 0, "description", 0, 0.6, 30, false));
//        symptomList.add(new VirusSymptom("Rash", 0, "description", 0.15, 0.4, 30, false));
//        symptomList.add(new VirusSymptom("Anaemia", 0, "description", 0, 0.5, 30, false));

//        abilityList.add(new VirusAbility("Cold Resistance I", 0, "description", 0.05, 0, 0, CountryClimate.Cold, 30));
//        abilityList.add(new VirusAbility("Heat Resistance I", 0, "description", 0.05, 0, 0, CountryClimate.Hot, 30));
//        abilityList.add(new VirusAbility("Bacterial Resilience I", 0, "description", 0.05, 0, 15, CountryClimate.Wet, 30));
//        abilityList.add(new VirusAbility("Drug Resistance I", 0, "description", 0.05, 0, 25, CountryClimate.Dry, 30));

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
        return infectionProbability / 40;
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
        countries = new ArrayList<Country>(){{
            add(new Country("America", 327508189, 0.8, CountryClimate.Cold));
            add(new Country("Beligum", 11498519, 0.5,CountryClimate.Dry));
            add(new Country("China", 1416818963, 0.4, CountryClimate.Wet));
            add(new Country("Denmark", 5754356, 0.5,CountryClimate.Cold));
            add(new Country("Egypt", 99375741, 0.3, CountryClimate.Hot));
            add(new Country("France", 65233271, 0.7,CountryClimate.Cold));
            add(new Country("Germany", 82353077, 0.5, CountryClimate.Dry));
            add(new Country("Hong Kong", 7450269, 0.9,CountryClimate.Wet));
            add(new Country("India", 1354051854, 0.1, CountryClimate.Hot));
            add(new Country("Japan", 127086134, 0.8,CountryClimate.Cold));
            add(new Country("Sweden", 10006742, 0.5, CountryClimate.Cold));
            add(new Country("Thailand", 69231623, 0.6,CountryClimate.Hot));
        }};

//        Country c;
//        c = new Country("America", 327508189);
//        c.setMedicalSystem(0.8);
//        c.setClimate(CountryClimate.Cold);
//        countries.add(c);

//        c = new Country("Beligum", 11498519);
//        c.setClimate(CountryClimate.Dry);
//        countries.add(c);

//        c = new Country("China", 1416818963);
//        c.setClimate(CountryClimate.Wet);
//        c.setMedicalSystem(0.4);
//        countries.add(c);

//        c = new Country("Denmark", 5754356);
//        c.setClimate(CountryClimate.Cold);
//        countries.add(c);

//        c = new Country("Egypt", 99375741);
//        c.setClimate(CountryClimate.Hot);
//        c.setMedicalSystem(0.3);
//        countries.add(c);

//        c = new Country("France", 65233271);
//        c.setClimate(CountryClimate.Cold);
//        c.setMedicalSystem(0.7);
//        countries.add(c);

//        c = new Country("Germany", 82353077);
//        c.setClimate(CountryClimate.Dry);
//        countries.add(c);

//        c = new Country("Hong Kong", 7450269);
//        c.setClimate(CountryClimate.Wet);
//        c.setMedicalSystem(0.9);
//        countries.add(c);

//        c = new Country("India", 1354051854);
//        c.setClimate(CountryClimate.Hot);
//        c.setMedicalSystem(0.1);
//        countries.add(c);

//        c = new Country("Japan", 127086134);
//        c.setClimate(CountryClimate.Cold);
//        c.setMedicalSystem(0.8);
//        countries.add(c);

//        c = new Country("Sweden", 10006742);
//        c.setClimate(CountryClimate.Cold);
//        countries.add(c);

//        c = new Country("Thailand", 69231623);
//        c.setClimate(CountryClimate.Hot);
//        c.setMedicalSystem(0.6);
//        countries.add(c);
    }

    public boolean checkHalfPopulationDead() {
        return getTotalDeathPopulation() >= (getWorldTotalPopulation() / 2);
    }
    public boolean isHalfPopulationDead() {
        return halfPopulationDead;
    }

    public void setHalfPopulationDead(boolean halfPopulationDead) {
        this.halfPopulationDead = halfPopulationDead;
    }
    public boolean checkHalfPopulationInfected() {
        return getTotalInfectedPopulation() >= (getWorldTotalPopulation() / 2);
    }

    public boolean shouldResearchStart() {
        return getTotalInfectedPopulation() >= (getWorldTotalPopulation() / 2);
    }

    public boolean isHalfPopulationInfected() {
        return halfPopulationInfected;
    }

    public Country getHighestInfectCountry() {
        int tmpMaxPopulation = 0;
        Country worstCountry = null;
        for (Country c : countries) {
            if (c.getInfectedPopulation() > tmpMaxPopulation && (!(c.getState() instanceof DeadCountry))) {
                worstCountry = c;
                tmpMaxPopulation = c.getInfectedPopulation();
            }
        }
        return worstCountry;
    }

//    public Country getHighestDeathCountry() {
//        int tmpMaxPopulation = 0;
//        Country worstCountry = null;
//        for (Country c : countries) {
//            if (c.getDeathPopulation() > tmpMaxPopulation) {
//                worstCountry = c;
//                tmpMaxPopulation = c.getDeathPopulation();
//            }
//        }
//        return worstCountry;
//    }


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
            if (c.getInfectedPopulation() < 1) {
                uninfectedCountries.add(c);
            }
        }
        return uninfectedCountries;
    }

    public int getRowByCountryName(String name) {
        int i = 0;
        for (Country c : countries) {
            if (name.equals(c.getName())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int getColByColName(String name) {
        //"Country","Infect","Death" must be the same as the att array in Main
        switch (name) {
            case "Country":
                return 0;
            case "Infect":
                return 1;
            case "Death":
                return 2;
            default:
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


    public ArrayList<Country> getCountries() {
        return countries;
    }

    public void pauseGame() {
        running.set(false);
    }

    public void resumeGame() {
        running.set(true);
        gameThread.interrupt();
    }

    public int getUpgradePoint() {
        return this.upgradePoint;
    }
    public void calUpgradePoint(int type, int calPoint) {
        // 0 = +
        // 1 = -
        if (type == 0)
            upgradePoint += calPoint;
        else
            upgradePoint -= calPoint;
    }

    public int upgradePointGainPerDay() {
        return 1;
    }

    public void makeInfectGainPointHarder() {

    }

    public Research getResearch() {
        return research;
    }

    public JLabel getTransmission_currcostLabel() {
        return transmission_currcostLabel;
    }

    public void setTransmission_currcostLabel(JLabel transmission_currcostLabel) {
        this.transmission_currcostLabel = transmission_currcostLabel;
    }

    public JLabel getSymptom_currcostLabel() {
        return symptom_currcostLabel;
    }

    public void setSymptom_currcostLabel(JLabel symptom_currcostLabel) {
        this.symptom_currcostLabel = symptom_currcostLabel;
    }

    public JLabel getAbility_currcostLabel() {
        return ability_currcostLabel;
    }

    public void setAbility_currcostLabel(JLabel ability_currcostLabel) {
        this.ability_currcostLabel = ability_currcostLabel;
    }

    public void updateCurrentPoint() {
        if (ability_currcostLabel != null) {
            ability_currcostLabel.setText("Current Point : " + getUpgradePoint());
        }
        if (symptom_currcostLabel != null) {
            symptom_currcostLabel.setText("Current Point : " + getUpgradePoint());
        }
        if (transmission_currcostLabel != null) {
            transmission_currcostLabel.setText("Current Point : " + getUpgradePoint());
        }
    }

    public void initPointLabel() {
        ability_currcostLabel = null;
        symptom_currcostLabel = null;
        transmission_currcostLabel = null;
    }

}
