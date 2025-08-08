<%@ page import="org.example.lab6.model.User" %>
<%
    User u = (User) session.getAttribute("user");
%>
<h1>Hello, <%= u != null ? u.getUsername() : "Guest" %>!</h1>
<% if (u != null) { %>
<p><a href="<%= request.getContextPath() %>/account/edit-profile">Edit Profile</a></p>
<p><a href="<%= request.getContextPath() %>/account/change-password">Change Password</a></p>
<% if (u.isAdmin()) { %>
<p><a href="<%= request.getContextPath() %>/admin/user">Admin Page</a></p>
<% } %>
<% } %>
