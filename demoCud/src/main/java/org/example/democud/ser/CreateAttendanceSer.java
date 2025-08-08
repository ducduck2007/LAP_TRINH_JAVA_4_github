package org.example.democud.ser;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.democud.model.Attendance;
import org.example.democud.model.AttendanceStatus;
import org.example.democud.res.AttendanceRes;
import org.example.democud.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/attendance/create")
public class CreateAttendanceSer extends HttpServlet {
    private final AttendanceRes repository = new AttendanceRes();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentName = req.getParameter("studentName");
        Date classDate = Date.valueOf(req.getParameter("classDate"));
        String statusStr = req.getParameter("status");

        Attendance att = new Attendance();
        att.setStudentName(studentName);
        att.setClassDate(classDate);
        att.setStatus(AttendanceStatus.valueOf(statusStr));

        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.persist(att);
        tx.commit();
        session.close();

        resp.sendRedirect(req.getContextPath() + "/attendance");
    }
}

