package be.kdg.webapps101.http;

import java.io.IOException;
import java.io.InputStream;

public class WebServerWithCgi extends WebServerWithFiles
{
    private String cgiPath;

    public WebServerWithCgi(int portNumber, String basePath, String defaultFile, String cgiPath)
    {
        super(portNumber, basePath, defaultFile);
        this.cgiPath = cgiPath;
    }

    @Override
    protected String createOutputString(String uri)
    {
        if (isCgi(uri))
        {
            return runCgi(uri);
        }
        else if (isFile(uri))
        {
            return readFile(uri);
        }
        else
        {
            return uriNotFoundError(uri);
        }
    }

    protected String runCgi(String uri)
    {
        if (cgiPath.length() >= uri.length())
        {
            return "Cannot find CGI";
        }
        String cgiName = uri.substring(cgiPath.length() + 1).replace("%20", " ");
        System.out.println("trying to run CGI " + cgiName);

        String command = cgiName;
        Process child = null;
        try
        {
            StringBuilder result = new StringBuilder();
            child = Runtime.getRuntime().exec(command);

            InputStream in = child.getInputStream();
            int c;
            while ((c = in.read()) != -1)
            {
                result.append((char) c);
            }
            in.close();
            return result.toString();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return "Cannot execute CGI";
        }
    }

    protected boolean isCgi(String uri)
    {
        return uri.startsWith(cgiPath);
    }

    public static void main(String args[])
    {
        WebServerWithCgi webServer = new WebServerWithCgi(9090, "src/main/resources/resources/web", "index.xhtml", "/cgi");
        webServer.run();
    }
}