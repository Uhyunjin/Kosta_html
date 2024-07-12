<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//새로운 도서등록을 위하여 사용자가 입력한 도서의 정보(도서번호,도서명,가격,출판사)는
	//JSP 내장객체인 request에 실려서 온다.
	
	//사용자가 요청한 문자셋은 한글임을 설정
	request.setCharacterEncoding("UTF-8");

	//사용자가 입력한 도서번호 도서명 가격 출판사를 받아와서 변수에 저장
	int bookid=Integer.parseInt(request.getParameter("bookid"));
	String bookname=request.getParameter("bookname");
	int price=Integer.parseInt(request.getParameter("price"));
	String publisher=request.getParameter("publisher");
	
	//DB 연결하여 실행시킬 데이터베이스 명령어 sql 만들기
	String sql="insert into book values(?,?,?,?)";
	
	//DB연결에 필요한 변수 만들기
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
		System.out.println(e.getMessage()); //콘솔에 출력
		out.println(e.getMessage()); //브라우저에 출력
	}
	
	if(re>0){
		out.print("<h2>도서 등록 성공</h2>");
	}else{
		out.print("<h2>도서 등록 실패</h2>");
	}
%>
</body>
</html>