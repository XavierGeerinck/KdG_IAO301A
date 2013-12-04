package mapdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Data {
    private static final List<Verjaardag> lijst = new ArrayList<>();

    static {
        lijst.add(new Verjaardag(18, 9, "Magda"));
        lijst.add(new Verjaardag(5, 5, "Jelmer"));
        lijst.add(new Verjaardag(23, 8, "Vera"));
        lijst.add(new Verjaardag(18, 9, "Liesa"));
        lijst.add(new Verjaardag(13, 3, "Willy"));
        lijst.add(new Verjaardag(5, 5, "Kim"));
    }

    public static List<Verjaardag> getData() {
        return Collections.unmodifiableList(lijst);
    }
}

