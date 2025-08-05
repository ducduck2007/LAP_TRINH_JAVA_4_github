package org.example.th04091.ser;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.th04091.model.Books;
import org.example.th04091.res.BookRes;

import java.io.IOException;
import java.util.List;

@WebServlet("/books/novels")
public class BookCategorySer extends HttpServlet {
    private final BookRes repository = new BookRes();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Books> books = repository.getAllCategory();

        req.setAttribute("dsBook", books);
        req.getRequestDispatcher("/views/books.jsp").forward(req, resp);
    }
}
