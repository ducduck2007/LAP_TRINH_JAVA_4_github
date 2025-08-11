<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Quản lý sách"/>
<jsp:include page="../_layout_header.jsp"/>
<h2>Quản lý sách</h2>
<form method="get" style="margin:12px 0; display:flex; gap:8px">
  <input name="q" value="${param.q}" placeholder="Tìm theo tiêu đề/tác giả"/>
  <button>Tìm</button>
</form>

<form method="post" action="${pageContext.request.contextPath}/admin/book/save" style="display:grid;grid-template-columns:1fr 1fr 120px 120px;gap:8px;align-items:end;margin:12px 0">
  <input name="id" placeholder="ID (để trống nếu thêm mới)"/>
  <input name="title" placeholder="Title" required/>
  <input name="author" placeholder="Author" required/>
  <input name="quantity" type="number" min="0" value="0" required/>
  <button>Lưu</button>
</form>

<table border="1" cellpadding="6" cellspacing="0">
  <tr><th>ID</th><th>Tiêu đề</th><th>Tác giả</th><th>Còn</th><th>Xóa</th></tr>
  <c:forEach var="b" items="${books}">
    <tr>
      <td>${b.id}</td>
      <td>${b.title}</td>
      <td>${b.author}</td>
      <td>${b.quantity}</td>
      <td>
        <form method="post" action="${pageContext.request.contextPath}/admin/book/delete" onsubmit="return confirm('Xóa?')">
          <input type="hidden" name="id" value="${b.id}"/>
          <button>Xóa</button>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>
<jsp:include page="../_layout_footer.jsp"/>