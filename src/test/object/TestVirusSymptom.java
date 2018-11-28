package test.object;

import object.VirusSymptom;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class TestVirusSymptom {

    /* TEST : getStatus */
    @Test
    public void testGetStatus() {
        VirusSymptom virusSymptom = new VirusSymptom("symp", "desc", 0.5, 0.1);
        boolean result = virusSymptom.getStatus();
        assertFalse(result);
    }

    /* TEST : setStatus */
    @Test
    public void testSetStatus() {
        VirusSymptom virusSymptom = new VirusSymptom("symp", "desc", 0.5, 0.1);
        virusSymptom.setStatus(true);
        boolean result = virusSymptom.getStatus();
        assertTrue(result);
    }

    /* TEST : getLevel */
    @Test
    public void testGetLevel() {
        VirusSymptom virusSymptom = new VirusSymptom("symp", "desc", 0.5, 0.1);
        int result = virusSymptom.getLevel();
        assertEquals(0, result);
    }

    /* TEST : getKillPeopleRate */
    @Test
    public void testGetKillPeopleRate() {
        VirusSymptom virusSymptom = new VirusSymptom("symp", "desc", 0.5, 0.1);
        double result = virusSymptom.getKillPeopleRate();
        assertEquals(0.15000000000000002, result);
    }

    /* TEST : getInfectionRate */
    @Test
    public void testGetInfectionRate() {
        VirusSymptom virusSymptom = new VirusSymptom("symp", "desc", 0.5, 0.1);
        double result = virusSymptom.getInfectionRate();
        assertEquals(0.5, result);
    }

    /* TEST : upLevel */
    @Test
    public void testUpLevel() {
        VirusSymptom virusSymptom = new VirusSymptom("symp", "desc", 0.5, 0.1);
        boolean result = virusSymptom.upLevel();
        assertTrue(result);
    }

}
