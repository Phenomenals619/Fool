import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "F:/uploads"; // Directory to store uploaded files

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the uploaded file from the request
        Part filePart = request.getPart("file");
        String fileName = getFileName(filePart);
        
        // Ensure the upload directory exists
        File uploadDir = new File(UPLOAD_DIRECTORY);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        
        // Save the uploaded file
        try (InputStream inputStream = filePart.getInputStream();
             FileOutputStream outputStream = new FileOutputStream(new File(UPLOAD_DIRECTORY + File.separator + fileName))) {
            
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            response.getWriter().println("File uploaded successfully!");
        }
    }

    // Extracts file name from HTTP header part
    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        for (String token : contentDisposition.split(";")) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 2, token.length() - 1);
            }
        }
        return null;
    }
}