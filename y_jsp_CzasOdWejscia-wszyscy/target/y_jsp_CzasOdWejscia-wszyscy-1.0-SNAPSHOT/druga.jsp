

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <html>
<head>
    <title>Reset globalny</title>
</head>

    <%
    application.setAttribute("globalnyReset", System.currentTimeMillis());
%>


<body>
    <h1>Licznik został zresetowany dla wszystkich użytkowników!</h1>
    <a href="pierwsza.jsp">Powrót na stronę główną</a>
</body>
</html>

</html>
