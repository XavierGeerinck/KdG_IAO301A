<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring 103</title>        
    </head>
    <body>        
        <div>
            <h2>Login to Welcome</h2>
            <sf:form method="POST" modelAttribute="loginFormBean" action="login" >
                <fieldset>
                    <table>
                        <tr>
                            <th><sf:label path="username">Username:</sf:label></th>
                            <td><sf:input path="username" size="30" />                        
                                <sf:errors path="username" cssClass="error" />
                            </td>
                        </tr>
                        <tr>
                            <th><sf:label path="password">Password:</sf:label></th>
                            <td><sf:input path="password" size="30" />                        
                                <sf:errors path="password" cssClass="error" />
                            </td>
                        </tr>                        
                        <tr>
                            <td><input username="commit" type="submit" value="Login" />
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </sf:form>
        </div>
    </body>
</html>