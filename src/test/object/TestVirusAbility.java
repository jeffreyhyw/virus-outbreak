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
    public void testGetLevel() {
        VirusAbility virusAbility = new VirusAbility("attName", "desc", CountryClimate.Hot);
        int result = virusAbility.getLevel();
        assertEquals(0, result);
    }

    /* TEST : upLevel */

    @Test
    public void testUpLevelC1() {
        VirusAbility virusAbility = new VirusAbility("attName", "desc", CountryClimate.Hot);
        virusAbility.upLevel();
        int result = virusAbility.getLevel();
        assertEquals(1, result);
    }

    @Test
    public void testUpLevelC2() {
        VirusAbility virusAbility = new VirusAbility("attName", "desc", CountryClimate.Hot);
        for (int i=0;i<6;i++) {
            virusAbility.upLevel();
        }
        int result = virusAbility.getLevel();
        assertEquals(5, result);
    }

    /* TEST : checkLevel */

    @Test
    public void testCheckLevel() {
        VirusAbility virusAbility = new VirusAbility("attName", "desc", CountryClimate.Hot);
        virusAbility.upLevel();
        boolean result = virusAbility.checkLevel();
        assertTrue(result);
    }

    /* TEST : getInfectionRate */

    @Test
    public void testGetInfectionRate() {
        VirusAbility virusAbility = new VirusAbility("attName", "desc", CountryClimate.Hot);
        double result = virusAbility.getInfectionRate();
        assertEquals(0.05, result);
    }


    /* TEST : getClimateBoost */

    @Test
    public void testGetClimateBoost() {
        VirusAbility virusAbility = new VirusAbility("attName", "desc", CountryClimate.Hot);
        CountryClimate result = virusAbility.getClimateBoost();
        assertEquals(CountryClimate.Hot, result);
    }

}
