package com.mypack;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IndexServlet", urlPatterns = {"/IndexServlet"})
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("userName");
        
        resp.setContentType("text/html");
        Cookie [] cv = req.getCookies();
        boolean userFound = false;
        
        for(int i = 0; i < cv.length; i++){
            if(cv[i].getName().equals("username") && cv[i].getValue().equals(uname)){
                userFound = true;
                for(int j = 0; j < cv.length; j++){
                    if(cv[j].getName().equals("visit")){
                        int visitCount = Integer.parseInt(cv[j].getValue()) + 1;
                        Cookie vc = new Cookie("visit", String.valueOf(visitCount));
                        resp.addCookie(vc);
                        break;
                    }
                }
                RequestDispatcher rd = req.getRequestDispatcher("/Welcome");
                rd.forward(req, resp);
                return;
            }
        }
        if(!userFound){
                Cookie ck1 = new Cookie("username", uname);
                Cookie ck2 = new Cookie("visit", "1");
                resp.addCookie(ck1);
                resp.addCookie(ck2);
                RequestDispatcher rd = req.getRequestDispatcher("/Welcome");
                rd.forward(req, resp);
            }
    }
    
}
