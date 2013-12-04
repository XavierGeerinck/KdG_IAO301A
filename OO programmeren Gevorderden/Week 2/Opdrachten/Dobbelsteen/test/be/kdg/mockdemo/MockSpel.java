package be.kdg.mockdemo;

import java.util.Arrays;
import java.util.List;

/**
 *
 *
 */
public class MockSpel implements SpelI {
    private MockDobbelsteen steen;
    private Integer[] worpen = new Integer[3];

    public MockSpel(MockDobbelsteen steen) {
        this.steen = steen;
    }

    /**
     *   Werk deze methode verder uit, maak gebruik van de hoger gedeclareerde variabelen.
     */
    public int bepaalScore() {
        for (int i = 0; i < worpen.length; i++) {
            worpen[i] = steen.werp();
        }

        List worpen = Arrays.asList(this.worpen);
        int score = 0;

        // Case 4, 5, 6
        if (worpen.contains(4) && worpen.contains(5) && worpen.contains(6)) {
            score = 1000;
        // Case 3 times the same
        } else if((this.worpen[0] == this.worpen[1]) && (this.worpen[0]  == this.worpen[2])) {
            score = 500;
        } else {
            for (int worp : this.worpen) {
                if (worp == 5) {
                    score += 50;
                } else if (worp == 1) {
                    score += 100;
                }
            }
        }

        return score;
    }

    private int sumWorpen(int[] worpen) {
        int sum = 0;

        for (int worp : worpen) {
            sum += worp;
        }

        return sum;
    }


}