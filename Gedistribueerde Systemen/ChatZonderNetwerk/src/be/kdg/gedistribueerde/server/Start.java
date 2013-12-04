package be.kdg.gedistribueerde.server;

import be.kdg.gedistribueerde.client.ChatClient;
import be.kdg.gedistribueerde.client.ChatFrame;

public class Start {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();

        ChatClient chatClient1 = new ChatClient(chatServer, "ikke");
        new ChatFrame(chatClient1);

        ChatClient chatClient2 = new ChatClient(chatServer, "bla");
        new ChatFrame(chatClient2);
    }
}
