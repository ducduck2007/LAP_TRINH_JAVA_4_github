package org.example.democud.ser;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.democud.model.Attendance;
import org.example.democud.model.AttendanceStatus;
import org.example.democud.res.AttendanceRes;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/attendance/update")
public class UpdateAttendanceSer extends HttpServlet {
    private final AttendanceRes repository = new AttendanceRes();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("attendanceID"));
        String studentName = req.getParameter("studentName");
        Date classDate = Date.valueOf(req.getParameter("classDate"));
        String statusStr = req.getParameter("status");

        Attendance att = new Attendance();
        att.setAttendanceID(id);
        att.setStudentName(studentName);
        att.setClassDate(classDate);
        att.setStatus(AttendanceStatus.valueOf(statusStr));

        repository.update(att);
        resp.sendRedirect(req.getContextPath() + "/attendance");
    }
}

