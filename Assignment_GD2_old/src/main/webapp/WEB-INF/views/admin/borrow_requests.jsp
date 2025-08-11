<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Duyệt yêu cầu"/>
<jsp:include page="../_layout_header.jsp"/>
<h2>Yêu cầu mượn</h2>
<table border="1" cellpadding="6" cellspacing="0">
  <tr><th>Sinh viên</th><th>Sách</th><th>Ngày</th><th>Trạng thái</th><th>Hành động</th></tr>
  <c:forEach var="r" items="${requests}">
    <tr>
      <td>${r.user.name} (${r.user.email})</td>
      <td>${r.book.title}</td>
      <td>${r.requestDate}</td>
      <td>${r.status}</td>
      <td>
        <c:if test="${r.status == 'PENDING'}">
          <form method="post" action="${pageContext.request.contextPath}/admin/borrow-action" style="display:inline">
            <input type="hidden" name="id" value="${r.id}"/>
            <input type="hidden" name="action" value="APPROVE"/>
            <button>Duyệt</button>
          </form>
          <form method="post" action="${pageContext.request.contextPath}/admin/borrow-action" style="display:inline">
            <input type="hidden" name="id" value="${r.id}"/>
            <input type="hidden" name="action" value="REJECT"/>
            <button>Từ chối</button>
          </form>
        </c:if>
      </td>
    </tr>
  </c:forEach>
</table>
<jsp:include page="../_layout_footer.jsp"/>