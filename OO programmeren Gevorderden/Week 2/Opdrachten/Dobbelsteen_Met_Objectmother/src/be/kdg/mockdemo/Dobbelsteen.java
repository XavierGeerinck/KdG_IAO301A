package be.kdg.mockdemo;

import java.util.Random;

public class Dobbelsteen implements Rollable {
    private Random random = new Random();

    public int werp() {
        return random.nextInt(6) + 1;
    }
}
