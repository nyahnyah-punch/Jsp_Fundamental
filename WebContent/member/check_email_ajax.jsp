<%@page import="kr.or.kpc.dao.CustomerDao" %>
<%@ page language="java" contentType="application/json; charset=UTF-8"%>
<%
	String email = request.getParameter("email");
	CustomerDao dao = CustomerDao.getInstance();
	dao.isExisted(email);
	boolean existed = dao.isExisted(email);
	
	if(existed){ 
	%> <!-- 이메일이 이미 존재하면 회원가입 실패 -->
		{"result" : "fail"} 
	<%
	}else{
		%>
		{"result" : "ok"}
		<%
	}
%>