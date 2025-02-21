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

@WebServlet("/pierwsza")
public class PierwszaServlet extends HttpServlet {
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            response.getWriter().println("<html>");
            response.getWriter().println("<h2> Podaj liczbe </h2>");
            response.getWriter().println("<form method='post'>");
            response.getWriter().println("<input type='number' name='liczba' required>");
            response.getWriter().println("<button type='submit'>Wyslij</button>");
            response.getWriter().println("</form>");
            response.getWriter().println("</html>"); 
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int liczba = Integer.parseInt(request.getParameter("liczba"));
        
        HttpSession sesja = request.getSession();
        sesja.setAttribute("liczba", liczba);
        
        if(liczba%2==0){
            response.sendRedirect("parzysta");
        }else{
            response.sendRedirect("nieparzysta");
        }
        
    }

}
