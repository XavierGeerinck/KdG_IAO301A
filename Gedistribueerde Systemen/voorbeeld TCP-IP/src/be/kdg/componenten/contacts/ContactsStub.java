/*
 * Gedistribueerde systemen
 * Karel de Grote-Hogeschool
 * 2006-2007
 * Kris Demuynck
 */

package be.kdg.componenten.contacts;

import be.kdg.componenten.communication.MessageManager;
import be.kdg.componenten.communication.MethodCallMessage;
import be.kdg.componenten.communication.NetworkAddress;

/**
 * Stub for Contacts component.
 */
public final class ContactsStub implements Contacts {
    private final NetworkAddress contactsAddress;
    private final MessageManager messageManager;

    /**
     * Constructs a new ContactsStub using the address of the real component.
     *
     * @param contactsAddress the address of the actual Contacts component (Skeleton)
     */
    public ContactsStub(NetworkAddress contactsAddress) {
        this.contactsAddress = contactsAddress;
        this.messageManager = new MessageManager();
    }

    /**
     * Waits for a reply and checks if it contains no return-value.
     */
    private void checkEmptyReply() {
        String value = "";
        while (!"Ok".equals(value)) {
            MethodCallMessage reply = messageManager.wReceive();
            if (!"result".equals(reply.getMethodName())) {
                continue;
            }
            value = reply.getParameter("result");
        }
    }

    /**
     * @see Contacts#add
     */
    public void add(String name, Address address, String tel) {
        //System.out.println("ContactsStub:add(" + name + ", " + address + ", " + tel + ")");
        MethodCallMessage message = new MethodCallMessage(messageManager.getMyAddress(), "add");
        message.setParameter("name", name);
        message.setParameter("address.isNull", "" + address.isNull());
        message.setParameter("address.street", address.getStreet());
        message.setParameter("address.number", address.getNumber());
        message.setParameter("address.zip", address.getZip());
        message.setParameter("address.city", address.getCity());
        message.setParameter("tel", tel);
        messageManager.send(message, contactsAddress);
        checkEmptyReply();
    }

    /**
     * @see Contacts#addressOf
     */
    public Address addressOf(String name) {
        //System.out.println("ContactsStub:addressOf(" + name + ")");
        MethodCallMessage message = new MethodCallMessage(messageManager.getMyAddress(), "addressOf");
        message.setParameter("name", name);
        messageManager.send(message, contactsAddress);
        MethodCallMessage reply = messageManager.wReceive();
        if (!"result".equals(reply.getMethodName())) return NullAddress.getInstance();
        String isNull = reply.getParameter("result.isNull");
        String street = reply.getParameter("result.street");
        String number = reply.getParameter("result.number");
        String zip = reply.getParameter("result.zip");
        String city = reply.getParameter("result.city");
        if ("true".equals(isNull)) {
            return NullAddress.getInstance();
        }
        return new Address(street, number, zip, city);
    }

    /**
     * @see Contacts#remove
     */
    public void remove(String name) {
        //System.out.println("ContactsStub:remove(" + name + ")");
        MethodCallMessage message = new MethodCallMessage(messageManager.getMyAddress(), "remove");
        message.setParameter("name", name);
        messageManager.send(message, contactsAddress);
        checkEmptyReply();
    }
}
