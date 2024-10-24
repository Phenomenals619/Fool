
package com.mypack;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionServlet", urlPatterns = {"/SessionServlet"})
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        HttpSession session =  req.getSession(true);
        
        if(session.isNew()){
            // New session created, so this is the user's first visit
            session.setAttribute("visited", true);  // Mark the user as visited
            out.println("<html><head><title>Session Example</title></head>");
            out.println("<body bgcolor='lightblue'>");
            out.println("<h2>Welcome! This is your first visit to this page.</h2>");
            out.println("</body></html>");
        }else {
            // Existing session, the user has visited before
            out.println("<html><head><title>Session Example</title></head>");
            out.println("<body bgcolor='lightblue'>");
            out.println("<h2>Welcome back! You've visited this page before.</h2>");
            out.println("</body></html>");
        }
    }
    
}
