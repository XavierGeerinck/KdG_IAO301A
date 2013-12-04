package mapdemo;

import java.util.*;

public class VerjaardagsKalender {
    private Map<String, Collection<Verjaardag>> verjaardagen;


    // Vul de onderstaande methoden aan!

    public VerjaardagsKalender() {
        this.verjaardagen = new HashMap<>();
    }

    public void voegToe(Verjaardag verjaardag) {
        // Calc key
        String sleutel = getSleutel(verjaardag);

        // Check if we don't got the key
        if (!this.verjaardagen.containsKey(sleutel)) {
            verjaardagen.put(sleutel, new ArrayList<Verjaardag>());
        }

        this.verjaardagen.get(sleutel).add(verjaardag);
    }

    public void verwijder(Verjaardag verjaardag) {
        // Calc key
        String sleutel = getSleutel(verjaardag);

        if (this.verjaardagen.get(sleutel) != null) {
            if (this.verjaardagen.get(sleutel).contains(verjaardag)) {
                this.verjaardagen.get(sleutel).remove(verjaardag);
            }

            // Check if count is 0
            if (this.verjaardagen.get(sleutel).isEmpty()) {
                this.verjaardagen.remove(sleutel);
            }
        }
    }

    public Collection<Verjaardag> zoekOpVerjaardag(String sleutel) {
        Collection<Verjaardag> results = this.verjaardagen.get(sleutel);

        if (results != null) {
            return results;
        }

        return null;
    }

    @Override
    public String toString() {
        return "" + verjaardagen;
    }

    private String getSleutel(Verjaardag verjaardag) {
        String dag = "" + verjaardag.getDag();
        String maand = "" + verjaardag.getMaand();

        if (verjaardag.getDag() < 10) {
            dag = "0" + verjaardag.getDag();
        }

        if (verjaardag.getMaand() < 10) {
            maand = "0" + verjaardag.getMaand();
        }

        return String.format("%s/%s", dag, maand);
    }
}
