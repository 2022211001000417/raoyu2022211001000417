package com.raoyu.week5;

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
        String driver=getServletContext().getInitParameter("driver");
        String url=getServletContext().getInitParameter("url");
        String username=getServletContext().getInitParameter("username");
        String password=getServletContext().getInitParameter("password");
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("连接成功2"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username=request.getParameter("username");
            String password=request.getParameter("password");

           String sql1="select*from usertable where username=? and password=?";
            PreparedStatement pstmt=con.prepareStatement(sql1);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            rs= pstmt.executeQuery();
           // System.out.println(rs.next());
            PrintWriter out= response.getWriter();
            if(rs.next()){
                out.println("<h1>Login Success!!!</h1>");
                out.println("Welcome,"+username);
            }else{
                out.println("Username or Password Error!!!");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
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
        }


    }
}
