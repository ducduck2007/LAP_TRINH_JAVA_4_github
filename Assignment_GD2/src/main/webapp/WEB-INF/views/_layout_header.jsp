<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <title><c:out value="${pageTitle}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/style.css"/>
</head>
<body>
<c:set var="me" value="${sessionScope.AUTH_USER}"/>
<header style="display:flex;gap:12px;align-items:center;justify-content:space-between;padding:10px;border-bottom:1px solid #eee">
    <div>
        <c:choose>
            <c:when test="${me != null && me.role == 'ADMIN'}">
                <a href="${pageContext.request.contextPath}/admin/borrow-requests">LibrarySystem</a>
            </c:when>
            <c:when test="${me != null && me.role == 'STUDENT'}">
                <a href="${pageContext.request.contextPath}/student/books">LibrarySystem</a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/login">LibrarySystem</a>
            </c:otherwise>
        </c:choose>
    </div>
    <nav>
        <c:choose>
            <c:when test="${me != null && me.role == 'ADMIN'}">
                <a href="${pageContext.request.contextPath}/admin/borrow-requests">Borrow Requests</a>
                <a href="${pageContext.request.contextPath}/admin/books" style="margin-left:10px">Books</a>
                <a href="${pageContext.request.contextPath}/logout" style="margin-left:10px">Logout</a>
            </c:when>
            <c:when test="${me != null && me.role == 'STUDENT'}">
                <a href="${pageContext.request.contextPath}/student/books">Books</a>
                <a href="${pageContext.request.contextPath}/student/my-requests" style="margin-left:10px">My Requests</a>
                <a href="${pageContext.request.contextPath}/logout" style="margin-left:10px">Logout</a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/login">Login</a>
            </c:otherwise>
        </c:choose>
    </nav>
</header>
<main style="padding:16px">
<c:if test="${not empty sessionScope.flash}">
    <div style="padding:8px 12px;border:1px solid #ddd;margin-bottom:12px">${sessionScope.flash}</div>
    <c:remove var="flash" scope="session"/>
</c:if>