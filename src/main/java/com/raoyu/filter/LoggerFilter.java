package com.raoyu.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "LoggerFilter")
public class LoggerFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //在访问servlet前请求doFilter()语句 doGet() or doPost
        System.out.println("request Logger filter 在访问servlet前进行doFilter()");
        chain.doFilter(request, response);//如果没有调用chain.doFilter(request, response)过滤器，用户的请求就不会到达目标，会在那个过滤器处停止。
        //继续响应下一个filter，如果没有，则响应servlet
        //response 在访问servlet后返回此处执行doFilter()语句
        System.out.println(" response Logger filter response 在访问servlet后返回此处进行doFilter()");
    }
}
