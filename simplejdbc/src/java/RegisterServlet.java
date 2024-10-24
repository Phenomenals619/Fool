
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("txtUid");
        String ps = request.getParameter("txtPass");
        String em = request.getParameter("txtEmail");
        String co = request.getParameter("txtCon");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb","root","Ahmed619#");
            PreparedStatement pst = con.prepareStatement("insert into user values(?,?,?,?)");
            pst.setString(1, id);
            pst.setString(2, ps);
            pst.setString(3, em);
            pst.setString(4, co);
            int row = pst.executeUpdate();
           
            RequestDispatcher rd=request.getRequestDispatcher("index.html");
            rd.include(request, response);
             out.println("<h1>" + row + " Inserted Succesfullyyyyy");
        } catch (Exception e) {
            out.println(e);
        }
    
}
}