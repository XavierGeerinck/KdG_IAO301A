<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="webshop" uri="http://www.kdg.be/tagcustom/mytags" %>
<jsp:useBean id="mandje" scope="session" type="be.kdg.tagcustom.model.Mandje"/>
<jsp:useBean id="klantnr" scope="session" type="java.lang.String"/>
<html>
    <head><title>Mandje</title></head>
    <body bgcolor='#99FFCC'>

        <h2>Inhoud mandje van klantnummer ${klantnr}</h2>

        <webshop:showBasket basket="${mandje}"/>

        <form  method="post" action="NaarKassaOfVerder">
            <input type="submit" name="submit" value="Naar Kassa"/>
            <input type="submit" name="submit" value="Verder Winkelen"/>
        </form>

    </body>
</html>