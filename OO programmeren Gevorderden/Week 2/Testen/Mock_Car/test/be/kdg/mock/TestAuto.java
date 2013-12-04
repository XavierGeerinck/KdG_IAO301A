package be.kdg.mock;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestAuto {
    private Auto testAuto;
    private MockMotor motor;

    @Before
    public void setUp() {
        motor = new MockMotor();
        testAuto = new AutoImpl(motor);
    }

    @Test
    public void versnelNaar30kph() {
        testAuto.versnel(100);
        testAuto.versnel(200);
        assertEquals("De snelheid moet <30> zijn.", 30, testAuto.getSnelheid());
    }

    @Test
    public void vertraagNaar30kph() {
        testAuto.versnel(500);
        testAuto.vertraag(200);
        assertEquals("De snelheid moet <30> zijn.", 30, testAuto.getSnelheid());        
    }

    @Test
    public void statusOk() {
        motor.setTemperatuur(80);
        assertEquals("Bij 80° moet de status 'ok' zijn.", "ok", testAuto.getStatus());
    }

    @Test
    public void statusMax() {
        motor.setTemperatuur(Auto.MAX_OLIETEMPERATUUR);
        assertEquals("Bij " + (Auto.MAX_OLIETEMPERATUUR) + "° moet de status 'ok' zijn.",
                "ok", testAuto.getStatus());
    }

    @Test
    public void statusOververhitting() {
        motor.setTemperatuur(Auto.MAX_OLIETEMPERATUUR + 1);
        assertEquals("Bij " + (Auto.MAX_OLIETEMPERATUUR + 1) + "° moet de status 'oververhitting' zijn.",
                "oververhitting", testAuto.getStatus());
    }
}