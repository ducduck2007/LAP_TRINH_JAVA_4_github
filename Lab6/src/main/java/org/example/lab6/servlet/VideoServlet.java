package org.example.lab6.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet({"/video/list", "/video/detail/*", "/video/like/*", "/video/share/*"})
public class VideoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write("Video servlet route: " + req.getRequestURI());
    }
}
