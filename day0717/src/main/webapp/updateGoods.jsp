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
<h2>상품 수정 페이지</h2>
<hr>
<br>
<form action="insertGoodsOK.do" method="post" enctype="multipart/form-data">
	상품번호 : <span>${vo.no }</span><input type="hidden" name="item" value=${vo.item }><br>
	상품이름 : <input type="text" name="item" value=${vo.item }><br>
	상품가격 : <input type="text" name="price" value=${vo.price }><br>
	상품수량 : <input type="text" name="qty" value=${vo.qty }><br>
	상품사진 : <input type="file" name="uploadFile" value=${vo.fname }><br>
	<br>
	<input type="submit" value="등록"><a href="listGoods.do"><input type="button" value="목록"></a>
</form>
</body>
</html>