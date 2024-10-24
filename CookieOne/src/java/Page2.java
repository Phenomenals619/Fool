
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Page2 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Page2</title></head>");
        out.println("<body bgcolor=yellow >");
        Cookie[] ck = request.getCookies();
        for (int i = 0; i < ck.length; i++) {
            if (ck[i].getName().equals("visit")) {
                int count = Integer.parseInt(ck[i].getValue()) + 1;
                out.println("<h1>Visit No : " + count + "</h1>");
                ck[i] = new Cookie("visit", count + "");
                response.addCookie(ck[i]);
            } else {
                out.println(ck[i].getName() + " = " + ck[i].getValue());
            }
            out.println("<h1><a href=Page3 >Click to visit Page 3 </a></h1>");
            out.println("<h1><a href=Page4 >Click to visit Page 4 </a></h1>");
            out.println("<h1><a href=Page5 >Click to visit Page 5 </a></h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
