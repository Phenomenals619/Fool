import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class FileDownloadServlet extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "F:/uploads";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the file name from request
        String fileName = request.getParameter("fileName");
        if (fileName == null || fileName.isEmpty()) {
            response.getWriter().println("File name is missing.");
            return;
        }

        // Locate the file
        File file = new File(UPLOAD_DIRECTORY + File.separator + fileName);
        if (!file.exists()) {
            response.getWriter().println("File not found.");
            return;
        }

        // Set response headers
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        response.setContentLength((int) file.length());

        // Send the file as the response
        try (FileInputStream inputStream = new FileInputStream(file);
             OutputStream outputStream = response.getOutputStream()) {
            
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }
}