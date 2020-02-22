package controller;

import model.Camera;
import model.NumPersone;
import model.Tipologia;
import persistence.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/show_rooms", name = "show_rooms")
public class VisualizzazioneCamere extends HttpServlet {

    private static final long serialVersionUID = 4027871639599175817L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            List<Tipologia> t = DBManager.getInstance().getDAOFactory().getTipologiaDao().retrieveAll();
            req.setAttribute("tip", t);
            List<NumPersone> np = DBManager.getInstance().getDAOFactory().getNumPersoneDao().retrieveAll();
            req.setAttribute("nump", np);
            List<Camera> cm = DBManager.getInstance().getDAOFactory().getCameraDao().retrieveAll();
            req.setAttribute("id", cm);
            RequestDispatcher rd = req.getRequestDispatcher("rooms-catalog-page.jsp");
            rd.include(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
        }
    }
}

