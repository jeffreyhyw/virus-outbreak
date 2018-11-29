package object;

public class VirusSymptom extends VirusAttribute {
    private boolean status;
    private int level;
    private double infectionRate;
    private double killPeopleRate;

    public VirusSymptom(String symptom_name, String description, double infectionRate, double killPeopleRate) {
        super(symptom_name, description, 30);
        this.status = false;
        this.level = 0;
        this.infectionRate = infectionRate;
        this.killPeopleRate = killPeopleRate;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
        if(status) {
            level = 1;
        }
    }

    public int getLevel() {
        return level;
    }

    public double getKillPeopleRate() {
        return killPeopleRate * 1.5;
    }

    public double getInfectionRate() {
        return this.infectionRate;
    }

}
