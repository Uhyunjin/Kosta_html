<%@page import="com.kosta.vo.CustomerVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>고객 목록</h2>
	<a href="insertCustomer.do">고객등록</a>
	<br>
	<table border="1" width="80%">
		<tr>
			<th>고객번호</th>
			<th>고객이름</th>			
		</tr>
		
		<c:forEach var="c" items="${list }">
			<tr>
				<td>${c.custid }</td>   
				<td> 
					<a href="detailCustomer.do?custid=${c.custid }">${c.name }</a>
				</td>   				
			</tr>
		</c:forEach>
	</table>
</body>
</html>




















