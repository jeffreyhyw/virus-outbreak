package object;

public class VirusSymptom extends VirusAttribute {
    private boolean status;
    private int level;
    private double infectionRate;
    private double killPeopleRate;
    private boolean researched;

    public VirusSymptom(String symptom_name, String description, double infectionRate, double killPeopleRate) {
        super(symptom_name, description, 30);
        this.status = false;
        this.level = 0;
        this.infectionRate = infectionRate;
        this.killPeopleRate = killPeopleRate;
        this.researched = false;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
        if(status == true) {
        		level = 1;
        }
	        	
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getKillPeopleRate() {
        return killPeopleRate * 1.5;
    }

    public void setKillPeopleRate(double killPeopleRate) {
        this.killPeopleRate = killPeopleRate;
    }

    public double getInfectionRate() {
        return this.infectionRate;
    }

    public boolean isResearched() {
        return researched;
    }

    public void setResearched(boolean researched) {
        this.researched = researched;
    }


}
