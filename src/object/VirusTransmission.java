package object;

public class VirusTransmission extends VirusAttribute{
	private int level;
	private double infectionRate = 0;
	private double killPeopleRate = 0;
	private double affectResearchRate = 0;
	
	public VirusTransmission(String att_name, int level, String description,
							double infectionRate, double killPeopleRate, int cost) {
		super(att_name, description, cost);
		this.level = level;
		this.infectionRate = infectionRate;
		this.killPeopleRate = killPeopleRate;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public double getInfectionRate() {
		return infectionRate;
	}

	public void setInfectionRate(double infectionRate) {
		this.infectionRate = infectionRate;
	}

	public double getKillPeopleRate() {
		return killPeopleRate;
	}

	public void setKillPeopleRate(double killPeopleRate) {
		this.killPeopleRate = killPeopleRate;
	}

	public double getAffectResearchRate() {
		return affectResearchRate;
	}

	public void setAffectResearchRate(double affectResearchRate) {
		this.affectResearchRate = affectResearchRate;
	}

	
}
