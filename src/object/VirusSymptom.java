package object;

public class VirusSymptom extends VirusAttribute{
	private boolean status;
	public VirusSymptom(String symptom_name, int level, String description, int cost, boolean status) {
		super(symptom_name, description, cost);
		this.status = status;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
}
