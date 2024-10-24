package com.mypack; 

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logg")
public class MyLoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head><title>Login</title></head>");
		out.println("<body>");
		out.println("Please fill all infomation");
		out.println("<form action='logg' method='post'>");
		out.println("Enter UserName: <input type='text' name='uname' required /><br/>");
		out.println("Enter Password: <input type='password' name='upass' required /><br/>");
		out.println("<input type='submit' value='Login' />");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String upass = req.getParameter("upass");
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		if(upass.equals("pass")) {
			out.println("Hello "+ uname);
		}
		else {
			out.println("Login failed");
		}
		
	}
}
