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
import model.NumPersone;
import model.Tipologia;
import persistence.DBManager;
import persistence.Dao;

@WebServlet(value = "/homepage", name = "homepage")
public class Home extends HttpServlet{

    private static final long serialVersionUID = -4724504639378125399L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
        rd.include(req,resp);
    }
}
