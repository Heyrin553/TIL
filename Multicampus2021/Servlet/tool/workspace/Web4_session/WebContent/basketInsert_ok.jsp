<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
장바구니에 상품이 담겼습니다<hr>
<form action="main">
		<input type="hidden" name="sign" value="logout"> 
		<input type="submit" value="로그아웃">
	</form>
<a href='index.jsp'>홈으로 가기</a><br>
<a href='basketView.jsp'>장바구니 보기</a><br>
<a href='login_ok.jsp'>계속 쇼핑하기</a><br>


</body>
</html>