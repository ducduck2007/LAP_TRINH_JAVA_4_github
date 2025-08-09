<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title><c:out value="${isEdit ? 'Update' : 'Create'}"/> destinations</title>
  <style>
    label { display:block; margin: 8px 0 4px; }
    .error { color: red; font-size: 0.9em; }
    .actions { margin-top: 12px; }
  </style>
</head>
<body>
<h2><c:out value="${isEdit ? 'Update' : 'Create'}"/> destinations</h2>
<form action="${pageContext.request.contextPath}${isEdit ? '/destinations/update?id=' + model.id : '/destinations/store'}" method="post">
  <label>Name</label>
  <input type="text" name="name" value="${model.name}">
  <div class="error"><c:out value="${errors.name}"/></div>

  <label>Budget Est</label>
  <input type="number" name="budget_est" min="0" value="${model.budget_est}">
  <div class="error"><c:out value="${errors.budget_est}"/></div>

  <label>
    <input type="checkbox" name="is_visited" <c:if test="${model.is_visited}">checked</c:if>/> Đã đến
  </label>

  <label>Country</label>
  <textarea name="country" rows="3">${model.country}</textarea>

  <div class="actions">
    <button type="submit">${isEdit ? 'Save' : 'Create'}</button>
    <a href="${pageContext.request.contextPath}/destinations">Back</a>
  </div>
</form>
</body>
</html>