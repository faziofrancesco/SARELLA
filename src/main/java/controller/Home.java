package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/homepage", name = "homepage")
public class Home extends HttpServlet {

    private static final long serialVersionUID = -4724504639378125399L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            rd.include(req, resp);

        } catch(Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
        }
    }
}
