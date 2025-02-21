

<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Wylosowana Liczba</h1>
        <%
            Integer liczba = (Integer) session.getAttribute("liczba");
            if (liczba==null){
            out.println("Nie podano liczby");
            }else{
            Random random = new Random();
            int losowaLiczba = random.nextInt(100) + liczba + 1;
            %>
            <p>Wylosowana liczba <%= losowaLiczba %></p>
            <%
            }
        %>
    </body>
</html>
