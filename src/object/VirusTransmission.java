package object;

public class VirusTransmission extends VirusAttribute{
	private int level;
	private double infectionRate = 0;
	private double killPeopleRate = 0;
	private double affectResearchRate = 0;
	private boolean researched;
	
	public VirusTransmission(String att_name, int level, String description,
							double infectionRate, double killPeopleRate, int cost) {
		super(att_name, description, cost);
		this.level = level;
		this.infectionRate = infectionRate;
		this.killPeopleRate = killPeopleRate;
		this.researched = false;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void upLevel() {
		if(level + 1 <= 5) {
			level += 1;
		}
	}
	public boolean checkLevel() {
		if(level + 1 <= 5) {
			return true;
		}
		else {
			return false;
		}
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

	public boolean getResearched() {
		return researched;
	}

	public void setResearched(boolean researched) {
		this.researched = researched;
	}

	
}
