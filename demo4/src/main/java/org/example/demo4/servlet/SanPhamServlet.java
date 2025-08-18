package org.example.demo4.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo4.entity.LoaiSanPham;
import org.example.demo4.entity.SanPham;
import org.example.demo4.repository.LoaiSanPhamRepository;
import org.example.demo4.repository.SanPhamRepository;

import java.io.IOException;

@WebServlet("/san-pham/*")
public class SanPhamServlet extends HttpServlet {
    private final SanPhamRepository sanPhamRepository = new SanPhamRepository();
    private final LoaiSanPhamRepository loaiSanPhamRepository = new LoaiSanPhamRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path= req.getPathInfo();
        if (path.equals("/hien-thi")) {
            hienThi(req, resp);
        } else if (path.equals("/detail")) {
            detail(req, resp);
        } else if (path.equals("/update")) {
            showFormUpdate(req, resp);
        } else if (path.equals("/delete")) {
            delete(req, resp);
        } else if (path.equals("/search")) {
            search(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path= req.getPathInfo();
        if (path.equals("/add")) {
            add(req, resp);
        } else if (path.equals("/update")) {
            update(req, resp);
        }
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("data", sanPhamRepository.findAll());
        req.setAttribute("lst_ma_loai_sp", loaiSanPhamRepository.findAll());
        req.getRequestDispatcher("/WEB-INF/views/san-pham.jsp").forward(req, resp);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma_san_pham = req.getParameter("ma_san_pham");
        String ten_san_pham = req.getParameter("ten_san_pham");
        String mota_san_pham = req.getParameter("mota_san_pham");
        String website_san_pham = req.getParameter("website_san_pham");
        int gia_ban_san_pham = Integer.parseInt(req.getParameter("gia_ban_san_pham"));
        int so_luong_san_pham = Integer.parseInt(req.getParameter("so_luong_san_pham"));
        int trang_thai_san_pham = Integer.parseInt(req.getParameter("trang_thai_san_pham"));

        int id_loai_san_pham = Integer.parseInt(req.getParameter("id_loai_san_pham"));
        LoaiSanPham loaiSanPham = loaiSanPhamRepository.findById(id_loai_san_pham);
        SanPham sanPham = new SanPham(null, ma_san_pham, ten_san_pham, mota_san_pham, website_san_pham, gia_ban_san_pham, so_luong_san_pham, loaiSanPham, trang_thai_san_pham);

        sanPhamRepository.create(sanPham);
        resp.sendRedirect(req.getContextPath() + "/san-pham/hien-thi");
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        SanPham sanPham = sanPhamRepository.findById(id);
        req.setAttribute("sanPham", sanPham);
        req.setAttribute("data", sanPhamRepository.findAll());
        req.setAttribute("lst_ma_loai_sp", loaiSanPhamRepository.findAll());
        req.getRequestDispatcher("/WEB-INF/views/san-pham.jsp").forward(req, resp);
    }

    private void showFormUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        SanPham sanPham = sanPhamRepository.findById(id);
        req.setAttribute("sanPham", sanPham);
        req.setAttribute("lst_ma_loai_sp", loaiSanPhamRepository.findAll());
        req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_san_pham = Integer.parseInt(req.getParameter("id_san_pham"));
        String ma_san_pham = req.getParameter("ma_san_pham");
        String ten_san_pham = req.getParameter("ten_san_pham");
        String mota_san_pham = req.getParameter("mota_san_pham");
        String website_san_pham = req.getParameter("website_san_pham");
        int gia_ban_san_pham = Integer.parseInt(req.getParameter("gia_ban_san_pham"));
        int so_luong_san_pham = Integer.parseInt(req.getParameter("so_luong_san_pham"));
        int trang_thai_san_pham = Integer.parseInt(req.getParameter("trang_thai_san_pham"));

        int id_loai_san_pham = Integer.parseInt(req.getParameter("id_loai_san_pham"));
        LoaiSanPham loaiSanPham = loaiSanPhamRepository.findById(id_loai_san_pham);
        SanPham sanPham = sanPhamRepository.findById(id_san_pham);

        sanPham.setMa_san_pham(ma_san_pham);
        sanPham.setTen_san_pham(ten_san_pham);
        sanPham.setMota_san_pham(mota_san_pham);
        sanPham.setWebsite_san_pham(website_san_pham);
        sanPham.setGia_ban_san_pham(gia_ban_san_pham);
        sanPham.setSo_luong_san_pham(so_luong_san_pham);
        sanPham.setId_loai_sp(loaiSanPham);
        sanPham.setTrang_thai_san_pham(trang_thai_san_pham);

        sanPhamRepository.update(sanPham);
        resp.sendRedirect(req.getContextPath() + "/san-pham/hien-thi");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        sanPhamRepository.delete(id);
        resp.sendRedirect(req.getContextPath() + "/san-pham/hien-thi");
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ten_san_pham = req.getParameter("ten_san_pham");
        req.setAttribute("data", sanPhamRepository.searchByTenSP(ten_san_pham));
        req.setAttribute("lst_ma_loai_sp", loaiSanPhamRepository.findAll());
        req.getRequestDispatcher("/WEB-INF/views/san-pham.jsp").forward(req, resp);
    }
}
