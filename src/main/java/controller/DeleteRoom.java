package controller;

import model.Camera;
import persistence.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/deleterooms_servlet", name = "deleterooms_servlet")
@MultipartConfig
public class DeleteRoom extends HttpServlet {

    private static final long serialVersionUID = 224905303019449713L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(405);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        try {
            String id = req.getParameter("deleteRoomModalId" +
                    "");
            Camera c = new Camera();
            c.setIdCamera(Integer.parseInt(id));
            DBManager.getInstance().getDAOFactory().getCameraDao().delete(c);

        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
        }
    }
}
