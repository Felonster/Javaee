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
import java.io.PrintWriter;

@WebServlet("/przywitanie")
public class WyswietlServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
            
            HttpSession sesja = request.getSession(false);
            PrintWriter out = response.getWriter();
            out.println("<html>");
            
            if (sesja == null || sesja.getAttribute("imie") == null || sesja.getAttribute("nazwisko") ==null){
                out.println("Nie podano danych");
            }else{
                String imie = (String) sesja.getAttribute("imie");
                String nazwisko = (String) sesja.getAttribute("nazwisko");
                out.println("<h2>Hello "+ imie+ " " + nazwisko + "</h2>");
                
            }
            out.println("</html>");
            
            
    }
    
}
