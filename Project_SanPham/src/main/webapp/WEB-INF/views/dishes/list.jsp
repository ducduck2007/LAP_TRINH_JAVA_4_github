<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách món ăn</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; }
        th { background: #f4f4f4; text-align: left; }
        a.btn { padding: 4px 8px; border: 1px solid #888; margin-right: 4px; text-decoration: none; }
    </style>
</head>
<body>
<h2>Tất cả sản phẩm (Dishes)</h2>
<p><a class="btn" href="${pageContext.request.contextPath}/dishes/create">+ Thêm món</a></p>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Calories</th>
        <th>Trạng thái</th>
        <th>Mô tả</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="d" items="${list}">
        <tr>
            <td>${d.id}</td>
            <td>${d.name}</td>
            <td>${d.calories}</td>
            <td><c:out value="${d.isVegan ? 'Chay' : 'Mặn'}"/></td>
            <td>${d.description}</td>
            <td>
                <a class="btn" href="${pageContext.request.contextPath}/dishes/show?id=${d.id}">Xem</a>
                <a class="btn" href="${pageContext.request.contextPath}/dishes/edit?id=${d.id}">Sửa</a>
                <form action="${pageContext.request.contextPath}/dishes/delete" method="post" style="display:inline" onsubmit="return confirm('Xóa món này?');">
                    <input type="hidden" name="id" value="${d.id}"/>
                    <button type="submit" class="btn">Xóa</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>