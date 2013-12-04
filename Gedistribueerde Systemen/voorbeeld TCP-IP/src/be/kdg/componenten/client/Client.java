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
     * @param contactsAddress the address of the Contacts component.
     */
    public Client(NetworkAddress contactsAddress) {
        contacts = new ContactsStub(contactsAddress);
    }

    /**
     * Adds two contacts (1 invalid and one correct) to the Contacts component
     * and tests if they are present.
     */
    private void run() {
        Address address = new Address("Langestraat", "42", "2000", "Ergens");
        contacts.add("ikke", address, "03/123.45.67");
        address = new Address("Langestraat", "42", "2000", "Antwerpen");
        contacts.add("gij", address, "03/765.43.21");

        System.out.println("address of ikke is:");
        address = contacts.addressOf("ikke");
        System.out.println(address);
        System.out.println("address of gij is:");
        address = contacts.addressOf("gij");
        System.out.println(address);
    }

    /**
     * Starts this component.
     *
     * @param args the ip-address and port-number of the Contacts component.
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java Client <contactsIP> <contactsPort>");
            System.exit(1);
        }
        int port = Integer.parseInt(args[1]);
        NetworkAddress contactsAddress = new NetworkAddress(args[0], port);
        Client client = new Client(contactsAddress);
        client.run();
    }
}
