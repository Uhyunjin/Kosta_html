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
	<h2>�μ����</h2>
	<table border="1" width="80%">
		<thead>
			<tr>
				<th>�μ���ȣ</th>
				<th>�μ���</th>
				<th>�μ���ġ</th>
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
				
				// 1.jdbc����̹��� �޸𸮷� �ε��Ѵ�
				Class.forName(driver);
				// 2.DB������ �����Ѵ�
				Connection conn = DriverManager.getConnection(url,username,password);
				
				// 3.Statement��ü�� �����Ѵ�
				Statement stmt=conn.createStatement();
				
				// 4.sql����� �����Ѵ�.
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