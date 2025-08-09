<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Chi tiết món ăn</title>
</head>
<body>
<h2>Chi tiết món ăn</h2>
<p><b>ID:</b> ${dish.id}</p>
<p><b>Tên:</b> ${dish.name}</p>
<p><b>Calories:</b> ${dish.calories}</p>
<p><b>Trạng thái:</b> ${dish.isVegan ? 'Chay' : 'Mặn'}</p>
<p><b>Mô tả:</b> ${dish.description}</p>
<p><a href="${pageContext.request.contextPath}/dishes">Quay lại danh sách</a></p>
</body>
</html>