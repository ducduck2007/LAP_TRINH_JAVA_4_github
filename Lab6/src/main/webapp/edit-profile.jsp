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
<head><title>Edit Profile</title></head>
<body>
<h2>Edit Profile</h2>
<form action="${pageContext.request.contextPath}/account/edit-profile" method="post">
  Username: <input type="text" name="username" value="<%= user.getUsername() %>" required/><br/><br/>
  Email: <input type="email" name="email" value="<%= user.getEmail() %>" required/><br/><br/>
  <button type="submit">Update Profile</button>
</form>
<p><a href="${pageContext.request.contextPath}/page.jsp">Back</a></p>
</body>
</html>
