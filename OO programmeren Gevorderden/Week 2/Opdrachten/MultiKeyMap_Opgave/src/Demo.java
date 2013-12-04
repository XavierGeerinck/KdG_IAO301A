
import mapdemo.VerjaardagsKalender;
import mapdemo.Verjaardag;
import mapdemo.Data;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 *  Dit is een opgave om het opslaan van meerdere values met dezelfde key in een
 *  map te demonstreren. In dit geval wordt de key samengesteld uit de
 *  attributen maand en dag (beide int), ze worden omgezet naar een string
 *  in de vorm MM/DD (bv 03/28 of 11/05) - methode getSleutel().
 *
 *  De klasse Verjaardag bevat de attributen maand (int), dag (int) en jarige (String).
 *  Bepaal zelf welke methoden je in deze klasse nodig hebt.
 *
 *  De objecten van het type verjaardag moeten in een map (naam verjaardagen)
 *  opgeslagen worden op basis van de hoger vernoemde key ("MM/DD")
 *  en het ganse object als value.
 *
 *  De klasse Verjaardagskalender bevat alleen het attribuut verjaardagen (Map).
 *  In deze klasse dien je, naast een constructor en een toString methode
 *  de volgde methoden te voorzien:
 *
 *      public void voegToe(Verjaardag verjaardag);
 *      public void verwijder(Verjaardag verjaardag);
 *
 *  Belangrijke opmerking: Dit programma is geschreven voor JDK 4 (Java 1.4)
 *
 *  Verwachte uitvoer:

Kalender = [[05/05 - Jelmer, 05/05 - Kim], [13/03 - Willy], [18/09 - Magda, 18/09 - Liesa], [23/08 - Vera]]

Jarigen op 18/09:
Magda
Liesa

Jarigen op 13/03:
Willy

Jarigen op 16/03:

Kalender = [[05/05 - Jelmer, 05/05 - Kim], [18/09 - Magda], [23/08 - Vera]]
 */

public class Demo {
    public static void main(String[] args) {
        VerjaardagsKalender kalender = new VerjaardagsKalender();

        // invoer data
        List lijst = Data.getData();
        for (Iterator it = lijst.iterator(); it.hasNext(); ) {
            kalender.voegToe((Verjaardag)it.next());
        }

        // controle-afdruk: originele inhoud
        System.out.println("\nKalender = " + kalender);

        toonJarigOpDatum(kalender, "18/09");
        toonJarigOpDatum(kalender, "13/03");
        toonJarigOpDatum(kalender, "16/03");

        Verjaardag liesa = new Verjaardag(18, 9, "Liesa");
        Verjaardag willy = new Verjaardag(13, 3, "Willy");
        Verjaardag dummy = new Verjaardag(16, 3, "Dummy");

        kalender.verwijder(liesa);
        kalender.verwijder(willy);
        kalender.verwijder(dummy);

        // controle-afdruk: na verwijderen
        System.out.println("\nKalender = " + kalender);
    }

    private static void toonJarigOpDatum(VerjaardagsKalender kalender, String datum) {
        Collection jarigen = kalender.zoekOpVerjaardag(datum);

        System.out.println("\nJarigen op " + datum + ":");
        for (Iterator it = jarigen.iterator(); it.hasNext(); ) {
            Verjaardag dag = (Verjaardag) it.next();
            System.out.println(dag.getJarige());
        }
    }
}

