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
<a href="/CLProject/levels/list">Levels</a>
<a href="/CLProject/enemies/list">Enemies</a>
<a href="/CLProject/quotes/list">Quotes</a>
</div>

<table>
	<tr>
		<th>Id</th>
		<th>Level Name</th>
		<th>Level Enemy</th>

		
	</tr>
	<c:forEach var="d" items="${dungeons}">
		<tr>
			<td><c:out value="${d.id}"/></td>
			<td><c:out value="${d.level.name}"/></td>
			<td><c:out value="${d.level.enemy.name}"/></td>
			
			
			
			
	
	</c:forEach>
</table>
</body>
</html>