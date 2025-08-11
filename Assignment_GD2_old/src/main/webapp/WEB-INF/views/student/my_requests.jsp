<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Yêu cầu của tôi"/>
<jsp:include page="../_layout_header.jsp"/>
<h2>Yêu cầu mượn</h2>
<table border="1" cellpadding="6" cellspacing="0">
  <tr><th>Sách</th><th>Ngày gửi</th><th>Trạng thái</th></tr>
  <c:forEach var="r" items="${requests}">
    <tr>
      <td>${r.book.title}</td>
      <td>${r.requestDate}</td>
      <td>${r.status}</td>
    </tr>
  </c:forEach>
</table>
<jsp:include page="../_layout_footer.jsp"/>