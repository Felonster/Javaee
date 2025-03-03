package javaee.ciastko.czas.od.wejscia;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/pokaz")
public class PokazServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        long aktualnyCzas = System.currentTimeMillis();
        long pierwszyCzas = aktualnyCzas;

        Cookie[] ciasteczka = request.getCookies();
        if (ciasteczka != null) {
            for (Cookie cookie : ciasteczka) {
                if ("pierwszaWizyta".equals(cookie.getName())) {
                    pierwszyCzas = Long.parseLong(cookie.getValue());
                }
            }
        }

        // Ustawiamy cookie, jeśli to pierwsza wizyta
        if (pierwszyCzas == aktualnyCzas) {
            Cookie noweCiasteczko = new Cookie("pierwszaWizyta", String.valueOf(aktualnyCzas));
            noweCiasteczko.setMaxAge(60 * 60 * 24); // ważne 1 dzień
            response.addCookie(noweCiasteczko);
        }

        long roznicaCzasu = (aktualnyCzas - pierwszyCzas) / 1000; // w sekundach

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Informacja o wizycie</title></head><body>");
        if (pierwszyCzas == aktualnyCzas) {
            out.println("<h1>To jest Twoja pierwsza wizyta!</h1>");
        } else {
            out.println("<h1>Minęło " + roznicaCzasu + " sekund od Twojej pierwszej wizyty.</h1>");
        }
        out.println("<a href='/ciastko-czas-od-wejscia/ustawczas'>Resetuj liczniki dla wszystkich</a>");
        out.println("</body></html>");
    }
}
