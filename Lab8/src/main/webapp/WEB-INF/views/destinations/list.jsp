<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List destinations</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; }
        th { background: #f4f4f4; text-align: left; }
        a.btn { padding: 4px 8px; border: 1px solid #888; margin-right: 4px; text-decoration: none; }
    </style>
</head>
<body>
<h2>All (Destinations)</h2>
<p><a class="btn" href="${pageContext.request.contextPath}/destinations/create">+ Create</a></p>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Budget Est</th>
        <th>Trạng thái</th>
        <th>Country</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="d" items="${list}">
        <tr>
            <td>${d.id}</td>
            <td>${d.name}</td>
            <td>${d.budget_est}</td>
            <td><c:out value="${d.is_visited ? 'Đã đến' : 'Chưa đến'}"/></td>
            <td>${d.country}</td>
            <td>
                <a class="btn" href="${pageContext.request.contextPath}/destinations/show?id=${d.id}">View</a>
                <a class="btn" href="${pageContext.request.contextPath}/destinations/edit?id=${d.id}">Update</a>
                <form action="${pageContext.request.contextPath}/destinations/delete" method="post" style="display:inline" onsubmit="return confirm('Delete now?');">
                    <input type="hidden" name="id" value="${d.id}"/>
                    <button type="submit" class="btn">Del</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>