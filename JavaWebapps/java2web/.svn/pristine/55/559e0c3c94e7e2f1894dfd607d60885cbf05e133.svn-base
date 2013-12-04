package be.kdg.tagcustom.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/NaarKassaOfVerder")
public class NaarKassaOfVerderServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String action = request.getParameter("submit");
        if (action.equals("Naar Kassa"))
        {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("index.jsp");
        }
        else
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/toonCatalogus.jsp");
            dispatcher.forward(request, response);
        }
    }
}
