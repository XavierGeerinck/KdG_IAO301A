<%-- 
    Document   : bloglist
    Created on : Oct 18, 2013, 2:17:34 PM
    Author     : Thierry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/main.css">
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
        
        
        <h1>TI Kdg Weblog <c:out value="${user.username}"/></h1>
        
        <p><a href="MyBlogServlet">Add a post</a></p>
        <p><a href="LogoffServlet">Log off</a></p>
        <table>
            <tbody>
                <c:forEach var="post" items="${posts}">
                    <c:if test="${id == post.id}"><tr id="firstColor">
                    </c:if>
                    <c:if test="${id != post.id}"><tr id="secondColor">
                    </c:if>
                        <td>${post.omschrijving}</td>
                        <td>${post.specialisatie}</td>
                        <td>${post.jaar}</td>
                        <td><a href="${post.url}">${post.url}</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
