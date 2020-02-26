package controller;

import model.Camera;
import persistence.DAOFactory;
import persistence.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(value = "/show_cart", name = "show_cart")
public class ShowCart extends HttpServlet {

    private static final long serialVersionUID = -8989377143352792023L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        try{
            if((req.getSession().getAttribute("logged") == null || !(boolean)req.getSession().getAttribute("logged"))) {
                throw new NullPointerException();
            }

            DAOFactory factory = DBManager.getInstance().getDAOFactory();

            Integer idOrdine = (Integer)req.getSession().getAttribute("idordine");
            List<Camera> ret = factory.getCameraDao().retrieveByOrder(idOrdine);
            BigDecimal totPrice = factory.getOrdineDao().retrieveTotalPrice(idOrdine);

            if(ret != null) {
                req.getSession().setAttribute("ordrooms", ret);
                req.getSession().setAttribute("totPrice", totPrice);

                resp.setStatus(201);

            } else {
                resp.setStatus(412);
            }

        } catch(Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
        }
    }
}
