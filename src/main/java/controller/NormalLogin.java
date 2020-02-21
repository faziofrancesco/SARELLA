package controller;

import javax.servlet.http.*;

import model.Cliente;
import persistence.DBManager;
import persistence.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet(value = "/normalLogin", name = "normalLogin")
public class NormalLogin extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(DBManager.getInstance().getDAOFactory().getClienteDao().existusernameandpassword(username,password))
        {
            req.getSession().setAttribute("logged",true);
            resp.addCookie(new Cookie("logged", "true"));
            req.setAttribute("username",username);
            req.getSession().setAttribute("username", username);
            resp.setStatus(201);

        } else {
            resp.setStatus(401);
        }
    }
}
