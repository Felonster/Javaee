

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Podane dane</h2>
        <%
            String imie1 = (String) session.getAttribute("imie1");
            String nazwisko1 = (String) session.getAttribute("nazwisko1");
            if (imie1==null || nazwisko1==null){
            out.println("Nie podane danych");
        }else{
        %>
        <p>Witaj <%= imie1%> <%= nazwisko1%> </p>
        <%
            }
        %>
        <a href="index.jsp">Powrot</a>
    </body>
</html>
