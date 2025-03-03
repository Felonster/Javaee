/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaee.ciastko.czas.od.wejscia;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ustawczas")
public class UstawCzasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Usunięcie ciasteczka przez ustawienie MaxAge na 0
        Cookie kasujCiasteczko = new Cookie("pierwszaWizyta", "");
        kasujCiasteczko.setMaxAge(0);
        response.addCookie(kasujCiasteczko);

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Reset</title></head><body>");
        out.println("<h1>Liczniki zostały zresetowane!</h1>");
        out.println("<a href='/ciastko-czas-od-wejscia/pokaz'>Powrót na stronę główną</a>");
        out.println("</body></html>");
    }
}

