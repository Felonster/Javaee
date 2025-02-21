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

// Servlet obsługujący sprawdzanie ciasteczka
@WebServlet("/druga")
public class CookieSprawdzServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Sprawdź, czy istnieje ciasteczko "mojaCiasteczko"
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
        if(czasUtworzenia!=null){
            long czasZapisany = Long.parseLong(czasUtworzenia);
            long czasTeraz = System.currentTimeMillis();
            long czasPozostaly = 30 - (czasTeraz-czasZapisany)/1000;
            if (czasPozostaly >0){
            response.getWriter().println("Do wygasniecia zostalo "+ czasPozostaly);
        }
        }else{
            response.getWriter().println("brak ciasteczka");  
        }
        response.getWriter().println("</html>");
    }
}

