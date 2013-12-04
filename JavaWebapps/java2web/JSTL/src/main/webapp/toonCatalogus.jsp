<%@page import="be.kdg.jstl.model.Films"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Catalogus</title></head>
<body bgcolor='#99FFCC'>

<h2>Maak je keuze klant nummer <%=session.getAttribute("klantnr")%></h2>

<form method="post" action="KoopFilmServlet" >
    Je hebt de keuze uit de volgende films:<br><br>
    <%
        Films films = (Films) application.getAttribute("films");
        for(String film : films.getFilms()) 
        {
    %>
        <input type="radio" name="film" value="<%=film%>"/><%=film%><br/>
    <%
        }
    %>
    <input type="submit" name="submit" value="Koop">
</form>

</body>
</html>