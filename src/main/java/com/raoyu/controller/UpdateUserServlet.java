package com.raoyu.controller;

import com.raoyu.dao.Userdao;
import com.raoyu.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con=null;
    public void init() throws ServletException {
        super.init();
        con= (Connection) getServletContext().getAttribute("con");//使用con完成连接数据库

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birthdate=request.getParameter("birthdate");
        User user=new User();
        user.setId(Integer.parseInt(id));
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
        user.setBirthdate(birthdate);
        Userdao userdao=new Userdao();
        try {
            int u=userdao.updateUser(con,user);
            HttpSession session=request.getSession();
            System.out.println("session id:"+session.getId());
            session.setMaxInactiveInterval(60);//设置到期时间
            session.setAttribute("user",user);//更新session中的内容
            if(u==0){
               request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request,response);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
