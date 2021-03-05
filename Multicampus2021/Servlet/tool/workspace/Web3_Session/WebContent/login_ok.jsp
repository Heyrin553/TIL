<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- <%
String id=session.getAttribute("id");
out.write(id);
%> --%>
	${id }님 로그인되셨습니다😉
		<form action="main">
		<input type="hidden" name="sign" value="logout"> <input
			type="submit" value="logout">

	</form>

	<hr>
	<form action="main">
	<input type="hidden" name="sign" value="basketInsert">
	<input type="radio" name="product" value="apple">>apple<br>
	<input type="radio" name="product" value="banana">banana<br>
	<input type="submit" value="장바구니 넣기">
	</form>

</body>
</html>