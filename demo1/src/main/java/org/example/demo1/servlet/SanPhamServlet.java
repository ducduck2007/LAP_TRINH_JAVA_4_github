package org.example.demo1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.demo1.entity.LoaiSanPham;
import org.example.demo1.entity.SanPham;
import org.example.demo1.repository.LoaiSanPhamRepos;
import org.example.demo1.repository.SanPhamRepos;

import java.io.IOException;
import java.util.List;

@WebServlet("/san-pham/*")
public class SanPhamServlet extends HttpServlet {
    private final SanPhamRepos sanPhamRepos = new SanPhamRepos();
    private final LoaiSanPhamRepos loaiSanPhamRepos = new LoaiSanPhamRepos();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        if (path == null || path.equals("/") || path.equals("/hien-thi")) {
            hienThi(req, resp);
        } else if (path.equals("/detail")) {
            detail(req, resp);
        } else if (path.equals("/update")) {
            showUpdateForm(req, resp);
        } else if (path.equals("/del")) {
            delete(req, resp);
        } else if (path.equals("/search")) {
            search(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        if (path.equals("/add")) {
            add(req, resp);
        } else if (path.equals("/update")) {
            update(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sanPhams", sanPhamRepos.getAll());
        req.setAttribute("loaiSpList", loaiSanPhamRepos.getAll());
        req.getRequestDispatcher("/views/hien-thi.jsp").forward(req, resp);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        String mota = req.getParameter("mota");
        int idLoaiSp = Integer.parseInt(req.getParameter("idLoaiSp"));
        LoaiSanPham loaiSanPham = loaiSanPhamRepos.getById(idLoaiSp);

        SanPham sanPham = new SanPham(null, ma, ten, mota, loaiSanPham);
        sanPhamRepos.create(sanPham);

        resp.sendRedirect(req.getContextPath() + "/san-pham/hien-thi");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        sanPhamRepos.deleteById(id);
        resp.sendRedirect(req.getContextPath() + "/san-pham/hien-thi");
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        SanPham spDetail = sanPhamRepos.getById(id);
        req.setAttribute("spDetail", spDetail);
        req.setAttribute("sanPhams", sanPhamRepos.getAll());
        req.setAttribute("loaiSpList", loaiSanPhamRepos.getAll());
        req.getRequestDispatcher("/views/hien-thi.jsp").forward(req, resp);
    }

    private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        SanPham sp = sanPhamRepos.getById(id);
        req.setAttribute("spDetail", sp);
        req.setAttribute("loaiSpList", loaiSanPhamRepos.getAll());
        req.getRequestDispatcher("/views/update.jsp").forward(req, resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
