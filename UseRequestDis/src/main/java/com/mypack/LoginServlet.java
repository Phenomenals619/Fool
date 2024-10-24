package com.mypack;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        
        if(password.equals("Servlet")) {
            req.setAttribute("username", name);
            RequestDispatcher rd = req.getRequestDispatcher("profile.jsp");
            rd.forward(req, resp);
        } else {
            req.setAttribute("error", "Invalid password! Please try again.");
            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            rd.include(req, resp);
        }
    }
    
}
