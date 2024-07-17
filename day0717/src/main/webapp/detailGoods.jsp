<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>제품 상세 페이지</h2>
<hr>
<br>
<table border="1" width="70%">

<tr>
	<td>제품번호</td>
	<td>제품명</td>
	<td>제품사진</td>
</tr>
<tr>
	<td>${vo.no }</td>
	<td>${vo.item }</td>
	<td><img src="images/${vo.fname }" width="150px"></td>
</tr>
</table>
<br>
<a href="updateGoods.do?no=${vo.no }"><input type="button" value="수정"></a>
<a href="deleteGoods.do?no=${vo.no }"><input type="button" value="삭제"></a>
<a href="listGoods.do"><input type="button" value="목록"></a>

</body>
</html>