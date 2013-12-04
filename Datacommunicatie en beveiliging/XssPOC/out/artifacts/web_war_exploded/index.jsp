<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <p>XSS</p>
    <form action="/XssVulnerable" method="POST">
        <input name="xss" type="text" value="" />
        <input type="submit" value="XssVulnerable" />
    </form>
    <br />
    <form action="/XssProtected" method="POST">
        <input name="xss" type="text" value="" />
        <input type="submit" value="XssProtected" />
    </form>
  </body>
</html>