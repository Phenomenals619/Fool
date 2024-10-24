package com.mypack;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calcuu")
public class Calcu extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<title>Calculator</title>");
		out.println("<body style='text-align: center'>");
		out.println("<h2>Simple Calculator</h2>");
		out.println("<form action='calcuu' method='post'>");
		out.println("First Num: <input type='text' name='num1' required/> <br/><br/>");
		out.println("Second Num: <input type='text' name='num2' required/> <br/><br/>");
		out.println("Operation: <select name='operation'>");
		out.println("<option value='add' >Add</option>");
		out.println("<option value='sub' >sub</option>");
		out.println("<option value='mul' >mul</option>");
		out.println("<option value='div' >div</option>");
		out.println("</select><br/><br/>");
		out.println("<input type='submit' value='Calculate' />");
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double num1 = Double.parseDouble(req.getParameter("num1"));
		double num2 = Double.parseDouble(req.getParameter("num2"));
		String operation = req.getParameter("operation");
		
		double result = 0;
		PrintWriter out = resp.getWriter();
		
		switch (operation) {
		case "add":
			result = num1 + num2;
			break;
		case "sub":
			result = num1 - num2;
			break;
		case "mul":
			result = num1 * num2;
			break;
		case "div":
			result = num1 / num2;
			break;
		default:
			out.println("Invalid operation");
			break;
		}
		
		resp.setContentType("text/html");
		out.println("<html>");
		out.println("<title>Calculator</title>");
		out.println("<body style='text-align: center'>");
		out.println("<h2> Result: " + result + "</h2>");
		out.println("</body>");
		out.println("</html>");
	}
}
