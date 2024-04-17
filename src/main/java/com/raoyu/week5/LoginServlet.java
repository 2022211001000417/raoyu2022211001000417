package com.raoyu.week5;

import com.raoyu.dao.Userdao;
import com.raoyu.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;
    @Override
    public void init() throws ServletException {
        super.init();
        /*String driver=getServletContext().getInitParameter("driver");
        String url=getServletContext().getInitParameter("url");
        String username=getServletContext().getInitParameter("username");
        String password=getServletContext().getInitParameter("password");
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("连接成功2"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
        con= (Connection) getServletContext().getAttribute("con");//使用con完成连接数据库

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out= response.getWriter();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        Userdao userdao=new Userdao();
        try {
           User user= userdao.findByUsernamePassword(con,username,password);
           if(user!=null){
               request.setAttribute("user",user);
               request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request,response);
           }else{
               request.setAttribute("message","Username or Password Error!!!");
               request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
           }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
       /* try {


            String sql1="select*from usertable where username=? and password=?";
            PreparedStatement pstmt=con.prepareStatement(sql1);
            pstmt.setString(1,username);
            pstmt.setString(2,password);

            rs= pstmt.executeQuery();
           // System.out.println(rs.next());

            if(rs.next()){
                //out.println("<h1>Login Success!!!</h1>");
                //out.println("<h1>"+"Welcome,"+username+"</h1>");
                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthdate",rs.getString("birthdate"));
                request.getRequestDispatcher("userinfo.jsp").forward(request,response);
            }else{
               // out.println("Username or Password Error!!!");
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }/*finally {
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (stmt!=null){
                try {stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }*/


    }
}
