package com.raoyu.week3.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name="form",urlPatterns = "/Register")

public class LifeCycleServlet extends HttpServlet {
   /* Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;
    @Override
    public void init() throws ServletException {
        //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        // String url="jdbc:sqlserver://localhost;databaseName=userdb";
        // String username="sa";
        //String password="yl750382904729";
        ServletContext context=getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //  String sql="insert into usertable(id,username,email,gender,birthdate) select'1',raoyu,123@qq.com,male,2004-07-12";
       /* try {
            String sql="insert into usertable(id,username,email,gender,birthdate) select'1',raoyu,123@qq.com,male,2004-07-12";
           stmt= con.createStatement();
           int count= stmt.executeUpdate(sql);
           if(count>0) {
               System.out.println("添加成功");
           }else{
               System.out.println("添加失败");
           }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/

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
        System.out.println("raoyu");



    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
