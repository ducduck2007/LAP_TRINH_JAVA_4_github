<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Danh sách sách"/>
<jsp:include page="../_layout_header.jsp"/>
<h2>Danh sách sách</h2>
<form method="get" style="margin:12px 0; display:flex; gap:8px">
  <input name="q" value="${q}" placeholder="Tìm theo tiêu đề hoặc tác giả" style="flex:1"/>
  <button>Tìm kiếm</button>
</form>
<table border="1" cellpadding="6" cellspacing="0">
  <tr><th>Tiêu đề</th><th>Tác giả</th><th>Còn</th><th>Thao tác</th></tr>
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
              <button>Mượn</button>
            </form>
          </c:when>
          <c:otherwise>
            <span>Hết</span>
          </c:otherwise>
        </c:choose>
      </td>
    </tr>
  </c:forEach>
</table>
<jsp:include page="../_layout_footer.jsp"/>