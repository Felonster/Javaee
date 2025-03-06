
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
    <title>Pierwsza strona</title>
    </head> 
<%
    // Pobranie globalnego czasu resetu
    Long globalnyReset = (Long) application.getAttribute("globalnyReset");
    if (globalnyReset == null) {
        globalnyReset = 0L;
    }

    // Sprawdzamy czas pierwszej wizyty w sesji
    Long czasPierwszejWizyty = (Long) session.getAttribute("czasPierwszejWizyty");
    long aktualnyCzas = System.currentTimeMillis();

    if (czasPierwszejWizyty == null || czasPierwszejWizyty < globalnyReset) {
        czasPierwszejWizyty = aktualnyCzas;
        session.setAttribute("czasPierwszejWizyty", czasPierwszejWizyty);
        out.println("<p>To Twoja pierwsza wizyta!</p>");
    } else {
        long roznica = (aktualnyCzas - czasPierwszejWizyty) / 1000;
        out.println("<p>Minęło " + roznica + " sekund od Twojej pierwszej wizyty.</p>");
    }
%>



<body>
    <h1>Witaj w aplikacji!</h1>
    <a href="druga.jsp">Zresetuj licznik dla wszystkich użytkowników</a>
</body>
</html>

