<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Đăng ký"/>
<jsp:include page="_layout_header.jsp"/>
<h2>Đăng ký</h2>
<c:if test="${not empty error}"><div style="color:red">${error}</div></c:if>
<c:if test="${not empty msg}"><div style="color:green">${msg}</div></c:if>
<form method="post" action="${pageContext.request.contextPath}/register" style="max-width:360px;display:grid;gap:8px">
  <input name="name" placeholder="Họ tên" required/>
  <input name="email" placeholder="Email" required/>
  <input name="password" type="password" placeholder="Mật khẩu" required/>
  <button>Tạo tài khoản</button>
</form>
<jsp:include page="_layout_footer.jsp"/>