package controller;
import model.Camera;
import persistence.DBManager;
import model.Prenotazione;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(value = "/eliminaPrenotazione", name = "eliminaPrenotazione")
public class DeletePrenotazione extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(405);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        Integer idordine= (Integer) req.getSession().getAttribute("idordine");
        Integer idcamera=Integer.valueOf(req.getParameter("roomId"));
        try {
            DBManager.getInstance().getDAOFactory().getPrenotazioneDao().deleteprenotazione(idordine,idcamera);
            resp.setStatus(201);

        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
        }

    }
}
