package com.example.assignment_gd2.servlet.student;

import com.example.assignment_gd2.dao.BorrowRequestDAO;
import com.example.assignment_gd2.model.User;
import com.example.assignment_gd2.util.SessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/student/my-requests")
public class MyRequestsServlet extends HttpServlet {
    private final BorrowRequestDAO borrowDAO = new BorrowRequestDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User me = SessionUtil.currentUser(req);
        req.setAttribute("requests", borrowDAO.findByUser(me.getId()));
        req.getRequestDispatcher("/WEB-INF/views/student/my_requests.jsp").forward(req, resp);
    }
}
