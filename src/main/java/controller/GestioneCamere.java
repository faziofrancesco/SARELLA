package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Camera;
import model.Cliente;
import model.NumPersone;
import model.Tipologia;
import persistence.DBManager;
import persistence.Dao;
@WebServlet(value = "/gestionecamere", name = "gestionecamere")
public class GestioneCamere extends  HttpServlet{

    private static final long serialVersionUID = 2590468198652604537L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        try{
            List<Tipologia> t=DBManager.getInstance().getDAOFactory().getTipologiaDao().retrieveAll();
            req.setAttribute("tip", t);
            List<NumPersone> np=DBManager.getInstance().getDAOFactory().getNumPersoneDao().retrieveAll();
            req.setAttribute("nump", np);
            List<Camera> cm=DBManager.getInstance().getDAOFactory().getCameraDao().retrieveAll();
            List<Integer>d=new ArrayList<Integer>();
            for(int i=0;i<cm.size();i++)
            {
                d.add(cm.get(i).getIdCamera());
            }
            req.setAttribute("id",d);
            RequestDispatcher rd = req.getRequestDispatcher("room-administration.jsp");
            rd.include(req, resp);
        } catch(Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
        }
    }
}
