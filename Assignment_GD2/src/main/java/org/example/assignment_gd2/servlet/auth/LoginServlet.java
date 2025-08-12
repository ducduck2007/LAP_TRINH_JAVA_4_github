package com.example.assignment_gd2.servlet.auth;

import com.example.assignment_gd2.dao.UserDAO;
import com.example.assignment_gd2.model.User;
import com.example.assignment_gd2.util.SessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private final UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User u = userDAO.findByEmail(email);
        if (u == null || !u.getPassword().equals(password)) {
            req.setAttribute("error", "Sai email hoặc mật khẩu");
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
            return;
        }
        req.getSession().setAttribute(SessionUtil.AUTH_USER, u);
        if (SessionUtil.isAdmin(u)) resp.sendRedirect(req.getContextPath() + "/admin/borrow-requests");
        else resp.sendRedirect(req.getContextPath() + "/student/books");
    }
}
