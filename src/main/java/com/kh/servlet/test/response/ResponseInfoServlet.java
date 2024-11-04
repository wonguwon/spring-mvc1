package com.kh.servlet.test.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-info")
public class ResponseInfoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //결과상태 코드를 지정
        response.setStatus(HttpServletResponse.SC_OK);

        //응답 헤더 설정
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //must-revalidate는 캐시된 콘텐츠가 만료되었을 경우 서버에 재검증을 요청
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-app", "header_test");

        //쿠키사용
        Cookie cookie = new Cookie("myCookie", "hihi");
        cookie.setMaxAge(500); //500초
        response.addCookie(cookie);


        //텍스트 응답
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
//      response.setContentLength(2); //(생략시 자동 생성)
//      PrintWriter writer = response.getWriter();
//      writer.println("ok");

        response.sendRedirect("/");
    }
}
