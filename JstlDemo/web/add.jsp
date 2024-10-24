<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
    <h1>Add New Employee</h1>

    <form method="post">
        Name: <input type="text" name="name" required/><br/><br/>
        Position: <input type="text" name="position" required/><br/><br/>
        <input type="submit" value="Add Employee"/>
    </form>

    <!-- SQL Insert Query -->
    <c:if test="${not empty param.name and not empty param.position}">
        <sql:setDataSource var="dbSource" driver="com.mysql.cj.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/practicals"
                           user="root" password="Ahmed619#"/>
        
        <sql:update dataSource="${dbSource}">
            INSERT INTO employees (name, position) VALUES ('${param.name}', '${param.position}');
        </sql:update>
        <c:redirect url="index.jsp"/>
    </c:if>
</body>
</html>
