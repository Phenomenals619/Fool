package com.mypack;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Welcome", urlPatterns = {"/Welcome"})
public class Welcome extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String uname = req.getParameter("userName");
        int visitCount = 1;
        
        Cookie [] cv = req.getCookies();
        
        for(int i = 0; i < cv.length; i++){
            if(cv[i].getName().equals("visit")){
                visitCount = Integer.parseInt(cv[i].getValue());
            }
        }
        
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Welcome</title></head>");
        out.println("<body bgcolor=pink >");
        out.println("<h1>Welcome "+uname+"</h1>");
        out.println("<b>Visit: " + visitCount + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
    
}
