package object;

public class VirusAbility extends VirusAttribute {
    private int level;
    private double infectionRate = 0;
//    private double killPeopleRate = 0;
    private double affectResearchRate = 0;
    private boolean researched;
    private CountryClimate climateBoost;

    public VirusAbility(String att_name, String description, double affectResearchRate, CountryClimate climateBoost) {
        super(att_name, description, 30);
        this.level = 0;
        this.infectionRate = 0.05;
//        this.killPeopleRate = 0;
        this.affectResearchRate = affectResearchRate;
        this.researched = false;
        this.setClimateBoost(climateBoost);
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
//        if (level + 1 <= 5) {
//            return true;
//        } else {
//            return false;
//        }
        return level + 1 <= 5;
    }

    public double getInfectionRate() {
        return infectionRate;
    }

    public boolean getResearched() {
        return researched;
    }

    public void setResearched(boolean researched) {
        this.researched = researched;
    }

    public CountryClimate getClimateBoost() {
        return climateBoost;
    }

    public void setClimateBoost(CountryClimate climateBoost) {
        this.climateBoost = climateBoost;
    }


}
