package be.kdg.jutil;

import be.kdg.jutil.objectmother.ProductObjectMother;
import be.kdg.jutil.objectmother.WinkelWagentjeObjectMother;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

import java.util.List;

public class TestWinkelWagentjeMetObjectMother {

    @Test
    public void voegToe() {
        WinkelWagentje wagentje = WinkelWagentjeObjectMother.maakWagentjeMetEenBoek();
        Product nieuwBoek = ProductObjectMother.maakRefactoringBoek();
        wagentje.voegToe(nieuwBoek);

        assertEquals("Het saldo moet <77.90> zijn", 77.90, wagentje.getSaldo(), 0.0);
        assertEquals(2, wagentje.getAantal());
    }

    @Test
    public void testWagentjeLeegMaken() {
        WinkelWagentje wagentje = WinkelWagentjeObjectMother.maakWagentjeMetTweeBoeken();
        wagentje.maakWagentjeLeeg();

        assertEquals("Het wagentje moet leeg zijn", 0, wagentje.getAantal());
        assertEquals("Het saldo moet <0> zijn", 0.0, wagentje.getSaldo(), 0.0);
    }

    @Test
    public void verwijder() throws IllegalArgumentException {
        WinkelWagentje wagentje = WinkelWagentjeObjectMother.maakWagentjeMetEenBoek();
        wagentje.verwijder(new Product("Extreme Programming", 23.95));

        assertEquals("Het aantal moet <0> zijn", 0, wagentje.getAantal());
        assertEquals("Het saldo moet <0.0> zijn", 0.0, wagentje.getSaldo(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void verwijderNietAanwezig() {
        WinkelWagentje wagentje = WinkelWagentjeObjectMother.maakWagentjeMetTweeBoeken();
        Product anderBoek = ProductObjectMother.maakAnderBoek();
        wagentje.verwijder(anderBoek);
        fail("Een onbekend boek moet een exception veroorzaken");
    }

    @Test
    public void getWagentje() {
        WinkelWagentje wagentje = WinkelWagentjeObjectMother.maakWagentjeMetEenBoek();
        List lijst = wagentje.getWagentje();
        Product boek = (Product) lijst.get(0);

        assertEquals("Het aantal producten moet <1> zijn", 1, lijst.size());
        assertEquals("Het boek moet <Extreme Programming> zijn", "Extreme Programming", boek.getNaam());
        assertEquals("De prijs van het boek moet <23.95> zijn", 23.95, boek.getPrijs(), 0.0);
    }

    /*

     public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(TestWinkelWagentjeMetObjectMother.class);
    }
    */
}
