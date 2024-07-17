<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>제목</h2>
<hr>
<br>
<form action="insertGoodsOK.do" method="post" enctype="multipart/form-data">
	상품이름 : <input type="text" name="item"><br>
	상품가격 : <input type="text" name="price"><br>
	상품수량 : <input type="text" name="qty"><br>
	상품사진 : <input type="file" name="uploadFile"><br>
	<br>
	<input type="submit" value="등록"><a href="listGoods.do"><input type="button" value="목록"></a>
</form>
</body>
</html>