/*
 * Gedistribueerde systemen
 * Karel de Grote-Hogeschool
 * 2006-2007
 * Kris Demuynck
 */

package be.kdg.componenten.zipcodes;

import be.kdg.componenten.communication.MessageManager;
import be.kdg.componenten.communication.MethodCallMessage;
import be.kdg.componenten.communication.NetworkAddress;

/**
 * Stub for ZipCodes component.
 */
public final class ZipCodesStub implements ZipCodes {
    private final NetworkAddress zipCodesAddress;
    private final MessageManager messageManager;

    /**
     * Constructs a new ZipCodesStub using the address of the real component.
     *
     * @param zipCodesAddress the address of the actual ZipCodes component (Skeleton)
     */
    public ZipCodesStub(NetworkAddress zipCodesAddress) {
        this.zipCodesAddress = zipCodesAddress;
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
     * @see ZipCodes#add
     */
    public void add(String code, String city) {
        MethodCallMessage message = new MethodCallMessage(messageManager.getMyAddress(), "add");
        message.setParameter("code", code);
        message.setParameter("city", city);
        messageManager.send(message, zipCodesAddress);
        checkEmptyReply();
    }

    /**
     * @see ZipCodes#getCode
     */
    public String getCode(String city) {
        MethodCallMessage message = new MethodCallMessage(messageManager.getMyAddress(), "getCode");
        message.setParameter("city", city);
        messageManager.send(message, zipCodesAddress);
        MethodCallMessage reply = messageManager.wReceive();
        if (!"result".equals(reply.getMethodName())) {
            return "";
        }
        return reply.getParameter("result");
    }

    /**
     * @see ZipCodes#getCity
     */
    public String getCity(String code) {
        MethodCallMessage message = new MethodCallMessage(messageManager.getMyAddress(), "getCity");
        message.setParameter("code", code);
        messageManager.send(message, zipCodesAddress);
        MethodCallMessage reply = messageManager.wReceive();
        if (!"result".equals(reply.getMethodName())) {
            return "";
        }
        return reply.getParameter("result");
    }
}
