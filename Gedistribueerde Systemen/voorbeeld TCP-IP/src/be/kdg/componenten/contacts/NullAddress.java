/*
 * Gedistribueerde systemen
 * Karel de Grote-Hogeschool
 * 2006-2007
 * Kris Demuynck
 */

package be.kdg.componenten.contacts;

import be.kdg.util.Nullable;

/**
 * Represents an invalid address.
 * Implemented as a Singleton and an immutable class.
 */
public final class NullAddress extends Address implements Nullable {
    private static NullAddress theNullAddress = new NullAddress();

    public static Address getInstance() {
        return theNullAddress;
    }

    private NullAddress() {
        super("Invalid street", "Invalid number", "Invalid zip", "Invalid city");
    }

    public String toString() {
        return "Invalid address";
    }

    public boolean isNull() {
        return true;
    }
}
