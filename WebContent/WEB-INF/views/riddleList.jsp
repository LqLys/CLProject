<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/CLProject/riddles/add">Add Riddle</a>
<table>
	<tr>
		<th>Name</th>
		<th>Riddle</th>
		<th>Answer</th>
		<th>Is correct</th>
		

		
	</tr>
	<c:forEach var="r" items="${riddles}">
		<tr>
			<td><c:out value="${r.name}"/></td>
			<td><c:out value="${r.text}"/></td>
		</tr>
		<c:forEach var="a" items="${r.answers}">
			<tr>
				<td></td>
				<td></td>
				<td>${a.text}</td>
				<td>${a.correct}</td>
			</tr>
		
		</c:forEach>
		
			
			
	
	</c:forEach>
</table>

</body>
</html>