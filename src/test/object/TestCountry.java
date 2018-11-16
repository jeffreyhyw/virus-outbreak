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
            private int population = 1234, infectedPopulation = 0, deathPopulation = 0;
            public int addInfectedPopulation(int pop) {
                infectedPopulation += pop;
                return infectedPopulation;
            }
        }
        StubCountry stubCountry = new StubCountry();
        int result = stubCountry.addInfectedPopulation(1000);
        assertEquals(1000,result);
    }

    @Test
    public void TestAddInfectedPopulationC2() {  // ERROR
        class StubCountry {
            private int population = 1234, infectedPopulation = 0, deathPopulation = 0;
            public int addInfectedPopulation(int pop) {
                infectedPopulation += pop;
                if (infectedPopulation > population && infectedPopulation < deathPopulation) {
                    infectedPopulation = population;
                } else if (infectedPopulation > population && infectedPopulation >= deathPopulation) {
                    infectedPopulation = population;
                }
                return infectedPopulation;
            }
        }
        StubCountry stubCountry = new StubCountry();
        int result = stubCountry.addInfectedPopulation(1000);
        assertEquals(1000,result);
    }

    @Test
    public void TestAddInfectedPopulationC3() {  // ERROR
        class StubCountry {
            private int population = 1234, infectedPopulation = 0, deathPopulation = 0;
            public int addInfectedPopulation(int pop) {
                infectedPopulation += pop;
                if (infectedPopulation > population && infectedPopulation < deathPopulation) {
                    infectedPopulation = population;
                } else if (infectedPopulation > population && infectedPopulation >= deathPopulation) {
                    infectedPopulation = population;
                }
                return infectedPopulation;
            }
        }
        StubCountry stubCountry = new StubCountry();
        int result = stubCountry.addInfectedPopulation(1000);
        assertEquals(1000,result);
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
    public void TestAddDeathPopulationC1() {
        class StubCountry {
            private int population = 1234, infectedPopulation = 0, deathPopulation = 0;
            public int addDeathPopulation(int pop) {
                deathPopulation += pop;
                return deathPopulation;
            }
        }
        StubCountry stubCountry = new StubCountry();
        int result = stubCountry.addDeathPopulation(1000);
        assertEquals(1000, result);
    }

    @Test
    public void TestAddDeathPopulationC2() {
        class StubCountry {
            private int population = 1234, infectedPopulation = 0, deathPopulation = 0;
            public int addDeathPopulation(int pop) {
                deathPopulation += pop;
                if (deathPopulation > infectedPopulation) {
                    deathPopulation = infectedPopulation;
                }
                return deathPopulation;
            }
        }
        StubCountry stubCountry = new StubCountry();
        int result = stubCountry.addDeathPopulation(1000);
        assertEquals(0, result);
    }

    @Test
    public void TestAddDeathPopulationC3() { // ERROR
        class StubCountry {
            private int population = 1234, infectedPopulation = 0, deathPopulation = 0;
            public int addDeathPopulation(int pop) {
                deathPopulation += pop;
                if (deathPopulation >= infectedPopulation && deathPopulation > population) {
                    deathPopulation = population;
                }
                return deathPopulation;
            }
        }
        StubCountry stubCountry = new StubCountry();
        int result = stubCountry.addDeathPopulation(1300);
        assertEquals(1234, result);
    }

    @Test
    public void TestAddDeathPopulationC4() {
        class StubCountry {
            private int population = 1234, infectedPopulation = 0, deathPopulation = 0;
            public int addDeathPopulation(int pop) {
                deathPopulation += pop;
                if (deathPopulation > infectedPopulation) {
                    deathPopulation = infectedPopulation;
                }
                if (deathPopulation >= infectedPopulation && deathPopulation > population) {
                    deathPopulation = population;
                }
                return deathPopulation;
            }
        }
        StubCountry stubCountry = new StubCountry();
        int result = stubCountry.addDeathPopulation(1000);
        assertEquals(0, result);
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

    /* TEST: getState */

    @Test
    public void TestGetState() {
        Country country = new Country("test", 1234, 0, CountryClimate.Hot);
        CountryState result = country.getState();
        assertEquals(new NormalCountry().getClass(), result.getClass());
    }

    /* TEST : setState */

    @Test
    public void TestSetState() {
        Country country = new Country("test", 1234, 0, CountryClimate.Hot);
        CountryState countryState = new DeadCountry();
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
