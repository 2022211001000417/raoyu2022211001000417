package com.raoyu.week4.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = {"/config"},
       initParams = {
                @WebInitParam(name="name1",value="raoyu"),
                @WebInitParam(name="studentid1",value="2022211001000417"),
                @WebInitParam(name="name",value="raoyu"),
                @WebInitParam(name="studentid",value="2022211001000417")
        }
)
public class ConfigdemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config=getServletConfig();
        String name=config.getInitParameter("name");
        String studentid=config.getInitParameter("studentid");
        String name1=config.getInitParameter("name1");
        String studentid1=config.getInitParameter("studentid1");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Task 1-Get init parameters from web.xml</h1>");
        out.println("<p>name="+name+"<p>");
        out.println("<p>studentid="+studentid+"<p>");
        out.println("<h1>Task 1-Get init parameters from @WebServlet</h1>");
        out.println("<p>name1="+name1+"<p>");
        out.println("<p>studentid1="+studentid1+"<p>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("raoyu");
    }
}
