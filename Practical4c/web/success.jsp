<%-- 
    Document   : success
    Created on : 03-Oct-2024, 8:14:37 am
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
    <h1>Welcome, <%= session.getAttribute("username") %>!</h1>
    <a href="logout.jsp">Logout</a>
</body>
</html>

