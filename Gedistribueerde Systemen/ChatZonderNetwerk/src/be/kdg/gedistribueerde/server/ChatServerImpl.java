package be.kdg.gedistribueerde.server;

import be.kdg.gedistribueerde.client.ChatClient;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class ChatServerImpl {
    private Map<String, ChatClient> clients;

    public ChatServerImpl() {
        this.clients = new HashMap<String, ChatClient>();
    }

    public void register(String name, ChatClient client) {
        clients.put(name, client);
        send("server", client.getName() + " has entered the room");
    }

    public void unregister(String name) {
        clients.remove(name);
        send("server", name + " has left the room");
    }

    public void send(String name, String message) {
        for(ChatClient client : clients.values()) {
            client.receive(name + ": " + message);
        }
    }

    public Map<String, ChatClient> getClients() {
        return clients;
    }
}
