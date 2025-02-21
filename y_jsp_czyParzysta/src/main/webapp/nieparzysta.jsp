

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Nieparzysta.jsp</h2>
        <%
            Integer liczba = (Integer) session.getAttribute("liczba");
            if (liczba == null){
            out.println("Nie podano liczby");
            }else{
            out.println("Liczba nieparzysta");
            }
        %>
        <a href="index.jsp">Powrot</a>
    </body>
</html>
