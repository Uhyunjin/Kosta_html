package com.kosta.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET 방식으로 요청했을때 응답해줄 내용을 써준다.
		String data="<h1>Hello Servelet</h1>";
		data+="<hr>";
		data+="<h1>안녕 서블릿</h1>";
		// 이렇게 동적으로 만들어진 html 태그를 사용자의 요청에 따라 응답으로 보내준다.
		
		// 1.응답방식을 설정해준다.
		response.setContentType("text/html;charset=UTF-8");
		// 2.동적으로 생성한 html을 요청한 사용자의 브라우저에 응답(출력)하기위하여 스트림을 얻어온다
		PrintWriter out = response.getWriter();
		// 3.출력 스트림을 통해서 html을 응답한다(출력한다)
		out.print(data);
		// 4.스트림을 닫아준다.
		out.close();
	}

}
