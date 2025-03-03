<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html>
<head>
    <title>Time Tracker</title>
</head>
<body>
    <div class="container">

<%
    // Pobierz czas pierwszej wizyty z sesji
    Date firstVisit = (Date) session.getAttribute("firstVisit");
    Date now = new Date();

    if (firstVisit == null) {
        // Ustawienie pierwszej wizyty
        firstVisit = now;
        session.setAttribute("firstVisit", firstVisit);
        out.println("<h1>To jest Twoja pierwsza wizyta!</h1>");
    } else {
        long timeDiff = now.getTime() - firstVisit.getTime();
        long seconds = timeDiff / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;

        out.println("<h1>Minęło od pierwszej wizyty:</h1>");
        out.println("<p>" + hours + " godzin, " + (minutes % 60) + " minut, " + (seconds % 60) + " sekund.</p>");
    }
%>

        <p><a href="pierwsza.jsp">Refresh</a></p>
        <p><a href="druga.jsp">Reset your counter</a></p>
    </div>
</body>
</html>