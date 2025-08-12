<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Quan ly sach"/>
<jsp:include page="../_layout_header.jsp"/>
<h2>Quan ly sach</h2>
<form method="get" style="margin:12px 0; display:flex; gap:8px">
  <input style="min-width: 300px; padding: 6px" name="q" value="${param.q}" placeholder="Tim kiem theo tieu de hoac tac gia"/>
  <button style="padding: 6px">Tim kiem</button>
</form>

<form method="post" action="${pageContext.request.contextPath}/admin/book/save" style="display:flex;margin:12px 0;gap: 5px">
  <input style="max-width: 100px; padding: 6px" name="id" placeholder="ID (de trong neu them moi)" readonly/>
  <input name="title" placeholder="tieu de" required/>
  <input name="author" placeholder="tac gia" required/>
  <input name="quantity" type="number" min="0" value="0" required/>
  <button>Luu</button>
</form>

<table border="1" cellpadding="6" cellspacing="0">
  <tr><th>ID</th><th>Tieu de</th><th>Tac gia</th><th>Sl con</th><th>Xoa</th></tr>
  <c:forEach var="b" items="${books}">
    <tr>
      <td>${b.id}</td>
      <td>${b.title}</td>
      <td>${b.author}</td>
      <td>${b.quantity}</td>
      <td>
        <form method="post" action="${pageContext.request.contextPath}/admin/book/delete" onsubmit="return confirm('Xoa?')">
          <input type="hidden" name="id" value="${b.id}"/>
          <button>Xoa</button>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>
<jsp:include page="../_layout_footer.jsp"/>