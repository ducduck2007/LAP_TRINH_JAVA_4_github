package com.example.assignment_gd2.servlet.admin;

import com.example.assignment_gd2.dao.BorrowRequestDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/borrow-requests")
public class AdminBorrowRequestsServlet extends HttpServlet {
    private final BorrowRequestDAO borrowDAO = new BorrowRequestDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("requests", borrowDAO.findAll());
        req.getRequestDispatcher("/WEB-INF/views/admin/borrow_requests.jsp").forward(req, resp);
    }
}
