package org.example.demo1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.demo1.entity.SanPham;
import org.example.demo1.repository.LoaiSanPhamRepos;
import org.example.demo1.repository.SanPhamRepos;

import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SanPhamSearchServlet extends HttpServlet {
    private final SanPhamRepos sanPhamRepos = new SanPhamRepos();
    private final LoaiSanPhamRepos loaiSanPhamRepos = new LoaiSanPhamRepos();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ten = req.getParameter("ten");

        List<SanPham> sanPhams;
        if (ten != null && !ten.trim().isEmpty()) {
            sanPhams = sanPhamRepos.searchByTen(ten);
        } else {
            sanPhams = sanPhamRepos.getAll();
        }

        req.setAttribute("sanPhams", sanPhams);
        req.setAttribute("loaiSpList", loaiSanPhamRepos.getAll());

        req.getRequestDispatcher("/views/hien-thi.jsp").forward(req, resp);
    }
}
