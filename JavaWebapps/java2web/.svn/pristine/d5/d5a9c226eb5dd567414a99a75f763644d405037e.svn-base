<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="inc" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="kdg" uri="http://www.kdg.be/webapps/kdg" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="pv" value="Banaan" scope="page" />
        <c:set var="rv" value="Framboos" scope="request" />

        <inc:Header who="Tag Tester Dudes">
            Geef de Page Variable mee aan de body via EL: ${pageScope.pv}
        </inc:Header>

        <kdg:fluppeke test="Lijst van namen" test2="Dat was het !">            
            <h1>Hello ${naam} !</h1>
        </kdg:fluppeke>      
        
            <p><c:out value="${pv}" /></p>

        <inc:Footer jaar="2012" />

    </body>
</html>
