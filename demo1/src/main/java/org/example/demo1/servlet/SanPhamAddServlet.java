package org.example.demo1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo1.entity.LoaiSanPham;
import org.example.demo1.entity.SanPham;
import org.example.demo1.repository.LoaiSanPhamRepos;
import org.example.demo1.repository.SanPhamRepos;

import java.io.IOException;

@WebServlet("/san-pham/add")
public class SanPhamAddServlet extends HttpServlet {
    private final SanPhamRepos sanPhamRepos = new SanPhamRepos();
    private final LoaiSanPhamRepos loaiSanPhamRepos = new LoaiSanPhamRepos();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        String mota = req.getParameter("mota");

        int idLoaiSp = Integer.parseInt(req.getParameter("idLoaiSp"));
        LoaiSanPham loaiSanPham = loaiSanPhamRepos.getById(idLoaiSp);

        SanPham sanPham = new SanPham(null, ma, ten, mota, loaiSanPham);
        sanPhamRepos.create(sanPham);

        resp.sendRedirect(req.getContextPath() + "/san-pham/hien-thi");
    }
}
