<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Detail destinations</title>
</head>
<body>
<h2>Detail destinations</h2>
<p><b>ID:</b> ${dish.id}</p>
<p><b>Tên:</b> ${dish.name}</p>
<p><b>Budget Est:</b> ${dish.budget_est}</p>
<p><b>Trạng thái:</b> ${dish.is_visited ? 'Đã đến' : 'Chưa đến'}</p>
<p><b>Country:</b> ${dish.country}</p>
<p><a href="${pageContext.request.contextPath}/destinations">Back</a></p>
</body>
</html>