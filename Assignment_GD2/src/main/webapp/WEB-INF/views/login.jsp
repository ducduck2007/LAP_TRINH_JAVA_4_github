<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty msg}">
  <script>
    alert('<c:out value="${msg}"/>');
  </script>
</c:if>
<c:set var="pageTitle" value="Dang nhap"/>
<jsp:include page="_layout_header.jsp"/>
<h2>Dang nhap</h2>
<c:if test="${not empty error}"><div style="color:red">${error}</div></c:if>
<form method="post" action="${pageContext.request.contextPath}/login" style="max-width:360px;display:grid;gap:8px">
  <input style="padding: 6px" name="email" placeholder="Email" required/>
  <input style="padding: 6px" name="password" type="password" placeholder="Mat khau" required/>
  <button style="padding: 8px; max-width: 100px">Dang nhap</button>
</form>
<p>Ban chua co tai khoan? <a href="${pageContext.request.contextPath}/register">Dang ky</a></p>
<jsp:include page="_layout_footer.jsp"/>