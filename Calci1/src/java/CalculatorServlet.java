import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Get input values from the form
        String num1Str = request.getParameter("number1");
        String num2Str = request.getParameter("number2");
        String operation = request.getParameter("operation");

        // Convert inputs to double
        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result = 0;

        // Perform the selected operation
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
                    PrintWriter out = response.getWriter();
                    out.println("Cannot divide by zero");
                    return;
                }
                break;
            default:
                break;
        }

        // Set response content type and return result
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd=request.getRequestDispatcher("index.html");
        rd.include(request, response);
        out.println("<html><body>");
        out.println("<h3>Result: " + result + "</h3>");
        out.println("</body></html>");
    }
}
