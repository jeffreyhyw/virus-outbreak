package object;

import java.util.ArrayList;

public class Virus {
	private String name;
	private String startLocation;
	private String startDate;
	private ArrayList<VirusAbility> abilityList;
	private ArrayList<VirusSymptom> symptomList;
	private ArrayList<VirusTransmission> transmissionList;
	
	
	public Virus(String name, String startLocation, String startDate, 
			ArrayList<VirusAbility> abilityList, ArrayList<VirusSymptom>symptomList, ArrayList<VirusTransmission>transmissionList) {
		this.name = name;
		this.startLocation = startLocation;
		this.startDate = startDate;
		this.abilityList = abilityList;
		this.symptomList = symptomList;
		this.transmissionList = transmissionList;
	}
	
	public Virus(String name, String startLocation, String startDate) {
		this.name = name;
		this.startLocation = startLocation;
		this.startDate = startDate;
		this.abilityList = new ArrayList<VirusAbility>();
		this.symptomList = new ArrayList<VirusSymptom>();
		this.transmissionList = new ArrayList<VirusTransmission>();
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public ArrayList<VirusAbility> getAbilityList() {
		return abilityList;
	}
	public void addAbility(VirusAbility ability) {
		this.abilityList.add(ability);
	}
	public void removeAbility(VirusAbility ability) {
		this.abilityList.remove(ability);
	}
	public ArrayList<VirusSymptom> getSymptomList() {
		return symptomList;
	}
	public void addSymptom(VirusSymptom symptom) {
		this.symptomList.add(symptom);
	}
	public void removeSymptom(VirusSymptom symptom) {
		this.symptomList.remove(symptom);
	}
	public ArrayList<VirusTransmission> getTransmissionList() {
		return transmissionList;
	}
	public void addTransmission(VirusTransmission transmission) {
		this.transmissionList.add(transmission);
	}
	public void removeTransmission(VirusTransmission transmission) {
		this.transmissionList.remove(transmission);
	}
}
