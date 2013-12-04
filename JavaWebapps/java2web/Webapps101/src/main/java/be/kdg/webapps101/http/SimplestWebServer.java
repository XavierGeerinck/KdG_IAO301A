package be.kdg.webapps101.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimplestWebServer
{
    private int portNumber;
    private ServerSocket serverSocket;

    public SimplestWebServer(int portNumber)
    {
        this.portNumber = portNumber;
        openServerSocket();
    }

    private void openServerSocket()
    {
        try
        {
            serverSocket = new ServerSocket(portNumber);
        }
        catch (IOException e)
        {
            System.err.println("Fatal error: Could not listen on port: " + portNumber);
            e.printStackTrace();
            System.exit(1);
        }
    }

    private String createOutputString()
    {
        return "<HTML><HEAD><TITLE>Testje</TITLE></HEAD><BODY>Dit is een test</BODY></HTML>";
    }

    protected void createReply(PrintWriter out, String outputLine)
    {
        System.out.println("Sending response");
        out.println("HTTP/1.0 200 OK");
        out.println("Content-Length: " + outputLine.length());
        out.println();
        out.println(outputLine);
    }

    protected void handleRequest(Socket clientSocket)
            throws IOException
    {
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine = in.readLine();
        if (inputLine != null && inputLine.startsWith("GET "))
        {
            System.out.println("Received request: ");
            String outputLine = createOutputString();
            this.createReply(out, outputLine);
        }
        printRequest(in, inputLine);
    }

    private void printRequest(BufferedReader in, String inputLine) throws IOException
    {
        while (inputLine != null)
        {
            System.out.println(inputLine);
            inputLine = in.readLine();
        }
    }

    public void run()
    {
        System.out.println("Web server started on port " + portNumber);

        while (true)
        {
            try
            {
                Socket clientSocket = serverSocket.accept();
                handleRequest(clientSocket);
                clientSocket.close();
            }
            catch (IOException e)
            {
                System.err.println("A network error occured");
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[])
    {
        SimplestWebServer webServer = new SimplestWebServer(9090);
        webServer.run();
    }
}

