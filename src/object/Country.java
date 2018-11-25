package object;

public class Country {
    private int population, infectedPopulation, deathPopulation;
    private String name;
    private double medicalSystem = 0.5;
    private CountryClimate climate;
    private CountryState state;

    //Initialize Country
    public Country(String name, int pop, double medicalSystem, CountryClimate climate) {
        this.name = name;
        this.population = pop;
        this.infectedPopulation = 0;
        this.deathPopulation = 0;
        this.medicalSystem = medicalSystem;
        this.climate = climate;
        state = new NormalCountry();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPopulation() {
        return this.population;
    }

    public int getInfectedPopulation() {
        return this.infectedPopulation;
    }

    public void addInfectedPopulation(int pop) {
        infectedPopulation += pop;
        if (infectedPopulation > population && infectedPopulation < deathPopulation) {
            infectedPopulation = population;
            setState(new InfectedCountry());
        } else if (infectedPopulation > population && infectedPopulation >= deathPopulation) {
            infectedPopulation = population;
            setState(new DeadCountry());
        }
    }

    public int getDeathPopulation() {
        return this.deathPopulation;
    }

    public void addDeathPopulation(int pop) {
        deathPopulation += pop;

        if (deathPopulation > infectedPopulation) {
            deathPopulation = infectedPopulation;
        }
        if (deathPopulation >= infectedPopulation && deathPopulation > population) {
            deathPopulation = population;
            setState(new DeadCountry());
        }
    }

    public int getUninfectedPopulation() {
        return population - infectedPopulation;
    }

    public CountryClimate getClimate() {
        return this.climate;
    }

    public CountryState getState() {
        return this.state;
    }

    public void setState(CountryState state) {
        this.state = state;
    }

    public double getMedicalSystem() {
        return medicalSystem;
    }

}