<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ducdo
  Date: 8/18/2025
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cap nhat san pham</title>
</head>
<body>
<form action="/san-pham/update" method="post">
  <input type="hidden" name="id_san_pham" value="${sanPham.id_san_pham}"/>
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
    <option value="1" ${sanPham.trang_thai_san_pham == 1 ? "selected" : ""}>On</option>
    <option value="0" ${sanPham.trang_thai_san_pham == 0 ? "selected" : ""}>Off</option>
  </select>
  <p>Ma loai sp:</p>
  <select name="id_loai_san_pham">
    <c:forEach items="${lst_ma_loai_sp}" var="item">
      <option value="${item.id_loai_san_pham}"
        ${sanPham.id_loai_sp.id_loai_san_pham == item.id_loai_san_pham ? "selected" : ""}>
          ${item.ma_loai_san_pham}
      </option>
    </c:forEach>
  </select>
  <button type="submit">Update</button>
</form>
</body>
</html>
