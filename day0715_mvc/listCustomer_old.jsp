<%@page import="com.kosta.vo.CustomerVO"%>
<%@page import="java.util.ArrayList"%>
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
	String msg = (String)request.getAttribute("msg");
	ArrayList<CustomerVO> list = (ArrayList<CustomerVO>) request.getAttribute("list");
%>
	메세지 : <%= msg %>
	<hr>
	
	<h2>고객 목록</h2>
	<hr>
	<table border="1" width="80%">
	<tr>		
			<th>고객번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>전화</th>
		
	</tr>
	<%
		for(CustomerVO c :list)	{
			%>
				<tr>
					<td><%=c.getCustid() %> </td>
					<td><%=c.getName() %> </td>
					<td><%=c.getAddress() %> </td>
					<td><%=c.getPhone() %> </td>
				</tr>
			<%
		}
	%>
	</table>
</body>
</html>











