package com.kosta.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertCustomer")
public class InsertCustomer extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data="";
		data+="<html>";
		data+="<body>";
		data+="<form action='' method='post'>";
		data+="고객 번호: <input type='text' name='custid'><br>";
		data+="고객 이름: <input type='text' name='name'><br>";
		data+="고객 주소: <input type='text' name='addr'><br>";
		data+="고객 전화: <input type='text' name='phone'><br>";
		data+="<input type='submit' value='등록'><br>";
		data+="<input type='reset' value='초기화'><br>";
		data+="</form>";
		data+="</body>";
		data+="</html>";
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(data);
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int custid=Integer.parseInt(request.getParameter("custid"));
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		String phone=request.getParameter("phone");
		
		String sql="insert into customer values(?,?,?,?)";
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String username="c##madang";
		String password="madang";
		
		int re=-1;
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,username,password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custid);
			pstmt.setString(2, name);
			pstmt.setString(3, addr);
			pstmt.setString(4, phone);
			re = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if (re>0) {
			out.print("고객등록 성공");
		}else {
			out.print("고객등록 실패");
		}
		out.close();
	}

}
