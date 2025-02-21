
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
            <label>Podaj liczbe: <input type="numeric" name="liczba" required /></label>
            <button type="submit">Wygeneruj losowa</button>
        </form>
        <%
            String liczbaPodana = request.getParameter("liczba");
            if(liczbaPodana!=null){
            try{
            int liczba = Integer.parseInt(liczbaPodana);
            session.setAttribute("liczba", liczba);
            response.sendRedirect("losowa.jsp");
            }catch(NumberFormatException e){
            
            }
            }
            
         %>
        
            
    </body>
</html>
