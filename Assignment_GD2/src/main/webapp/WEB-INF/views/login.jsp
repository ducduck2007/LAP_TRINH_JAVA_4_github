<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Đăng nhập"/>
<jsp:include page="_layout_header.jsp"/>
<h2>Đăng nhập</h2>
<c:if test="${not empty error}"><div style="color:red">${error}</div></c:if>
<form method="post" action="${pageContext.request.contextPath}/login" style="max-width:360px;display:grid;gap:8px">
  <input name="email" placeholder="Email" required/>
  <input name="password" type="password" placeholder="Mật khẩu" required/>
  <button>Đăng nhập</button>
</form>
<p>Chưa có tài khoản? <a href="${pageContext.request.contextPath}/register">Đăng ký</a></p>
<jsp:include page="_layout_footer.jsp"/>