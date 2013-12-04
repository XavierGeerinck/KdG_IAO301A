<%-- 
    Document   : index
    Created on : Oct 18, 2013, 1:52:44 PM
    Author     : Thierry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="LoginServlet" method="get">
      <table align="center" width="100%" cellspacing="2" cellpadding="2">
        <tbody><tr>
          <td width="22%" align="left">Gepost door</td>
          <td width="78%"><input type="text" name="name" align="left" size="15"></td>
        </tr>
        <tr>
          <td align="left">Jaar</td>
          <td>
            <select name="jaar" size="1">
              <option value="TI1">TI1</option>
              <option value="TI2">TI2</option>
              <option value="TI3">TI3</option>
            </select>
          </td>
        </tr>
        <tr>
          <td align="left">Specialiteit</td>
          <td>
            <p>
              <input type="radio" name="specialiteit" value="Applicatieontwikkeling">
              Applicatieontwikkeling<br>
              <input type="radio" name="specialiteit" value="Multimedia">
              Multimedia<br>
              <input type="radio" name="specialiteit" value="Datacommunicatie">
              Datacommunicatie<br>
              <input type="radio" name="specialiteit" value="SoftwareEngeneering">
              SoftwareEngeneering<br>
            </p>
          </td>
        </tr>
        </tbody>
      </table>
      <input type="submit" name="submit" value="Naar de Blog">
      </form>
    </body>
</html>

