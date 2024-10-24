package mypack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.*;
import javax.servlet.*;


/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = {"/NonBlockingServlet"})
public class NonBlockingServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>FileReader</h1>");
            String filename = "/WEB-INF/SampleText.txt";
            ServletContext c = getServletContext();
            InputStream in = c.getResourceAsStream(filename);
            String path = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() +"/ReadingNonBloclingServlet";
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setChunkedStreamingMode(2);
            conn.setDoOutput(true);
            conn.connect();
            if (in != null) {
                InputStreamReader inr = new InputStreamReader(in);
                BufferedReader br = new BufferedReader(inr);
                String text = "";
                System.out.println("Reading started....");
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
                while ((text = br.readLine()) != null) {
                    out.print(text + "<br>");
                    try {
                        Thread.sleep(1000);
                        out.flush();
                    } catch (InterruptedException ex) {
                    }
                }
                out.print("reading completed....");
                bw.flush();
                bw.close();
            }
        }
    }
}



