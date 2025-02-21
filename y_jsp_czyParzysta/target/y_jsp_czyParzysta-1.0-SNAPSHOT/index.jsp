
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Podaj liczbe</h2>
        <form method="post" action="index.jsp">
            <label>Liczba: <input type="number" name="liczba" required/></label>
            <button type="submit">Wyslij</button>
        </form>
        <%
            String liczbaPodana = request.getParameter("liczba");
            if(liczbaPodana!=null){
            try{
            // Pobranie liczby z formularza
            int liczba = Integer.parseInt(liczbaPodana);
             // Zapisanie liczby w sesji
             session.setAttribute("liczba", liczba);
             
             if(liczba % 2 ==0){
             response.sendRedirect("parzysta.jsp");
            }else{
            response.sendRedirect("nieparzysta.jsp");
            }
            }
            catch (NumberFormatException e){
            out.println("podaj liczbe");
            }
            
            }
            
        %>
    </body>
</html>
