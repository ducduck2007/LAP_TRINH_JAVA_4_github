<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
  <title>Attendance Detail</title>
</head>
<body>
<h1>Attendance Detail</h1>
<p><strong>ID:</strong> ${attendance.attendanceID}</p>
<p><strong>Student Name:</strong> ${attendance.studentName}</p>
<p><strong>Class Date:</strong> <fmt:formatDate value="${attendance.classDate}" pattern="yyyy-MM-dd"/></p>
<p><strong>Status:</strong> ${attendance.status}</p>

<a href="/attendance">Back to List</a>
</body>
</html>
