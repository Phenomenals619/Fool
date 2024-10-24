<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
    <h1>Employee List</h1>

    <!-- Set up the database connection -->
    <sql:setDataSource var="dbSource" driver="com.mysql.cj.jdbc.Driver" 
                       url="jdbc:mysql://localhost:3306/practicals" 
                       user="root" password="Ahmed619#"/>

    <!-- Query the employees table -->
    <sql:query var="employees" dataSource="${dbSource}">
        SELECT * FROM employees;
    </sql:query>

    <!-- Display employees in a table -->
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Position</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="row" items="${employees.rows}">
            <tr>
                <td>${row.id}</td>
                <td>${row.name}</td>
                <td>${row.position}</td>
                <td>
                    <a href="update.jsp?id=${row.id}&name=${row.name}&position=${row.position}">Edit</a>
                    <a href="delete.jsp?id=${row.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <a href="add.jsp">Add New Employee</a>
</body>
</html>
