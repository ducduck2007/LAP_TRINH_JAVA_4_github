package com.example.project_sanpham.servlet;

import com.example.project_sanpham.dao.DishDAO;
import com.example.project_sanpham.entity.Dish;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "DishesServlet", urlPatterns = {
        "/dishes",            // danh sách
        "/dishes/create",      // form thêm
        "/dishes/store",       // submit thêm
        "/dishes/edit",        // form sửa?id=
        "/dishes/update",      // submit sửa
        "/dishes/delete",      // xóa?id=
        "/dishes/show"         // xem chi tiết?id=
})
public class DishesServlet extends HttpServlet {
    private DishDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new DishDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String path = req.getServletPath();
        switch (path) {
            case "/dishes/create":
                showForm(req, resp, new Dish(), new HashMap<>(), false);
                break;
            case "/dishes/edit":
                Integer idEdit = parseId(req);
                Dish dEdit = dao.findById(idEdit);
                if (dEdit == null) { resp.sendRedirect(req.getContextPath() + "/dishes"); return; }
                showForm(req, resp, dEdit, new HashMap<>(), true);
                break;
            case "/dishes/show":
                Integer idShow = parseId(req);
                Dish dShow = dao.findById(idShow);
                if (dShow == null) { resp.sendRedirect(req.getContextPath() + "/dishes"); return; }
                req.setAttribute("dish", dShow);
                req.getRequestDispatcher("/WEB-INF/views/dishes/detail.jsp").forward(req, resp);
                break;
            default: // "/dishes"
                req.setAttribute("list", dao.findAll());
                req.getRequestDispatcher("/WEB-INF/views/dishes/list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String path = req.getServletPath();
        if ("/dishes/store".equals(path)) {
            Dish d = bind(req);
            Map<String, String> errors = validate(d, false);
            if (!errors.isEmpty()) {
                showForm(req, resp, d, errors, false);
                return;
            }
            dao.save(d);
            resp.sendRedirect(req.getContextPath() + "/dishes");
        } else if ("/dishes/update".equals(path)) {
            Integer id = parseId(req);
            Dish existed = dao.findById(id);
            if (existed == null) { resp.sendRedirect(req.getContextPath() + "/dishes"); return; }
            Dish d = bind(req);
            d.setId(id);
            Map<String, String> errors = validate(d, true);
            if (!errors.isEmpty()) {
                showForm(req, resp, d, errors, true);
                return;
            }
            dao.update(d);
            resp.sendRedirect(req.getContextPath() + "/dishes");
        } else if ("/dishes/delete".equals(path)) {
            Integer id = parseId(req);
            dao.delete(id);
            resp.sendRedirect(req.getContextPath() + "/dishes");
        } else {
            resp.sendRedirect(req.getContextPath() + "/dishes");
        }
    }

    private Integer parseId(HttpServletRequest req) {
        try { return Integer.parseInt(req.getParameter("id")); }
        catch (Exception e) { return null; }
    }

    private Dish bind(HttpServletRequest req) {
        Dish d = new Dish();
        d.setName(req.getParameter("name"));
        try { d.setCalories(Integer.parseInt(req.getParameter("calories"))); }
        catch (Exception e) { d.setCalories(null); }
        d.setIsVegan("on".equals(req.getParameter("isVegan")) || "1".equals(req.getParameter("isVegan")));
        d.setDescription(req.getParameter("description"));
        return d;
    }

    private Map<String, String> validate(Dish d, boolean isUpdate) {
        Map<String, String> errs = new HashMap<>();
        if (d.getName() == null || d.getName().trim().isEmpty()) {
            errs.put("name", "Tên không được để trống");
        }
        if (d.getCalories() == null) {
            errs.put("calories", "Calories phải là số");
        } else if (d.getCalories() < 0) {
            errs.put("calories", "Calories phải >= 0");
        }
        if (d.getIsVegan() == null) d.setIsVegan(false);
        return errs;
    }

    private void showForm(HttpServletRequest req, HttpServletResponse resp, Dish model, Map<String, String> errors, boolean isEdit)
            throws ServletException, IOException {
        req.setAttribute("model", model);
        req.setAttribute("errors", errors);
        req.setAttribute("isEdit", isEdit);
        req.getRequestDispatcher("/WEB-INF/views/dishes/form.jsp").forward(req, resp);
    }
}