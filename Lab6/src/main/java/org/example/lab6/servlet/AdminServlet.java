package org.example.lab6.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet({"/admin/video", "/admin/user", "/admin/like", "/admin/share"})
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write("Admin servlet route: " + req.getRequestURI());
    }
}
