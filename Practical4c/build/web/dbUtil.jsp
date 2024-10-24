<%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.SQLException" %>
<%
    Connection conn = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/user_db", "root", "root");
    } catch (ClassNotFoundException | SQLException e) {
        out.println("Database connection error: " + e.getMessage());
    }
%>

