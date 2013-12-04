/*
 * Gedistribueerde systemen
 * Karel de Grote-Hogeschool
 * 2006-2007
 * Kris Demuynck
 */

package be.kdg.componenten.zipcodes;

import java.util.Map;
import java.util.TreeMap;

/**
 * Implementation of the ZipCodes component.
 */
public final class ZipCodesImpl implements ZipCodes {
    private final Map<String, String> codes;
    private final Map<String, String> cities;

    /**
     * Constructs a new ZipCode component.
     * Some data is already put in the database.
     */
    public ZipCodesImpl() {
        codes = new TreeMap<String, String>();
        cities = new TreeMap<String, String>();
        codes.put("Antwerpen", "2000");
        cities.put("2000", "Antwerpen");
    }

    /**
     * @see ZipCodes#add
     */
    public void add(String code, String city) {
        //System.out.println("ZipCodesImpl:add(" + code + ", " + city + ")");
        codes.put(city, code);
        cities.put(code, city);
    }

    /**
     * @see ZipCodes#getCode
     */
    public String getCode(String city) {
        //System.out.println("ZipCodesImpl:getCode(" + city + ")");
        return codes.get(city);
    }

    /**
     * @see ZipCodes#getCity
     */
    public String getCity(String code) {
        //System.out.println("ZipCodesImpl:getCity(" + code + ")");
        return cities.get(code);
    }
}
