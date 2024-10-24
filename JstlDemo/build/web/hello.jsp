<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSTL Simple Example</title>
</head>
<body>

    <h1>Welcome to the JSTL Example Page</h1>

    <!-- Set a list of items (fruits) -->
    <c:set var="fruits" value="${['Apple', 'Banana', 'Orange', 'Grapes']}" />

    <h2>List of Fruits</h2>
    <!-- Check if the list is not empty -->
    <c:if test="${not empty fruits}">
        <ul>
            <!-- Iterate over the list and display each fruit -->
            <c:forEach var="fruit" items="${fruits}">
                <li>${fruit}</li>
            </c:forEach>
        </ul>
    </c:if>

    <!-- Conditional Example: Display different messages based on a condition -->
    <c:set var="userRole" value="guest" />
    
    <h2>Access Level:</h2>
    <c:choose>
        <c:when test="${userRole == 'admin'}">
            <p>You are an Admin! You have full access.</p>
        </c:when>
        <c:when test="${userRole == 'user'}">
            <p>You are a User! You have limited access.</p>
        </c:when>
        <c:otherwise>
            <p>You are a Guest! Please log in to access more features.</p>
        </c:otherwise>
    </c:choose>



</body>
</html>
