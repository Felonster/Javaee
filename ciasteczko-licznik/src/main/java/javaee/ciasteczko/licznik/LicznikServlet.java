
package javaee.ciasteczko.licznik;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pierwsza")
public class LicznikServlet extends HttpServlet {
         @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
// Wyszukaj ciasteczko o nazwie "licznik"
        Cookie[] ciasteczka = request.getCookies();
        int licznik = 0;

        if (ciasteczka != null) {
            for (Cookie cookie : ciasteczka) {
                if ("licznik".equals(cookie.getName())) {
                    licznik = Integer.parseInt(cookie.getValue());
                }
            }
        }
        licznik++;

        // Utwórz nowe ciasteczko z aktualnym licznikiem
        Cookie noweCiasteczko = new Cookie("licznik", String.valueOf(licznik));
        noweCiasteczko.setMaxAge(60); // Czas życia: 60 sekund (1 minuta)
        response.addCookie(noweCiasteczko);
      
        response.getWriter().println("<html><head><title>Licznik odwiedzin</title></head><body>");
        response.getWriter().println("<h1>Witaj na stronie!</h1>");
        response.getWriter().println("<p>Odwiedziłeś tę stronę: " + licznik + " razy.</p>");
        response.getWriter().println("</body></html>");
    }
}
