<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@page import="kr.or.kpc.dto.CustomerDto"%>
<%@page import="kr.or.kpc.dao.CustomerDao"%> 

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="/js/jquery-3.5.1.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>

<title>Hello, world!</title>

<style>
</style>
</head>

<body>
	<!-- 메뉴 만들기 -->
	<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: #11ae97;">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo01"
			aria-controls="navbarTogglerDemo01" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
			<a class="navbar-brand" href="#">Hidden brand</a>
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link" href="#">홈
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li class="nav-item"><a class="nav-link href="/notice/list.jsp">공지사항</a></li>
			</ul>
			<div class="form-inline my-2 my-lg-0">
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<%
					CustomerDto customerDto = (CustomerDto)session.getAttribute("login");
					if(customerDto != null) {
				%>
				<li class="nav-item active">
					<a><strong><%=customerDto.getName()%></strong>님</a>
					<a class="nav-link" href="/member/login.jsp">로그아웃</a>
				</li>
				<% } else { %>
						<li class="nav-item">
						<a class="nav-link" href="/member/login.jsp">로그인</a>
					</li>
				<%} %>
			</ul>
			</div>
		</div>
	</nav>