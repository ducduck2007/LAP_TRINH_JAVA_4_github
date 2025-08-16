<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    th, td { border: 1px solid #ccc; }
</style>
<html>
<head>
    <title>List San Pham</title>
</head>
<body>
<a href="/san-pham/hien-thi">
    <h3>Quan ly san pham</h3>
</a>

<form action="/search" method="get">
    <input type="text" name="ten" placeholder="Nhap ten san pham"/>
    <button type="submit">Tim kiem</button>
</form>
<br/>
<form action="/san-pham/add" method="post">
    <div>
        <label>Mã</label>
        <input type="text" name="ma" value="${spDetail.ma}"/>
    </div>
    <div>
        <label>Loại sản phẩm</label>
        <select name="idLoaiSp">
            <c:forEach items="${loaiSpList}" var="loai">
                <option value="${loai.id}"
                    ${not empty spDetail and spDetail.idLoaiSp.id == loai.id ? 'selected' : ''}>
                        ${loai.maLoaiSanPham}
                </option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label>Tên</label>
        <input type="text" name="ten" value="${spDetail.ten}"/>
    </div>
    <div>
        <label>Mô tả</label>
        <input type="text" name="mota" value="${spDetail.mota}"/>
    </div>

    <button type="submit">Add</button>
</form>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Ma</th>
        <th>Ten</th>
        <th>Mo ta</th>
        <th>Ma loai sp</th>
        <th>Ten loai sp</th>
        <th>Hanh dong</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sanPhams}" var="sp">
        <tr>
            <td>${sp.id}</td>
            <td>${sp.ma}</td>
            <td>${sp.ten}</td>
            <td>${sp.mota}</td>
            <td>${sp.idLoaiSp.maLoaiSanPham}</td>
            <td>${sp.idLoaiSp.tenLoaiSanPham}</td>
            <td>
                <a href="/san-pham/detail?id=${sp.id}">Detail</a>
                &nbsp;|&nbsp;
                <a href="/san-pham/update?id=${sp.id}">Update</a>
                &nbsp;|&nbsp;
                <a href="/san-pham/del?id=${sp.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
