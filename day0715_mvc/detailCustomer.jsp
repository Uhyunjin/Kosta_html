<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		document.querySelector("#delete_btn").onclick = function(event){
			let re = confirm("정말로 삭제할까요?");
			if(re == false){
				event.preventDefault();
				return false;
			}
		}
	}
</script>
</head>
<body>
	<h2>고객 상세</h2>
	<hr>
	고객번호 : ${c.custid }<br>
	고객이름 : ${c.name }<br>
	고객주소 : ${c.address }<br>
	고객전화 : ${c.phone }<br>
	<hr>
	<a href="updateCustomer.do?custid=${c.custid }">수정</a>
	<a id="delete_btn" href="deleteCustomer.do?custid=${c.custid }">삭제</a>
</body>
</html>














