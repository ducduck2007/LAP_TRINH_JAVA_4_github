<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Admin Login"/>
<jsp:include page="../_layout_header.jsp"/>
<h2>Admin Login</h2>
<c:if test="${not empty error}"><div style="color:red">${error}</div></c:if>
<form method="post" action="${pageContext.request.contextPath}/admin/login" style="max-width:360px;display:grid;gap:8px">
  <input name="email" placeholder="Email" required/>
  <input name="password" type="password" placeholder="Mật khẩu" required/>
  <button>Đăng nhập</button>
</form>
<jsp:include page="../_layout_footer.jsp"/>