package controller;

import model.Cliente;
import persistence.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(value = "/updateUser", name = "updateUser")
@MultipartConfig
public class UpdateUser extends HttpServlet {

    private static final long serialVersionUID = -1502971624749032132L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(405);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        try {
            Cliente r = new Cliente();
            r.setIdCliente((Integer)req.getSession().getAttribute("idcliente"));
            r.setNome(req.getParameter("updateClienteName"));
            r.setCognome(req.getParameter("updateClienteSurname"));

            try {
                String date = req.getParameter("updateClienteDate");
                r.setDataDiNascita(Date.valueOf(date));
            } catch(IllegalArgumentException s) {
                r.setDataDiNascita(null);
            }

            r.setEmail(req.getParameter("updateClienteEmail"));
            String newUsername = req.getParameter("updateClienteUsername");
            String newPassword = req.getParameter("updateClientePassword");
            r.setUsername(newUsername);
            r.setPassword(newPassword);

            DBManager.getInstance().getDAOFactory().getClienteDao().update(r);

            if(newUsername != null && !newUsername.equals("")) req.getSession().setAttribute("username", newUsername);
            if(newPassword != null && !newPassword.equals("")) req.getSession().setAttribute("password", newPassword);

            resp.setStatus(201);

        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
        }

    }
}
