package object;

import java.util.ArrayList;

public class Virus {
	private String name;
	private ArrayList<VirusTransmission> transmissionList;
	private ArrayList<VirusSymptom> symptomList;
	private ArrayList<VirusAbility> abilityList;
	private double virusSpeed = 0.005;
	private double virusPower = 0;
	

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
	
	public int getInfectPerDay(Country c) {
		return (int) ((c.getPopulation() * c.getMedicalSystem()) * virusSpeed);
	}
	
	public int getKillPerDay(Country c) {
		if(c.getDeathPopulation() > c.getInfectedPopulation())
		{
			return 0;
		}
		else
		{
			return (int) ((c.getPopulation() * c.getMedicalSystem()) * (virusPower + getSymptomKillPower()));
		}
	}
	
	public double getSymptomKillPower() {
		double killPower = 0;
		for (VirusSymptom vs : symptomList) {
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

}
