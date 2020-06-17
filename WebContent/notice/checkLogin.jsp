<%@page import="kr.or.kpc.dto.CustomerDto"%>
<%@page import="kr.or.kpc.dao.CustomerDao"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String email = request.getParameter("email");
	String pwd = request.getParameter("pwd");
	
	CustomerDao dao = CustomerDao.getInstance();
	CustomerDto dto = dao.getLogin(email, pwd);
	
	if(dto != null){
		//email pwd일치
		//세션에 클라이언트 정보를 저장한다
		session.setAttribute("login", dto);
		
		//공지사항 리스트로 가기
		response.sendRedirect("/notice/list.jsp?page=1");
	}else {
		%>
		<!-- email pwd노일치 -->
		<script>
		alert("회원정보가 일치하지 않습니다.");
		history.back(-1);
		</script>
		<%
	}
	
%>