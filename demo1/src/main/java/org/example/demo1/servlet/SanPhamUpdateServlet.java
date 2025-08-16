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

@WebServlet("/san-pham/update")
public class SanPhamUpdateServlet extends HttpServlet {
    private final SanPhamRepos sanPhamRepos = new SanPhamRepos();
    private final LoaiSanPhamRepos loaiSanPhamRepos = new LoaiSanPhamRepos();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        SanPham sp = sanPhamRepos.getById(id);

        req.setAttribute("spDetail", sp);
        req.setAttribute("loaiSpList", loaiSanPhamRepos.getAll());
        req.getRequestDispatcher("/views/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        String mota = req.getParameter("mota");
        int idLoaiSp = Integer.parseInt(req.getParameter("idLoaiSp"));

        LoaiSanPham loaiSp = loaiSanPhamRepos.getById(idLoaiSp);

        SanPham sanPham = sanPhamRepos.getById(id);
        sanPham.setMa(ma);
        sanPham.setTen(ten);
        sanPham.setMota(mota);
        sanPham.setIdLoaiSp(loaiSp);

        sanPhamRepos.update(sanPham);

        resp.sendRedirect(req.getContextPath() + "/san-pham/hien-thi");
    }
}
