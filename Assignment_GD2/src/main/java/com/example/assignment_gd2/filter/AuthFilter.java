package com.example.assignment_gd2.filter;

import com.example.assignment_gd2.model.User;
import com.example.assignment_gd2.util.SessionUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        String ctx = req.getContextPath();
        User u = SessionUtil.currentUser(req);

        boolean isAuthPage = uri.startsWith(ctx + "/login") || uri.startsWith(ctx + "/register") || uri.startsWith(ctx + "/admin/login");
        boolean isStatic = uri.startsWith(ctx + "/assets/") || uri.contains(".css") || uri.contains(".js") || uri.contains(".png") || uri.contains(".jpg");

        if (isAuthPage || isStatic) { chain.doFilter(request, response); return; }

        if (u == null) { resp.sendRedirect(ctx + "/login"); return; }

        // role-based URL guard
        if (uri.startsWith(ctx + "/admin/") && !SessionUtil.isAdmin(u)) { resp.sendError(403); return; }
        if (uri.startsWith(ctx + "/student/") && !SessionUtil.isStudent(u)) { resp.sendError(403); return; }

        chain.doFilter(request, response);
    }
}
