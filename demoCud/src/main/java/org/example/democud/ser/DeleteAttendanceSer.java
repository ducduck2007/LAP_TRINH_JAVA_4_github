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

@WebServlet("/attendance/delete")
public class DeleteAttendanceSer extends HttpServlet {
    private final AttendanceRes repository = new AttendanceRes();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        Integer attendanceId = Integer.parseInt(idParam);

        boolean isDeleted = repository.deleteByID(attendanceId);
        if (isDeleted) {
            resp.sendRedirect(req.getContextPath() + "/attendance");
        } else {
            resp.getWriter().println("Attendance not found" + idParam);
        }
    }
}
