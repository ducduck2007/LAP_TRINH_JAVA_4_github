package com.example.assignment_gd2.servlet.admin;

import com.example.assignment_gd2.dao.BookDAO;
import com.example.assignment_gd2.dao.BorrowRequestDAO;
import com.example.assignment_gd2.model.Book;
import com.example.assignment_gd2.model.BorrowRequest;
import com.example.assignment_gd2.util.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/borrow-action")
public class AdminBorrowActionServlet extends HttpServlet {
    private final BorrowRequestDAO borrowDAO = new BorrowRequestDAO();
    private final BookDAO bookDAO = new BookDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String action = req.getParameter("action"); // APPROVE | REJECT

        if ("APPROVE".equalsIgnoreCase(action)) {
            // xử lý trong 1 transaction: check quantity -> -1 -> set APPROVED
            Transaction tx = null;
            try (Session s = HibernateUtil.getSession()) {
                tx = s.beginTransaction();
                var br = s.get(BorrowRequest.class, id);
                if (br != null && "PENDING".equalsIgnoreCase(br.getStatus())) {
                    Book b = s.get(Book.class, br.getBook().getId());
                    if (b.getQuantity() != null && b.getQuantity() > 0) {
                        b.setQuantity(b.getQuantity() - 1);
                        br.setStatus("APPROVED");
                        s.merge(b);
                        s.merge(br);
                    } else {
                        req.getSession().setAttribute("flash", "Sách đã hết, không thể duyệt.");
                        tx.rollback();
                        resp.sendRedirect(req.getContextPath() + "/admin/borrow-requests");
                        return;
                    }
                }
                tx.commit();
            } catch (Exception e) { if (tx != null) tx.rollback(); throw new RuntimeException(e); }
        } else if ("REJECT".equalsIgnoreCase(action)) {
            borrowDAO.updateStatus(id, "REJECTED");
        }
        resp.sendRedirect(req.getContextPath() + "/admin/borrow-requests");
    }
}