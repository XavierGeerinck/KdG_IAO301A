package be.kdg.webapps101.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpIpServer
{
    private int portNumber;
    private ServerSocket serverSocket;
    private int nextNumber;

    public TcpIpServer(int portNumber)
    {
        this.portNumber = portNumber;
        nextNumber = 0;
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

    protected void handleRequest(Socket clientSocket)
            throws IOException
    {
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine = in.readLine();
        if (inputLine != null && inputLine.startsWith("GET_NEXT_NUMBER"))
        {
            System.out.println("Received request: " + inputLine);
            String reply = createReply();
            out.println(reply);
        }
    }

    private String createReply()
    {
        nextNumber++;
        return "" + nextNumber;
    }

    public void run()
    {
        System.out.println("Server started on port " + portNumber);

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
        TcpIpServer server = new TcpIpServer(8765);
        server.run();
    }
}
