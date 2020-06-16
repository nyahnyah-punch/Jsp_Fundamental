package kr.or.kpc.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kpc.dao.MemberDao;
import kr.or.kpc.dto.MemberDto;

@WebServlet("/member.kpc")

public class MemberServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	
	throws IOException{
		//setContentType에 따라서 다양한 파일이 올 수 있음 - html, json, xml, img, exel, docx 등등 다 가능
		response.setContentType("text/html;charset=utf-8"); //html에 한글을 지원하기위한 utf-8설정
		PrintWriter out = response.getWriter(); //네트워크 스트림 
		out.println("<html>"); //자바로 html을 리스펀스 -웹서버의 역할을 함 
		out.println("	<head>");
		out.println("		<title>집에갈ㄹ..</title>");
		out.println("	</head>");
		out.println("		<body>");
		MemberDao dao = MemberDao.getInstance();
		ArrayList<MemberDto> list = dao.select();
		out.println("			<table>");
		out.print("<tr>");
		out.print("<td>이름</td><td>번호</td>");
		out.print("</tr>");
		
		for(MemberDto dto:list) {
			String name = dto.getName();
			int num = dto.getNum();
			out.println("<tr>");
			out.println("<td>"+name+"</td><td>"+num+"</td>");
			out.println("</tr>");
		}
		
		out.println("			</table>");
		out.println("		</body>");
		out.println("</html>");
	}
	

}