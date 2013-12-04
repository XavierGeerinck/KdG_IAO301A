/*
 * Gedistribueerde systemen
 * Karel de Grote-Hogeschool
 * 2006-2007
 * Kris Demuynck
 */
package be.kdg.componenten.client;

import be.kdg.componenten.communication.NetworkAddress;
import be.kdg.componenten.contacts.Address;
import be.kdg.componenten.contacts.Contacts;
import be.kdg.componenten.contacts.ContactsStub;

/**
 * Represents a client component that tests the Contacts component.
 */
public class Client {
    private Contacts contacts;

    /**
     * Creates a new Client component.
     *
     * @param contacts an object that implements the Contacts-interface
     */
    public Client(Contacts contacts) {
        this.contacts = contacts;
    }

    /**
     * Adds two contacts (1 invalid and one correct) to the Contacts component
     * and tests if they are present.
     */
    public void run() {
        Address address = new Address("Langestraat", "42", "2000", "Ergens");
        contacts.add("ikke", address, "03/123.45.67");
        address = new Address("Langestraat", "42", "2000", "Antwerpen");
        contacts.add("gij", address, "03/765.43.21");
        contacts.remove("ikke");

        System.out.println("address of ikke is:");
        address = contacts.addressOf("ikke");
        System.out.println(address);
        System.out.println("address of gij is:");
        address = contacts.addressOf("gij");
        System.out.println(address);
    }


}
