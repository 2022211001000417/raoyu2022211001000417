<%--
  Created by IntelliJ IDEA.
  User: 饶
  Date: 2024/4/5
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if(!(request.getAttribute("message")==null)){
       out.println("<h3>"+request.getAttribute("message")+"</h3>");
    }
%>
<form action="login" method="post">
    username<input type="text" name="username"><br>
    password<input type="password" name="password"><br>
    <button type="submit">login</button>

</form>
<%@include file="footer.jsp"%>

</body>
</html>
