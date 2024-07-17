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
<h2>게시물 등록</h2>
<hr>
<form action="updateBoardOK.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="no" ${b.no }>
	글제목 : <input type="text" name="title" value=${b.title }><br>
	작성자 : ${b.writer }<br>
	글암호 : <input type="password" name="pwd"><br>
	글내용 : <br>
	<textarea rows="10" cols="60" name="content">${b.content }</textarea><br>
	<c:if test="${isImg!='yes' }">
		<img src="upload/${b.fname }" width="50" height="50">
	</c:if>
	<input type="hidden" name="fname" value="${b.fname }">
	<input type="hidden" name="fsize" value="${b.fsize }">
	
	첨부파일 :  <input type="file" name="uploadFile">
	<input type="submit" value="수정">
	<input type="reset" value="비우기">
</form>
</body>
</html>