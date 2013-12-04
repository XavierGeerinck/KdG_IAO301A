package be.kdg.mockdemo;

/**
 * @author Kristiaan Behiels
 * @version 1.0 22-nov-2008
 */

/*
 * In dit spel werp je eenmaal met drie dobbelstenen.
 * Daarna wordt je score bepaald en wel als volgt:
 *
 * Indien je een 4, een 5 en een 6 gooit krijg je 1000 punten.
 * Indien je driemaal dezelfde waarde gooit krijg je 500 punten.
 * In alle andere gevallen krijg je voor elke 5 50 punten en voor elke 1 100 punten.
 */

/**
 * Deze interface gebruik je om een Mock spel te maken.
 *
 * Bij deze oefening zal je testen schrijven zonder het werkelijke spel uit te werken,
 * alles wordt dus "gemockt".
 *
 */
public interface SpelI {
    int bepaalScore();
}
