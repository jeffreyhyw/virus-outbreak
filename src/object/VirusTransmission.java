package object;

public class VirusTransmission extends VirusAttribute {
    private int level;
    private double infectionRate;

    public VirusTransmission(String att_name, String description, double infectionRate) {
        super(att_name, description, 30);
        this.level = 0;
        this.infectionRate = infectionRate;
    }

    public int getLevel() {
        return level;
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

}
