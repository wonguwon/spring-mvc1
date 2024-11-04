package com.kh.servlet.test.request;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * 1. 쿼리 파라미터 전송 기능
 * 전송 : http://localhost:8081/request-param?name=kimcoding&age=20&hobby=운동&hobby=음악감상
 *
 * 2.
 *
 * HttpServletRequest의 getParameter()와 getParameterValues()를 이용하여 추출해서 사용할 수 있음
 *
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("파라미터 : ");
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println();

        System.out.println("값이 여러개인 파라미터 : ");
        String[] usernames = request.getParameterValues("hobby");
        for (String name : usernames) {
            System.out.println("username = " + name);
        }

        response.getWriter().write("ok");
    }
}
