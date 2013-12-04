package be.kdg.webapps102.filters;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TeLoggenServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String message = (String) request.getAttribute("message");
        if (message == null)
        {
            message = "hello world";
        }
        PrintWriter out = response.getWriter();
        out.print("<html><head><title>Te loggen servlet</title></head><body>");
        out.print(message);
        out.println("</body></html>");
    }

    // vermijd het volgende:
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
}
