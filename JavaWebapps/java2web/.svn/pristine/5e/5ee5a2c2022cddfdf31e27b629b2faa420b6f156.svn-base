package be.kdg.sessions.view;

import be.kdg.sessions.model.Mandje;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ToonMandje")
public class ToonMandjeServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String klantnr = (String) session.getAttribute("klantnr");
        Mandje mandje = (Mandje) request.getAttribute("mandje");
        List lijst = mandje.getAankopen();

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Mandje</title></head>");
        out.println("<body bgcolor='#99FFCC'>");
        out.println("<h2>Inhoud mandje van klantnummer " + klantnr + "</h2>");

        for (int i = 0; i < lijst.size(); i++)
        {
            out.println(lijst.get(i) + "<br>");
        }
        out.println("<form  method=\"POST\" action=\"Mandje\">");
        out.println("   <input type=\"submit\" name=\"submit\" value=\"Naar Kassa\">");
        out.println("   <input type=\"submit\" name=\"submit\" value=\"Verder Winkelen\">");
        out.println("</form>");
        out.println("</body><html>");
    }
}