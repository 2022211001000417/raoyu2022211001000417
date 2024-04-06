<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1><%= "This is my home page !" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet week1</a><br>
<a href="week2">student info servlet week2</a><br>
<a href="form">lifeCycle Servlet week3 </a><br>
<a href="config">config week4</a><br>
<a href="jdbc">jdbc week4</a><br>
<a href="register.jsp">register week4</a><br>
<a href="Myjsp.jsp">include week5</a><br>
<a href="login.jsp">loginservlet week5</a><br>

<%@include file="footer.jsp"%>
</body>
</html>