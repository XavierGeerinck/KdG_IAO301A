package be.kdg.mockito;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

public class TestAuto {
    private Auto testAuto;
    @Mock  private Motor motor;

    @Before
    public void setUp() {
       MockitoAnnotations.initMocks(this); // Initialiseer alle mocks (@Mock annotation)
       testAuto = new AutoImpl(motor);
    }

    @Test
    public void versnelNaar30kph() {
        testAuto.versnel(100);
        testAuto.versnel(300);

        when(motor.getToerental()).thenReturn(300);

        verify(motor, times(2)).getToerental();

        assertEquals("De snelheid moet <30> zijn.", 30, testAuto.getSnelheid());
    }

    @Test
    public void vertraagNaar30kph() {
        testAuto.versnel(500);
        testAuto.vertraag(200);

        when(motor.getToerental()).thenReturn(300);

        verify(motor, times(2)).getToerental();

        assertEquals("De snelheid moet <30> zijn.", 30, testAuto.getSnelheid());
    }

    @Test
    public void statusOk() {
        when(motor.getTemperatuur()).thenReturn(80);

        String status = testAuto.getStatus();
        verify(motor).getTemperatuur();

        assertEquals("Bij 80° moet de status 'ok' zijn.", "ok", status);
    }

    @Test
    public void statusMax() {
        when(motor.getTemperatuur()).thenReturn(Auto.MAX_OLIETEMPERATUUR);

        String status = testAuto.getStatus();
        verify(motor).getTemperatuur();

        assertEquals("Bij " + (Auto.MAX_OLIETEMPERATUUR) + "° moet de status 'ok' zijn.", "ok", status);
    }

    @Test
    public void statusOververhitting() {
        when(motor.getTemperatuur()).thenReturn(Auto.MAX_OLIETEMPERATUUR + 1);

        String status = testAuto.getStatus();
        verify(motor).getTemperatuur();

        assertEquals("Bij " + (Auto.MAX_OLIETEMPERATUUR + 1) + "° moet de status 'oververhitting' zijn.",
                "oververhitting", status);
    }
}
