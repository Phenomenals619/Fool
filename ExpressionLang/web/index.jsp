<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Simple Calculator using Expression Language (EL)</title>
</head>
<body>
    <h1>Simple Calculator</h1>
    
    <form action="index.jsp" method="post">
        <label for="num1">Number 1: </label>
        <input type="number" name="num1" id="num1" step="any" required>
        <br><br>
        
        <label for="num2">Number 2: </label>
        <input type="number" name="num2" id="num2" step="any" required>
        <br><br>
        
        <label for="operation">Operation: </label>
        <select name="operation" id="operation" required>
            <option value="add">Addition</option>
            <option value="subtract">Subtraction</option>
            <option value="multiply">Multiplication</option>
            <option value="divide">Division</option>
        </select>
        <br><br>
        
        <input type="submit" value="Calculate">
    </form>

    <%
        // Fetching input parameters
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");
        String operation = request.getParameter("operation");

        if (num1Str != null && num2Str != null && operation != null) {
            try {
                double num1 = Double.parseDouble(num1Str);
                double num2 = Double.parseDouble(num2Str);
                double result = 0;

                // Using EL to evaluate the result
                switch (operation) {
                    case "add":
                        result = num1 + num2;
                        break;
                    case "subtract":
                        result = num1 - num2;
                        break;
                    case "multiply":
                        result = num1 * num2;
                        break;
                    case "divide":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            out.println("<p style='color:red;'>Error: Division by zero is not allowed.</p>");
                        }
                        break;
                }

                // Display the result using Expression Language
                request.setAttribute("result", result);
            } catch (NumberFormatException e) {
                out.println("<p style='color:red;'>Invalid input. Please enter valid numbers.</p>");
            }
        }
    %>

    <c:if test="${not empty result}">
        <h2>Result: ${result}</h2>
    </c:if>
</body>
</html>