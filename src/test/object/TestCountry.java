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
}
