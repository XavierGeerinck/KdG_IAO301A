package be.kdg.jutil;

import be.kdg.jutil.objectmother.WinkelWagentjeObjectMother;
import be.kdg.jutil.objectmother.ProductObjectMother;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.fail;
import org.testng.annotations.Test;

import java.util.List;

// TODO Installeren TestNG-J plugin voor integratie van TestNG in IntelliJ?

public class TestWinkelWagentjeMetObjectMother_TestNG {

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

    @Test (expectedExceptions = {IllegalArgumentException.class})
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
}
