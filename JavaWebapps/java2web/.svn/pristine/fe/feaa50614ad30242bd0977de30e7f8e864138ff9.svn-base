package be.kdg.webapps101.http;

import java.io.*;
import java.net.Socket;

public class WebServerWithFiles extends SimplestWebServer
{
    private final String URI_NOT_FOUND_ERROR_PART1 = "<html><head><title>Error!!!</title></head><body>Error: cannot find the specified URI: ";
    private final String URI_NOT_FOUND_ERROR_PART2 = "</body></html>";
    private String basePath;
    private String defaultFile;

    public WebServerWithFiles(int portNumber, String basePath, String defaultFile)
    {
        super(portNumber);
        this.basePath = basePath;
        this.defaultFile = defaultFile;
    }

    protected String readFile(String uri)
    {
        byte[] fileContents;
        try
        {
            String path = findFileName(uri);
            System.out.println("Reading file: " + path);
            File file = new File(path);
            FileInputStream filestream;
            filestream = new FileInputStream(file);
            fileContents = new byte[(int) file.length()];
            filestream.read(fileContents, 0, fileContents.length);
            filestream.close();
        }
        catch (IOException e)
        {
            return uriNotFoundError(uri);
        }
        return new String(fileContents);
    }

    private String findFileName(String uri)
    {
        String result = basePath + uri;
        File file = new File(result);
        if (file.isDirectory())
        {
            if (!uri.endsWith("/"))
            {
                result = result + '/';
            }
            result = result + defaultFile;
        }
        return result;
    }

    protected String createOutputString(String uri)
    {
        if (isFile(uri))
        {
            return readFile(uri);
        }
        else
        {
            return uriNotFoundError(uri);
        }
    }

    protected String uriNotFoundError(String uri)
    {
        return URI_NOT_FOUND_ERROR_PART1
                + uri
                + URI_NOT_FOUND_ERROR_PART2;
    }

    protected boolean isFile(String uri)
    {
        String path = findFileName(uri);
        File file = new File(path);
        return file.isFile() && file.canRead();
    }

    private String findPathInGetRequest(String inputLine)
    {
        int startOfPath = inputLine.indexOf('/');
        int endOfPath = inputLine.indexOf(' ', startOfPath);
        String result = inputLine.substring(startOfPath, endOfPath);
        System.out.println("path in GET request = " + result);
        return result;
    }

    @Override
    protected void handleRequest(Socket clientSocket)
            throws IOException
    {
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine = in.readLine();
        if (inputLine != null && inputLine.startsWith("GET "))
        {
            System.out.println("Received request: " + inputLine);
            String path = findPathInGetRequest(inputLine);
            String outputLine = createOutputString(path);
            this.createReply(out, outputLine);
        }
    }

    public static void main(String args[])
    {
        WebServerWithFiles webServer = new WebServerWithFiles(9090, "src/main/resources/web", "index.xhtml");
        webServer.run();
    }
}