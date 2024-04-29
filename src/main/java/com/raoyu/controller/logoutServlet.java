package com.raoyu.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "logoutServlet", value = "/logout")
public class logoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从Session中获取登录信息，若存在会话则返回该会话，否则返回NULL，不再新建一个会话
        request.getSession(false).invalidate();//立即销毁session
        request.setAttribute("message","you have successfully logged out.");
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
