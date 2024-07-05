<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Driver"%>
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
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	int age = Integer.parseInt(request.getParameter("age"));
	String email = request.getParameter("email");
	String pwd = request.getParameter("pwd");
	String []hobby = request.getParameterValues("hobby");
	String hobby2 = String.join(",", hobby);
	String gender = request.getParameter("gender");
	String bloodType= request.getParameter("bloodType");
	String job= request.getParameter("job");
	String food = request.getParameter("food");
	String pro  = request.getParameter("pro");
	String sql="INSERT INTO member(NO,name,addr,age,email,pwd,hobby,gender,bloodtype,job,food,info) "+
			   "values(seq_member.nextval,?,?,?,?,?,?,?,?,?,?,?)";
	
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String username="c##kosta1234";
	String password="kosta1234";
	
	try{
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(url,username,password);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,name);
		pstmt.setString(2,addr);
		pstmt.setInt(3,age);
		pstmt.setString(4,email);
		pstmt.setString(5,pwd);
		pstmt.setString(6,hobby2);
		pstmt.setString(7,gender);
		pstmt.setString(8,bloodType);
		pstmt.setString(9,job);
		pstmt.setString(10,food);
		pstmt.setString(11,pro);
		int re=pstmt.executeUpdate();		
		System.out.print(re);
		
	}catch(Exception e){
		System.out.print(e.getMessage());		
	}
	
	%>
	이름 : <%= name %><br>
	주소 : <%= addr %><br>
	나이 : <%= age %><br>
	메일 : <%= email %><br>
	비번 : <%= pwd %><br>
	취미 : 
	<%
		for(String h : hobby){
			%>
				<%= h %>&nbsp;
			<%
		}
	%><br>
	성별 : <%= gender %><br>
	혈액 : <%= bloodType %><br>
	직업 : <%= job %>
	음식 : <%= food %><br>
	소개 : <%= pro %><br>
	
	
</body>
</html>