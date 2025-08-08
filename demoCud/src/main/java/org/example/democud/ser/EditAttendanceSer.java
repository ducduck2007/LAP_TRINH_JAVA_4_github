package org.example.democud.ser;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.democud.model.Attendance;
import org.example.democud.res.AttendanceRes;

import java.io.IOException;

@WebServlet("/attendance/edit")
public class EditAttendanceSer extends HttpServlet {
    private final AttendanceRes repository = new AttendanceRes();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        Attendance attendance = repository.findById(id);

        req.setAttribute("attendance", attendance);
        req.setAttribute("formAction", req.getContextPath() + "/attendance/update");
        req.setAttribute("dsAttendance", repository.getAll()); // Để hiển thị table
        req.getRequestDispatcher("/views/attendance.jsp").forward(req, resp);
    }
}

