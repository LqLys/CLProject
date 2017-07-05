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
<div>
<a href="/CLProject">Home Page</a>
<a href="/CLProject/enemies/list">Enemies</a>
<a href="/CLProject/quotes/list">Quotes</a>
</div>
<a href="/CLProject/levels/add">Add level</a>
<table>
	<tr>
		<th>Level Name</th>
		<th>Enemy</th>

		
	</tr>
	<c:forEach var="l" items="${levels}">
		<tr>
			<td><c:out value="${l.name}"/></td>
			<td><c:out value="${l.enemy.name}"/></td>
			
			
			
	
	</c:forEach>
</table>
</body>
</html>