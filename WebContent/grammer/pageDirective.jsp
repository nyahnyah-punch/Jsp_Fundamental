<%@page import="java.io.File"%>
<%@ page import="java.util.Calendar"%> <!-- 임폴트 -->
<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" %> <!-- 이게 신세대의 방법이다 -->
<%@ page session="false" %>
<%@ page buffer="7kb" %>
<%@ page autoFlush="true" %>
<%@ page errorPage="error.jsp" %> <!-- 애러 발생하면 이 페이지로 감 -->
<%@ page isELIgnored="true" %> <!-- 디폴트가 false고 입력받는거 보일지 안보일지 정하는친구 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Directive</title>
</head>
<body>

	<h1>와랄랄라라</h1>
	
	<%
		Calendar c = Calendar.getInstance();
		File f = new File("");
		//String str = null;
		//int len = str.length(); //NullPointException Error
	%>
	
	${param.id }

</body>
</html>