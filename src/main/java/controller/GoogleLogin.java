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

@WebServlet(value = "/googleLogin", name = "googleLogin")
public class GoogleLogin extends HttpServlet {

	private static final long serialVersionUID = 7919968393646409012L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		Cliente user = DBManager.getInstance().getDAOFactory().getClienteDao().retrieveByEmail(email);
		System.out.println(email);
		if(user != null) {
			req.getSession().setAttribute("user", user);
			req.getSession().setAttribute("firstLogin", true);
			resp.getOutputStream().print(1);
		}
		else {
			Cliente u=new Cliente();
			u.setEmail(email);
			u.setNome(name);

			Dao<Cliente> userdao = DBManager.getInstance().getDAOFactory().getClienteDao();
			userdao.save(u);
			req.getSession().setAttribute("user", user);
			req.getSession().setAttribute("firstLogin", true);
			resp.getOutputStream().print(1);
		}
	}
}
