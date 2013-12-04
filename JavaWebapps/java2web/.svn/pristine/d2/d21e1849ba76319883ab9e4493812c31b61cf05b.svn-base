package be.kdg.webapps.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleServlet extends HttpServlet {
    private int numberOfAccesses;

    public void init(ServletConfig servletConfig) throws ServletException {
        numberOfAccesses = 0;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        numberOfAccesses++;
        String result = "<html><head><title>My Servlet</title></head><body>";
        result  += "This page has been accessed " + numberOfAccesses + " times...";
        result += "</body></html>";
        out.println(result);
    }
}
