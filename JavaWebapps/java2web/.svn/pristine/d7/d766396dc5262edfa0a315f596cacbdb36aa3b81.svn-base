<%-- 
    Document   : createBean
    Created on : Oct 17, 2011, 10:03:12 PM
    Author     : wouter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="user" class="be.kdg.jsp.model.User" scope="session">
            <jsp:setProperty name="user" property="*" />
        </jsp:useBean>
        
        Ingevulde gegevens zijn:
        <jsp:getProperty name="user" property="username" />
        <jsp:getProperty name="user" property="password" />

        
        
        <%-- volgende regel kan je ook eens weglaten --%>
        <jsp:forward page="/RegisterServlet" />     

    </body>
</html>
