<%@page import="be.kdg.jsp.model.Mandje"%>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head><title>Mandje</title></head>
    <body bgcolor='#99FFCC'>

        <h2>Inhoud mandje van klantnummer <%=session.getAttribute("klantnr")%></h2>
        <%
            Mandje mandje = (Mandje) session.getAttribute("mandje");
            List<String> filmsInMandje = mandje.getAankopen();
            for (String film : filmsInMandje)
            {
                out.println(film + "<br/>");
            }
        %>
        <form  method="post" action="NaarKassaOfVerderServlet">
            <input type="submit" name="submit" value="Naar Kassa"/>
            <input type="submit" name="submit" value="Verder Winkelen"/>
        </form>

    </body>
</html>