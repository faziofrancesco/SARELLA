package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import model.Ordine;
import model.Pagamento;

import persistence.DAOFactory;
import persistence.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
@WebServlet(value = "/Paga", name = "Paga")
public class Pay extends HttpServlet {
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

            RequestDispatcher rd = req.getRequestDispatcher("/homepage");
            rd.forward(req,resp);

        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
        }
    }
}
