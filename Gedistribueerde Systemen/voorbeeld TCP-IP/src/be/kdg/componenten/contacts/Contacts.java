/*
 * Gedistribueerde systemen
 * Karel de Grote-Hogeschool
 * 2006-2007
 * Kris Demuynck
 */

package be.kdg.componenten.contacts;

/**
 * Interface for the Contacts component.
 */
public interface Contacts {
    /**
     * Add a new contact to the database.
     *
     * @param name    the name of the contact.
     * @param address the address of the contact.
     * @param tel     the telephone-number of the contact.
     */
    public void add(String name, Address address, String tel);

    /**
     * Retrieves the address of a certain contact.
     *
     * @param name the name of the contact.
     * @return the address of the contact.
     */
    public Address addressOf(String name);

    /**
     * Removes a contact from the database.
     *
     * @param name the name of the contact.
     */
    public void remove(String name);
}
