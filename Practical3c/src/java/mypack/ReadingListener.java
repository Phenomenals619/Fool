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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;

/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = {"/ReadingListener"})
public class ReadingListener extends HttpServlet {

    private ServletInputStream input = null;
    private AsyncContext ac = null;

    ReadingListener(ServletInputStream in, AsyncContext c) {
        input = in;
        ac = c;
    }

    public void onDataAvailable() throws IOException {
    }

    public void onAllDataRead() throws IOException {
        ac.complete();
    }

    public void onError(final Throwable t) {
        ac.complete();
        t.printStackTrace();
    }

    

}
