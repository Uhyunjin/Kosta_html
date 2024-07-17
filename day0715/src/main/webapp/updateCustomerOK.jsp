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
request.setCharacterEncoding("UTF-8");
int custid=Integer.parseInt(request.getParameter("custid"));
String custname=request.getParameter("name");
String addr=request.getParameter("addr");
String phone=request.getParameter("phone");
String sql="insert into customer values(?,?,?,?)";
String driver="oracle.jdbc.driver.OracleDriver";
String url="jdbc:oracle:thin:@localhost:1521:XE";
String user="c##madang";
String password="madang";
int re=-1;

try{
	Class.forName(driver);
	Connection conn = DriverManager.getConnection(url, user, password);
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, custname);
	pstmt.setString(2, addr);
	pstmt.setString(3, phone);
	pstmt.setInt(4, custid);
	re = pstmt.executeUpdate();
	pstmt.close();
	conn.close();
}catch(Exception e){
	System.out.println(e.getMessage());
}

if(re>0){
	%>
	고객 추가 성공
	<%
}
%>
<hr>
<a href="listCustomer.jsp">고객 목록</a>
<a href="insertCustomer.jsp">고객 추가</a>
</body>
</html>