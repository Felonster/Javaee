package javaee.z_servlet_czasodwejscia;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/reset")
public class ResetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Reset the first visit time in session
        HttpSession session = request.getSession();
        session.removeAttribute("firstVisit");

        // Get the context path (e.g. "/z_Servlet_CzasOdWejscia") to redirect properly
        String contextPath = request.getContextPath();
        
        // Redirect to the main page with the full context path
        response.sendRedirect(contextPath + "/czasodwejscia");
    }
}
