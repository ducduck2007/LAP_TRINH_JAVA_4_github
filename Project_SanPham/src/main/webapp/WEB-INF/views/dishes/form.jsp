<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title><c:out value="${isEdit ? 'Cập nhật' : 'Thêm mới'}"/> món ăn</title>
  <style>
    label { display:block; margin: 8px 0 4px; }
    .error { color: red; font-size: 0.9em; }
    .actions { margin-top: 12px; }
  </style>
</head>
<body>
<h2><c:out value="${isEdit ? 'Cập nhật' : 'Thêm mới'}"/> món ăn</h2>
<form action="${pageContext.request.contextPath}${isEdit ? '/dishes/update?id=' + model.id : '/dishes/store'}" method="post">
  <label>Tên *</label>
  <input type="text" name="name" value="${model.name}">
  <div class="error"><c:out value="${errors.name}"/></div>

  <label>Calories *</label>
  <input type="number" name="calories" min="0" value="${model.calories}">
  <div class="error"><c:out value="${errors.calories}"/></div>

  <label>
    <input type="checkbox" name="isVegan" <c:if test="${model.isVegan}">checked</c:if>/> Món chay
  </label>

  <label>Mô tả</label>
  <textarea name="description" rows="3">${model.description}</textarea>

  <div class="actions">
    <button type="submit">${isEdit ? 'Lưu thay đổi' : 'Thêm mới'}</button>
    <a href="${pageContext.request.contextPath}/dishes">Quay lại danh sách</a>
  </div>
</form>
</body>
</html>