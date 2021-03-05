<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String name = "";
	name = (String) session.getAttribute("login_name");
	if (name == null) {
		name = "guest";
	}

	/* String name="guest"; 
	Cookie []all=request.getCookies();
	if(all!=null){
		for(Cookie c:all){
			if(c.getName().equals("myCookie")){
		name=c.getValue();
			}
		}
	}  */
	%>

	<%=name%>
	님 즐거운 쇼핑 되세요🙌
	<a href='basketView.jsp'><%=name%>님의 장바구니 보기</a>
	<hr>

	<form action="main">
		<input type="hidden" name="key" value="basketInsert"> 
		<input type="submit" value="장바구니 넣기">
		<table>
			<tr>
				<td><img src="img/냉장고.jpg" width="300px" height="300px"></td>
				<td><img src="img/TV.jpg" width="300px" height="300px"></td>
				<td><img src="img/세탁기.jpg" width="300px" height="300px"></td>
			</tr>
			<tr>
				<td><input type="radio" name="product" value="냉장고"></td>
				<td><input type="radio" name="product" value="TV"></td>
				<td><input type="radio" name="product" value="세탁기"></td>
			</tr>
		</table>
	</form>
	<br>


</body>
</html>