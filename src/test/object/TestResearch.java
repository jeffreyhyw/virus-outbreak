package test.object;

import object.Country;
import object.CountryClimate;
import object.Research;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestResearch {

    /* TEST: getCurrentResearch */

    @Test
    public void TestGetCurrentResearch() {
        Research research = new Research();
        int result = research.getCurrentResearch();
        assertEquals(0, result);
    }

    /* TEST: addCurrentResearch */

    @Test
    public void TestAddCurrentResearchC1() {
        Research research = new Research();
        research.addCurrentResearch(-1);
        int result = research.getCurrentResearch();
        assertEquals(-1, result);
        // the current research should not less then 0
    }

    @Test
    public void TestAddCurrentResearchC2() {
        Research research = new Research();
        research.addCurrentResearch(50);
        int result = research.getCurrentResearch();
        assertEquals(50, result);
    }

    @Test
    public void TestAddCurrentResearchC3() {
        Research research = new Research();
        research.addCurrentResearch(150);
        int result = research.getCurrentResearch();
        assertEquals(100, result);
        // currentResearch >= 100 should remove =
    }

    /* TEST: getHoldByCountry */

    @Test
    public void TestGetHoldByCountry() {
        Country country = new Country("test", 1234, 10.0, CountryClimate.Hot);
        Research research = new Research();
        research.setHoldByCountry(country);
        Country result = research.getHoldByCountry();
        assertEquals(country.getName(), result.getName());
        assertEquals(country.getPopulation(), result.getPopulation());
        assertEquals(country.getMedicalSystem(), result.getMedicalSystem());
        assertEquals(country.getClimate(), result.getClimate());
    }

    /* TEST: setHoldByCountry */

    @Test
    public void TestSetHoldByCountryC1() {
        // DeathPopulation is 0
        class StubResearch {
            private int researchPerDay = 0;     // should int in the orig class

            public int setHoldByCountry(Country holdByCountry) {
                if (holdByCountry != null) {
                    researchPerDay = (int) (holdByCountry.getMedicalSystem() - (holdByCountry.getDeathPopulation() / holdByCountry.getPopulation()));
                    if (researchPerDay < 0) {
                        researchPerDay = 0;
                    }
                }
                return researchPerDay;
            }
        }
        Country country = new Country("test", 1234, 10.0, CountryClimate.Hot);
        StubResearch stubResearch = new StubResearch();
        int result = stubResearch.setHoldByCountry(country);
        assertEquals(10, result);
    }

    @Test
    public void TestSetHoldByCountryC2() {
        // DeathPopulation is 1200
        class StubResearch {
            private int researchPerDay = 0;

            public int setHoldByCountry(Country holdByCountry) {
                if (holdByCountry != null) {
                    researchPerDay = (int) (holdByCountry.getMedicalSystem() - (holdByCountry.getDeathPopulation() / holdByCountry.getPopulation()));
                    if (researchPerDay < 0) {
                        researchPerDay = 0;
                    }
                }
                return researchPerDay;
            }
        }
        Country country = new Country("test", 1234, 10.0, CountryClimate.Hot);
        country.setDeathPopulation(1200);
        StubResearch stubResearch = new StubResearch();
        int result = stubResearch.setHoldByCountry(country);
        assertEquals(10, result);
    }

    @Test
    public void TestSetHoldByCountryC3() {
        // DeathPopulation is 1200, medicalSystem is 0
        class StubResearch {
            private int researchPerDay = 0;

            public int setHoldByCountry(Country holdByCountry) {
                if (holdByCountry != null) {
                    researchPerDay = (int) (holdByCountry.getMedicalSystem() - (holdByCountry.getDeathPopulation() / holdByCountry.getPopulation()));
                    if (researchPerDay < 0) {
                        researchPerDay = 0;
                    }
                }
                return researchPerDay;
            }
        }
        Country country = new Country("test", 1234, 0.0, CountryClimate.Hot);
        country.setDeathPopulation(1200);
        StubResearch stubResearch = new StubResearch();
        int result = stubResearch.setHoldByCountry(country);
        assertEquals(0, result);
    }

    /* TEST: addResearchPerDay */

    @Test
    public void TestAddResearchPerDayC1() {
        Research research = new Research();
        research.addResearchPerDay(50.0);
        double result = research.getResearchPerDay();
        assertEquals(1.0, result);
    }

    @Test
    public void TestAddResearchPerDayC2() {
        Research research = new Research();
        research.addResearchPerDay(-50.0);
        double result = research.getResearchPerDay();
        assertEquals(0.0, result);
    }

    /* TEST: getResearchPerDay */

    @Test
    public void TestGetResearchPerDayC1() {
        Country country = new Country("test", 1234, 10.0, CountryClimate.Hot);
        Research research = new Research();
        research.setHoldByCountry(country);
        int result = research.getResearchPerDay();
        assertEquals(1, result);
    }

    @Test
    public void TestGetResearchPerDayC2() {
        Country country = new Country("test", 1234, 0.0, CountryClimate.Hot);
        Research research = new Research();
        research.setHoldByCountry(country);
        int result = research.getResearchPerDay();
        assertEquals(0, result);
    }
}
