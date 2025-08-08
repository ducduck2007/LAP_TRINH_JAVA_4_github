<%@ page import="org.example.lab6.model.User" %>
<%
  User user = (User) session.getAttribute("user");
  if (user == null) {
    response.sendRedirect(request.getContextPath() + "/login.jsp");
    return;
  }
%>
<!DOCTYPE html>
<html>
<head><title>Change Password</title></head>
<body>
<h2>Change password for <%= user.getUsername() %></h2>
<form action="${pageContext.request.contextPath}/account/change-password" method="post">
  Current password: <input type="password" name="currentPassword" required/><br/><br/>
  New password: <input type="password" name="newPassword" required/><br/><br/>
  Confirm new password: <input type="password" name="confirmPassword" required/><br/><br/>
  <button type="submit">Change Password</button>
</form>
<p><a href="${pageContext.request.contextPath}/page.jsp">← Back</a></p>
</body>
</html>
