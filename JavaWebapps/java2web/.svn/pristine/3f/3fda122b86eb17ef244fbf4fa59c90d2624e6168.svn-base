package be.kdg.jsp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Catalogus")
public class CatalogusServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        String klantnr = request.getParameter("klantnr");
        HttpSession session = request.getSession();
        session.setAttribute("klantnr", klantnr);
        request.getRequestDispatcher("/toonCatalogus.jsp").forward(request, response);
    }
}
