<%@page import="java.sql.ResultSet"%>
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
<header>고객 목록</header>
<hr>
	<ul>
		<%
			String sql="select * from customer";
			String driver="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String user="c##madang";
			String password="madang";
			int re=-1;
			try{
				Class.forName(driver);
				Connection conn=DriverManager.getConnection(url,user,password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery(sql);
				while(rs.next()){
					%>
					<li><a href="detailCustomer.jsp?custid=<%=rs.getInt(1)%>"><%= rs.getString(2) %></a></li>
					<%
				}
				rs.close();
				pstmt.close();
				conn.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		%>
	</ul>
</body>
</html>