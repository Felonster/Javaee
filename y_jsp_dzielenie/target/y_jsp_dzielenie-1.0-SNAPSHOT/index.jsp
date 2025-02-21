
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Dzielenie</h2>
        <form method="post" action="index.jsp">
            <label>Licznik: <input type="number" name="licznik" required/></label>
            <label>Mianownik: <input type="number" name="mianownik" required/></label>
                <button type="submit">Podziel</button>
        </form>
        <%
            String licznik1 = request.getParameter("licznik");
            String mianownik1 = request.getParameter("mianownik");
            if(licznik1!=null && licznik1 != null){
            try{
            int licznik = Integer.parseInt(licznik1);
            int mianownik = Integer.parseInt(mianownik1);
            
            if(mianownik == 0){
            response.sendRedirect("blad.jsp");
            }else{
            double wynik = (double) licznik/mianownik;
            %>
            <p>Wynik: <%= wynik %></p>
            <%
            }
            }catch(NumberFormatException e){
            
            }
            }
        
        %>
        
        
    </body>
</html>
