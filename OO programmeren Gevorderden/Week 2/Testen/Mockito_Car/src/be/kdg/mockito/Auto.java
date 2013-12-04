package be.kdg.mockito;

/**
 * @author Kristiaan Behiels
 * @version 1.0 4-dec-2008 17:36:08
 */
public interface Auto {
    int MAX_OLIETEMPERATUUR = 120;

    void versnel(int toename);

    void vertraag(int afname);

    int getSnelheid();

    String getStatus();
}
