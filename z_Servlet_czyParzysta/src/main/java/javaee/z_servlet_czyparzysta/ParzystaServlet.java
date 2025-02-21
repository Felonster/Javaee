/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaee.z_servlet_czyparzysta;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/parzysta")
public class ParzystaServlet extends HttpServlet {
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesja = request.getSession();
        Integer liczba = (Integer) sesja.getAttribute("liczba");
        
        
        response.getWriter().println("<html>");
        
        if (liczba !=null && liczba %2 ==0){
            response.getWriter().println("<h2>parzysta</h2>");
        }else{
            response.getWriter().println("<h2>nie podano liczby</h2>");
        }
        response.getWriter().println("</html>");
    }

}
