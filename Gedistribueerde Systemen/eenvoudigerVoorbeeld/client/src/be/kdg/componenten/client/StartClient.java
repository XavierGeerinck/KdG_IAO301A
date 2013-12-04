package be.kdg.componenten.client;

import be.kdg.componenten.communication.NetworkAddress;
import be.kdg.componenten.contacts.ContactsStub;


public class StartClient {
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
        ContactsStub contactsStub = new ContactsStub(contactsAddress);
        Client client = new Client(contactsStub);
        client.run();
    }
}
