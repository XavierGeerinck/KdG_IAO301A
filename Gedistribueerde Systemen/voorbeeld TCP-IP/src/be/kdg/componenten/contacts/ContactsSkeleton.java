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
 * Skeleton for Contacts component.
 */
public final class ContactsSkeleton {
    private final MessageManager messageManager;
    private final Contacts contacts;

    /**
     * Constructs a new Skeleton, given the address of the ZipCodes component.
     *
     * @param zipCodeAddress the address of the ZipCodes component.
     */
    public ContactsSkeleton(NetworkAddress zipCodeAddress) {
        messageManager = new MessageManager();
        System.out.println("my address = " + messageManager.getMyAddress());
        contacts = new ContactsImpl(zipCodeAddress);
    }

    /**
     * Sends reply with no return-value to the originator of a request.
     *
     * @param request the request that is aswered.
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
    private void run() {
        while (true) {
            MethodCallMessage request = messageManager.wReceive();
            handleRequest(request);
        }
    }

    /**
     * Starts this component.
     *
     * @param args the ip-address and port-number of the ZipCodes component.
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java ContactsSkeleton <zipCodesIP> <zipCodesPort>");
            System.exit(1);
        }
        int port = Integer.parseInt(args[1]);
        NetworkAddress zipCodesAddress = new NetworkAddress(args[0], port);
        ContactsSkeleton contactsSkeleton = new ContactsSkeleton(zipCodesAddress);
        contactsSkeleton.run();
    }
}
