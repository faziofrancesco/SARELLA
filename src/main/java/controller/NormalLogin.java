package controller;

import model.Admin;
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
            String username = req.getParameter("username2");
            String password = req.getParameter("password2");
            Boolean check=false;
            Cliente admin=DBManager.getInstance().getDAOFactory().getClienteDao().retrieveByUsernamePassword(username, password);
            Admin ad=DBManager.getInstance().getDAOFactory().getAdminDao().retrieveByUser(admin.getIdCliente());
            if(DBManager.getInstance().getDAOFactory().getAdminDao().retrieveByUser(admin.getIdCliente())!=null &&  ad.getIdAdmin()!=0){
               check=true;
            }
            Cliente cl=DBManager.getInstance().getDAOFactory().getClienteDao().retrieveByUsernamePassword(username, password);

            if (DBManager.getInstance().getDAOFactory().getClienteDao().retrieveByUsernamePassword(username, password)!=null && cl.getIdCliente()!=0) {

                Integer idordine=DBManager.getInstance().getDAOFactory().getOrdineDao().retrieveByUser(admin.getIdCliente());
                req.getSession().setAttribute("idordine", idordine);
                req.getSession().setAttribute("idcliente",admin.getIdCliente() );

                resp.addCookie(new Cookie("logged", "true"));
                req.setAttribute("username", username);
                req.getSession().setAttribute("username", username);
                req.getSession().setAttribute("logged",true);
                if(check==true){
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
