package be.kdg.cars2;

public interface Auto {
    int MAX_OLIETEMPERATUUR = 120;

    void versnel(int toename);

    void vertraag(int afname);

    int getSnelheid();

    String getStatus();
}
