package controller;

import model.Camera;
import persistence.DAOFactory;
import persistence.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/show_cart", name = "show_cart")
public class ShowCart extends HttpServlet {

    private static final long serialVersionUID = -8989377143352792023L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            if((req.getSession().getAttribute("logged") == null || !(boolean)req.getSession().getAttribute("logged"))) {
                throw new NullPointerException();
            }

            Integer idordine=DBManager.getInstance().getDAOFactory().getOrdineDao().retrieveByUser((Integer) req.getSession().getAttribute("idcliente"));
            req.getSession().setAttribute("idordine",idordine);
            DAOFactory factory = DBManager.getInstance().getDAOFactory();

            List<Camera> ret = factory.getCameraDao().retrieveByOrder(idordine);
            Integer totPrice = factory.getOrdineDao().retrieveTotalPrice(idordine).intValueExact();

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {


    }
}
