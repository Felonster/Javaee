package javaee.z_servlet_czasodwejscia;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;

@WebServlet("/czasodwejscia")
public class CzasOdWejsciaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type and character encoding
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        Long firstVisit = (Long) session.getAttribute("firstVisit");
        
        // If the session doesn't have the "firstVisit" attribute, set it
        if (firstVisit == null) {
            firstVisit = System.currentTimeMillis();
            session.setAttribute("firstVisit", firstVisit);
        }

        // Calculate the duration since first visit
        long now = System.currentTimeMillis();
        Duration duration = Duration.ofMillis(now - firstVisit);
        
        // Prepare time components
        long days = duration.toDays();
        long hours = duration.toHoursPart();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();

        // Get the context path (e.g. "/z_Servlet_CzasOdWejscia") to redirect properly
        String contextPath = request.getContextPath();

        // Generate HTML content
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Czas od pierwszej wizyty</title>");
            out.println("<style>body { font-family: Arial, sans-serif; margin: 20px; }</style>");
            out.println("</head><body>");
            out.println("<h1>Czas od pierwszej wizyty</h1>");
            out.printf("<p>Minęło: %d dni, %d godzin, %d minut, %d sekund</p>", days, hours, minutes, seconds);
            out.println("<a href=\"" + contextPath + "/reset\">Resetuj</a>");
            out.println("</body></html>");
        }
    }
}
