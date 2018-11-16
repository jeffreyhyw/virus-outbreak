package object;

import java.util.ArrayList;

public class Virus {
    private String name;
    private ArrayList<VirusTransmission> transmissionList;
    private ArrayList<VirusSymptom> symptomList;
    private ArrayList<VirusAbility> abilityList;
    private double virusSpeed = 0.01;
    private double virusPower = 0.01;

    public Virus(String name,
                 ArrayList<VirusTransmission> transmissionList,
                 ArrayList<VirusSymptom> symptomList,
                 ArrayList<VirusAbility> abilityList) {
        this.name = name;
        this.transmissionList = transmissionList;
        this.symptomList = symptomList;
        this.abilityList = abilityList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<VirusTransmission> getTransmissionList() {
        return transmissionList;
    }

    public ArrayList<VirusSymptom> getSymptomList() {
        return symptomList;
    }

    public ArrayList<VirusAbility> getAbilityList() {
        return abilityList;
    }

    public int getInfectPerDay(Country c, int day) {
        if (getInfectionPower(c) == 0) {
            return (int) (day * day * c.getMedicalSystem());
        } else {
            return (int) (day * day * c.getMedicalSystem() + (c.getUninfectedPopulation() * (1 - c.getMedicalSystem()) * virusSpeed * (1 + getInfectionPower(c))));
        }
    }


    public int getKillPerDay(Country c, int day) {
        if (getSymptomKillPower() == 0) {
            return 0;
        } else {
            return (int) (c.getInfectedPopulation() * (1 - c.getMedicalSystem()) * virusPower * (1 + getSymptomKillPower()));
        }
    }

    public double getInfectionPower(Country c) {
        double infectPower = 0;
        for (VirusSymptom vs : symptomList) {
            if (vs.isResearched())
                infectPower += vs.getInfectionRate() * vs.getLevel();
        }
        for (VirusTransmission vt : transmissionList) {
            if (vt.isResearched())
                infectPower += vt.getInfectionRate() * vt.getLevel();
        }
        for (VirusAbility va : abilityList) {
            if (va.isResearched()) {
                //Bost virus power if the climate of the place suitable for virus
                if (va.getClimateBoost() == c.getClimate()) {
                    infectPower += va.getInfectionRate() * va.getLevel() * 2;
                } else {
                    infectPower += va.getInfectionRate() * va.getLevel();
                }
            }
        }
        return infectPower;
    }

    public double getSymptomKillPower() {
        double killPower = 0;
        for (VirusSymptom vs : symptomList) {
            if (vs.isResearched())
                killPower += vs.getKillPeopleRate() * vs.getLevel();

        }
        return killPower;

    }

}
