package object;

public class Country {
	private int population, infectedPopulation, deathPopulation;
	private String name;
	private double medicalSystem = 0.5;
	private CountryClimate climate;
	private CountryEconomy economy;
	
	//Initialize Country
	public Country(String name, int pop)
	{
		this.name = name;
		this.population = pop;
		this.infectedPopulation = 0;
		this.deathPopulation = 0;
		climate = new CountryClimate();
		economy = new CountryEconomy();
	}
	
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}
	
	public int getPopulation()
	{
		return this.population;
	}
	
	public void setPopulation(int pop)
	{
		this.population = pop;
	}
	
	public int getInfectedPopulation()
	{
		return this.infectedPopulation;
	}
	
	public void setInfectedPopulation(int pop)
	{
		this.infectedPopulation = pop;
	}
	
	public void addInfectedPopulation(int pop)
	{
		infectedPopulation += pop;
		if(infectedPopulation > population)
		{
			infectedPopulation = population;
		}
	}
	
	public int getDeathPopulation()
	{
		return this.deathPopulation;
	}
	
	public void setDeathPopulation(int pop)
	{
		this.deathPopulation = pop;
	}
	
	public void addDeathPopulation(int pop)
	{
		deathPopulation += pop;
		if(deathPopulation > population)
		{
			deathPopulation = population;
		}
	}
	
	public CountryClimate getClimate()
	{
		return this.climate;
	}
	
	public void setClimate(CountryClimate climate)
	{
		this.climate = climate;
	}
	
	public CountryEconomy getEconomy()
	{
		return this.economy;
	}
	
	public void setEconomy(CountryEconomy economy)
	{
		this.economy = economy;
	}


	public double getMedicalSystem() {
		return medicalSystem;
	}


	public void setMedicalSystem(double medicalSystem) {
		this.medicalSystem = medicalSystem;
	}
}