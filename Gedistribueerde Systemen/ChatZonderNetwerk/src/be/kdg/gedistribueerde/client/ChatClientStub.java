package be.kdg.gedistribueerde.client;

import be.kdg.componenten.communication.MessageManager;
import be.kdg.componenten.communication.MethodCallMessage;
import be.kdg.componenten.communication.NetworkAddress;

/**
 * Created by xaviergeerinck on 19/11/13.
 */
public class ChatClientStub implements ChatClient{
    private final NetworkAddress serverAddress;
    private final MessageManager messageManager;
    private String name;

    public ChatClientStub(NetworkAddress serverAddress) {
        this.serverAddress = serverAddress;
        this.messageManager = new MessageManager();
    }

    public String getName() {
        return name;
    }

    public void send(String name, String msg) {
        //System.out.println("ContactsStub:add(" + name + ", " + address + ", " + tel + ")");
        MethodCallMessage message = new MethodCallMessage(messageManager.getMyAddress(), "send");
        message.setParameter("name", name);
        message.setParameter("message", "" + msg);
        messageManager.send(message, serverAddress);
        checkEmptyReply();
    }

    public void receive(String message) {
        if (textReceiver == null) return;
        textReceiver.receive(message);
    }

    public void setTextReceiver(TextReceiver textReceiver) {
        this.textReceiver = textReceiver;
    }

    public void unregister() {
        MethodCallMessage message = new MethodCallMessage(messageManager.getMyAddress(), "unregister");
        message.setParameter("name", "" + name);
        messageManager.send(message, serverAddress);
        checkEmptyReply();
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
        NetworkAddress chatServerAddress = new NetworkAddress(args[0], port);
        ChatClientStub chatClientStub = new ChatClientStub(chatServerAddress);
        ChatClientImpl client = new ChatClientImpl(chatClientStub, "blabla");
        client.run();
    }
}
