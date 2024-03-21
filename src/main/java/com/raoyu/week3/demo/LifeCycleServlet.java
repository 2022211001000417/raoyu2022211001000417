package com.raoyu.week3.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
//@WebServlet(name="form",urlPatterns = "/LifeCycleServlet")

public class LifeCycleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        String email= request.getParameter("email");
        String birthdate= request.getParameter("birthdate");
        String sex= request.getParameter("sex");
        request.setAttribute("a1",username);
        request.setAttribute("a2",password);
        request.setAttribute("a3",email);
        request.setAttribute("a4",birthdate);
        request.setAttribute("a5",sex);
        RequestDispatcher rs=request.getRequestDispatcher("/display.jsp");
        rs.forward(request,response);



    }
}
