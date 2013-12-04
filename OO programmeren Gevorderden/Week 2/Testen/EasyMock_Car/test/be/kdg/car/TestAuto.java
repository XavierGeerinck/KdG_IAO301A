package be.kdg.car;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestAuto {
    private Auto testAuto;
    private Motor mock;

    @Before
    public void setUp() {
        mock = createMock(Motor.class);
        testAuto = new AutoImpl(mock);
    }

    @Test
    public void versnelNaar30kph() {
        // Voorbereiding voor de invloed van versnel() op
        // de Motor als Auto goed werkt.
        expect(mock.getToerental()).andReturn(0);
        mock.setToerental(100);
        expect(mock.getToerental()).andReturn(100);
        mock.setToerental(300);
        replay(mock);

        // Test het gedrag
        testAuto.versnel(100);
        testAuto.versnel(200);

        // Controle of de verwachte oproepen gedaan werden.
        verify(mock);

        // Test op basis van een gekende returnwaarde van de Motor
        reset(mock);
        expect(mock.getToerental()).andReturn(300);
        replay(mock);
        int snelheid = testAuto.getSnelheid();

        verify(mock);
        assertEquals("De snelheid moet <30> zijn.", 30, snelheid);

    }

        @Test
        public void vertraagNaar30kph() {
        // Voorbereiding voor de invloed van versnel()/vertraag() op
        // de Motor als Auto goed werkt.
        expect(mock.getToerental()).andReturn(0);
        mock.setToerental(500);
        expect(mock.getToerental()).andReturn(500);
        mock.setToerental(300);
        replay(mock);

        // Test het gedrag
        testAuto.versnel(500);
        testAuto.vertraag(200);    

        // Controle of de verwachte oproepen gedaan werden.
        verify(mock);
    }

    @Test
    public void statusOk() {
        // Bij de oproep van getStatus() moet de mock een temperatuur teruggeven
        expect(mock.getTemperatuur()).andReturn(80);
        replay(mock);
        String status = testAuto.getStatus();
        
        // Test met een 80° mock
        verify(mock);
        assertEquals("Bij 80° moet de status 'ok' zijn.", "ok", status);
     
    }

    @Test
    public void statusMax() {
        reset(mock);
        expect(mock.getTemperatuur()).andReturn(Auto.MAX_OLIETEMPERATUUR);
        replay(mock);
        String status = testAuto.getStatus();
        
        verify(mock);
        assertEquals("Bij " + (Auto.MAX_OLIETEMPERATUUR) + "° moet de status 'ok' zijn.",
                "ok", status);
    }

    @Test
    public void statusOververhitting() {
        reset(mock);
        expect(mock.getTemperatuur()).andReturn(Auto.MAX_OLIETEMPERATUUR + 1);
        replay(mock);
        String status = testAuto.getStatus();

        verify(mock);
        assertEquals("Bij " + (Auto.MAX_OLIETEMPERATUUR + 1) + "° moet de status 'oververhitting' zijn.",
                "oververhitting", status);
        
    }
}