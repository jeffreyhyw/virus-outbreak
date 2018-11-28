package test.object;

import object.VirusAttribute;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class TestVirusAttribute {

    /* TEST : getAtt_name */
    @Test
    public void testGetAtt_name() {
        VirusAttribute virusAttribute = new VirusAttribute("att", "desc", 30);
        String result = virusAttribute.getAtt_name();
        assertEquals("att", result);
    }

    /* TEST : getDescription */
    @Test
    public void testGetDescription() {
        VirusAttribute virusAttribute = new VirusAttribute("att", "desc", 30);
        String result = virusAttribute.getDescription();
        assertEquals("desc", result);
    }

    /* TEST : getCost */
    @Test
    public void testGetCost() {
        VirusAttribute virusAttribute = new VirusAttribute("att", "desc", 30);
        int result = virusAttribute.getCost();
        assertEquals(30, result);
    }

    /* TEST : isResearched */
    @Test
    public void testGetResearched() {
        VirusAttribute virusAttribute = new VirusAttribute("att", "desc", 30);
        boolean result = virusAttribute.isResearched();
        assertFalse(result);
    }

    /* TEST : setResearched */
    @Test
    public void testSetResearched() {
        VirusAttribute virusAttribute = new VirusAttribute("att", "desc", 30);
        virusAttribute.setResearched(true);
        boolean result = virusAttribute.isResearched();
        assertTrue(result);
    }

}
