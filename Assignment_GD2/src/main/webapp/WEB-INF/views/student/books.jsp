<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Danh sach sach"/>
<jsp:include page="../_layout_header.jsp"/>
<h2>Danh sach sach</h2>
<form method="get" style="margin:12px 0; display:flex; gap:8px">
  <input name="q" value="${q}" placeholder="Tim kiem theo tieu de hoac tac gia" style="flex:1; padding: 6px"/>
  <button style="padding: 6px">Tim kiem</button>
</form>
<table border="1" cellpadding="6" cellspacing="0">
  <tr><th>Tieu de</th><th>Tac gia</th><th>Sl con</th><th>Thao tac</th></tr>
  <c:forEach var="b" items="${books}">
    <tr>
      <td>${b.title}</td>
      <td>${b.author}</td>
      <td style="text-align:center">${b.quantity}</td>
      <td>
        <c:choose>
          <c:when test="${b.quantity > 0}">
            <form method="post" action="${pageContext.request.contextPath}/student/borrow">
              <input type="hidden" name="bookId" value="${b.id}"/>
              <button>Muon</button>
            </form>
          </c:when>
          <c:otherwise>
            <span>Het</span>
          </c:otherwise>
        </c:choose>
      </td>
    </tr>
  </c:forEach>
</table>
<jsp:include page="../_layout_footer.jsp"/>