/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaee.z_servlet_przywitanie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/index")
public class DaneServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String imie = request.getParameter("imie");
        String nazwisko = request.getParameter("nazwisko");
        
        HttpSession sesja = request.getSession();
        sesja.setAttribute("imie", imie);
        sesja.setAttribute("nazwisko", nazwisko);
        
        response.sendRedirect("przywitanie");
    }
    
}
