package be.kdg.webapps101.http.servlet;

public class MyServlet implements Servlet
{
    private int numberOfAccesses;

    public void init()
    {
        numberOfAccesses = 0;
    }

    public String service()
    {
        numberOfAccesses++;
        String result = "<html><head><title>My Servlet</title></head><body>";
        result += "This page has been accessed " + numberOfAccesses + " times...";
        result += "</body></html>";
        return result;
    }

    public void destroy()
    {
    }
}
