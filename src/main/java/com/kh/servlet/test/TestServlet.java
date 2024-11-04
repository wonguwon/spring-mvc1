package com.kh.servlet.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
    name: 서블릿 이름
    urlPatterns: URL 매핑
 */
@WebServlet(name = "helloServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String msg = request.getParameter("msg");
        System.out.println("msg : " + msg);

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        response.getWriter().println("hello TestServlet");
    }
}
