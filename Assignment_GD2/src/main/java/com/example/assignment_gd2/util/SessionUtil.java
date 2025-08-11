package com.example.assignment_gd2.util;

import com.example.assignment_gd2.model.User;
import jakarta.servlet.http.HttpServletRequest;

public class SessionUtil {
    public static final String AUTH_USER = "AUTH_USER";

    public static User currentUser(HttpServletRequest req) {
        Object o = req.getSession().getAttribute(AUTH_USER);
        return (o instanceof User) ? (User) o : null;
    }

    public static boolean isAdmin(User u) { return u != null && "ADMIN".equalsIgnoreCase(u.getRole()); }
    public static boolean isStudent(User u) { return u != null && "STUDENT".equalsIgnoreCase(u.getRole()); }
}
