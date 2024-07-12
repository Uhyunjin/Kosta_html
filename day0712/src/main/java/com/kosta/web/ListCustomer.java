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
 * Servlet implementation class ListCustomer
 */
@WebServlet("/ListCustomer")
public class ListCustomer extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql="select custid,name from customer";
		String data="<html>";
		data+="<h2>고객목록</h2><hr>";
		data+="<body>";
		data+="<ul>";
		
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String username="c##madang";
		String password="madang";
		
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,username,password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int custid=rs.getInt(1);
				String name=rs.getString(2);
				data+="<li><a href='DetailCustomer?custid="+custid+"'>"+name+"</a></li>";	//ul태그 사이에 li태그 반복문으로 추가
				
			}
				
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		data+="</ul>";
		data+="</body>";
		data+="</html>";
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(data);
		out.close();
	}

}
