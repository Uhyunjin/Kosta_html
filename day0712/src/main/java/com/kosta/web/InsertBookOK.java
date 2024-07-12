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

/**
 * Servlet implementation class InsertBookOK
 */
@WebServlet("/InsertBookOK")
public class InsertBookOK extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼양식에서 새로운 도서등록을 위하여 입력한 내용을 갖고 doPost로 옵니다
		// 이 때 사용자의 요청정보는 request에 실려서 옵니다.
		// request를 통해서 사용자가 요청한 정보(도서정보)를 받아올 수 있어요
		// 받아오기 전에 요청한 문자셋이 한글임을 먼저 설정한 후에 데이터를 받아와야 한다.
		
		// 요청한 문자셋이 한글임을 설정
		request.setCharacterEncoding("UTF-8");
		
		// 요청한 새로운 도서 등록을 위하여 요청한 데이터(도서번호 도서명 가격 출판사)를 받아와서 변수에 저장
		// 요청한 데이터는 모두 doPost메서드의 매개변수 request에 실려 있다
		int bookid=Integer.parseInt(request.getParameter("bookid"));
		String bookname=request.getParameter("bookname");
		int price=Integer.parseInt(request.getParameter("price"));
		String publisher=request.getParameter("publisher");
		
		//DB 연결하여 실행시킬 DB명령어 만들기
		String sql="insert into book values(?,?,?,?)";
		
		//DB연결을 위한 드라이버이름, url, username,password 변수를 만들기
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE"; // 이 부분의 localhost를 선생님 ip주소로 변경하면 선생님의 DB로 입력이 가능하다
		String username="c##madang";
		String password="madang";
		int re=-1;
		
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,username,password);
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,bookid);
			pstmt.setString(2,bookname);
			pstmt.setInt(3,price);
			pstmt.setString(4,publisher);
			
			re=pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =response.getWriter();
		if (re>0) {
			out.print("부서등록 성공");
		}else {
			out.print("부서등록 실패");
		}
		out.close();
	}

}
