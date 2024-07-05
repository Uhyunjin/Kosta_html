<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body></tr>
	<h2>부서목록</h2>
	<table border="1" width="80%">
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서명</th>
				<th>부서위치</th>
			</tr>
		</thead>
		<tbody>
			
			<%
			try{
				String driver="oracle.jdbc.driver.OracleDriver";
				String url="jdbc:oracle:thin:@localhost:1521:XE";
				String username="c##madang";
				String password="madang";
				String sql="select dno,dname,dloc from dept";
				
				// 1.jdbc드라이버를 메모리로 로드한다
				Class.forName(driver);
				// 2.DB서버에 연결한다
				Connection conn = DriverManager.getConnection(url,username,password);
				
				// 3.Statement객체를 생성한다
				Statement stmt=conn.createStatement();
				
				// 4.sql명령을 실행한다.
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next()){
				%>
				<tr>
					<td><%=rs.getString(1) %></td>
					<td><%=rs.getString(2) %></td>
					<td><%=rs.getString(3) %></td>
				</tr>
				<%
				}
			
					rs.close();
					stmt.close();
					conn.close();
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			
			%>
			
		</tbody>
	</table>
</body>
</html>