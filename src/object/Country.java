package object;

public class Country {
	private int population, infectedPopulation, didePopulation;
	private String name;
	private CountryClimate climate;
	private CountryEconomy economy;
	
	//Initialize Country
	public Country(String name, int pop)
	{
		this.name = name;
		this.population = pop;
		this.infectedPopulation = 0;
		this.didePopulation = 0;
		climate = new CountryClimate();
		economy = new CountryEconomy();
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
	
	public int getDiedPopulation()
	{
		return this.didePopulation;
	}
	
	public void setDiedPopulation(int pop)
	{
		this.didePopulation = pop;
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
}