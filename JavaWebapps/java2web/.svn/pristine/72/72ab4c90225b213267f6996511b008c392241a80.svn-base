package be.kdg.cookies.controller;

import be.kdg.cookies.model.Mandje;
import be.kdg.cookies.model.Mandjes;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Mandje")
public class MandjeServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        Mandjes mandjes = zoekMandjes();
        Mandje mandje = haalMandje(request, mandjes);
        String url = verwerkRequest(request, mandje);
        forward(url, request, response, mandje);
    }

    private Mandjes zoekMandjes()
    {
        ServletContext servletContext = getServletContext();
        Mandjes mandjes = (Mandjes) servletContext.getAttribute("mandjes");
        if (mandjes == null)
        {
            mandjes = new Mandjes();
            servletContext.setAttribute("mandjes", mandjes);
        }
        return mandjes;
    }

    private Mandje haalMandje(HttpServletRequest request, Mandjes mandjes) throws IOException
    {
        String klantnr = haalKlantNummer(request);
        Mandje mandje = mandjes.haalMandje(klantnr);
        if (mandje == null)
        {
            mandje = new Mandje();
            mandjes.add(klantnr, mandje);
        }
        return mandje;
    }

    private String haalKlantNummer(HttpServletRequest request)
    {
        String klantnr = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
        {
            for (int i = 0; i < cookies.length; i++)
            {
                Cookie cookie = cookies[i];
                String cookieName = cookie.getName();
                if (cookieName.equals("klantnr"))
                {
                    klantnr = cookie.getValue();
                }
            }
        }
        return klantnr;
    }

    private String verwerkRequest(HttpServletRequest request, Mandje mandje) throws ServletException, IOException
    {
        String film = request.getParameter("film");
        String mode = request.getParameter("submit");

        if (mode.equals("Koop") && (film != null))
        {
            mandje.add(film);
            return "/ToonMandje";
        }
        else if (mode.equals("Verder Winkelen"))
        {
            return "/Catalogus";
        }
        else
        {
            return "/index.html";
        }
    }

    private void forward(String url, HttpServletRequest request, HttpServletResponse response, Mandje mandje) throws ServletException, IOException
    {
        request.setAttribute("mandje", mandje);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }
}
