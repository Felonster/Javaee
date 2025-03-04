<%@ page import="java.util.*" %>
<%
    List<String> listaInformacji = (List<String>) application.getAttribute("wszystkieInformacje");
%>
<html>
<head>
    <title>Lista informacji</title>
</head>
<body>
    <h1>Wszystkie zapisane informacje:</h1>
    <%
        if(listaInformacji != null && !listaInformacji.isEmpty()) {
            for(String info : listaInformacji) {
                out.println("<p>" + info + "</p>");
            }
        } else {
            out.println("<p>Brak zapisanych informacji.</p>");
        }
    %>
    <br>
    <a href="pierwsza.jsp">Dodaj kolejn? informacj?</a>
</body>
</html>
