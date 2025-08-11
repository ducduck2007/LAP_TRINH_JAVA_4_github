package com.example.assignment_gd2.servlet.admin;

import com.example.assignment_gd2.dao.BookDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/book/delete")
public class AdminBookDeleteServlet extends HttpServlet {
    private final BookDAO bookDAO = new BookDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        bookDAO.delete(id);
        resp.sendRedirect(req.getContextPath() + "/admin/books");
    }
}
