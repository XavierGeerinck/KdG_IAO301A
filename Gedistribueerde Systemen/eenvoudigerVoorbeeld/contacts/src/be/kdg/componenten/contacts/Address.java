/*
 * Gedistribueerde systemen
 * Karel de Grote-Hogeschool
 * 2006-2007
 * Kris Demuynck
 */

package be.kdg.componenten.contacts;

import be.kdg.util.Nullable;

/**
 * Represents an address containing a street, number, zip-code and city.
 * Implemented as an immutable class (except that class is not final:
 * this is to allow NullAddress to inherit from this class).
 */
public class Address implements Nullable {
    private final String street;
    private final String number;
    private final String zip;
    private final String city;
    private final String asString;

    /**
     * Constructs a new Address with the given street, number, zip-code and city.
     *
     * @param street the name of the street.
     * @param number the number (may contain any characters).
     * @param zip    the zip-code of the city.
     * @param city   the name of the city.
     */
    public Address(String street, String number, String zip, String city) {
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.city = city;
        this.asString = street + " " + number + ", " + zip + " " + city;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String toString() {
        return asString;
    }

    public boolean isNull() {
        return false;
    }
}
