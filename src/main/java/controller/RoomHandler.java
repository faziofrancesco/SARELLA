package controller;

import model.Camera;
import model.NumPersone;
import model.Tipologia;
import persistence.DAOFactory;
import persistence.DBManager;
import persistence.PersistenceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(value = "/rooms-handler", name = "rooms-handler")
public class RoomHandler extends HttpServlet {

    private static final long serialVersionUID = -4881835338388887651L;

    private final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>(){

        private static final long serialVersionUID = 1678329264931762966L;
        {
            put("show", "rooms-catalog-page.jsp");
            put("admin", "room-administration.jsp");
            put("single", "room-page.jsp");
        }
    };

    private void loadRoomRange(HttpServletRequest req, HttpServletResponse resp, boolean dateRange) throws PersistenceException, NullPointerException {
        DAOFactory f = DBManager.getInstance().getDAOFactory();

        List<Tipologia> t = f.getTipologiaDao().retrieveAll();
        req.setAttribute("tip", t);
        List<NumPersone> np = f.getNumPersoneDao().retrieveAll();
        req.setAttribute("nump", np);

        List<Camera> cm = null;
        if(!dateRange) {
            cm = f.getCameraDao().retrieveAll();
        } else {
            Date andata = Date.valueOf(req.getParameter("arrivalDate"));
            Date ritorno = Date.valueOf(req.getParameter("departureDate"));
            cm = f.getCameraDao().retrieveInRange(andata, ritorno);
        }
        req.setAttribute("prods", cm);
    }

    private void loadSingleRoom(HttpServletRequest req, HttpServletResponse resp) throws PersistenceException, NullPointerException {
        Camera c = new Camera();
        c.setIdCamera(Integer.parseInt(req.getParameter("id")));
        c = DBManager.getInstance().getDAOFactory().getCameraDao().retrieve(c);
        req.setAttribute("room", c);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        try{
            String target = req.getParameter("target");
            if(!map.containsKey(target)) {
                throw new Exception();
            } else {
                switch(target) {
                    case "admin": loadRoomRange(req, resp, false);
                        break;

                    case "show": loadRoomRange(req, resp, true);
                        break;

                    case "single": loadSingleRoom(req, resp);
                        break;
                }
            }

            req.getRequestDispatcher(map.get(target)).include(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(404);
        }
    }
}
