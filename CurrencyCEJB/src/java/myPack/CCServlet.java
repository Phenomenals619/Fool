/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myPack;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Admin
 */
@WebServlet("/CCServlet")
public class CCServlet extends HttpServlet {

    
    CCBean obj =new CCBean();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        double amt = Double.parseDouble(request.getParameter("amt"));
        if (request.getParameter("type").equals("r2d")) {
            out.println("<h1>" + amt + " Rupees = " + obj.r2Dollor(amt) + " Dollors</h1>");
        }
        if (request.getParameter("type").equals("d2r")) {
            out.println("<h1>" + amt + " Dollors = " + obj.d2Rupees(amt) + " Rupees</h1>");
        }
    }
}
