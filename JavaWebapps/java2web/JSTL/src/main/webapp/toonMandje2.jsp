<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head><title>Mandje</title></head>
<body bgcolor='#99FFCC'>

    <h2>Inhoud mandje van klantnummer ${klantnr}</h2>
    <p>Impliciet object: ${pageContext.findAttribute("mandje").toString()}</p>

    <!-- Hier zie je het gebruik van JSTL tags -->
    <!-- Dit wordt pas in hoofdstuk 9 behandeld -->
    <c:forEach items="${mandje.aankopen}" var="film">
        ${film}<br/>
    </c:forEach>

    <form method="post" action="NaarKassaOfVerderServlet">
        <input type="submit" name="submit" value="Naar Kassa"/>
        <input type="submit" name="submit" value="Verder Winkelen"/>
    </form>

</body>
</html>