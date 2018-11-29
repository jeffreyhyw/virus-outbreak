package object;

public class VirusTransmission extends VirusAttribute {
    private int level;
    private double infectionRate;
    private String referenAttName;


    public VirusTransmission(String att_name, String description, double infectionRate, String referenAttName) {
        super(att_name, description, 30);
        this.level = 0;
        this.infectionRate = infectionRate;
        this.referenAttName = referenAttName;

    }
    public VirusTransmission(String att_name, String description, double infectionRate) {
        super(att_name, description, 30);
        this.level = 0;
        this.infectionRate = infectionRate;
        this.referenAttName = "";
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

	public String getReferenAttName() {
		return referenAttName;
	}

}
