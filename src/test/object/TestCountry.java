package test.object;

import object.*;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestCountry {

    /* TEST: setName */
    @Test
    public void testSetName() {
        Country country = new Country("test", 1234, 0, CountryClimate.Hot);
        country.setName("changedName");
        String result = country.getName();
        assertEquals("changedName", result);
    }

    /* TEST: getName */
    @Test
    public void testGetName() {
        Country country = new Country("test", 1234, 0, CountryClimate.Hot);
        String result = country.getName();
        assertEquals("test", result);
    }

    /* TEST: getPopulation */
    @Test
    public void testGetPopulation() {
        Country country = new Country("test", 1234, 0, CountryClimate.Hot);
        int result = country.getPopulation();
        assertEquals(1234, result);
    }


    /* TEST: getInfectedPopulation */
    @Test
    public void testGetInfectedPopulation() {
        Country country = new Country("test", 1234, 0, CountryClimate.Hot);
        int result = country.getInfectedPopulation();
        assertEquals(0, result);
    }

    /* TEST: addInfectedPopulation */
    @Test
    public void testAddInfectedPopulation() {
        Country country = new Country("test", 1234, 5, CountryClimate.Hot);
        country.addInfectedPopulation(1000);
        int result = country.getInfectedPopulation();
        assertEquals(1000,result);
    }

    /* TEST: getDeathPopulation */
    @Test
    public void testGetDeathPopulation() {
        Country country = new Country("test", 1234, 0, CountryClimate.Hot);
        int result = country.getDeathPopulation();
        assertEquals(0, result);
    }

    /* TEST : addDeathPopulation */
    @Test
    public void testAddDeathPopulationC1() {
        Country country = new Country("test", 1234, 5, CountryClimate.Hot);
        country.addInfectedPopulation(500);
        country.addDeathPopulation(500);
        int result = country.getDeathPopulation();
        assertEquals(500, result);
    }

    @Test
    public void testAddDeathPopulationC2() {
        Country country = new Country("test", 1234, 5, CountryClimate.Hot);
        country.addDeathPopulation(500);
        int result = country.getDeathPopulation();
        assertEquals(0, result);
    }

    /* TEST : getUninfectedPopulation */
    @Test
    public void testGetUninfectedPopulation() {
        Country country = new Country("test", 1234, 0, CountryClimate.Hot);
        int result = country.getUninfectedPopulation();
        assertEquals(1234, result);
    }

    /* TEST : getClimate */
    @Test
    public void testGetClimate() {
        Country country = new Country("test", 1234, 0, CountryClimate.Hot);
        CountryClimate result = country.getClimate();
        assertEquals(CountryClimate.Hot, result);
    }

    /* TEST: getState */
    @Test
    public void testGetState() {
        Country country = new Country("test", 1234, 0, CountryClimate.Hot);
        CountryState result = country.getState();
        assertEquals(new NormalCountry().getClass(), result.getClass());
    }

    /* TEST : setState */
    @Test
    public void testSetState() {
        Country country = new Country("test", 1234, 0, CountryClimate.Hot);
        CountryState countryState = new DeadCountry();
        country.setState(countryState);
        CountryState result = country.getState();
        assertEquals(countryState, result);
    }

    /* TEST : getMedicalSystem */
    @Test
    public void testGetMedicalSystem() {
        Country country = new Country("test", 1234, 1234.1234, CountryClimate.Hot);
        double result = country.getMedicalSystem();
        assertEquals(1234.1234, result);
    }

}
