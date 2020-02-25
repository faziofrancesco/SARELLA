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

@WebServlet(value = "/updaterooms_servlet", name = "updaterooms_servlet")
@MultipartConfig
public class UpdateRoom extends HttpServlet {

    private static final long serialVersionUID = 4054930605466624053L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(405);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        try {
            Camera r = new Camera();

            String id = req.getParameter("updateRoomFormId");
            r.setIdCamera(Integer.parseInt(id));

            String descrizione = req.getParameter("updateRoomFormDesc");
            if (descrizione != null) {
                r.setDescrizione(descrizione);
            }

            String prezzo = req.getParameter("updateRoomFormPrice");
            if (prezzo != null) {
                r.setPrezzo(new BigDecimal(prezzo));
            }

            String numMaxPersone = req.getParameter("updateRoomFormNumP");
            if (numMaxPersone != null) {
                r.setNumPersone(Integer.parseInt(numMaxPersone));
            }

            String tipo = req.getParameter("updateRoomFormType");
            if (tipo != null) {
                r.setTipologia(Integer.parseInt(tipo));
            }

            Part img = req.getPart("updateRoomFormImg");
            if (img != null) {
                String filename = Paths.get(img.getSubmittedFileName()).getFileName().toString();
                InputStream fileContent = img.getInputStream();
                r.setImagePath(filename);
            }

            DBManager.getInstance().getDAOFactory().getCameraDao().update(r);

            resp.setStatus(201);

        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
        }

    }
}

