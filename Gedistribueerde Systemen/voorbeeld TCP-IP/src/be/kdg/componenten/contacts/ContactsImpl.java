/*
 * Gedistribueerde systemen
 * Karel de Grote-Hogeschool
 * 2006-2007
 * Kris Demuynck
 */

package be.kdg.componenten.contacts;

import be.kdg.componenten.communication.NetworkAddress;
import be.kdg.componenten.zipcodes.ZipCodes;
import be.kdg.componenten.zipcodes.ZipCodesStub;

import java.util.Map;
import java.util.TreeMap;

/**
 * Implementation of the Contacts component.
 */
public final class ContactsImpl implements Contacts {
    private final Map<String, Contact> contacts;
    private final ZipCodes zipCodes;

    /**
     * Creates a new Contacts component.
     *
     * @param zipCodesAddress the address of the ZipCodes component.
     */
    public ContactsImpl(NetworkAddress zipCodesAddress) {
        contacts = new TreeMap<String, Contact>();
        zipCodes = new ZipCodesStub(zipCodesAddress);
    }

    /**
     * @see Contacts#add
     */
    public void add(String name, Address address, String tel) {
        //System.out.println("ContactsImpl:add(" + name + ", " + address + ", " + tel + ")");
        String city = address.getCity();
        String code = zipCodes.getCode(city);
        if (!code.equals(address.getZip())) {
            return;
        }
        Contact contact = new Contact(name, address, tel);
        contacts.put(name, contact);
    }

    /**
     * @see Contacts#addressOf
     */
    public Address addressOf(String name) {
        //System.out.println("ContactsImpl:addressOf(" + name + ")");
        Contact contact = contacts.get(name);
        if (contact == null) {
            return NullAddress.getInstance();
        }
        return contact.getAddress();
    }

    /**
     * @see Contacts#remove
     */
    public void remove(String name) {
        //System.out.println("ContactsImpl:remove(" + name + ")");
        contacts.remove(name);
    }
}
