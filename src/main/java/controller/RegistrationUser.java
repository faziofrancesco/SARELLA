package controller;

import model.Cliente;
import persistence.DBManager;
import persistence.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(value = "/registrationUser", name = "registrationUser")
public class RegistrationUser extends HttpServlet {
    private static final long serialVersionUID = -6910811414241559167L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setStatus(405);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String cognome = request.getParameter("surname");
        String data = request.getParameter("datanascita");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        Cliente cliente=new Cliente();
        cliente.setNome(name);
        cliente.setCognome(cognome);
        cliente.setDataDiNascita(Date.valueOf(data));
        cliente.setEmail(email);
        cliente.setUsername(username);
        cliente.setPassword(password);
        Dao<Cliente> userdao = DBManager.getInstance().getDAOFactory().getClienteDao();
        userdao.save(cliente);
        response.setStatus(201);
    }
}
