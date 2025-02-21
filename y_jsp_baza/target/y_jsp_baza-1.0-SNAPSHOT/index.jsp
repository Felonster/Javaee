<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="pl">

<head>
    <title>Lista Osób</title>
    <meta charset="UTF-8">
</head>

<body>
    <h2>Dodaj osobę</h2>

    <!-- Formularz do dodawania osoby -->
    <form method="post" action="index.jsp">
        <label>Imię: <input type="text" name="imie" required /></label><br>
        <label>Adres: <input type="text" name="adres" required /></label><br>
        <label>Telefon: <input type="text" name="telefon" required /></label><br>
        <button type="submit">Dodaj osobę</button>
    </form>

    <hr>

    <h2>Lista osób:</h2>

    <%
        // Pobranie danych z formularza
        String imie = request.getParameter("imie");
        String adres = request.getParameter("adres");
        String telefon = request.getParameter("telefon");

        // Inicjalizacja listy osób w sesji (jeśli nie istnieje)
        List<String[]> listaOsob = (List<String[]>) session.getAttribute("listaOsob");
        if (listaOsob == null) {
            listaOsob = new ArrayList<>();
            session.setAttribute("listaOsob", listaOsob);
        }

        // Dodanie nowej osoby do listy, jeśli dane są podane
        if (imie != null && adres != null && telefon != null) {
            listaOsob.add(new String[]{imie, adres, telefon});
        }

        // Wyświetlenie tabeli z osobami
        if (!listaOsob.isEmpty()) {
    %>
        <table border="1">
            <tr>
                <th>Imię</th>
                <th>Adres</th>
                <th>Telefon</th>
            </tr>
            <%
                for (String[] osoba : listaOsob) {
            %>
                <tr>
                    <td><%= osoba[0] %></td>
                    <td><%= osoba[1] %></td>
                    <td><%= osoba[2] %></td>
                </tr>
            <%
                }
            %>
        </table>
    <%
        } else {
            out.println("<p>Brak dodanych osób.</p>");
        }
    %>

    <!-- Przycisk do usunięcia danych z sesji -->
    <form method="post" action="index.jsp">
        <button type="submit" name="czysc">Wyczyść listę</button>
    </form>

    <%
        // Usunięcie danych z sesji po kliknięciu "Wyczyść listę"
        if (request.getParameter("czysc") != null) {
            session.removeAttribute("listaOsob");
            response.sendRedirect("index.jsp");
        }
    %>

</body>

</html>
