package org.example.demo1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.demo1.entity.SanPham;
import org.example.demo1.repository.LoaiSanPhamRepos;
import org.example.demo1.repository.SanPhamRepos;

import java.io.IOException;

@WebServlet("/san-pham/detail")
public class SanPhamDetailServlet extends HttpServlet {
    private final SanPhamRepos sanPhamRepos = new SanPhamRepos();
    private final LoaiSanPhamRepos loaiSanPhamRepos = new LoaiSanPhamRepos();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        SanPham spDetail = sanPhamRepos.getById(id);
        req.setAttribute("spDetail", spDetail);

        req.setAttribute("sanPhams", sanPhamRepos.getAll());
        req.setAttribute("loaiSpList", loaiSanPhamRepos.getAll());

        req.getRequestDispatcher("/views/hien-thi.jsp").forward(req, resp);
    }
}
