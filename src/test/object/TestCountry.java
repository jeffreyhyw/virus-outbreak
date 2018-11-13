package test.object;

import object.*;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class TestCountry {

    /* TEST: setName */

    @Test
    public void TestSetName() {
        Country country = new Country("test", 1234, 0, CountryClimate.Hot);
        country.setName("changedName");
        String result = country.getName();
        assertEquals("changedName", result);
    }

    /* TEST: getName */

    @Test
    public void TestGetName() {
        Country country = new Country("test", 1234, 0, CountryClimate.Hot);
        String result = country.getName();
        assertEquals("test", result);
    }

    /* TEST: getPopulation */

    @Test
    public void TestGetPopulation() {
        Country country = new Country("test", 1234, 0, CountryClimate.Hot);
        int result = country.getPopulation();
        assertEquals(1234, result);
    }

    /* TEST: setPopulation */

    @Test
    public void TestSetPopulation() {
        Country country = new Country("test", 1234, 0, CountryClimate.Hot);
        country.setPopulation(1500);
        int result = country.getPopulation();
        assertEquals(1500, result);
    }

    /* TEST: getInfectedPopulation */

    @Test
    public void TestGetInfectedPopulation() {
        Country country = new Country("test", 1234, 0, CountryClimate.Hot);
        int result = country.getInfectedPopulation();
        assertEquals(0, result);
    }

    /* TEST: setInfectedPopulation */

    @Test
    public void TestSetInfectedPopulation() {
        Country country = new Country("test", 1234, 0, CountryClimate.Hot);
        country.setInfectedPopulation(999);
        int result = country.getInfectedPopulation();
        assertEquals(999, result);
    }

    /* TEST: addInfectedPopulation */

    @Test
    public void TestAddInfectedPopulationC1() {
        class StubCountry {
            private int population = 1000, infectedPopulation = 0, deathPopulation = 0;
            private CountryState state;

            public int addInfectedPopulation(int pop) {
                infectedPopulation += pop;
                if (infectedPopulation > population && infectedPopulation < deathPopulation) {
                    infectedPopulation = population;
                } else if (infectedPopulation > population && infectedPopulation >= deathPopulation) {
                    infectedPopulation = population;
                }
                return infectedPopulation;
            }

            public int getPopulation() {
                return this.population;
            }
        }
        StubCountry stubCountry = new StubCountry();

    }

    /* TEST: getDeathPopulation */

    @Test
    public void TestGetDeathPopulation() {
        Country country = new Country("test", 1234, 0, CountryClimate.Hot);
        int result = country.getDeathPopulation();
        assertEquals(0, result);
    }

    /* TEST: setDeathPopulation */

    @Test
    public void TestSetDeathPopulation() {
        Country country = new Country("test", 1234, 0, CountryClimate.Hot);
        country.setDeathPopulation(1234);
        int result = country.getDeathPopulation();
        assertEquals(1234, result);
    }

    /* TEST : addDeathPopulation */

    @Test
    public void TestAddDeathPopulation() {

    }

    /* TEST : getUninfectedPopulation */

    @Test
    public void TestGetUninfectedPopulation() {
        Country country = new Country("test", 1234, 0, CountryClimate.Hot);
        int result = country.getUninfectedPopulation();
        assertEquals(1234, result);
    }

    /* TEST : getClimate */

    @Test
    public void TestGetClimate() {
        Country country = new Country("test", 1234, 0, CountryClimate.Hot);
        CountryClimate result = country.getClimate();
        assertEquals(CountryClimate.Hot, result);
    }

    /* TEST : setState */

    @Test
    public void TestSetState() {
        Country country = new Country("test", 1234, 0, CountryClimate.Hot);
        CountryState countryState = new NormalCountry();
        country.setState(countryState);
        CountryState result = country.getState();
        assertEquals(countryState, result);
    }

    /* TEST : getMedicalSystem */

    @Test
    public void TestGetMedicalSystem() {
        Country country = new Country("test", 1234, 1234.1234, CountryClimate.Hot);
        double result = country.getMedicalSystem();
        assertEquals(1234.1234, result);
    }

}
