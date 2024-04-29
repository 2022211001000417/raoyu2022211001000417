package com.raoyu.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //在访问servlet前请求doFilter()语句 doGet() or doPost
        System.out.println("request AuthFilter 在访问servlet前进行doFilter()");
        chain.doFilter(request, response);
        //response 在访问servlet后返回此处执行doFilter()语句
        System.out.println("response AuthFilter response 在访问servlet后返回此处进行doFilter()");
    }
}
