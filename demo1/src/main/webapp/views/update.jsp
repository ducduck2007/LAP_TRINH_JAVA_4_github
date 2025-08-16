<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update sản phẩm</title>
</head>
<body>
<h3>Cập nhật sản phẩm</h3>

<form action="/san-pham/update" method="post">
    <input type="hidden" name="id" value="${spDetail.id}" />

    <div>
        <label>Mã</label>
        <input type="text" name="ma" value="${spDetail.ma}"/>
    </div>
    <div>
        <label>Loại sản phẩm</label>
        <select name="idLoaiSp">
            <c:forEach items="${loaiSpList}" var="loai">
                <option value="${loai.id}" ${spDetail.idLoaiSp.id == loai.id ? "selected" : ""}>
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

    <button type="submit">Update</button>
</form>

</body>
</html>
