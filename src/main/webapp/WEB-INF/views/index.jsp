<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1>Read all cookie</h1>
<%
    Cookie[] allCookies=request.getCookies();//give all cookies
    if(allCookies!=null){
        for(Cookie c:allCookies){
            //get one by one
            String cName=c.getName();
            String cValue=c.getValue();
            out.println("<br>"+cName+" ---- "+cValue);
        }}%>
<h2><%="Welcome to my online shop home page"%></h2>
<form method="get" target="_blank" action="search">
    <input type="text" name="txt" size="30">
    <select name="search">
        <option value="baidu">Baidu</option>
        <option value="Bing">Bing</option>
        <option value="google">Google</option>
    </select>
    <input type="submit" value="Search">
</form>

<!--<h1><%= "This is my home page !" %></h1><br/>
<a href="hello-servlet">Hello Servlet week1</a><br>
<a href="week2">student info servlet week2</a><br>
<a href="form">lifeCycle Servlet week3 </a><br>
<a href="config">config week4</a><br>
<a href="jdbc">jdbc week4</a><br>
<a href="register.jsp">register week4</a><br>
<a href="Myjsp.jsp">include week5</a><br>
<a href="login.jsp">loginservlet week5</a><br>-->

<%@include file="footer.jsp"%>
</body>
</html>