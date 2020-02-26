package controller;

import model.Cliente;
import model.GoogleUser;
import persistence.DAOFactory;
import persistence.DBManager;
import persistence.Dao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/googleLogin", name = "googleLogin")
public class GoogleLogin extends HttpServlet {

    private static final long serialVersionUID = 7919968393646409012L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        try {

            DAOFactory factory = DBManager.getInstance().getDAOFactory();

            String email = req.getParameter("email");
            String name = req.getParameter("nome");
            Cliente user = factory.getClienteDao().retrieveByEmail(email);
            if(user == null) {
                Cliente u = new Cliente();
                u.setUsername(name);
                u.setEmail(email);
                u.setPassword("*Tensa1.,");
                Dao<Cliente> userdao = factory.getClienteDao();
                userdao.save(u);
                Cliente cl = factory.getClienteDao().retrieveByUsernamePassword(name, "*Tensa1.,");
                Dao<GoogleUser> usergoogle = factory.getGoogleUserDao();
                GoogleUser gu = new GoogleUser();
                gu.setFk_cliente(cl.getIdCliente());
                usergoogle.save(gu);
            }

            req.getSession().setAttribute("userGoogle",true);
            resp.addCookie(new Cookie("userGoogle", "true"));
            req.getSession().setAttribute("logged", true);
            resp.addCookie(new Cookie("logged", "true"));
            req.setAttribute("username", name);
            req.getSession().setAttribute("username",name);

            resp.getOutputStream().print(1);
            resp.setStatus(201);

        } catch(Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
        }
    }
}
