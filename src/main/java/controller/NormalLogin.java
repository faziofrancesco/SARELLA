package controller;

import model.Cliente;
import persistence.DBManager;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/normalLogin", name = "normalLogin")
public class NormalLogin extends HttpServlet {

    private static final long serialVersionUID = 1719454196023301003L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            Boolean check=false;
            Cliente admin=DBManager.getInstance().getDAOFactory().getClienteDao().retrieveByUsernamePassword(username, password);
            if(DBManager.getInstance().getDAOFactory().getAdminDao().retrieveByUser(admin.getIdCliente())!=null){
               check=true;
            }
            if (DBManager.getInstance().getDAOFactory().getClienteDao().retrieveByUsernamePassword(username, password)!=null) {

                req.getSession().setAttribute("logged", true);
                resp.addCookie(new Cookie("logged", "true"));
                req.setAttribute("username", username);
                req.getSession().setAttribute("username", username);
                if(check){
                    req.getSession().setAttribute("admin", true);
                    resp.addCookie(new Cookie("admin", "true"));
                }
                resp.setStatus(201);

            } else {
                resp.setStatus(401);
            }
        }

        catch(Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
        }

    }
}
