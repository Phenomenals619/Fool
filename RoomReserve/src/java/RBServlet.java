
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/RBServlet")
public class RBServlet extends HttpServlet {

    
    RRBean obj=new RRBean();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String rt = request.getParameter("txtType");
        String cn = request.getParameter("txtCust");
        String cm = request.getParameter("txtMob");
        String msg = obj.roomBook(rt, cn, cm);
        out.println(msg);
    }
}
