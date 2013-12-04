package be.kdg.gedistribueerde.client;

import be.kdg.gedistribueerde.client.ChatClientStub;
import be.kdg.gedistribueerde.client.TextReceiver;

public class ChatClientImpl implements ChatClient {
    private ChatClientStub chatServer;
    private TextReceiver textReceiver;
    private String name;

    public ChatClientImpl(ChatClientStub chatServer, String name) {
        this.chatServer = chatServer;
        this.name = name;
        chatServer.register(this);
    }

    public String getName() {
        return name;
    }

    public void send(String message) {
        chatServer.send(name, message);
    }

    public void receive(String message) {
        if (textReceiver == null) return;
        textReceiver.receive(message);
    }

    public void setTextReceiver(TextReceiver textReceiver) {
        this.textReceiver = textReceiver;
    }

    public void unregister() {
        chatServer.unregister(this);
    }

    /**
     * Adds two contacts (1 invalid and one correct) to the Contacts component
     * and tests if they are present.
     */
    public void run() {
        name = "bla";
    }
}
