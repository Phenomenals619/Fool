<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Employee</title>
</head>
<body>
    <h1>Update Employee</h1>

    <form method="post">
        <input type="hidden" name="id" value="${param.id}"/>
        Name: <input type="text" name="name" value="${param.name}" required/><br/><br/>
        Position: <input type="text" name="position" value="${param.position}" required/><br/><br/>
        <input type="submit" value="Update Employee"/>
    </form>

    <!-- SQL Update Query -->
    <c:if test="${not empty param.name and not empty param.position}">
        <sql:setDataSource var="dbSource" driver="com.mysql.cj.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/practicals"
                           user="root" password="Ahmed619#"/>
        
        <sql:update dataSource="${dbSource}">
            UPDATE employees SET name = '${param.name}', position = '${param.position}' WHERE id = ${param.id};
        </sql:update>
        <c:redirect url="index.jsp"/>
    </c:if>
</body>
</html>
