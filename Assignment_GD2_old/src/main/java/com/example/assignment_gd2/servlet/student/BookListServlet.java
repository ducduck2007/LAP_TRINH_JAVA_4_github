package com.example.assignment_gd2.servlet.student;

import com.example.assignment_gd2.dao.BookDAO;
import com.example.assignment_gd2.model.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/student/books")
public class BookListServlet extends HttpServlet {
    private final BookDAO bookDAO = new BookDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String q = req.getParameter("q");
        List<Book> books = bookDAO.findAll(q);
        req.setAttribute("books", books);
        req.setAttribute("q", q == null ? "" : q);
        req.getRequestDispatcher("/WEB-INF/views/student/books.jsp").forward(req, resp);
    }
}
