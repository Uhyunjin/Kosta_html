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
<%
	int custid=Integer.parseInt(request.getParameter("custid"));
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="c##madang";
	String password="madang";
	String name="";
	String addr="";
	String phone="";
	String sql="update customer set custname=?,address=?,phone=? where custid=?";
	
	try{
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(url,user,password);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, custid);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			%>
			name=rs.getString(2)
			addr=rs.getString(3)
			phone=rs.getString(4)
			<%
		}
		rs.close();
		pstmt.close();
		conn.close();
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
%>
<h2>고객수정</h2>
<hr>
<form action="updateCustomerOK.jsp" method="post">
	고객번호:<span><%=custid %></span><input type="hidden" name="custid" value=<%=custid %>><br>
	고객이름:<input type="text" name="name" value="<%=name %>"><br>
	고객주소:<input type="text" name="addr" value="<%=addr %>"><br>
	고객전화:<input type="text" name="phone" value="<%=phone %>"><br>
	<input type="submit" value="수정">
	<input type="reset" value="다시입력">
</form>
</body>
</html>