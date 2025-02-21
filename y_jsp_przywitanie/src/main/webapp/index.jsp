
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Podaj imie nazwisko</h2>
        <form method="post" action="index.jsp">
            <label>Imie: <input type="text" name="imie" required/></label>
            <label>Nazwisko: <input type="text" name="nazwisko" required/></label>
            <button type="submit">Zapisz</button>
        </form>
        <%
            String imie1 = request.getParameter("imie");
            String nazwisko1 = request.getParameter("nazwisko");
            if(imie1 !=null && nazwisko1 !=null){
            
            session.setAttribute("imie1", imie1);
            session.setAttribute("nazwisko1", nazwisko1);
            response.sendRedirect("przywitanie.jsp");
            }
        %>
        
    </body>
</html>
