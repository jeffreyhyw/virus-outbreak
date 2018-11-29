package test.object;

import object.InfectedCountry;
import object.NormalCountry;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class TestNormalCountry {

    /* TEST: isAll() */
    @Test
    public void testIsAll() {
        NormalCountry normalCountry = new NormalCountry();
        boolean result = normalCountry.isAll();
        assertFalse(result);
    }

    /* TEST: setAll() */
    @Test
    public void testSetAll() {
        NormalCountry normalCountry = new NormalCountry();
        normalCountry.setAll(true);
        boolean result = normalCountry.isAll();
        assertTrue(result);
    }
}
