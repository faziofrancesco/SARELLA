package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Camera;
import persistence.DBManager;
import persistence.Dao;

@WebServlet(value = "/rooms_servlet", name = "rooms_servlet")
public class AddRoom extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 4054930605466624053L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(405);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("Id1");
        String tipo = req.getParameter("Tipo1");
        String descrizione = req.getParameter("Descrizione1");
        String numMaxPersone = req.getParameter("numMaxPersone1");
        String immagine = ("images/").concat(req.getParameter("Img1"));
        String prezzo = req.getParameter("Prezzo1");

        Camera r = new Camera();
        r.setIdCamera(Integer.parseInt(id));
        r.setTipologia(Integer.parseInt(tipo));
        r.setDescrizione(descrizione);
        r.setNumPersone(Integer.parseInt(numMaxPersone));
        r.setPrezzo(Double.parseDouble(prezzo));
        r.setImagePath(immagine);

        DBManager.getInstance().getDAOFactory().getCameraDao().save(r);

        resp.setStatus(201);
    }
}
