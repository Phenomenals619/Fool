/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mypacky;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Admin
 */
@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); out.println("<form action='ShowResult' method='post'>");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/qadb", "root", "spdt");
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("select * from quiz");
            out.println("<table border='1'>");
            int qno = 0;
            while (res.next()) {
                qno++;
                out.println("<tr><td>" + res.getString(1) + "</td>");
                out.println("<td>" + res.getString(2) + "</td></tr>");
                
                out.println("<tr><td><input type='radio' name='" + qno + "' value='" + res.getString(3) + "'> </td>"
                            + "<td>" + res.getString(3) + "</td></tr>");
                out.println("<tr><td><input type='radio' name='" + qno + "' value='" + res.getString(4) + "'> </td>"
                            + "<td>" + res.getString(4) + "</td></tr>");
                out.println("<tr><td><input type='radio' name='" + qno + "' value='" + res.getString(5) + "'> </td>"
                            + "<td>" + res.getString(5) + "</td></tr>");
                out.println("<tr><td><input type='radio' name='" + qno + "' value='" + res.getString(6) + "'> </td>"
                            + "<td>" + res.getString(6) + "</td></tr>");
            }
        } catch (Exception e) {
            out.println(e);
        }
        out.println("</table>");
        out.println("<input type='reset'>");
        out.println("<input type='submit' value='SUBMIT'>");
        out.println("</form>");
    }
}

