package controller;

import model.Camera;
import persistence.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Paths;

@WebServlet(value = "/rooms_servlet", name = "rooms_servlet")
@MultipartConfig
public class AddRoom extends HttpServlet {

    private static final long serialVersionUID = 4054930605466624053L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(405);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        try{
            String id = req.getParameter("id");
            String descrizione = req.getParameter("descrizione");
            String prezzo = req.getParameter("prezzo");

            Camera r = new Camera();
            r.setIdCamera(Integer.parseInt(id));
            r.setPrezzo(new BigDecimal(prezzo));
            r.setDescrizione(descrizione);

            String numMaxPersone = req.getParameter("numpersone");
            if(numMaxPersone!=null) {
                r.setNumPersone(Integer.parseInt(numMaxPersone));
            }

            String tipo = req.getParameter("tipo");
            if(tipo != null) {
                r.setTipologia(Integer.parseInt(tipo));
            }

            Part img = req.getPart("img");
            if(img != null) {
                String filename = Paths.get(img.getSubmittedFileName()).getFileName().toString();
                InputStream fileContent = img.getInputStream();
                r.setImagePath(filename);
            }

            DBManager.getInstance().getDAOFactory().getCameraDao().save(r);

            resp.setStatus(201);

        }catch(Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
        }

    }
}
