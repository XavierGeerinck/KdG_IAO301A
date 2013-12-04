/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.jstl.controller;

import be.kdg.jstl.model.Mandje;
import be.kdg.jstl.model.Mandjes;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author wouter
 */
@WebServlet("/KoopFilmServlet")
public class KoopFilmServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String film = request.getParameter("film");
        ServletContext servletContext = getServletContext();
        Mandjes mandjes = (Mandjes) servletContext.getAttribute("mandjes");
        HttpSession session = request.getSession();
        String klantnr = (String) session.getAttribute("klantnr");
        Mandje mandje = mandjes.haalMandje(klantnr);

        if (mandje == null)
        {
            mandje = new Mandje();
            mandjes.add(klantnr, mandje);
        }
        mandje.add(film);
        session.setAttribute("mandje", mandje);
        response.sendRedirect("toonMandje2.jsp");
    }
}
