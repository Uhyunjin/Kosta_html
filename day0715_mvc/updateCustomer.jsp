<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>고객수정</h2>
	<hr>
	<form action="updateCustomerOK.do" method="post">
		고객번호 : <span>${c.custid }</span><input type="hidden" name="custid" value="${c.custid }"><br>
		고객이름 : <input type="text" name="name" value="${c.name }"><br>
		고객주소 : <input type="text" name="address" value="${c.address }"><br>
		고객전화 : <input type="text" name="phone" value="${c.phone }"><br>
		<input type="submit" value="수정">
		<input type="reset" value="다시입력">
	</form>
</body>
</html>














