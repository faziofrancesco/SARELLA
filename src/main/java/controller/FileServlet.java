package controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.URLDecoder;
import java.nio.file.Files;

@WebServlet(value = "/images/*", name = "images/*")
public class FileServlet extends HttpServlet {

    private static final long serialVersionUID = 1880603484626848088L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try{
            String filename = URLDecoder.decode(request.getPathInfo().substring(1), "UTF-8");
            File file = new File("C:" + File.separator + "SIW-resources", filename);
            response.setHeader("Content-Type", getServletContext().getMimeType(filename));
            response.setHeader("Content-Length", String.valueOf(file.length()));
            response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
            Files.copy(file.toPath(), response.getOutputStream());
        } catch(Exception e) {
            e.printStackTrace();
            response.setStatus(500);
        }
    }

}
