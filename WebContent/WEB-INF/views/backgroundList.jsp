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
<a href="/CLProject/quotes/list">Quotes</a>
<a href="/CLProject/dungeons/list">Dungeons</a>
</div>
<a href="/CLProject/backgrounds/add">Add background</a>
<table>
	<tr>
		<th>Name</th>
		<th>Img Address</th>

		
	</tr>
	<c:forEach var="b" items="${backgrounds}">
		<tr>
			<td><c:out value="${b.name}"/></td>
			<td><c:out value="${b.backgroundURL}"/></td>
			
			
	
	</c:forEach>
</table>

</body>
</html>