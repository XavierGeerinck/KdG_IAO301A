package be.kdg.webapps101.http.servlet;

public interface Servlet
{
    public void init();

    public String service();

    public void destroy();
}