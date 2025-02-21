/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaee.ciasteczko.timeout;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pierwsza")
public class CookieUstawServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long czasTeraz = System.currentTimeMillis();
        Cookie ciastko = new Cookie("czasUtworzenia", String.valueOf(czasTeraz));
        ciastko.setMaxAge(30); 
        response.addCookie(ciastko); 
        
        response.getWriter().println("<html>");
        response.getWriter().println("<Ciasteczko zapisane>");
        response.getWriter().println("<p>Przejdz na <a href='druga'>druga strone</a></p>");
        response.getWriter().println("</html>");
        
    }
}

