package javaee.z_servlet_baza;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/pierwsza")
public class BazaServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        if (context.getAttribute("peopleList") == null) {
            context.setAttribute("peopleList", new ArrayList<String[]>());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ServletContext context = getServletContext();
        List<String[]> people = (List<String[]>) context.getAttribute("peopleList");

        out.println("<html><head><title>Lista osób</title></head><body>");
        out.println("<h2>Lista osób</h2>");
        out.println("<table border='1'><tr><th>Imię</th><th>Adres</th><th>Telefon</th></tr>");

        for (String[] person : people) {
            out.println("<tr><td>" + person[0] + "</td><td>" + person[1] + "</td><td>" + person[2] + "</td></tr>");
        }

        out.println("</table>");
        out.println("<h3>Dodaj nową osobę:</h3>");
        out.println("<form action='pierwsza' method='post'>");
        out.println("Imię: <input type='text' name='name' required><br>");
        out.println("Adres: <input type='text' name='address' required><br>");
        out.println("Telefon: <input type='text' name='phone' required><br>");
        out.println("<button type='submit'>Dodaj</button>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");

        ServletContext context = getServletContext();
        List<String[]> people = (List<String[]>) context.getAttribute("peopleList");

        people.add(new String[]{name, address, phone});

        response.sendRedirect("pierwsza");
    }
}
