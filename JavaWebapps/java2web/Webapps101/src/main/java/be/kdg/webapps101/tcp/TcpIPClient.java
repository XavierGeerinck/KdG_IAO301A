package be.kdg.webapps101.tcp;

import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TcpIPClient {

    private void getNextNumber(String host, int port) {
        try {
            Socket clientSocket = new Socket(host, port);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.println("GET_NEXT_NUMBER");
            String reply = in.readLine();
            clientSocket.close();
            System.out.println("reply = " + reply);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        TcpIPClient client = new TcpIPClient();
        client.getNextNumber("127.0.0.1", 8765);
    }

}
