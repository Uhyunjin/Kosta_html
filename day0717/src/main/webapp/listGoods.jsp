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
<h2>상품 리스트</h2>
<hr>
<br>
<table border="1" width="70%">
	<tr>
		<th>상품번호</th>
		<th>상품이름</th>
	</tr>
	<c:forEach var="g" items="${list }">
		<tr>
			<td>${g.no }</td>
			<td><a href="detailGoods.do?no=${g.no }">${g.item }</a></td>
		</tr>
	</c:forEach>
</table>
<br>
<a href="insertGoods.do"><input type="button" value="상품 등록하기"></a>
</body>
</html>