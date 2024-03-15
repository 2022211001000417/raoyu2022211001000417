package com.raoyu.week2.homework;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class raoyu1  extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        out.println("Name:RaoYu");
        out.println("ID:2022211001000417");
        out.println("Date and Time Sun March 15th 2:02:34 CST 2024");

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)  {



    }
}
