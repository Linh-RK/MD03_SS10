<%--
  Created by IntelliJ IDEA.
  User: phamlinh
  Date: 30/9/24
  Time: 04:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h2>SIMPLE CALCULATOR</h2>
<from action ="calculator" method = "post">
  <p>First operand:</p>
  <input type="number" name="first">
  <p>Operator:</p>
  <select name="calculate" >
    <option value="add">Addition</option>
    <option value="sub">Subtraction</option>
    <option value="div">Division</option>
    <option value="mul">Multiplication</option>
  </select>
  <p>Second operand:</p>
  <input type="number" name="second"><br>
  <button type="submit">Calculate</button>
</from>
<p style="color: red;">
  ${error != null ? error : ""}
</p>

</body>
</html>
