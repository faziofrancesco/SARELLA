package controller;

import persistence.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/normalLogin", name = "normalLogin")
public class NormalLogin extends HttpServlet {

    private static final long serialVersionUID = 1719454196023301003L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username + " " + password);

        if (DBManager.getInstance().getDAOFactory().getClienteDao().existusernameandpassword(username, password)!=null) {

            req.getSession().setAttribute("logged", true);
            resp.addCookie(new Cookie("logged", "true"));
            req.setAttribute("username", username);
            req.getSession().setAttribute("username", username);
            resp.setStatus(201);

        } else {
            resp.setStatus(401);
        }
    }
}