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
<h2>게시물 상세</h2>
<hr>
글번호 : ${b.no }<br>
글제목 : ${b.title }<br>
작성자 : ${b.writer }<br>
글내용 : ${b.content }<br>
등록일 : ${b.regdate }<br>
조회수 : ${b.hit }<br>

<hr>
<c:if test="${isImg =='yes' }">
	<img src="upload/${b.fname }" width="200" height="200">
</c:if>
<c:if test="${isImg !='yes' }">
	첨부파일 : <a href="upload/${b.fname }">${b.fname }(${b.fsize }bytes)<br></a>
</c:if>


<c:if test="${userID==b.writer }">
	<a href="updateBoard.do?no=${b.no }">수정</a>
	&nbsp&nbsp
	<a href="deleteBoard.do?no=${b.no }">삭제</a>	
</c:if>

</body>
</html>