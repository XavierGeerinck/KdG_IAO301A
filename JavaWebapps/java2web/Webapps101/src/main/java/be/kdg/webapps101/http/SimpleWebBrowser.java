package be.kdg.webapps101.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleWebBrowser
{
    private void surf(String host, int port, String dir)
    {
        try
        {
            Socket clientSocket = new Socket(host, port);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.println("GET " + dir + " HTTP/1.1");
            out.println("Host: " + host + ":" + port);
            out.println();
            int c = in.read();
            while (c != -1)
            {
                System.out.print((char) c);
                c = in.read();
            }
            clientSocket.close();
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args)
    {
        if (args.length != 3)
        {
            System.err.println("Usage: SimpleWebBrowser <host> <port> <dir>");
            System.exit(1);
        }
        SimpleWebBrowser simpleWebBrowser = new SimpleWebBrowser();
        simpleWebBrowser.surf(args[0], Integer.parseInt(args[1]), args[2]);
    }
}
