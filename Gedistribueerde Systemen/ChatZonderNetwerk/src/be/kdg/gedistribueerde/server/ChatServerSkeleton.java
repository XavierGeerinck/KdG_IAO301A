package be.kdg.gedistribueerde.server;

import be.kdg.componenten.communication.MessageManager;
import be.kdg.componenten.communication.MethodCallMessage;
import be.kdg.gedistribueerde.client.ChatClient;
import be.kdg.gedistribueerde.client.ChatClientImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xaviergeerinck on 19/11/13.
 */
public class ChatServerSkeleton {
    private final MessageManager messageManager;
    private ChatServerImpl chatServer;

    public ChatServerSkeleton() {
        messageManager = new MessageManager();
        this.chatServer = new ChatServerImpl();
    }

    public void handleRegister(MethodCallMessage request) {
        ChatClient client = new ChatClientImpl();
        chatServer.register(client);

        MethodCallMessage message = new MethodCallMessage(messageManager.getMyAddress(), "send");
        message.setParameter("name", "server");
        message.setParameter("message", client.getName() + " has entered the room");
        handleSend(message);
    }

    public void handleUnregister(MethodCallMessage request) {
        String name = request.getParameter("name");

        chatServer.unregister(name);

        MethodCallMessage message = new MethodCallMessage(messageManager.getMyAddress(), "send");
        message.setParameter("name", "server");
        message.setParameter("message", name + " has left the room");
        handleSend(message);
    }

    public void handleSend(MethodCallMessage request) {
        String name = request.getParameter("name");
        String message = request.getParameter("message");

        for(ChatClient client : chatServer.getClients().values()) {
            client.receive(name + ": " + message);
        }
    }

    /**
     * Handles an incomming request.
     *
     * @param request the request that is being handled.
     */
    private void handleRequest(MethodCallMessage request) {
        //System.out.println("ContactsSkeleton:handleRequest(" + request + ")");
        String methodName = request.getMethodName();
        if ("send".equals(methodName)) {
            handleSend(request);
        } else if("register".equals(methodName)) {
            handleRegister(request);
        } else {
            System.out.println("ChatServerSkeleton: received an unknown request:");
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
        ChatServerSkeleton chatServerSkeleton = new ChatServerSkeleton();
        chatServerSkeleton.run();
    }
}
