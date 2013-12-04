package be.kdg.dobbel;

import be.kdg.dobbel.mother.DobbelsteenMother;
import org.junit.*;

import static org.junit.Assert.*;

public class TestSpel {
    private Spel spel;

    @Before
    public  void setup() {
        spel = new Spel();
    }

    /**
     * Test speciale scores
     */
    @Test
    public void score500driemaalEen() {
        vergelijk(DobbelsteenMother.maakDrieMaalEen(), 500);
    }

    @Test
    public void score500driemaalTwee() {
        vergelijk(DobbelsteenMother.maakDrieMaalTwee(), 500);
    }

    @Test
    public void score500driemaalVijf() {
       vergelijk(DobbelsteenMother.maakDrieMaalVijf(), 500);
    }

     @Test
    public void score1000() {
        vergelijk(DobbelsteenMother.maakVierVijfZes(), 1000);
    }

    /**
     * Test gewone scores
     */

    @Test
    public void scoreNul() {
        vergelijk(DobbelsteenMother.maakTweeDrieVier(), 0);
    }

    @Test
    public void score50() {
       vergelijk(DobbelsteenMother.maakVijfZesTwee(), 50);
    }

    @Test
    public void score100met2maal50() {
       vergelijk(DobbelsteenMother.maakVijfVierVijf(), 100);
    }

    @Test
    public void score100() {
       vergelijk(DobbelsteenMother.maakDrieZesEen(), 100);
    }

    @Test
    public void score150() {
       vergelijk(DobbelsteenMother.maakVijfZesEen(), 150);
    }

    @Test
    public void score200() {
       vergelijk(DobbelsteenMother.maakEenEenVier(), 200);
    }

    private void vergelijk(Rollable steen, int expected) {
        spel.werpDriemaal(steen);
        int score = spel.bepaalScore();
        assertEquals(expected, score);
    }

    @Test
    public void testToString() {
        Rollable steen = DobbelsteenMother.maakVijfZesEen();
        spel.werpDriemaal(steen);
        String string = spel.toString();
        assertEquals(string, "5 6 1 ");
    }

    @After
    public void tearDown() {
        spel = null;
    }








}

