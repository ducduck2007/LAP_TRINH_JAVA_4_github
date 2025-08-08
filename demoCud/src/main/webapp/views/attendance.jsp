<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>List Of Attendances</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f4f7f9;
            margin: 0;
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            background: #fff;
            padding: 20px;
            margin: 20px auto;
            border-radius: 10px;
            width: 400px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }

        form p {
            margin-bottom: 15px;
            color: #333;
        }

        input[type="text"],
        input[type="date"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            margin-top: 5px;
        }

        input[type="radio"] {
            margin-right: 5px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-weight: bold;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        table {
            width: 90%;
            margin: 30px auto;
            border-collapse: collapse;
            background: #fff;
            box-shadow: 0 4px 12px rgba(0,0,0,0.05);
        }

        th, td {
            padding: 12px 20px;
            border-bottom: 1px solid #ddd;
            text-align: center;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        a {
            text-decoration: none;
            color: #e74c3c;
            font-weight: bold;
        }

        a:hover {
            color: #c0392b;
        }
    </style>
</head>
<body>

<h1>List of Attendances</h1>

<form action="${formAction}" method="POST">
    <input type="hidden" name="attendanceID" value="${attendance.attendanceID}" />

    <p>
        Student Name:
        <input type="text" name="studentName" value="${attendance.studentName}" />
    </p>
    <p>
        Class Date:
        <input type="date" name="classDate" value="${attendance.classDate}" />
    </p>
    <p>Status:</p>
    <p>
        <label><input type="radio" name="status" value="Present"
                      <c:if test="${attendance.status == 'Present'}">checked</c:if>
        /> Present</label>
        <label><input type="radio" name="status" value="Absent"
                      <c:if test="${attendance.status == 'Absent'}">checked</c:if>
        /> Absent</label>
    </p>
    <p>
        <input type="submit" value="<c:choose><c:when test='${not empty attendance}'>Update</c:when><c:otherwise>Create</c:otherwise></c:choose>" />
    </p>
</form>

<table>
    <tr>
        <th>AttendanceID</th>
        <th>Student Name</th>
        <th>Class Date</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${dsAttendance}" var="data">
        <tr>
            <td>${data.attendanceID}</td>
            <td>${data.studentName}</td>
            <td><fmt:formatDate value="${data.classDate}" pattern="yyyy-MM-dd"/></td>
            <td>${data.status}</td>
            <td>
                <a href="/demoCud_war_exploded/attendance/delete?id=${data.attendanceID}">Delete</a> |
                <a href="/demoCud_war_exploded/attendance/showDetail?id=${data.attendanceID}">Xem chi tiết</a> |
                <a href="/demoCud_war_exploded/attendance/edit?id=${data.attendanceID}">Update</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
