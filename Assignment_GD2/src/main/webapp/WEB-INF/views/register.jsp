<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Dang ky"/>
<jsp:include page="_layout_header.jsp"/>
<h2>Dang ky</h2>
<c:if test="${not empty error}"><div style="color:red">${error}</div></c:if>
<c:if test="${not empty msg}"><div style="color:green">${msg}</div></c:if>
<form method="post" action="${pageContext.request.contextPath}/register" style="max-width:360px;display:grid;gap:8px">
  <input style="padding: 6px" name="name" placeholder="Name" required/>
  <input style="padding: 6px" name="email" placeholder="Email" required/>
  <input style="padding: 6px" name="password" type="password" placeholder="Mat khau" required/>
  <button style="padding: 8px; max-width: 100px">Tao tai khoan</button>
</form>
<jsp:include page="_layout_footer.jsp"/>