package object;

public class VirusTransmission extends VirusAttribute {
    private int level;
    private double infectionRate;
    private boolean researched;

    public VirusTransmission(String att_name, String description, double infectionRate) {
        super(att_name, description, 30);
        this.level = 0;
        this.infectionRate = infectionRate;
        this.researched = false;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void upLevel() {
        if (level + 1 <= 5) {
            level += 1;
        }
    }

    public boolean checkLevel() {
        return level + 1 <= 5;
    }

    public double getInfectionRate() {
        return infectionRate;
    }

    public boolean isResearched() {
        return researched;
    }

    public void setResearched(boolean researched) {
        this.researched = researched;
    }


}
