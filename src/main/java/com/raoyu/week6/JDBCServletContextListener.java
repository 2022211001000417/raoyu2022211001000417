package com.raoyu.week6;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.*;
//在listener中使用context变量连接数据库
@WebListener
public class JDBCServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //tomcat 启动时响应
        String driver=sce.getServletContext().getInitParameter("driver");
        String url=sce.getServletContext().getInitParameter("url");
        String username=sce.getServletContext().getInitParameter("username");
        String password=sce.getServletContext().getInitParameter("password");
        try {
            Class.forName(driver);
           Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("连接成功2"+con);
            sce.getServletContext().setAttribute("con" ,con);//在request域中设置con用于使用
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //tomcat 结束时响应
        sce.getServletContext().removeAttribute("con");
    }
}
