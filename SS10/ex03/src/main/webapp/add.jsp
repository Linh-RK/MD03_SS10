<%--
  Created by IntelliJ IDEA.
  User: phamlinh
  Date: 30/9/24
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD NEW PRODUCT</title>
</head>
<body>
<h2>ADD NEW PRODUCT</h2>
<form action="<%=request.getContextPath()%>/product" method="post">
  <input type="hidden" name="id" ><br>
  <p>Name</p>
  <input type="text" name="name" ><br>
  <p>Img</p>
  <input type="text" name="img" ><br>
  <p>price</p>
  <input type="text" name="price" ><br>
  <p>stock</p>
  <input type="text" name="stock" ><br>
  <input type="submit" name="action" value="add"><br>
</form>
</body>
</html>
