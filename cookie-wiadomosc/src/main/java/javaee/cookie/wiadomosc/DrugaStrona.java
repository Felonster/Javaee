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
import java.util.Date;

@WebServlet("/druga")
public class DrugaStrona extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
            // Pobranie ciasteczek z przeglądarki
            Cookie[] ciastka = request.getCookies();
            String czasUtworzenia = null;
            
            if (ciastka != null) {
            for (Cookie c : ciastka) {
                if (c.getName().equals("czasUtworzenia")) {
                    czasUtworzenia = c.getValue();
                    break;
                }
            }
        }
            response.getWriter().println("<html>");
            if(czasUtworzenia != null){
                long czas = Long.parseLong(czasUtworzenia);
                Date data = new Date(czas);
                response.getWriter().println("Ciasteczko utworzone o " + data);
            }else{
                response.getWriter().println("nie znaleziono ciasteczka");
            }
            response.getWriter().println("</html>");
                
                
                
            }
            
    }
    

