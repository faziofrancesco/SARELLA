package controller;

import model.Cliente;
import model.GoogleUser;
import persistence.DBManager;
import persistence.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/googleLogin", name = "googleLogin")
public class GoogleLogin extends HttpServlet {

    private static final long serialVersionUID = 7919968393646409012L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String name = req.getParameter("nome");
        Cliente user = DBManager.getInstance().getDAOFactory().getClienteDao().retrieveByEmail(email);
        if (user != null) {
            req.getSession().setAttribute("userGoogle",true);
            resp.addCookie(new Cookie("userGoogle", "true"));
            req.getSession().setAttribute("logged", true);
            resp.addCookie(new Cookie("logged", "true"));
            req.setAttribute("username", name);
            req.getSession().setAttribute("username",name);
            resp.setStatus(201);
            resp.getOutputStream().print(1);
        } else {
            Cliente u = new Cliente();
            u.setUsername(name);
            u.setEmail(email);
            u.setPassword("*Tensa1.,");
            Dao<Cliente> userdao = DBManager.getInstance().getDAOFactory().getClienteDao();
            userdao.save(u);
            Cliente cl=DBManager.getInstance().getDAOFactory().getClienteDao().existusernameandpassword(name,"*Tensa1.,");
            Dao<GoogleUser> usergoogle = DBManager.getInstance().getDAOFactory().getGoogleUserDao();
            GoogleUser gu=new GoogleUser();
            gu.setFk_cliente(cl.getIdCliente());
            usergoogle.save(gu);
            req.getSession().setAttribute("userGoogle",true);
            resp.addCookie(new Cookie("userGoogle", "true"));
            req.getSession().setAttribute("logged", true);
            resp.addCookie(new Cookie("logged", "true"));
            req.setAttribute("username", name);
            req.getSession().setAttribute("username",name);

            resp.setStatus(201);
            resp.getOutputStream().print(1);
        }
    }
}
