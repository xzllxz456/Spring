<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%-- 연결된 세션 초기화 하고 화면 이동(로그인 페이지) --%>
    
<%
	// 1. 세션 초기화(세션 객체 종료)
	session.invalidate();

	// 2. 화면 네비게이션(로그인 페이지)
	response.sendRedirect("login.jsp");
%>