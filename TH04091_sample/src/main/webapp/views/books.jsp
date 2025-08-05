<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>List Of Books</title>
</head>
<body>
<h1>List of Books</h1>
<table border="1">
    <tr>
        <th>BookID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Category</th>
        <th>Publisher</th>
        <th>QuantityInStock</th>
        <th>Price</th>
        <th>Summary</th>
        <th>PublishedDate</th>
        <th>ReturnDueDate</th>
        <th>CreatedAt</th>
        <th>ISBN</th>
    </tr>
    <c:forEach items="${dsBook}" var="bk">
        <tr>
            <td>${bk.bookID}</td>
            <td>${bk.title}</td>
            <td>${bk.author}</td>
            <td>${bk.category}</td>
            <td>${bk.publisher}</td>
            <td>${bk.quantityInStock}</td>
            <td>${bk.price}</td>
            <td>${bk.summary}</td>
            <td>${bk.publishedDate}</td>
            <td>${bk.returnDueDate}</td>
            <td>${bk.createdAt}</td>
            <td>${bk.isbn}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

