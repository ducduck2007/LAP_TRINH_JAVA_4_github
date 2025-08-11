package com.example.assignment_gd2.servlet.student;

import com.example.assignment_gd2.dao.BookDAO;
import com.example.assignment_gd2.dao.BorrowRequestDAO;
import com.example.assignment_gd2.model.Book;
import com.example.assignment_gd2.model.User;
import com.example.assignment_gd2.util.SessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/student/borrow")
public class BorrowRequestCreateServlet extends HttpServlet {
    private final BorrowRequestDAO borrowDAO = new BorrowRequestDAO();
    private final BookDAO bookDAO = new BookDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User me = SessionUtil.currentUser(req);
        Integer bookId = Integer.valueOf(req.getParameter("bookId"));
        Book b = bookDAO.findById(bookId);
        if (b == null || b.getQuantity() <= 0) {
            req.getSession().setAttribute("flash", "Sách đã hết, không thể mượn.");
            resp.sendRedirect(req.getContextPath() + "/student/books");
            return;
        }
        borrowDAO.create(me, b);
        req.getSession().setAttribute("flash", "Đã gửi yêu cầu mượn (PENDING).");
        resp.sendRedirect(req.getContextPath() + "/student/books");
    }
}
