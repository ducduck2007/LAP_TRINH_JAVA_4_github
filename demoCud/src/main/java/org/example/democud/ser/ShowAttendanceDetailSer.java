package org.example.democud.ser;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.democud.model.Attendance;
import org.example.democud.res.AttendanceRes;

import java.io.IOException;

@WebServlet("/attendance/showDetail")
public class ShowAttendanceDetailSer extends HttpServlet {
    private final AttendanceRes repository = new AttendanceRes();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing attendance ID");
            return;
        }

        try {
            int id = Integer.parseInt(idParam);
            Attendance att = repository.findById(id);

            if (att == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Attendance not found");
                return;
            }

            req.setAttribute("attendance", att);
            req.getRequestDispatcher("/views/showAttendanceDetail.jsp").forward(req, resp);

        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
        }
    }
}
