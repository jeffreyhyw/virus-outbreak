package test.object;

import object.VirusTransmission;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class TestVirusTransmission {
    /* TEST : getLevel */
    @Test
    public void testGetLevel() {
        VirusTransmission virusTransmission = new VirusTransmission("att", "desc", 0.5);
        int result = virusTransmission.getLevel();
        assertEquals(0, result);
    }

    /* TEST : setLevel */
    @Test
    public void testSetLevel() {
        VirusTransmission virusTransmission = new VirusTransmission("att", "desc", 0.5);
        virusTransmission.setLevel(3);
        int result = virusTransmission.getLevel();
        assertEquals(3, result);
    }

    /* TEST : upLevel */
    @Test
    public void testUpLevelC1() {
        VirusTransmission virusTransmission = new VirusTransmission("att", "desc", 0.5);
        virusTransmission.upLevel();
        int result = virusTransmission.getLevel();
        assertEquals(1, result);
    }

    @Test
    public void testUpLevelC2() {
        VirusTransmission virusTransmission = new VirusTransmission("att", "desc", 0.5);
        for (int i=0;i<7;i++) {
            virusTransmission.upLevel();
        }
        int result = virusTransmission.getLevel();
        assertEquals(5, result);
    }


    /* TEST : checkLevel */
    @Test
    public void testCheckLevel() {
        VirusTransmission virusTransmission = new VirusTransmission("att", "desc", 0.5);
        boolean result = virusTransmission.checkLevel();
        assertTrue(result);
    }

    /* TEST : getInfectionRate */
    @Test
    public void testGetInfectionRate() {
        VirusTransmission virusTransmission = new VirusTransmission("att", "desc", 0.5);
        double result = virusTransmission.getInfectionRate();
        assertEquals(0.5, result);
    }

    /* TEST : isResearched */
    @Test
    public void testGetResearched() {
        VirusTransmission virusTransmission = new VirusTransmission("att", "desc", 0.5);
        boolean result = virusTransmission.isResearched();
        assertFalse(result);
    }

    /* TEST : setResearched */
    @Test
    public void testSetResearched() {
        VirusTransmission virusTransmission = new VirusTransmission("att", "desc", 0.5);
        virusTransmission.setResearched(true);
        boolean result = virusTransmission.isResearched();
        assertTrue(result);
    }
}
