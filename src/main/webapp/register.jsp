<%--
  Created by IntelliJ IDEA.
  User: 饶
  Date: 2024/3/15
  Time: 3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1><%= "This is my register JSP page" %>
</h1>
<form action="register" method="post">
    username<input type="text" name="username"><br>
    password<input type="password" name="password"><br>
    email<input type="text" name="email"><br>
    birthdate<input type="text" name="birthdate">(yyyy-yy-yy)<br>
    <input type="radio" name="gender" value="male">male
    <input type="radio" name="gender" value="female">female
    <input type="radio" name="gender" value="privary">privary<br>
    <button type="submit">submit</button>
    <p></p>
</form>
<%@include file="footer.jsp"%>
</body>
</html>
