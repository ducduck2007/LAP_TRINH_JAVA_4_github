package org.example.lab6.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.lab6.model.User;

import java.io.IOException;

@WebFilter({"/admin/*", "/account/change-password", "/account/edit-profile", "/video/like/*", "/video/share/*"})
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        String uri = request.getRequestURI();

        if (user == null) {
            session.setAttribute("redirect", uri);
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        } else if (uri.contains("/admin") && !user.isAdmin()) {
            response.sendRedirect(request.getContextPath() + "/page.jsp");
        } else {
            chain.doFilter(req, res);
        }
    }
}
