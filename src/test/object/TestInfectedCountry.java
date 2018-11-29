package test.object;


import object.DeadCountry;
import object.InfectedCountry;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class TestInfectedCountry {

    /* TEST: isAll() */
    @Test
    public void testIsAll() {
        InfectedCountry infectedCountry = new InfectedCountry();
        boolean result = infectedCountry.isAll();
        assertFalse(result);
    }

    /* TEST: setAll() */
    @Test
    public void testSetAll() {
        InfectedCountry infectedCountry = new InfectedCountry();
        infectedCountry.setAll(true);
        boolean result = infectedCountry.isAll();
        assertTrue(result);
    }

}
