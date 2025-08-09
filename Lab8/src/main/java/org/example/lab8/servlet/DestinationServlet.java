package org.example.lab8.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lab8.dao.DestinationDAO;
import org.example.lab8.entity.Destination;

import java.io.IOException;
import java.util.*;

@WebServlet(name = "DestinationServlet", urlPatterns = {
        "/destinations",             // danh sách
        "/destinations/create",      // form thêm
        "/destinations/store",       // submit thêm
        "/destinations/edit",        // form sửa?id=
        "/destinations/update",      // submit sửa
        "/destinations/delete",      // xóa?id=
        "/destinations/show"         // xem chi tiết?id=
})
public class DestinationServlet extends HttpServlet {
    private DestinationDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new DestinationDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String path = req.getServletPath();
        switch (path) {
            case "/destinations/create":
                showForm(req, resp, new Destination(), new HashMap<>(), false);
                break;
            case "/destinations/edit":
                Integer idEdit = parseId(req);
                Destination dEdit = dao.findById(idEdit);
                if (dEdit == null) { resp.sendRedirect(req.getContextPath() + "/destinations"); return; }
                showForm(req, resp, dEdit, new HashMap<>(), true);
                break;
            case "/destinations/show":
                Integer idShow = parseId(req);
                Destination dShow = dao.findById(idShow);
                if (dShow == null) { resp.sendRedirect(req.getContextPath() + "/destinations"); return; }
                req.setAttribute("dish", dShow);
                req.getRequestDispatcher("/WEB-INF/views/destinations/detail.jsp").forward(req, resp);
                break;
            default:
                req.setAttribute("list", dao.findAll());
                req.getRequestDispatcher("/WEB-INF/views/destinations/list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String path = req.getServletPath();
        if ("/destinations/store".equals(path)) {
            Destination d = bind(req);
            Map<String, String> errors = validate(d, false);
            if (!errors.isEmpty()) {
                showForm(req, resp, d, errors, false);
                return;
            }
            dao.save(d);
            resp.sendRedirect(req.getContextPath() + "/destinations");
        } else if ("/destinations/update".equals(path)) {
            Integer id = parseId(req);
            Destination existed = dao.findById(id);
            if (existed == null) { resp.sendRedirect(req.getContextPath() + "/destinations"); return; }
            Destination d = bind(req);
            d.setId(id);
            Map<String, String> errors = validate(d, true);
            if (!errors.isEmpty()) {
                showForm(req, resp, d, errors, true);
                return;
            }
            dao.update(d);
            resp.sendRedirect(req.getContextPath() + "/destinations");
        } else if ("/destinations/delete".equals(path)) {
            Integer id = parseId(req);
            dao.delete(id);
            resp.sendRedirect(req.getContextPath() + "/destinations");
        } else {
            resp.sendRedirect(req.getContextPath() + "/destinations");
        }
    }

    private Integer parseId(HttpServletRequest req) {
        try { return Integer.parseInt(req.getParameter("id")); }
        catch (Exception e) { return null; }
    }

    private Destination bind(HttpServletRequest req) {
        Destination d = new Destination();
        d.setName(req.getParameter("name"));
        try { d.setBudget_est(Integer.parseInt(req.getParameter("budget_est"))); }
        catch (Exception e) { d.setBudget_est(null); }
        d.setIs_visited("on".equals(req.getParameter("is_visited")) || "1".equals(req.getParameter("is_visited")));
        d.setCountry(req.getParameter("country"));
        return d;
    }

    private Map<String, String> validate(Destination d, boolean isUpdate) {
        Map<String, String> errs = new HashMap<>();
        if (d.getName() == null || d.getName().trim().isEmpty()) {
            errs.put("name", "Tên không được để trống");
        }
        if (d.getBudget_est() == null) {
            errs.put("budget_est", "budget_est phải là số");
        } else if (d.getBudget_est() < 0) {
            errs.put("budget_est", "budget_est phải >= 0");
        }
        if (d.getIs_visited() == null) d.setIs_visited(false);
        return errs;
    }

    private void showForm(HttpServletRequest req, HttpServletResponse resp, Destination model, Map<String, String> errors, boolean isEdit)
            throws ServletException, IOException {
        req.setAttribute("model", model);
        req.setAttribute("errors", errors);
        req.setAttribute("isEdit", isEdit);
        req.getRequestDispatcher("/WEB-INF/views/destinations/form.jsp").forward(req, resp);
    }
}