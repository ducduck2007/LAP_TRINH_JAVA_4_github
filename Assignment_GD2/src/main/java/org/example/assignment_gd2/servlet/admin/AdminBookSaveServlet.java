package com.example.assignment_gd2.servlet.admin;

import com.example.assignment_gd2.dao.BookDAO;
import com.example.assignment_gd2.model.Book;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/book/save")
public class AdminBookSaveServlet extends HttpServlet {
    private final BookDAO bookDAO = new BookDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idStr = req.getParameter("id");
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        Integer quantity = Integer.valueOf(req.getParameter("quantity"));

        Book b = new Book();
        if (idStr != null && !idStr.isBlank()) b.setId(Integer.valueOf(idStr));
        b.setTitle(title);
        b.setAuthor(author);
        b.setQuantity(quantity);
        bookDAO.saveOrUpdate(b);
        resp.sendRedirect(req.getContextPath() + "/admin/books");
    }
}
