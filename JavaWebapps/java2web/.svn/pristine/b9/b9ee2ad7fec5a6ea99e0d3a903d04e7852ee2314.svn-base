package be.kdg.webapps101.http;

import be.kdg.webapps101.http.servlet.Servlet;
import java.util.HashMap;

public class WebServerWithServlets extends WebServerWithCgi
{
    private String servletPath;
    private HashMap<String, Servlet> servletContainer;

    public WebServerWithServlets(int portNumber, String basePath, String defaultFile, String cgiPath, String servletPath)
    {
        super(portNumber, basePath, defaultFile, cgiPath);
        this.servletPath = servletPath;
        servletContainer = new HashMap<String, Servlet>();
    }

    @Override
    protected String createOutputString(String uri)
    {
        if (isServlet(uri))
        {
            return runServlet(uri);
        }
        else if (isCgi(uri))
        {
            return runCgi(uri);
        }
        else if (isFile(uri))
        {
            return readFile(uri);
        }
        else
            return uriNotFoundError(uri);
    }

    private String runServlet(String uri)
    {
        if (servletPath.length() >= uri.length())
        {
            return "Cannot find servlet";
        }
        String servletName = uri.substring(servletPath.length() + 1);
        System.out.println("trying to run servlet " + servletName);
        if (!servletContainer.containsKey(servletName))
        {
            Class servletClass;
            Servlet servlet;
            try
            {
                servletClass = Class.forName("be.kdg.webapps101.http.servlet." + servletName);
                servlet = (Servlet) servletClass.newInstance();
            }
            catch (Exception e)
            {
                return "Cannnot find servlet";
            }
            servlet.init();
            servletContainer.put(servletName, servlet);
        }
        Servlet servlet = servletContainer.get(servletName);
        return servlet.service();
    }

    private boolean isServlet(String uri)
    {
        return uri.startsWith(servletPath);
    }

    public static void main(String args[])
    {
        WebServerWithServlets webServer =
       new WebServerWithServlets(9090, "resources", "index.html", "/cgi", "/servlets");
        webServer.run();
    }
}