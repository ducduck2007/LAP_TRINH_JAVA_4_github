<!DOCTYPE html>
<html>
<head><title>Login</title></head>
<body>
<h2>Login</h2>
<form action="${pageContext.request.contextPath}/account/sign-in" method="post">
  Username: <input name="username" required/> <br/>
  Password: <input type="password" name="password" required/> <br/>
  <button type="submit">Login</button>
</form>
</body>
</html>
