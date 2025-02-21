/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaee.z_servlet_losowa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet("/losowa")
public class LosowaServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        HttpSession sesja = request.getSession();
        Integer liczba = (Integer) sesja.getAttribute("liczba");
        Random random = new Random();
        response.getWriter().println("<html>");
        if(liczba!=null){
          int wylosowanaLiczba = random.nextInt(100) + liczba +1;
          response.getWriter().println("<h2>Wylosowana Liczba:</h2>");
          response.getWriter().println(wylosowanaLiczba);
        }else{
          response.getWriter().println("<h2>Nie podano liczby</h2>"); 
        }

        response.getWriter().println("</html>");
        
        
        
    }
}
