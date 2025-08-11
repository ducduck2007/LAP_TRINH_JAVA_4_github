package com.example.assignment_gd2.servlet.auth;

import com.example.assignment_gd2.dao.UserDAO;
import com.example.assignment_gd2.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private final UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (userDAO.findByEmail(email) != null) {
            req.setAttribute("error", "Email đã tồn tại");
            req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
            return;
        }
        User u = new User();
        u.setName(name);
        u.setEmail(email);
        u.setPassword(password); // demo plain text
        u.setRole("STUDENT");
        userDAO.save(u);
        req.setAttribute("msg", "Đăng ký thành công. Vui lòng đăng nhập.");
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }
}