package controller;

import model.Cliente;
import persistence.DBManager;
import persistence.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(value = "/registrationUser", name = "registrationUser")
@MultipartConfig
public class RegistrationUser extends HttpServlet {

    private static final long serialVersionUID = -6910811414241559167L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setStatus(405);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        try {
            String name = request.getParameter("reg-name");
            String cognome = request.getParameter("reg-surname");
            String data = request.getParameter("reg-date");
            String username = request.getParameter("reg-username");
            String password = request.getParameter("reg-password");
            String email = request.getParameter("reg-email");
            Cliente cliente = new Cliente();
            cliente.setNome(name);
            cliente.setCognome(cognome);
            cliente.setDataDiNascita(Date.valueOf(data));
            cliente.setEmail(email);
            cliente.setUsername(username);
            cliente.setPassword(password);
            Dao<Cliente> userdao = DBManager.getInstance().getDAOFactory().getClienteDao();
            userdao.save(cliente);
            response.setStatus(201);
        } catch(Exception e) {
            e.printStackTrace();
            response.setStatus(500);
        }
    }
}
