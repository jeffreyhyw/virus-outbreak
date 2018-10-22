package object;

public class VirusSymptom {
	private String symptom_name;
	private String description;
	private int cost;
	private boolean status;
	public VirusSymptom(String symptom_name, int level, String description, int cost, boolean status) {
		this.symptom_name = symptom_name;
		this.description = description;
		this.cost = cost;
		this.status = status;
	}
	
	public String getSymptom_name() {
		return symptom_name;
	}

	public void setSymptom_name(String symptom_name) {
		this.symptom_name = symptom_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
}
