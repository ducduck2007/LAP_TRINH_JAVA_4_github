package org.example.demo1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.demo1.repository.SanPhamRepos;

import java.io.IOException;

@WebServlet("/san-pham/del")
public class SanPhamDeleteServlet extends HttpServlet {
    private final SanPhamRepos sanPhamRepos = new SanPhamRepos();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        sanPhamRepos.deleteById(id);
        resp.sendRedirect(req.getContextPath() + "/san-pham/hien-thi");
    }
}
