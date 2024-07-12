package com.kosta.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertBook
 */
@WebServlet("/InsertBook")
public class InsertBook extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String insertForm="<h2>도서 등록</h2>"+
						  "<form action='InsertBookOK' method='post'>"+
						  "bookid"+
						  "<input type='text' name='bookid'>"+
						  "<br>"+
						  "bookname"+
						  "<input type='text' name='bookname'>"+
						  "<br>"+
						  "price"+
						  "<input type='text' name='price'>"+
						  "<br>"+
						  "publisher"+
						  "<input type='text' name='publisher'>"+
						  "<br>"+
						  "<input type='submit' value='등록'>"+
						  "<input type='reset' name='취소'>"+
						  "</form>";
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.print(insertForm);
		out.close();
		
	}

}
