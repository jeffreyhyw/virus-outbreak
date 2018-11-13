package test.object;

import object.VirusSymptom;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class TestVirusSymptom {

    /* TEST : getStatus */
    @Test
    public void TestGetStatus(){
        VirusSymptom virusSymptom = new VirusSymptom("symp", "desc", 0.5, 0.1);
        boolean result = virusSymptom.getStatus();
        assertFalse(result);
    }

    /* TEST : setStatus */
    @Test
    public void TestSetStatus(){
        VirusSymptom virusSymptom = new VirusSymptom("symp", "desc", 0.5, 0.1);
        virusSymptom.setStatus(true);
        boolean result = virusSymptom.getStatus();
        assertTrue(result);
    }

    /* TEST : getLevel */
    @Test
    public void TestGetLevel(){
        VirusSymptom virusSymptom = new VirusSymptom("symp", "desc", 0.5, 0.1);
        int result = virusSymptom.getLevel();
        assertEquals(0, result);
    }

    /* TEST : getKillPeopleRate */
    @Test
    public void TestGetKillPeopleRate(){
        VirusSymptom virusSymptom = new VirusSymptom("symp", "desc", 0.5, 0.1);
        double result = virusSymptom.getKillPeopleRate();
        assertEquals(0.15000000000000002, result);
    }

    /* TEST : setKillPeopleRate */
    @Test
    public void TestSetKillPeopleRate(){
        VirusSymptom virusSymptom = new VirusSymptom("symp", "desc", 0.5, 0.1);
        virusSymptom.setKillPeopleRate(0.33);
        double result = virusSymptom.getKillPeopleRate();
        assertEquals(0.495, result);
    }

    /* TEST : getInfectionRate */
    @Test
    public void TestGetInfectionRate(){
        VirusSymptom virusSymptom = new VirusSymptom("symp", "desc", 0.5, 0.1);
        double result = virusSymptom.getInfectionRate();
        assertEquals(0.5, result);
    }

    /* TEST : isResearched */
    @Test
    public void TestGetResearched(){
        VirusSymptom virusSymptom = new VirusSymptom("symp", "desc", 0.5, 0.1);
        boolean result = virusSymptom.isResearched();
        assertFalse(result);
    }

    /* TEST : setResearched */
    @Test
    public void TestSetResearched(){
        VirusSymptom virusSymptom = new VirusSymptom("symp", "desc", 0.5, 0.1);
        virusSymptom.setResearched(true);
        boolean result = virusSymptom.isResearched();
        assertTrue(result);
    }

    /* TEST : upLevel */
    @Test
    public void TestUpLevel(){
        VirusSymptom virusSymptom = new VirusSymptom("symp", "desc", 0.5, 0.1);
        boolean result = virusSymptom.upLevel();
        assertTrue(result);
    }



}
