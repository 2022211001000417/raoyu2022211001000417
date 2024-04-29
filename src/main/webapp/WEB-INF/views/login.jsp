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
<%
    Cookie[] allCookies=request.getCookies();//give all cookies
    String username="",password="",remembermevalue="";
    if(allCookies!=null){//逐个获取cookie
        for(Cookie c:allCookies){
            //get one by one
            //给cookie赋值
           if(c.getName().equals("cusername")){
               username=c.getValue();
           }
            if(c.getName().equals("cpassword")){
                password=c.getValue();
            }
            if(c.getName().equals("cremeberme")){
                remembermevalue=c.getValue();
            }
        }
    }%>
<form action="login" method="post">
    username<input type="text" name="username" value="<%=username%>"><br>
    password<input type="text" name="password" value="<%=password%>"><br>
    <!--checked 属性用来设置页面加载时复选框的选中状态。当属性值为“checked”时，对应的复选框会被选中。未选中则数据不会提交
    ? : 为Java中的三元运算符，表示条件判断语句，对布尔类型的语句进行判断，即 A ? B : C，表示：如果语句A为真，则执行语句B，如果语句A为假，则执行语句C。-->
    <input type="checkbox" name="rememberme" value="1" <%=remembermevalue.equals("1")?"checked":""%>>Remember Me<br>
    <button type="submit">login</button>

</form>
<%@include file="footer.jsp"%>

</body>
</html>
