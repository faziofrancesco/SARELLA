package controller;
import model.Cliente;
import model.Prenotazione;
import persistence.DBManager;
import persistence.Dao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@WebServlet(value = "/addbookingtocart", name = "addbookingtocart")
public class Booking extends HttpServlet{
    private static final long serialVersionUID = 12332424324323242L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        try {
            Prenotazione p = new Prenotazione();
            p.setIdOrdineFk((Integer) request.getSession().getAttribute("idordine"));
            System.out.println((Integer) request.getSession().getAttribute("idordine"));
            java.sql.Date andata = (Date)request.getSession().getAttribute("andata");;
            java.sql.Date ritorno = (Date)request.getSession().getAttribute("ritorno");;

            p.setDataCheckIn(andata);
            p.setDataCheckout(ritorno);

            p.setIdCameraFk((Integer) request.getSession().getAttribute("idca"));
            DBManager.getInstance().getDAOFactory().getPrenotazioneDao().save(p);
            response.setStatus(201);

        } catch(Exception e) {
            e.printStackTrace();
            response.setStatus(500);
        }
    }
}
