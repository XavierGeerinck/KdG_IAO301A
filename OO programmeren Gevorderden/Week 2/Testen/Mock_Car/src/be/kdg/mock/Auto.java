package be.kdg.mock;

public interface Auto {
    int MAX_OLIETEMPERATUUR = 120;

    void versnel(int toename);

    void vertraag(int afname);

    int getSnelheid();

    String getStatus();
}
