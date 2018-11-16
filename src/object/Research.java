package object;

public class Research {
    private Country holdByCountry;
    private double researchPerDay = 0;
    private int currentResearch = 0;

    public int getCurrentResearch() {
        return currentResearch;
    }

    public void addCurrentResearch(int n) {
        currentResearch += n;
        if (currentResearch >= 100) {
            currentResearch = 100;
        }
    }

    public Country getHoldByCountry() {
        return holdByCountry;
    }

    public void setHoldByCountry(Country holdByCountry) {
        this.holdByCountry = holdByCountry;
        if (holdByCountry != null) {
            researchPerDay = (int) (holdByCountry.getMedicalSystem() - (holdByCountry.getDeathPopulation() / holdByCountry.getPopulation()));
            if (researchPerDay < 0) {
                researchPerDay = 0;
            }
        }
    }

    public void addResearchPerDay(double n) {
        researchPerDay += n;
    }

    public int getResearchPerDay() {
        if (researchPerDay >= 1) {
            researchPerDay -= 1;
            return 1;
        } else {
            return 0;
        }
    }
}
