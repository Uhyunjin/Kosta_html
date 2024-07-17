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
<script type="text/javascript">
	window.onload=function(){
		document.querySelector('#delete_btn').onclick=function(event){
			let re=confirm("정말???");
			if(re==false){
				event.preventDefault();
				return false;
			}
		}
	}
</script>
</head>
<body>
<h2>고객 상세 정보</h2>
<hr>
<%
	int custid=Integer.parseInt(request.getParameter("custid"));
	String sql="select custid,name,address,phone from customer where custid=?";
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="c##madang";
	String password="madang";
	try{
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(url,user,password);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, custid);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			%>
			고객번호:<%=rs.getInt(1) %><br>
			고객이름:<%=rs.getString(2) %><br>
			고객주소:<%=rs.getString(3) %><br>
			고객전화:<%=rs.getString(4) %><br>
			<%
		}
		%>
		<hr>
		<a href="updateCustomer.jsp?custid=<%=custid%>">수정하기</a>
		<a href="deleteCustomer.jsp?custid=<%=custid%>" id="delete_btn">삭제하기</a>
		<%
		rs.close();
		pstmt.close();
		conn.close();
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
%>
</body>
</html>