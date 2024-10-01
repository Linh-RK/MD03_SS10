<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phamlinh
  Date: 30/9/24
  Time: 04:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>USER</title>
</head>
<body>
<h2>Danh sách khách hàng</h2>
<table border="1px" width="500px">
  <thead>
  <tr>
    <th>Tên</th>
    <th>Ngày sinh</th>
    <th>Địa chỉ</th>
    <th>Ảnh</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${users}" var = "user">
    <tr>
      <td>${user.name}</td>
      <td>${user.birthday}</td>
      <td>${user.address}</td>
      <td><img src="" alt="img"></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
