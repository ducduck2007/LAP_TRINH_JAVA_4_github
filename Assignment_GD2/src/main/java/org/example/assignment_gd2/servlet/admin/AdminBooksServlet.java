package com.example.assignment_gd2.servlet.admin;

import com.example.assignment_gd2.dao.BookDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/books")
public class AdminBooksServlet extends HttpServlet {
    private final BookDAO bookDAO = new BookDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("books", bookDAO.findAll(req.getParameter("q")));
        req.getRequestDispatcher("/WEB-INF/views/admin/books.jsp").forward(req, resp);
    }
}
