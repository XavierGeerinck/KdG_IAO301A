package be.kdg.tagfiles.servlets;

import be.kdg.tagfiles.model.Mandje;
import be.kdg.tagfiles.model.Mandjes;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/KoopFilm")
public class KoopFilmServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String film = request.getParameter("item");
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
        response.sendRedirect("toonMandje.jsp");
    }
}
