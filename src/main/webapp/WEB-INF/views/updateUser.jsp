<%--
  Created by IntelliJ IDEA.
  User: 饶
  Date: 2024/4/25
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1><%="User Update"%>
</h1>
<%
//获取session中的user
    User u=(User) session.getAttribute("user");
%>
<form action="updateUser" method="post">
    <input type="hidden" name="id" value="<%=u.getId()%>">
    username<input type="text" name="username" value="<%=u.getUsername()%>"><br>
    password<input type="password" name="password" value="<%=u.getPassword()%>"><br>
    email<input type="text" name="email" value="<%=u.getEmail()%>"><br>
    birthdate<input type="text" name="birthdate" value="<%=u.getBirthdate()%>">(yyyy-yy-yy)<br>
    <input type="radio" name="gender" value="male" <%="male".equals(u.getGender())?"checked":""%>>male
    <input type="radio" name="gender" value="female" <%="female".equals(u.getGender())?"checked":""%>>female
    <input type="radio" name="gender" value="privacy" <%="privacy".equals(u.getGender())?"checked":""%>>privacy<br>
    <button type="submit" >Save Changes</button>
    <p></p>
</form>
<%@include file="footer.jsp"%>
</body>
</html>
