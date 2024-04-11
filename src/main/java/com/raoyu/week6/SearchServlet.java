package com.raoyu.week6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // request.setCharacterEncoding("UTF-8");
       // response.setContentType("text/html;charset=UTF-8");
       // response.setCharacterEncoding("UTF-8");
       // response.setHeader("content-type","text/html;charset=UTF-8");
        String txt= request.getParameter("txt");
        String search= request.getParameter("search");
        System.out.println(txt);
        if(txt.equals("")){
            response.sendRedirect("index.jsp");
        }else{
            if(search.equals("baidu")){
                response.sendRedirect("https://www.baidu.com/s?wd="+txt);
            }else if(search.equals("Bing")){
                response.sendRedirect("https://cn.bing.com/search?q="+txt);
            } else if (search.equals("google")) {
                response.sendRedirect("https://www.google.com/search?q="+txt);
            }

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
