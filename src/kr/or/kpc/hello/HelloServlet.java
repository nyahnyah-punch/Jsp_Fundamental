package kr.or.kpc.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello.kpc")

public class HelloServlet extends HttpServlet {
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
		out.println("			<h1>집에 가고싶은 사람의 모임</h1>");
		
		String id = request.getParameter("id"); //쿼리에 있는 키값민 일면 벨류 얻어오기 가능
		String pwd = request.getParameter("pwd");
		
		out.println("			<h1>");
		out.println("			id : " +id+ ", pwd : "+pwd);
		out.println("			</h1>");
		out.println("		</body>");
		out.println("</html>");
	}
	

}