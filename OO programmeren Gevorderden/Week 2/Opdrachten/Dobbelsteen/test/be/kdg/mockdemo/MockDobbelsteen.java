package be.kdg.mockdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * In deze klasse hoef je niets aan te passen
 *
 */
public class MockDobbelsteen implements Rollable {
    private int index = 0;

    // package toegangkelijkheid voor het testen
    List<Integer> waarden = new ArrayList<Integer>();

    public int werp() {
        int waarde = waarden.get(index++);
        if (index >= waarden.size()) {
            index = 0;
        }
        return waarde;
    }
}
