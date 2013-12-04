<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="webshop" uri="http://www.kdg.be/tagcustom/mytags" %>
<jsp:useBean id="klantnr" scope="session" type="java.lang.String"/>
<jsp:useBean id="films" scope="application" type="be.kdg.tagcustom.model.Films"/>
<html>
    <head><title>Catalogus</title></head>
    <body bgcolor='#99FFCC'>

        <h2>Maak je keuze klant nummer ${klantnr}</h2>
        Je hebt de keuze uit de volgende films:<br>

        <webshop:selectFromItems items="${films.films}" selectUrl="KoopFilm"/>

    </body>
</html>