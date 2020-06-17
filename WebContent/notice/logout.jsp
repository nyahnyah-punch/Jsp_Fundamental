<%@page import="kr.or.kpc.dto.CustomerDto"%>
<%@page import="kr.or.kpc.dao.CustomerDao"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%
	session.invalidate(); //세션객체 삭제
	response.sendRedirect("/member/login.jsp");
%>