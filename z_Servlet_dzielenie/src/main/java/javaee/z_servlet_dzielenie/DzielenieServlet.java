/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaee.z_servlet_dzielenie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pierwsza")
public class DzielenieServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
            response.getWriter().println("<html>");
        response.getWriter().println("<h2>Podaj Liczby</h2>");
        response.getWriter().println("<form method = 'post'>");
        response.getWriter().println("<input type='number' name='licznik' required>");
        response.getWriter().println("<input type='number' name='mianownik' required>");
        response.getWriter().println("<button type='submit'>wyslij</button>");     
        response.getWriter().println("</form>");
        
        response.getWriter().println("</html>");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        int licznik = Integer.parseInt(request.getParameter("licznik"));
        int mianownik = Integer.parseInt(request.getParameter("mianownik"));
        
        if(mianownik==0){
            response.sendRedirect("blad");      
        }else{
            double wynik = (double) licznik/mianownik;
             response.getWriter().println("<html>");
            response.getWriter().println("<h2>Wynik dzielenie</h2>");
        response.getWriter().println("<h2>"+ wynik+"</h2>");
         response.getWriter().println("</html>");
          response.getWriter().println("<p> <a href = 'pierwsza'>Powrot</a></p>");
        }
    }
    
}
