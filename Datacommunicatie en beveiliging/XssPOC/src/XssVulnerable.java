import org.owasp.esapi.ESAPI;
import org.owasp.esapi.codecs.MySQLCodec;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by xaviergeerinck on 29/11/13.
 */
public class XssVulnerable extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<p>" + request.getParameter("xss") + "</p>");
        out.println("<script id=\"init_data\" type=\"application/json\">\n" +
                request.getParameter("xss") + "\n" +
                "</script>");
        out.close();
    }
}
