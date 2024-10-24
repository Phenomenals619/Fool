<%-- 
    Document   : logout
    Created on : 03-Oct-2024, 8:15:39 am
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
    session.invalidate();
    response.sendRedirect("index.jsp");
%>

