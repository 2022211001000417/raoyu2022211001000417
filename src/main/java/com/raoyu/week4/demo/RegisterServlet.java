package com.raoyu.week4.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "RegisterServlet", urlPatterns ={ "/register"})
public class RegisterServlet extends HttpServlet {

    Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;
    PreparedStatement pstmt=null;
    @Override
   public void init() throws ServletException {
       //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        // String url="jdbc:sqlserver://localhost;databaseName=userdb";
        // String username="sa";
        //String password="yl750382904729";
       // ServletContext context=getServletContext();
        /*String driver=getServletConfig().getServletContext().getInitParameter("driver");
        String url=getServletConfig().getServletContext().getInitParameter("url");
        String username=getServletConfig().getServletContext().getInitParameter("username");
        String password=getServletConfig().getServletContext().getInitParameter("password");
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("连接成功2"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
       con= (Connection) getServletContext().getAttribute("con");//完成连接数据库

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       System.out.println("Raoyu");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Raoyu1");
       try {
           String username=request.getParameter("username");
           String password=request.getParameter("password");
           String email=request.getParameter("email");
           String gender=request.getParameter("gender");
           String birthdate=request.getParameter("birthdate");
           String sql="insert into usertable(username,password,email,gender,birthdate) select ?,?,?,?,?";
           pstmt=con.prepareStatement(sql);
           pstmt.setString(1,username);
           pstmt.setString(2,password);
           pstmt.setString(3,email);
           pstmt.setString(4,gender);
           pstmt.setString(5,birthdate);
           pstmt.executeUpdate();
           response.sendRedirect("login.jsp");
          /* String sql1="select*from usertable";
           pstmt=con.prepareStatement(sql1);
            rs= pstmt.executeQuery();
           PrintWriter out = response.getWriter();
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<td>id<td>");
            out.println("<td>username<td>");
           out.println("<td>password<td>");
            out.println("<td>email<td>");
            out.println("<td>gender<td>");
            out.println("<td>birthdate<td>");
            out.println("<tr>");
            while(rs.next()){
                out.println("<tr>");
                out.println("<td>"+rs.getInt("id")+"<td>");
                out.println("<td>"+rs.getString("username")+"<td>");
                out.println("<td>"+rs.getString("password")+"<td>");
                out.println("<td>"+rs.getString("email")+"<td>");
                out.println("<td>"+rs.getString("gender")+"<td>");
                out.println("<td>"+rs.getString("birthdate")+"<td>");
                out.println("<tr>");
            }
            out.println("<table>");*/
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
            if (pstmt!=null){
                try {pstmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }

    }

    @Override
    public void destroy() {

        super.destroy();
    }
}
