<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Employee</title>
</head>
<body>
    <h1>Delete Employee</h1>

    <!-- SQL Delete Query -->
    <sql:setDataSource var="dbSource" driver="com.mysql.cj.jdbc.Driver"
                       url="jdbc:mysql://localhost:3306/practicals"
                       user="root" password="Ahmed619#"/>
    
    <sql:update dataSource="${dbSource}">
        DELETE FROM employees WHERE id = ${param.id};
    </sql:update>

    <c:redirect url="index.jsp"/>
</body>
</html>
