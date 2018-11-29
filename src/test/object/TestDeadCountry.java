package test.object;

import object.Country;
import object.CountryClimate;
import object.DeadCountry;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class TestDeadCountry {

    /* TEST: isAll() */
    @Test
    public void testIsAll() {
        DeadCountry deadCountry = new DeadCountry();
        boolean result = deadCountry.isAll();
        assertFalse(result);
    }

    /* TEST: setAll() */
    @Test
    public void testSetAll() {
        DeadCountry deadCountry = new DeadCountry();
        deadCountry.setAll(true);
        boolean result = deadCountry.isAll();
        assertTrue(result);
    }
}
