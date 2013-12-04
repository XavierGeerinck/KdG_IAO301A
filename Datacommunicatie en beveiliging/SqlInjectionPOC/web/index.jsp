<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <p>Injection String: ' OR '1' = '1</p>
    <form action="/insertStatement" method="POST">
        <input name="name" type="text" value="" />
        <input type="submit" value="InsertStatement" />
    </form>
    <br />
    <form action="/insertPreparedStatement" method="POST">
        <input name="name" type="text" value="" />
        <input type="submit" value="InsertPreparedStatement" />
    </form>
    <br />
    <form action="/insertESAPI" method="POST">
        <input name="name" type="text" value="" />
        <input type="submit" value="InsertStatement" />
    </form>
  </body>
</html>