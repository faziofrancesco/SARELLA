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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tipologia> t=DBManager.getInstance().getDAOFactory().getTipologiaDao().retrieveAll();
        req.setAttribute("tip", t);
        List<NumPersone> np=DBManager.getInstance().getDAOFactory().getNumPersoneDao().retrieveAll();
        req.setAttribute("nump", np);
        RequestDispatcher rd = req.getRequestDispatcher("room-administration.jsp");
        List<Camera> cameras=DBManager.getInstance().getDAOFactory().getCameraDao().retrieveAll();
        List<Integer> idc=new ArrayList<Integer>();
        if(cameras.size()>=1) {
            for (int i = 0; i < cameras.size(); i++)
                idc.add(cameras.get(i).getIdCamera());
            req.setAttribute("idc", idc);
        }
        rd.include(req, resp);
    }
}
