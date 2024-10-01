<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phamlinh
  Date: 30/9/24
  Time: 05:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/product?action=add" class="btn btn-primary">ADD PRODUCT</a>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>NAME</th>
        <th>IMAGE</th>
        <th>PRICE</th>
        <th>STOCK</th>
        <th>ACTION</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${productList}" var="product">
        <tr>
            <th>${product.id}</th>
            <th>${product.name}</th>
            <th>${product.img}</th>
            <th>${product.price}</th>
            <th>${product.stock}</th>
            <th><a href="<%=request.getContextPath()%>/product?action=edit&id=${product.id}">Edit</a></th>
            <th><a href="<%=request.getContextPath()%>/product?action=delete&id=${product.id}">Delete</a></th>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
