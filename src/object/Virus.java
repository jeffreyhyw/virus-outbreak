package object;

import java.util.ArrayList;

public class Virus {
	private String name;
	private ArrayList<VirusTransmission> transmissionList;
	private ArrayList<VirusSymptom> symptomList;
	private ArrayList<VirusAbility> abilityList;
//	private double virusSpeed = 0.003;
//	private double virusPower = 0.01;
	private double virusSpeed = 0.01;
	private double virusPower = 0.01;
	private boolean researched;
	

	public Virus(String name, 
			ArrayList<VirusTransmission> transmissionList,
			ArrayList<VirusSymptom> symptomList,
			ArrayList<VirusAbility> abilityList) {
		this.name = name;
		this.transmissionList = transmissionList;
		this.symptomList = symptomList;
		this.abilityList = abilityList;
		this.researched = false;
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
	public void addTransmissionList(VirusTransmission transmission) {
		this.transmissionList.add(transmission);
	}
	public void removeTransmissionList(VirusTransmission transmission) {
		this.transmissionList.remove(transmission);
	}
	public ArrayList<VirusSymptom> getSymptomList() {
		return symptomList;
	}
	public void addSymptomList(VirusSymptom symptom) {
		this.symptomList.add(symptom);
	}
	public void removeSymptomList(VirusSymptom symptom) {
		this.symptomList.remove(symptom);
	}
	public ArrayList<VirusAbility> getAbilityList() {
		return abilityList;
	}
	public void addAbilityList(VirusAbility ability) {
		this.abilityList.add(ability);
	}
	public void removeAbilityList(VirusAbility ability) {
		this.abilityList.remove(ability);
	}
	
	public int getInfectPerDay(Country c, int day) {
		if(getInfectionPower(c) == 0)
		{
			return (int) (day * day * c.getMedicalSystem());
		}
		else
		{
			return (int) (day * day * c.getMedicalSystem() + ( c.getUninfectedPopulation() * (1 - c.getMedicalSystem()) * virusSpeed * (1+getInfectionPower(c)) ));
		}
	}
	
	
	public int getKillPerDay(Country c, int day) {
		if(getSymptomKillPower() == 0)
		{
			return 0;
		}
		else
		{
			return (int) (c.getInfectedPopulation() * (1 - c.getMedicalSystem()) * virusPower *  (1 + getSymptomKillPower()) );
		}
	}
	
	public double getInfectionPower(Country c) {
		double infectPower = 0;
		for (VirusSymptom vs : symptomList) {
			if(vs.getResearched())
				infectPower += vs.getInfectionRate() * vs.getLevel();
 		}
		for (VirusTransmission vt : transmissionList) {
			if(vt.getResearched())
				infectPower += vt.getInfectionRate() * vt.getLevel();
 		}
		for (VirusAbility va : abilityList) {
			if(va.getResearched()) 
			{
				//Bost virus power if the climate of the place suitable for virus
				if(va.getClimateBoost() == c.getClimate())
				{
					infectPower += va.getInfectionRate() * va.getLevel() * 2;
				}
				else
				{
					infectPower += va.getInfectionRate() * va.getLevel();
				}
			}
 		}
		return infectPower;
	}
	
	public double getSymptomKillPower() {
		double killPower = 0;
		for (VirusSymptom vs : symptomList) {
			if(vs.getResearched())
				killPower += vs.getKillPeopleRate() * vs.getLevel();

 		}
		return killPower;
		
	}
	
	public double getVirusPower() {
		return virusPower;
	}

	public void setVirusPower(double virusPower) {
		this.virusPower = virusPower;
	}
	
	public void setResearched(boolean status) {
		researched = status;
	}
	
	public boolean getResearched() {
		return this.researched;
	}

}
