/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mypacky;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet("/ShowResult")
public class ShowResult extends HttpServlet{
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/qadb", "root", "spdt");
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("select ans from quiz");
            int count = 0, qno = 0;
            while (res.next()) {
                if (res.getString(1).equals(request.getParameter("" + (++qno)))) {
                    count++;
                    out.println("<h1>Correct </h1>");
                } else {
                    out.println("<h1>Incorrect </h1>");
                }
            }
            out.println("<h1>Your Score is " + count + " </h1>");
        } catch (Exception e) {
            out.println(e);
        }
    }
}

