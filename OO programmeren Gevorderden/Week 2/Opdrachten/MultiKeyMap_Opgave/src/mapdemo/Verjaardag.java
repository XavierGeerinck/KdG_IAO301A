package mapdemo;

public class Verjaardag  {
    private int dag;
    private int maand;
    private String jarige;

    // Vul deze klasse verder aan!
    public Verjaardag(int dag, int maand, String jarige) {
        this.dag = dag;
        this.maand = maand;
        this.jarige = jarige;
    }

    public String getJarige() {
       return jarige;
    }

    public int getDag() {
        return dag;
    }

    public int getMaand() {
        return maand;
    }

    @Override
    public String toString() {
        return jarige;
    }
}
