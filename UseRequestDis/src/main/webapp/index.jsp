<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Enter Correct Details</h1>
        <form action="LoginServlet" method="post">
            <input type="text" name="username" required /><br/><br/>
            <input type="password" name="password" required /><br/><br/>
            <input type="submit" value="Login" />
        </form>
        <p style="color: red">
            ${error != null ? error : ""}
        </p>
    </body>
</html>
