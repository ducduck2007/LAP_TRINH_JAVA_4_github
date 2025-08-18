<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ducdo
  Date: 8/18/2025
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>San Pham</title>
    <style>
        tr, td, th {
            border: 1px solid deeppink;
        }
    </style>
</head>
<body>
    <h2>Danh sach san pham</h2>
    <form action="/san-pham/add" method="post">
        <p>Ma san pham:</p>
        <input type="text" name="ma_san_pham" value="${sanPham.ma_san_pham}" required/>
        <p>Ten san pham:</p>
        <input type="text" name="ten_san_pham" value="${sanPham.ten_san_pham}" required/>
        <p>Mo ta:</p>
        <input type="text" name="mota_san_pham" value="${sanPham.mota_san_pham}" required/>
        <p>Website:</p>
        <input type="text" name="website_san_pham" value="${sanPham.website_san_pham}" required/>
        <p>Gia ban:</p>
        <input type="number" name="gia_ban_san_pham" value="${sanPham.gia_ban_san_pham}" required/>
        <p>So luong:</p>
        <input type="number" name="so_luong_san_pham" value="${sanPham.so_luong_san_pham}" required/>
        <p>Trang thai:</p>
        <select name="trang_thai_san_pham">
            <option value="1" ${not empty sanPham and sanPham.trang_thai_san_pham == 1 ? 'selected' : ''}>On</option>
            <option value="0" ${not empty sanPham and sanPham.trang_thai_san_pham == 0 ? 'selected' : ''}>Off</option>
        </select>
        <p>Ma loai sp:</p>
        <select name="id_loai_san_pham">
            <c:forEach items="${lst_ma_loai_sp}" var="item">
                <option value="${item.id_loai_san_pham}"
                    ${not empty sanPham and sanPham.id_loai_sp.id_loai_san_pham == item.id_loai_san_pham ? 'selected' : ''}>
                        ${item.ma_loai_san_pham}
                </option>
            </c:forEach>
        </select>
        <button type="submit">Add</button>
    </form>
    <form action="/san-pham/search" method="get">
        <input type="text" name="ten_san_pham" placeholder="Tim kiem ten san pham"/>
        <button type="submit">Tim kiem</button>
    </form>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Ma san pham</th>
            <th>Ten san pham</th>
            <th>Mo ta</th>
            <th>Website</th>
            <th>Gia ban</th>
            <th>So luong</th>
            <th>Trang thai</th>
            <th>Ma loai sp</th>
            <th>Ten loai sp</th>
            <th>Hanh dong</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${data}" var="item">
            <tr>
                <td>${item.id_san_pham}</td>
                <td>${item.ma_san_pham}</td>
                <td>${item.ten_san_pham}</td>
                <td>${item.mota_san_pham}</td>
                <td>${item.website_san_pham}</td>
                <td>${item.gia_ban_san_pham}</td>
                <td>${item.so_luong_san_pham}</td>
                <td>${item.trang_thai_san_pham}</td>
                <td>${item.id_loai_sp.ma_loai_san_pham}</td>
                <td>${item.id_loai_sp.ten_loai_san_pham}</td>
                <td>
                    <a href="/san-pham/detail?id=${item.id_san_pham}">Detail</a>
                    <a href="/san-pham/update?id=${item.id_san_pham}">Update</a>
                    <a href="/san-pham/delete?id=${item.id_san_pham}">
                        <button>Delete</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- phân trang -->
    <div>
        <c:forEach begin="1" end="${totalPage}" var="i">
            <a href="?page=${i}" ${i==currentPage ? 'style="font-weight:bold;color:red;"' : ''}>${i}</a>
        </c:forEach>
    </div>
</body>
</html>
