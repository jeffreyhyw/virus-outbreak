package object;

import java.util.ArrayList;

public class Virus {
	private String startDate;
	private String startLocation;
	private String name;
	private ArrayList<VirusTransmission> transmissionList;
	private ArrayList<VirusSymptom> symptomList;
	private ArrayList<VirusAbility> abilityList;
	
	public Virus(String startDate, String startLocation, String name, 
			ArrayList<VirusTransmission> transmissionList,
			ArrayList<VirusSymptom> symptomList,
			ArrayList<VirusAbility> abilityList) {
		this.startDate = startDate;
		this.startLocation = startLocation;
		this.name = name;
		this.transmissionList = transmissionList;
		this.symptomList = symptomList;
		this.abilityList = abilityList;
		
	}
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
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
	
	

}
