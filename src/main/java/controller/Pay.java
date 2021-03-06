package controller;

import model.Ordine;
import model.Pagamento;
import persistence.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
@WebServlet(value = "/Paga", name = "Paga")
public class Pay extends HttpServlet {

    private static final long serialVersionUID = 4628435760395132596L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        try{
            Pagamento p = new Pagamento();
            Date date = new Date();
            Integer temp = (Integer) req.getSession().getAttribute("totPrice");
            p.setImporto(new BigDecimal(temp));
            p.setDataPagamento(new Timestamp(date.getTime()));
            DBManager.getInstance().getDAOFactory().getPagamentoDao().save(p);
            Pagamento idpfk = DBManager.getInstance().getDAOFactory().getPagamentoDao().retrieveLastPaypment();
            Ordine o = new Ordine();
            o.setIdOrdine((Integer) req.getSession().getAttribute("idordine"));
            o.setIdClienteFk((Integer) req.getSession().getAttribute("idcliente"));
            o.setIdPagamentoFk(idpfk.getIdPagamento());
            DBManager.getInstance().getDAOFactory().getOrdineDao().update(o);

            req.getSession().removeAttribute("ordrooms");
            req.getSession().removeAttribute("totPrice");

            resp.setStatus(201);

        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
        }
    }
}
