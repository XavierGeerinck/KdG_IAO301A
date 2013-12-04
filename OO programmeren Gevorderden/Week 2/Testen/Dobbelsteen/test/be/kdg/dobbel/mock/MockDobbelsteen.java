package be.kdg.dobbel.mock;

import be.kdg.dobbel.Rollable;

import java.util.ArrayList;
import java.util.List;

public class MockDobbelsteen implements Rollable {
    private int index = 0;
    private List<Integer> waarden = new ArrayList<>();

    public MockDobbelsteen(int een, int twee, int drie) {
        waarden.add(een);
        waarden.add(twee);
        waarden.add(drie);
    }

    public int werp() {
        int waarde = waarden.get(index++);
        if (index >= waarden.size()) {
            index = 0;
        }
        return waarde;
    }
}
