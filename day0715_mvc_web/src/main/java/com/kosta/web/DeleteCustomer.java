package com.kosta.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteCustomer")
public class DeleteCustomer extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int custid=Integer.parseInt(request.getParameter("custid"));

		String sql="delete customer where custid=?";
		
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String username="c##madang";
		String password="madang";
		String name="";
		String addr="";
		String phone="";
		
		int re=-1;
		
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,username,password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custid);
			re=pstmt.executeUpdate();

			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (re>0) {
			out.print("고객삭제 성공");
		}else {
			out.print("고객삭제 실패");
		}
		response.setContentType("text/html;charset=UTF-8");
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
