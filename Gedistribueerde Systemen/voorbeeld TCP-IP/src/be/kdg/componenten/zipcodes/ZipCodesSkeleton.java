/*
 * Gedistribueerde systemen
 * Karel de Grote-Hogeschool
 * 2006-2007
 * Kris Demuynck
 */

package be.kdg.componenten.zipcodes;

import be.kdg.componenten.communication.MessageManager;
import be.kdg.componenten.communication.MethodCallMessage;

/**
 * Skeleton for ZipCodes component.
 */
public final class ZipCodesSkeleton {
    private final MessageManager messageManager;
    private final ZipCodes zipCodes;

    /**
     * Constructs a new Skeleton.
     */
    public ZipCodesSkeleton() {
        messageManager = new MessageManager();
        System.out.println("my address = " + messageManager.getMyAddress());
        zipCodes = new ZipCodesImpl();
    }

    /**
     * Sends reply with no return-value to the originator of a request.
     *
     * @param request the request that is being handled.
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
        String code = request.getParameter("code");
        String city = request.getParameter("city");
        zipCodes.add(code, city);
        sendEmptyReply(request);
    }

    /**
     * Handles a request containing an "getCode" methodname.
     *
     * @param request the request that is being handled.
     */
    private void handleGetCode(MethodCallMessage request) {
        String city = request.getParameter("city");
        String code = zipCodes.getCode(city);
        MethodCallMessage reply = new MethodCallMessage(messageManager.getMyAddress(), "result");
        reply.setParameter("result", code);
        messageManager.send(reply, request.getOriginator());
    }

    /**
     * Handles a request containing an "getCity" methodname.
     *
     * @param request the request that is being handled.
     */
    private void handleGetCity(MethodCallMessage request) {
        String code = request.getParameter("code");
        String city = zipCodes.getCity(code);
        MethodCallMessage reply = new MethodCallMessage(messageManager.getMyAddress(), "result");
        reply.setParameter("result", city);
        messageManager.send(reply, request.getOriginator());
    }

    /**
     * Handles an incomming request.
     *
     * @param request the request that is being handled.
     */
    private void handleRequest(MethodCallMessage request) {
        //System.out.println("ZipCodesSkeleton:handleRequest(" + request + ")");
        String methodName = request.getMethodName();
        if ("add".equals(methodName)) {
            handleAdd(request);
        } else if ("getCode".equals(methodName)) {
            handleGetCode(request);
        } else if ("getCity".equals(methodName)) {
            handleGetCity(request);
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
     * @param args no command-line parameters needed.
     */
    public static void main(String[] args) {
        ZipCodesSkeleton contactsSkeleton = new ZipCodesSkeleton();
        contactsSkeleton.run();
    }
}
