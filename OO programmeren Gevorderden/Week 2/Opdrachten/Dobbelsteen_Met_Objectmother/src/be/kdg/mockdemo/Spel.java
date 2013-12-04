package be.kdg.mockdemo;

/**
 * Hier is spel uitgewerkt
 */
public class Spel {
    private int[] worpen = new int[3];

    public Spel() {
        Rollable steen = new Dobbelsteen();
        speel(steen);
    }

    private void speel(Rollable steen) {
        werpDriemaal(steen);
        int score = bepaalScore();
        System.out.printf("Geworpen %s --> score = %d\n", this, score);
    }

    public void werpDriemaal(Rollable steen) {
        for (int i = 0; i < 3; i++) {
            worpen[i] = steen.werp();
        }
    }

    public int bepaalScore() {
       if (vierVijfZes()) {
            return 1000;
        }
        if (alleGelijk()) {
            return 500;
        }
        int score = 0;
        for (int i = 0; i < 3; i++) {
            int worp = worpen[i];
            if (worp == 5) {
                score += 50;
            }
            if (worp == 1) {
                score += 100;
            }
        }
        return score;
    }

    private boolean vierVijfZes() {
        int aantal4 = bepaalAantal(4);
        int aantal5 = bepaalAantal(5);
        int aantal6 = bepaalAantal(6);
        return aantal4 == 1 && aantal5 == 1 && aantal6 == 1;
    }

    private int bepaalAantal(int testWaarde) {
        int aantal = 0;
        for (int i = 0; i < 3; i++) {
            if (worpen[i] == testWaarde) aantal++;
        }
        return aantal;
    }

    private boolean alleGelijk() {
        return worpen[0] == worpen[1] && worpen[1] == worpen[2];
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < 3; i++) {
           s +=  Integer.toString(worpen[i]) + " ";
        }
        return s;
    }

}
