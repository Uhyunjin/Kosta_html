<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>회원목록</h2>
	<hr>
	<%
		String name="spring";;
		int age=20;
		//자바 코드는 페이지 소스보기에서 노출되지 않는다
	%>
	<h1>이름:<%=name %></h1>
	<h2>나이:<%=age %></h2>
</body>
</html>