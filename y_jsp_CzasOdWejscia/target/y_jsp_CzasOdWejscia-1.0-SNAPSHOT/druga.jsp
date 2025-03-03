<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
    <title>Reset Counter</title>
</head>
<body>
    <div class="container">
        <h1>Counter Reset</h1>
       
    <%
        Date now = new Date();
        session.setAttribute("firstVisit", now);
    %>

        
        <p>Your visit counter has been reset!</p>
        <p><a href="pierwsza.jsp">Go back to see the new counter</a></p>
    </div>
</body>
</html>