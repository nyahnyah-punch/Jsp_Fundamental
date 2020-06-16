<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	안녕안녕
	<% //jsp엔 자바코드 넣기 가능 근데 html에선 그런거 몬해
	for(int i=0; i<=100; i++) {
		out.print("집에 언제가?<br>");
	}
	%>

</body>
</html>