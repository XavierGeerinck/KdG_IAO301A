package be.kdg.urlrewriting.view;

import be.kdg.urlrewriting.model.Mandje;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ToonMandje")
public class ToonMandjeServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        String klantnr = URLDecoder.decode(request.getParameter("klantnr"), "UTF-8");
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
        String url = "Mandje?klantnr=" + URLEncoder.encode(klantnr, "UTF-8");
        out.println("<form  method=\"POST\" action=" + url + ">");
        out.println("   <input type=\"submit\" name=\"submit\" value=\"Naar Kassa\">");
        out.println("   <input type=\"submit\" name=\"submit\" value=\"Verder Winkelen\">");
        out.println("</form>");
        out.println("</body><html>");
    }
}
