/*
 * Gedistribueerde systemen
 * Karel de Grote-Hogeschool
 * 2006-2007
 * Kris Demuynck
 */

package be.kdg.componenten.zipcodes;

/**
 * Interface for the ZipCodes component.
 */
public interface ZipCodes {
    /**
     * Adds a zip-code and a city to the database.
     *
     * @param code the zip-code.
     * @param city the name of the city.
     */
    public void add(String code, String city);

    /**
     * Retrieves the zip-code for a given city.
     *
     * @param city the name of the city.
     * @return the zip-code of the city.
     */
    public String getCode(String city);

    /**
     * Retrieves the name of a city for a given zip-code.
     *
     * @param code the zip-code of the city.
     * @return the name of the city.
     */
    public String getCity(String code);
}
