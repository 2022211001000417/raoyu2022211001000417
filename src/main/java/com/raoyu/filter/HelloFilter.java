package com.raoyu.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
//使用注解部署过滤器。也可通过web.xml来部署
@WebFilter(filterName = "HelloFilter",
//部署方式 1./hello---部署一个servlet
//       2./*----部署所有servlet
//       3./hello /register ....--部署几个servlet

urlPatterns={"/hello"})
public class HelloFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init() filter");
    }

    public void destroy() {
        System.out.println("destroy() filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //在访问servlet前请求doFilter()语句 doGet() or doPost
        System.out.println("request HelloFilter 在访问servlet前进行doFilter()");
        chain.doFilter(request, response);
        //response 在访问servlet后返回此处执行doFilter()语句
        System.out.println("response HelloFilter 在访问servlet后返回此处进行doFilter()");
    }
}
