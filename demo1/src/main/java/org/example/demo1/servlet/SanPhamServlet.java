package org.example.demo1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo1.entity.SanPham;
import org.example.demo1.repository.LoaiSanPhamRepos;
import org.example.demo1.repository.SanPhamRepos;

import java.io.IOException;
import java.util.List;

@WebServlet("/san-pham/hien-thi")
public class SanPhamServlet extends HttpServlet {
    private final SanPhamRepos sanPhamRepos = new SanPhamRepos();
    private final LoaiSanPhamRepos loaiSanPhamRepos = new LoaiSanPhamRepos();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<SanPham> sanPhams = sanPhamRepos.getAll();
        req.setAttribute("sanPhams", sanPhams);

        req.setAttribute("loaiSpList", loaiSanPhamRepos.getAll());

        req.getRequestDispatcher("/views/hien-thi.jsp").forward(req, resp);
    }
}
