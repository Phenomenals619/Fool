<%-- 
    Document   : validate
    Created on : 03-Oct-2024, 7:54:03 am
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Validation Page</h1>
        <jsp:useBean id="obj" scope="request"
                     class="myPack.CheckerBean" >
            <jsp:setProperty name="obj" property="*"/>
        </jsp:useBean>
        <%if (obj.validate()) { %>
        <jsp:forward page="successful.jsp"/>
        <% } else {%>
        <jsp:include page="index.html"/>
        <%}%>
        <%=obj.getError()%>
    </body>
</html>
