package org.example.lab6.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import org.example.lab6.dao.UserDAOImpl;
import org.example.lab6.model.User;

import java.io.IOException;

@WebServlet({"/account/sign-in", "/account/change-password", "/account/edit-profile"})
public class AccountServlet extends HttpServlet {
    private final UserDAOImpl dao = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();

        if (uri.contains("sign-in")) {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);

        } else if (uri.contains("edit-profile")) {
            req.getRequestDispatcher("/edit-profile.jsp").forward(req, resp);

        } else if (uri.contains("change-password")) {
            req.getRequestDispatcher("/change-password.jsp").forward(req, resp);

        } else {
            resp.sendRedirect(req.getContextPath() + "/page.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();

        if (uri.contains("sign-in")) {
            String user = req.getParameter("username");
            String pass = req.getParameter("password");

            User found = dao.findByUsername(user);
            if (found != null && found.getPassword().equals(pass)) {
                req.getSession().setAttribute("user", found);
                String redirectURL = (String) req.getSession().getAttribute("redirect");
                if (redirectURL != null) {
                    resp.sendRedirect(redirectURL);
                } else {
                    resp.sendRedirect(req.getContextPath() + "/page.jsp");
                }
            } else {
                resp.getWriter().println("Incorrect username or password.");
            }

        } else if (uri.contains("edit-profile")) {
            User user = (User) req.getSession().getAttribute("user");
            if (user == null) {
                resp.sendRedirect(req.getContextPath() + "/login.jsp");
                return;
            }

            String newUsername = req.getParameter("username");
            String newEmail = req.getParameter("email");

            user.setUsername(newUsername);
            user.setEmail(newEmail);
            dao.update(user);

            resp.getWriter().println("Profile updated successfully!");

        } else if (uri.contains("change-password")) {
            User user = (User) req.getSession().getAttribute("user");
            if (user == null) {
                resp.sendRedirect(req.getContextPath() + "/login.jsp");
                return;
            }

            String currentPass = req.getParameter("currentPassword");
            String newPass = req.getParameter("newPassword");
            String confirmPass = req.getParameter("confirmPassword");

            if (!user.getPassword().equals(currentPass)) {
                resp.getWriter().println("Current password is incorrect.");
                return;
            }

            if (!newPass.equals(confirmPass)) {
                resp.getWriter().println("New password does not match.");
                return;
            }

            user.setPassword(newPass);
            dao.update(user);

            resp.getWriter().println("Password changed successfully!");
        }
    }
}
