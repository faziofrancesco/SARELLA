package controller;

import model.Camera;
import model.Ordine;
import persistence.DAOFactory;
import persistence.DBManager;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(value = "/storico", name = "storico")
public class StoricoOrdini extends HttpServlet {

    private static final long serialVersionUID = 829948915089756101L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        try {

            DAOFactory factory = DBManager.getInstance().getDAOFactory();

            Integer idCliente = (Integer)req.getSession().getAttribute("idcliente");
            List<Ordine> ordine = factory.getOrdineDao().retrieveForStorico(idCliente);

            ConcurrentHashMap<Integer, List<Camera>> camere = new ConcurrentHashMap<>();
            for(Ordine o : ordine) {
                List<Camera> c = factory.getCameraDao().retrieveByOrder(o.getIdOrdine());
                camere.put(o.getIdOrdine(), c);
            }

            req.getSession().setAttribute("ordine", ordine);
            req.getSession().setAttribute("camere", camere);

            resp.setStatus(201);

        } catch(Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
        }
    }
}
