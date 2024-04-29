<%@ page import="com.raoyu.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 饶
  Date: 2024/4/10
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<link href="styles.css?version=1.0.0" rel="stylesheet" type="text/css">
<script src="script.js?version=1.0.0" type="text/javascript"></script>
<img src="image.jpg?version=1.0.0" alt="Image">

<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
    User us= (User) session.getAttribute("user");
%>
<table>
    <tr><td>Username:</td><td><%=us.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=us.getPassword()%></td></tr>
    <tr><td>Email:</td><td><%=us.getEmail()%></td></tr>
    <tr><td>Gender:</td><td><%=us.getGender()%></td></tr>
    <tr><td>Birthdate:</td><td><%=us.getBirthdate()%></td></tr>
    <tr><td><a href="updateUser">Update user</a></td></tr>
</table>
<%@include file="footer.jsp"%>
</body>
</html>
