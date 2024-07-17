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
<c:if test="${re==1 }">
	로그인 성공
</c:if>
<c:if test="${re==0 }">
	로그인 실패(암호 오류)
</c:if>
<c:if test="${re==-1 }">
	로그인 실패(없는 아이디)
</c:if>

</body>
</html>