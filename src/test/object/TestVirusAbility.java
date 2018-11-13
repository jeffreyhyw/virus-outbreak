package test.object;

import object.CountryClimate;
import object.VirusAbility;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class TestVirusAbility {

    /* TEST : getLevel */
    @Test
    public void TestGetLevel(){
        VirusAbility virusAbility = new VirusAbility("attName", "desc", 0.1, CountryClimate.Hot);
        int result = virusAbility.getLevel();
        assertEquals(0, result);
    }

    /* TEST : upLevel */
    @Test
    public void TestUpLevel(){
        VirusAbility virusAbility = new VirusAbility("attName", "desc", 0.1, CountryClimate.Hot);
        virusAbility.upLevel();
        int result = virusAbility.getLevel();
        assertEquals(1, result);
    }

    /* TEST : checkLevel */
    @Test
    public void TestCheckLevel(){
        VirusAbility virusAbility = new VirusAbility("attName", "desc", 0.1, CountryClimate.Hot);
        boolean result = virusAbility.checkLevel();
        assertTrue(result);
    }

    /* TEST : getInfectionRate */
    @Test
    public void TestGetInfectionRate(){
        VirusAbility virusAbility = new VirusAbility("attName", "desc", 0.1, CountryClimate.Hot);
        double result = virusAbility.getInfectionRate();
        assertEquals(0.05, result);
    }

    /* TEST : getResearched */
    @Test
    public void TestGetResearched(){
        VirusAbility virusAbility = new VirusAbility("attName", "desc", 0.1, CountryClimate.Hot);
        boolean result = virusAbility.getResearched();
        assertFalse(result);
    }

    /* TEST : setResearched */
    @Test
    public void TestSetResearched(){
        VirusAbility virusAbility = new VirusAbility("attName", "desc", 0.1, CountryClimate.Hot);
        virusAbility.setResearched(true);
        boolean result = virusAbility.getResearched();
        assertTrue(result);
    }

    /* TEST : getClimateBoost */
    @Test
    public void TestGetClimateBoost(){
        VirusAbility virusAbility = new VirusAbility("attName", "desc", 0.1, CountryClimate.Hot);
        CountryClimate result = virusAbility.getClimateBoost();
        assertEquals(CountryClimate.Hot, result);
    }

}
