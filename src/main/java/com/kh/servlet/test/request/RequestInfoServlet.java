package com.kh.servlet.test.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RequestInfoServlet", urlPatterns = "/request-info")
public class RequestInfoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("요청 method: " + request.getMethod()); // HTTP 메서드 (예: GET)
        System.out.println("요청 URL: " + request.getRequestURL()); // 요청 URI

        System.out.println("--- Header정보 ---");
        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + ": " + request.getHeader(headerName))); // 각 헤더 이름과 값을 출력
        System.out.println("--- Header정보 ---\n");

        System.out.println("Server Name: " + request.getServerName()); // 서버 이름
        System.out.println("Server Port: " + request.getServerPort() + "\n"); // 서버 포트 번호

        System.out.println("[Cookies]");
        if (request.getCookies() != null) { // 쿠키가 존재하는 경우
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue()); // 쿠키 이름과 값 출력
            }
        }
        System.out.println();

        System.out.println("Content Type: " + request.getContentType()); // 콘텐츠 타입
        System.out.println("Content Length: " + request.getContentLength()); // 콘텐츠 길이
        System.out.println("Character Encoding: " + request.getCharacterEncoding()); // 문자 인코딩

        System.out.println("--- Miscellaneous Info ---");
        System.out.println("[Remote Info]");
        System.out.println("Remote Host: " + request.getRemoteHost()); // 원격 호스트 이름
        System.out.println("Remote Address: " + request.getRemoteAddr()); // 원격 IP 주소
        System.out.println("Remote Port: " + request.getRemotePort() + "\n"); // 원격 포트 번호

        System.out.println("[Local Info]");
        System.out.println("Local Name: " + request.getLocalName()); // 로컬 서버 이름
        System.out.println("Local Address: " + request.getLocalAddr()); // 로컬 서버 IP 주소
        System.out.println("Local Port: " + request.getLocalPort()); // 로컬 포트 번호
        System.out.println("--- Miscellaneous Info End ---\n");
    }

}
