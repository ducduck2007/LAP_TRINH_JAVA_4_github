package org.example.democud.ser;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.democud.model.Attendance;
import org.example.democud.res.AttendanceRes;

import java.io.IOException;
import java.util.List;

@WebServlet("/attendance")
public class AttendanceSer extends HttpServlet {
    private final AttendanceRes repository = new AttendanceRes();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Attendance> books = repository.getAll();
        req.setAttribute("dsAttendance", books);
        req.setAttribute("formAction", req.getContextPath() + "/attendance/create");
        req.getRequestDispatcher("/views/attendance.jsp").forward(req, resp);
    }
}
