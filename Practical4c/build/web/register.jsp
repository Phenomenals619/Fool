<%-- 
    Document   : register
    Created on : 03-Oct-2024, 8:11:02 am
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="dbUtil.jsp" %>
<%@ page import="java.sql.PreparedStatement" %>
<%
    String message = "";

    if (request.getMethod().equalsIgnoreCase("POST")) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            String query = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                message = "Registration successful! <a href='index.jsp'>Login here</a>";
            } else {
                message = "Registration failed.";
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
    <title>Register</title>
</head>
<body>
    <h2>Register Here</h2>
    <form method="POST">
        Username: <input type="text" name="username" required><br><br>
        Password: <input type="password" name="password" required><br><br>
        <input type="submit" value="Register">
    </form>
    <p><%= message %></p>
    <p>Already have an account? <a href="index.jsp">Login</a></p>
</body>
</html>
<%
    if (conn != null) {
        conn.close();
    }
%>


