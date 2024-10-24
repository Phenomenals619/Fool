package com.mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/college";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "bhms312";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String country = req.getParameter("country");

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish database connection
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            // SQL Query for inserting data
            String insertQuery = "INSERT INTO students(username, password, email, country) VALUES (?, ?, ?, ?)";
            ps = con.prepareStatement(insertQuery);

            // Set parameters
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, country);

            // Execute the update query
            int result = ps.executeUpdate();

            if (result > 0) {
                out.println("Registration Successful!<br>");

                // SQL Query to fetch all student data
                String accessQuery = "SELECT * FROM students";
                ps = con.prepareStatement(accessQuery);
                rs = ps.executeQuery();

                // Display data
                out.println("<h3>All Students</h3>");

                while (rs.next()) {
                    out.println(rs.getInt("id"));
                    out.print(rs.getString("username"));
                    out.print(rs.getString("email"));
                    out.print(rs.getString("country"));
                    out.print("<br/>");
                }
            } else {
                out.println("Registration Failed!");
            }

        } catch (ClassNotFoundException | SQLException e) {
            out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close resources in the finally block
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
