package com.kosta.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertDept")
public class InsertDept extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String form="<h2>부서 등록</h2>"+
				  "<form action='InsertDeptOK' method='post'>"+
				  "NO. : "+
				  "<input type='text' name='dno'>"+
				  "<br>"+
				  "NAME : "+
				  "<input type='text' name='dname'>"+
				  "<br>"+
				  "LOCATION : "+
				  "<input type='text' name='dloc'>"+
				  "<hr>"+
				  "<input type='submit' value='등록'>"+
				  "<input type='reset' name='취소'>"+
				  "</form>";
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(form);
		out.close();

	}

}
