
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Parzysta.jsp</h2>
        <%
            Integer liczba = (Integer) session.getAttribute("liczba");
            if(liczba==null){
            out.println("nie podano liczby");
            }else{
            out.println("Liczba parzysta");
            }
            %>
            <a href="index.jsp">Powrot</a>
    </body>
</html>
