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
	<c:if test="${re>0 }">
	게시물을 등록성공
	</c:if>
	<c:if test="${re<=0 }">
	게시물을 등록실패
	</c:if>
	<a href="insertBoard.do">새 게시물 등록</a>
	<a href="listBoard.do">새 게시물 등록</a>
</body>
</html>