<%-- 
    Document   : index
    Created on : 03-Oct-2024, 8:12:12 am
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="dbUtil.jsp" %>
<%@ page import="java.sql.PreparedStatement, java.sql.ResultSet" %>
<%
    String message = "";

    if (request.getMethod().equalsIgnoreCase("POST")) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                session.setAttribute("username", username);
                response.sendRedirect("success.jsp");
            } else {
                message = "Invalid username or password.";
            }
        } catch (Exception e) {
            message = "Error: " + e.getMessage();
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h2>Login Here</h2>
    <form method="POST">
        Username: <input type="text" name="username" required><br><br>
        Password: <input type="password" name="password" required><br><br>
        <input type="submit" value="Login">
    </form>
    <p><%= message %></p>
    <p>Don't have an account? <a href="register.jsp">Register here</a></p>
</body>
</html>
<%
    if (conn != null) {
        conn.close();
    }
%>

