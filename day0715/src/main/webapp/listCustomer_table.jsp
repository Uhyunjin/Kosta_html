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
	<table border=1 width="50%">
	<tr>
		<th>고객번호</th>
		<th>고객이름</th>
		<th>고객주소</th>
		<th>고객전화</th>
	</tr>
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
					<tr>
						<td><%=rs.getInt(1)%></td>
						<td>
							<a href="detailCustomer.jsp?custid=<%=rs.getInt(1)%>"><%=rs.getString(2) %></a>
						</td>
						<td><%=rs.getString(3)%></td>
						<td><%=rs.getString(4)%></td>
					</tr>
					<%
				}
				rs.close();
				pstmt.close();
				conn.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		%>
	</table>
</body>
</html>