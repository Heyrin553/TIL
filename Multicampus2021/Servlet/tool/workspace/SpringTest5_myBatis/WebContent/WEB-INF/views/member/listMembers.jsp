<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>no</th><th>id</th><th>pw</th><th>name</th><th>date</th>
		</tr>

		<c:forEach var="m" items="${memberList }" varStatus="i" >
			<tr>
				<td>${i.count }</td>
				<td>${m.id }</td>
				<td>${m.pw }</td>
				<td>${m.name }</td>
				<td>${m.date }</td>	
				<td><a href="removeMember.do?id=${m.id }">삭제하기</a></td>			
			</tr>
		</c:forEach>
	</table>
</body>
</html>
