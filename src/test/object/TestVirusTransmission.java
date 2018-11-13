package test.object;

import object.VirusTransmission;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class TestVirusTransmission {
    /* TEST : getLevel */
    @Test
    public void TestGetLevel(){
        VirusTransmission virusTransmission = new VirusTransmission("att", "desc", 0.5);
        int result = virusTransmission.getLevel();
        assertEquals(0,result);
    }

    /* TEST : setLevel */
    @Test
    public void TestSetLevel(){
        VirusTransmission virusTransmission = new VirusTransmission("att", "desc", 0.5);
        virusTransmission.setLevel(3);
        int result = virusTransmission.getLevel();
        assertEquals(3,result);
    }

    /* TEST : upLevel */
    @Test
    public void TestUpLevel(){
        VirusTransmission virusTransmission = new VirusTransmission("att", "desc", 0.5);
        virusTransmission.upLevel();
        int result = virusTransmission.getLevel();
        assertEquals(2,result);
    }

    /* TEST : checkLevel */
    @Test
    public void TestCheckLevel(){
        VirusTransmission virusTransmission = new VirusTransmission("att", "desc", 0.5);
        boolean result = virusTransmission.checkLevel();
        assertTrue(result);
    }

    /* TEST : getInfectionRate */
    @Test
    public void TestGetInfectionRate(){
        VirusTransmission virusTransmission = new VirusTransmission("att", "desc", 0.5);
        double result = virusTransmission.getInfectionRate();
        assertEquals(0.5,result);
    }

    /* TEST : getResearched */
    @Test
    public void TestGetResearched(){
        VirusTransmission virusTransmission = new VirusTransmission("att", "desc", 0.5);
        boolean result = virusTransmission.getResearched();
        assertFalse(result);
    }

    /* TEST : setResearched */
    @Test
    public void TestSetResearched(){
        VirusTransmission virusTransmission = new VirusTransmission("att", "desc", 0.5);
        virusTransmission.setResearched(true);
        boolean result = virusTransmission.getResearched();
        assertTrue(result);
    }
}
