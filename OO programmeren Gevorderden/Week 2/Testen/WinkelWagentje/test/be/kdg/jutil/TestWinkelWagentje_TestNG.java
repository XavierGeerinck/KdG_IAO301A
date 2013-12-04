package be.kdg.jutil;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.fail;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

// TODO Installeren TestNG-J plugin voor integratie van TestNG in IntelliJ

public class TestWinkelWagentje_TestNG {

    private WinkelWagentje wagentje;
    private Product boek;

    @BeforeMethod
    public void setUp() {
        wagentje = new WinkelWagentje();
        boek = new Product("Extreme Programming", 23.95);
        wagentje.voegToe(boek);
    }

    @AfterMethod
    public void tearDown() {
        wagentje = null;
    }

    @Test
    public void voegToe() {
        Product nieuwBoek = new Product("Refactoring", 53.95);
        wagentje.voegToe(nieuwBoek);
        double verwachtSaldo = boek.getPrijs() + nieuwBoek.getPrijs();
        assertEquals("Het saldo moet <77.90> zijn", verwachtSaldo, wagentje.getSaldo(), 0.0);
        assertEquals("Het aantal moet <2> zijn", 2, wagentje.getAantal());
    }

    @Test
    public void verwijder() throws IllegalArgumentException {
        wagentje.verwijder(boek);
        assertEquals("Het aantal moet <0> zijn", 0, wagentje.getAantal());
        assertEquals("Het saldo moet <0.0> zijn", 0.0, wagentje.getSaldo(), 0.0);
    }

    @Test (expectedExceptions = {IllegalArgumentException.class})
    public void verwijderNietAanwezig() {
        Product anderBoek = new Product("Ender's Game", 4.95);
        wagentje.verwijder(anderBoek);
        fail("Een onbekend boek moet een exception veroorzaken");
    }

    @Test
    public void maakWagentjeLeeg() {
        wagentje.maakWagentjeLeeg();
        assertEquals("Het wagentje moet leeg zijn", 0, wagentje.getAantal());
        assertEquals("Het saldo moet <0> zijn", 0.0, wagentje.getSaldo(), 0.0);
    }

    @Test
    public void getWagentje() {
        List lijst = wagentje.getWagentje();
        Product boek = (Product) lijst.get(0);
        assertEquals("Het aantal producten moet <1> zijn", 1, lijst.size());
        assertEquals("Het boek moet <Extreme Programming> zijn", "Extreme Programming", boek.getNaam());
        assertEquals("De prijs van het boek moet <23.95> zijn", 23.95, boek.getPrijs(), 0.0);
    }
}
