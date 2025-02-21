/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaee.cookie.wiadomosc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/pierwsza")
public class PierwszaStrona extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        long czas = System.currentTimeMillis();
        
        Cookie ciastko = new Cookie("czasUtworzenia", String.valueOf(czas));
        ciastko.setMaxAge(60);
        response.addCookie(ciastko);
        
            response.setContentType("text/html");
            response.getWriter().println("<html>");
            response.getWriter().println("Cookie ustawione");
            response.getWriter().println("<form action='druga' method='get'>");
            response.getWriter().println("<button type='submit'>Przejdz na druga strone</button>");
            response.getWriter().println("</form>");
            response.getWriter().println("</html>");
        }
        
    }
    

