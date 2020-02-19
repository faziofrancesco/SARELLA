package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import persistence.DBManager;
import persistence.Dao;
@WebServlet(value = "/gestionecamere", name = "gestionecamere")

public class GestioneCamere extends  HttpServlet{

    private static final long serialVersionUID = 2590468198652604537L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd=req.getRequestDispatcher("room-administration.jsp");
        rd.include(req,resp);
    }
}
