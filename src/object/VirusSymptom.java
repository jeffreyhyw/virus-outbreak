package object;

public class VirusSymptom extends VirusAttribute {
    private boolean status;
    private int level;
    private double infectionRate;
    private double killPeopleRate;
    private double affectResearchRate = 0;
    private boolean researched;

    public VirusSymptom(String symptom_name, String description, double infectionRate, double killPeopleRate) {
        super(symptom_name, description, 30);
        this.status = false;
        this.level = 0;
        this.infectionRate = infectionRate;
        this.killPeopleRate = killPeopleRate;
        this.researched = false;
    }

//    public VirusSymptom(String symptom_name, int level, String description, double infectionRate,
//                        double killPeopleRate, int cost, boolean status) {
//        super(symptom_name, description, cost);
//        this.status = status;
//        this.level = level;
//        this.infectionRate = infectionRate;
//        this.killPeopleRate = killPeopleRate;
//        this.researched = false;
//    }

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
        return killPeopleRate * 1.5;
    }
    public void setKillPeopleRate(double killPeopleRate) {
        this.killPeopleRate = killPeopleRate;
    }

    public double getInfectionRate() {
        return this.infectionRate;
    }

    public boolean getResearched() {
        return researched;
    }
    public void setResearched(boolean researched) {
        this.researched = researched;
    }

    public boolean upLevel() {
        level = 1;
        return true;
    }
}
