package controller;

import model.Camera;
import model.Cliente;
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
import java.sql.Date;

@WebServlet(value = "/updateUser", name = "updateUser")
public class UpdateUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(405);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        try {
            Cliente r = new Cliente();
            r.setIdCliente((Integer) req.getSession().getAttribute("idcliente"));
            r.setNome((String) req.getAttribute("a"));
            System.out.println((String) req.getAttribute("a"));
            r.setCognome((String) req.getAttribute("k"));
            r.setDataDiNascita((Date) req.getAttribute("date2"));
            r.setEmail((String) req.getAttribute("email2"));
            DBManager.getInstance().getDAOFactory().getClienteDao().update(r);

            resp.setStatus(201);

        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
        }

    }
}
