package controller;

import model.Camera;
import persistence.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/single_room", name = "single_room")
public class SingolaCamera extends HttpServlet {

    private static final long serialVersionUID = -3101357226887176059L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            Camera c = new Camera();
            c.setIdCamera(Integer.parseInt(req.getParameter("target")));
            c = DBManager.getInstance().getDAOFactory().getCameraDao().retrieve(c);
            req.setAttribute("room", c);

            RequestDispatcher rd = req.getRequestDispatcher("room-page.jsp");
            rd.include(req, resp);

        } catch(Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
        }
    }
}
