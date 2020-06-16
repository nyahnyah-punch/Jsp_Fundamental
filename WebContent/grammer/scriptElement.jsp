<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.kpc.dto.MemberDto"%>
<%@page import="kr.or.kpc.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Script Element</title>
</head>
<body>

	<%! //매소드 생성 가능
		private String name;

		public int plus(int a, int b) {
		return a + b;
	}
	%>
	
	<% //메소드 호출은 가능하나 선은은 불가능 
		int result = plus(10,20);
		out.println(result); //출력방법 1
	%>
	
	<%= //출력방법 2
		result
	%>
	
	<% 
		MemberDto dto = new MemberDto(1,"안녕");
	%>
	
	<%= dto.getName()%>, <%= dto.getNum()%> <br>
	
	<% 
		MemberDao dao = MemberDao.getInstance();
		ArrayList<MemberDto> list = dao.select();
	%>
	
	<table>
		<tr>
			<th>번호</th><th>이름</th>
		</tr>
		<%for(MemberDto memberDto : list){ %>
		<tr>
			<td><%=memberDto.getNum() %></td>
			<td><%=memberDto.getName() %></td>
		</tr>
		
		<%} %>
	
	</table>

</body>
</html>