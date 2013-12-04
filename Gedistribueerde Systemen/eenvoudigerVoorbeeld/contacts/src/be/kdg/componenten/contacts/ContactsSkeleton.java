/*
 * Gedistribueerde systemen
 * Karel de Grote-Hogeschool
 * 2006-2007
 * Kris Demuynck
 */

package be.kdg.componenten.contacts;

import be.kdg.componenten.communication.MessageManager;
import be.kdg.componenten.communication.MethodCallMessage;

/**
 * Skeleton for Contacts component.
 */
public final class ContactsSkeleton {
    private final MessageManager messageManager;
    private final Contacts contacts;

    /**
     * Constructs a new Skeleton, given the address of the ZipCodes component.
     */
    public ContactsSkeleton() {
        messageManager = new MessageManager();
        System.out.println("my address = " + messageManager.getMyAddress());
        contacts = new ContactsImpl();
    }

    /**
     * Sends reply with no return-value to the originator of a request.
     *
     * @param request the request that is answered.
     */
    private void sendEmptyReply(MethodCallMessage request) {
        MethodCallMessage reply = new MethodCallMessage(messageManager.getMyAddress(), "result");
        reply.setParameter("result", "Ok");
        messageManager.send(reply, request.getOriginator());
    }

    /**
     * Handles a request containing an "add" methodname.
     *
     * @param request the request that is being handled.
     */
    private void handleAdd(MethodCallMessage request) {
        String name = request.getParameter("name");
        String addressIsNull = request.getParameter("address.isNull");
        String addressStreet = request.getParameter("address.street");
        String addressNumber = request.getParameter("address.number");
        String addressCity = request.getParameter("address.city");
        String addressZip = request.getParameter("address.zip");
        Address address;
        if ("true".equals(addressIsNull)) {
            address = NullAddress.getInstance();
        } else {
            address = new Address(addressStreet, addressNumber, addressZip, addressCity);
        }
        String tel = request.getParameter("tel");
        contacts.add(name, address, tel);
        sendEmptyReply(request);
    }

    /**
     * Handles a request containing an "addressOf" methodname.
     *
     * @param request the request that is being handled.
     */
    private void handleAddressOf(MethodCallMessage request) {
        String name = request.getParameter("name");
        Address address = contacts.addressOf(name);
        MethodCallMessage reply = new MethodCallMessage(messageManager.getMyAddress(), "result");
        reply.setParameter("result.isNull", "" + address.isNull());
        reply.setParameter("result.street", address.getStreet());
        reply.setParameter("result.number", address.getNumber());
        reply.setParameter("result.city", address.getCity());
        reply.setParameter("result.zip", address.getZip());
        messageManager.send(reply, request.getOriginator());
    }

    /**
     * Handles a request containing a "remove" methodname.
     *
     * @param request the request that is being handled.
     */
    private void handleRemove(MethodCallMessage request) {
        String name = request.getParameter("name");
        contacts.remove(name);
        sendEmptyReply(request);
    }

    /**
     * Handles an incomming request.
     *
     * @param request the request that is being handled.
     */
    private void handleRequest(MethodCallMessage request) {
        //System.out.println("ContactsSkeleton:handleRequest(" + request + ")");
        String methodName = request.getMethodName();
        if ("add".equals(methodName)) {
            handleAdd(request);
        } else if ("addressOf".equals(methodName)) {
            handleAddressOf(request);
        } else if ("remove".equals(methodName)) {
            handleRemove(request);
        } else {
            System.out.println("ContactsSkeleton: received an unknown request:");
            System.out.println(request);
        }
    }

    /**
     * The main loop for this skeleton.
     */
    public void run() {
        while (true) {
            MethodCallMessage request = messageManager.wReceive();
            handleRequest(request);
        }
    }
}
