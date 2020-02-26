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

@WebServlet(value = "/addbookingtocart", name = "addbookingtocart")
public class Booking extends HttpServlet{
    private static final long serialVersionUID = 12332424324323242L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        try {
            System.out.println( request.getSession().getAttribute("andata"));
            Prenotazione p=new Prenotazione();
            p.setIdOrdineFk((Integer) request.getSession().getAttribute("idordine"));
            java.sql.Date date =  (Date)request.getSession().getAttribute("andata");
            java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
            java.sql.Date date1 =  (Date)request.getSession().getAttribute("ritorno");
            java.sql.Timestamp timestamp1 = new java.sql.Timestamp(date1.getTime());
            p.setDataCheckIn(timestamp);
            p.setDataCheckout(timestamp1);
            p.setIdCameraFk((Integer) request.getSession().getAttribute("idca"));
            DBManager.getInstance().getDAOFactory().getPrenotazioneDao().save(p);
            response.setStatus(201);
        } catch(Exception e) {
            e.printStackTrace();
            response.setStatus(500);
        }
    }
}
