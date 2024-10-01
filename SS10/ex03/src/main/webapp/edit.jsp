<%--
  Created by IntelliJ IDEA.
  User: phamlinh
  Date: 30/9/24
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EDIT</title>
</head>
<body>
    <H2>EDIT</H2>
    <form action="${pageContext.request.contextPath}/product" method="post">
        <input type="hidden" name="id" value="${product.id}"><br>
        <p>Name</p>
        <input type="text" name="name" value="${product.name}"><br>
        <p>Img</p>
        <input type="text" name="img" value="${product.img}"><br>
        <p>price</p>
        <input type="text" name="price" value="${product.price}"><br>
        <p>stock</p>
        <input type="text" name="stock" value="${product.stock}"><br>
        <input type="submit" name="action" value="edit"><br>
    </form>
</body>
</html>
