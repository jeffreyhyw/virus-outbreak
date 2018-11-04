package object;

public class VirusSymptom extends VirusAttribute{
	private boolean status;
	private int level;
	private double infectionRate = 0;
	private double killPeopleRate = 0;
	private double affectResearchRate = 0;
	private int cost;
	
	public VirusSymptom(String symptom_name, int level, String description, double infectionRate,
						 double killPeopleRate, int cost, boolean status) {
		super(symptom_name, description, cost);
		this.status = status;
		this.level = level;
		this.infectionRate = infectionRate;
		this.killPeopleRate = killPeopleRate;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public double getKillPeopleRate() {
		return killPeopleRate;
	}

	public void setKillPeopleRate(double killPeopleRate) {
		this.killPeopleRate = killPeopleRate;
	}

	public double getInfectionRate() {
		// TODO Auto-generated method stub
		return this.infectionRate;
	}

}
