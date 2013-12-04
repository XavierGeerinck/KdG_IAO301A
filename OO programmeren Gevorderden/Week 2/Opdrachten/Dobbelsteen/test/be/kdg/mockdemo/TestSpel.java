package be.kdg.mockdemo;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Werk deze klasse verder uit, vul aan waar nodig.
 *
 */
public class TestSpel {
    private MockDobbelsteen steen;
    private MockSpel spel;

    private static List<Integer> driemaalEen = new ArrayList<Integer>(3);
    private static List<Integer> driemaalTwee = new ArrayList<Integer>(3);
    private static List<Integer> driemaalVijf = new ArrayList<Integer>(3);
    private static List<Integer> duizend = new ArrayList<Integer>(3);
    private static List<Integer> nul = new ArrayList<Integer>(3);
    private static List<Integer> vijftig = new ArrayList<Integer>(3);
    private static List<Integer> tweeMaalVijftig = new ArrayList<Integer>(3);
    private static List<Integer> honderd = new ArrayList<Integer>(3);
    private static List<Integer> honderdVijftig = new ArrayList<Integer>(3);
    private static List<Integer> tweehonderd = new ArrayList<Integer>(3);

    @BeforeClass
    public static void setStenen() {
        driemaalEen     = Arrays.asList(1, 1, 1);
        driemaalTwee    = Arrays.asList(2, 2, 2);
        driemaalVijf    = Arrays.asList(5, 5, 5);
        duizend         = Arrays.asList(4, 5, 6);
        nul             = Arrays.asList(3, 3, 2);
        vijftig         = Arrays.asList(5, 4, 3);
        tweeMaalVijftig = Arrays.asList(5, 5, 2);
        honderd         = Arrays.asList(1, 4, 3);
        honderdVijftig  = Arrays.asList(1, 5, 3);
        tweehonderd     = Arrays.asList(1, 1, 2);
    }

    @Before
    public void setUp() {
        steen = new MockDobbelsteen();
        spel = new MockSpel(steen);


    }

    @After
    public void tearDown() {
        steen = null;
        spel = null;
    }

    /**
     * Test speciale scores
     */
    @Test
    public void score500driemaalEen() {
        steen.waarden = driemaalEen;
        assertTrue(500 == spel.bepaalScore());
    }

    @Test
    public void score500driemaalTwee() {
        steen.waarden = driemaalTwee;
        assertTrue(500 == spel.bepaalScore());
    }

    @Test
    public void score500driemaalVijf() {
        steen.waarden = driemaalVijf;
        assertTrue(500 == spel.bepaalScore());
    }

    @Test
    public void score1000() {
        steen.waarden = duizend;
        assertTrue(1000 == spel.bepaalScore());
    }

    @Test
    public void scoreNul() {
        steen.waarden = nul;
        assertTrue(0 == spel.bepaalScore());
    }

    @Test
    public void score50() {
        steen.waarden = vijftig;
        assertTrue(50 == spel.bepaalScore());
    }

    @Test
    public void score100met2maal50() {
        steen.waarden = tweeMaalVijftig;
        assertTrue(100 == spel.bepaalScore());
    }

    @Test
    public void score100() {
        steen.waarden = honderd;
        assertTrue(100 == spel.bepaalScore());
    }

    @Test
    public void score150() {
        steen.waarden = honderdVijftig;
        assertTrue(150 == spel.bepaalScore());
    }

    @Test
    public void score200() {
        steen.waarden = tweehonderd;
        assertTrue(200 == spel.bepaalScore());
    }
}

