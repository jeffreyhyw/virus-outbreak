package test.object;

import object.VirusAttribute;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class TestVirusAttribute {

    /* TEST : getAtt_name */
    @Test
    public void TestGetAtt_name(){
        VirusAttribute virusAttribute = new VirusAttribute("att","desc",30);
        String result = virusAttribute.getAtt_name();
        assertEquals("att",result);
    }

    /* TEST : getDescription */
    @Test
    public void TestGetDescription(){
        VirusAttribute virusAttribute = new VirusAttribute("att","desc",30);
        String result = virusAttribute.getDescription();
        assertEquals("desc",result);
    }

    /* TEST : getCost */
    @Test
    public void TestGetCost(){
        VirusAttribute virusAttribute = new VirusAttribute("att","desc",30);
        int result = virusAttribute.getCost();
        assertEquals(30, result);
    }

    /* TEST : getResearched */
    @Test
    public void TestGetResearched(){
        VirusAttribute virusAttribute = new VirusAttribute("att","desc",30);
        boolean result = virusAttribute.getResearched();
        assertFalse(result);
    }

    /* TEST : setResearched */
    @Test
    public void TestSetResearched(){
        VirusAttribute virusAttribute = new VirusAttribute("att","desc",30);
        virusAttribute.setResearched(true);
        boolean result = virusAttribute.getResearched();
        assertTrue(result);
    }

}
