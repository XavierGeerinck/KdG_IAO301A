/*
 * Gedistribueerde systemen
 * Karel de Grote-Hogeschool
 * 2006-2007
 * Kris Demuynck
 */

package be.kdg.componenten.contacts;

/**
 * Represents a contact containing a name, an address and a telephone number.
 * Implemented as an immutable class.
 */
public final class Contact {
    private final String name;
    private final Address address;
    private final String tel;
    private final String asString;

    /**
     * Constructs a new Contact with the given name, address and telephone number.
     *
     * @param name    the name of the contact.
     * @param address the address of the contact.
     * @param tel     the telephone-number of the contact (may contain any characters).
     */
    public Contact(String name, Address address, String tel) {
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.asString = "[ " + name + ", " + address + ", " + tel + "]";
    }


    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getTel() {
        return tel;
    }

    public String toString() {
        return asString;
    }
}
