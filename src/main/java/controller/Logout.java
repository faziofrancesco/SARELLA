package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/logout", name = "logout")
public class Logout extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = -3499056463190953357L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("userGoogle", false);
        req.getSession().setAttribute("logged", false);
        req.getSession().removeAttribute("username");
        resp.addCookie(new Cookie("logged", "false"));
        resp.addCookie(new Cookie("logged", "false"));
        resp.addCookie(new Cookie("userGoogle", "false"));
        req.getRequestDispatcher("/homepage").forward(req, resp);
        // resp.sendRedirect(req.getHeader("referer"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(405); // Permission denied, only GET here
    }
}
