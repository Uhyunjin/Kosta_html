package com.kosta.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DetailCustomer
 */
@WebServlet("/DetailCustomer")
public class DetailCustomer extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int custid=Integer.parseInt(request.getParameter("custid"));
		
		String sql="select * from customer where custid=?";
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String data="<html>";
		data+="<head>";
		data+="<script type='text/javascript'>";
		data+="window.onload=function(){";
		data+="document.querySelector('#delete_button').onclick=function(event){";		
		data+="let re=confirm('정말로 삭제하시겠습니까?');";		
		data+="if(re==false){";		
		data+="event.preventDefault();";		
		data+="return false;";		
		data+="}";		
		data+="}";		
		data+="}";		
		data+="</script>";
		data+="</head>";
		data+="<body>";
		
		
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String username="c##madang";
		String password="madang";
		
		
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,username,password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custid);
			ResultSet rs = pstmt.executeQuery();
			// 조회 레코드가 하나일때에는 while보다는 if를 사용한다
			
			if (rs.next()) {
				String name=rs.getString(2);
				String addr=rs.getString(3);
				String phone=rs.getString(4);
				
				data+="고객번호 : "+custid+"<br>";
				data+="고객이름 : "+name+"<br>";
				data+="고객주소 : "+addr+"<br>";
				data+="고객전화 : "+phone+"<br>";
			}
			rs.close();
			pstmt.close();
			conn.close();			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		data+="<hr>";
		data+="<br>";
		data+="<br>";
		data+="<br>";
		data+="<a href='UpdateCustomer?custid="+custid+"'>수정하기</a>";
		data+="<a id='delete_button' href='DeleteCustomer?custid="+custid+"'>삭제하기</a>";
		
		
		data+="</body>";
		data+="</html>";
		
		response.setContentType("text/html;charset=UTF-8");
		out.print(data);
		out.close();
	}
}
