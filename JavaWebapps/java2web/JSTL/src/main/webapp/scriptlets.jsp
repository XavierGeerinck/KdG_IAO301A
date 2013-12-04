<%@ page import="java.util.Date"%>
<%!
    String zegHallo() {
        return "hallo";
    }
%>
<html>
  <head><title>Scriptlets demo</title></head>
  <body>
    <p>Het volgende werd in java geschreven:
    <% out.println(new Date()); %>
    </p>
    <% int answer = 42; %>
    <p>Het antwoord op de ultieme vraag is <%= answer %></p>
    <p><%= zegHallo() %></p>
  </body>
</html>