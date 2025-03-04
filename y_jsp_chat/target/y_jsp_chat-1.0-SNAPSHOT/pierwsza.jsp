<%@ page import="java.util.*" %>
<%
    String nowaInformacja = request.getParameter("informacja");
    if(nowaInformacja != null && !nowaInformacja.isEmpty()) {
        List<String> listaInformacji = (List<String>) application.getAttribute("wszystkieInformacje");
        if(listaInformacji == null) {
            listaInformacji = new ArrayList<>();
        }
        listaInformacji.add(nowaInformacja);
        application.setAttribute("wszystkieInformacje", listaInformacji);
        out.println("<p>Informacja zostala zapisana!</p>");
    }
%>
<html>
<head>
    <title>Dodaj informacje</title>
</head>
<body>
    <h1>Podaj informacje do zapisania:</h1>
    <form method="post">
        <input type="text" name="informacja" />
        <input type="submit" value="Zapisz" />
    </form>
    <br>
    <a href="druga.jsp">Zobacz wszystkie informacje</a>
</body>
</html>
