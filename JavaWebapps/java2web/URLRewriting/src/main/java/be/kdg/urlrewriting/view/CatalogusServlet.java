package be.kdg.urlrewriting.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Catalogus")
public class CatalogusServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        String klantnr = request.getParameter("klantnr");

        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<title>Catalogus</title></head>");
        out.println("<body bgcolor='#99FFCC'>");
        out.println("<h2>Maak je keuze klant nummer " + klantnr + "</h2>");

        String url = "Mandje?klantnr=" + URLEncoder.encode(klantnr, "UTF-8");

        out.println("<form method=\"POST\" action=" + url + " >");
        out.println("Je hebt de keuze uit de volgende films:<br><br>");
        out.println("  <input type=\"radio\" name=\"film\" value=\"The Matrix\">The Matrix</input><br>");
        out.println("  <input type=\"radio\" name=\"film\" value=\"Memento\">Memento</input><br>");
        out.println("  <input type=\"radio\" name=\"film\" value=\"Daredevil\">Daredevil</input><br>");
        out.println("  <input type=\"radio\" name=\"film\" value=\"Resident Evil\">Resident Evil</input><br><br>");
        out.println("  <input type=\"submit\" name=\"submit\" value=\"Koop\">");
        out.println("</form>");
        out.println("</body><html>");
    }
}
