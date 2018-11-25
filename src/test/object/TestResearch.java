package test.object;

import object.Country;
import object.CountryClimate;
import object.Research;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestResearch {

    /* TEST: getCurrentResearch */
    @Test
    public void testGetCurrentResearch() {
        Research research = new Research();
        int result = research.getCurrentResearch();
        assertEquals(0, result);
    }

    /* TEST: addCurrentResearch */
    @Test
    public void testAddCurrentResearchC1() {
        Research research = new Research();
        research.addCurrentResearch(50);
        int result = research.getCurrentResearch();
        assertEquals(50, result);
    }

    @Test
    public void testAddCurrentResearchC2() {
        Research research = new Research();
        research.addCurrentResearch(150);
        int result = research.getCurrentResearch();
        assertEquals(100, result);
    }

    /* TEST: getHoldByCountry */

    @Test
    public void testGetHoldByCountry() {
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
    public void testSetHoldByCountryC1() {
        Country country = new Country("test", 1234, 10.0, CountryClimate.Hot);
        Research research = new Research();
        research.setHoldByCountry(country);
        int result = research.getResearchPerDay();
        assertEquals(1, result);
    }

    @Test
    public void testSetHoldByCountryC2() {
        Country country = new Country("test", 1234, -10.0, CountryClimate.Hot);
        Research research = new Research();
        research.setHoldByCountry(country);
        int result = research.getResearchPerDay();
        assertEquals(0, result);
    }

    /* TEST: addResearchPerDay */
    @Test
    public void testAddResearchPerDay() {
        Research research = new Research();
        research.addResearchPerDay(50.0);
        int result = research.getResearchPerDay();
        assertEquals(1, result);
    }

    /* TEST: getResearchPerDay */
    @Test
    public void testGetResearchPerDayC1() {
        Research research = new Research();
        research.addResearchPerDay(80.0);
        int result = research.getResearchPerDay();
        assertEquals(1, result);
    }

    @Test
    public void testGetResearchPerDayC2() {
        Research research = new Research();
        int result = research.getResearchPerDay();
        assertEquals(0, result);
    }
}
