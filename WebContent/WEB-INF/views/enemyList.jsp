<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="http://users.pja.edu.pl/~s7505/main/tabej/main.css" />
<title>Enemies</title>
</head>
<body>
<header class="page-header">
    <ul class="menu">
      <li><a href="/CLProject">Home Page</a></li>
		<li><a href="/CLProject/levels/list">Levels</a></li>
		<li><a href="/CLProject/quotes/list">Quotes</a></li>
		<li><a href="/CLProject/riddles/list">Riddles</a></li>
		<li><a href="/CLProject/answers/list">Answers</a></li>
     
      </ul>
</header>

<a href="/CLProject/enemies/add">Add enemy</a>
<table>
	<tr>
		<th>Name</th>
		<th>Health Points</th>
		<th>Damage</th>
		<th>Quotes</th>
		<th>Found in</th>
		<th>Img Address</th>

		
	</tr>
	<c:forEach var="e" items="${enemies}">
		<tr>
			<td><c:out value="${e.name}"/></td>
			<td><c:out value="${e.healthPoints}"/></td>
			<td><c:out value="${e.damage}"/></td>
			<td><a href="/CLProject/quotes/list/${e.id}">Quotes</a></td>
			<td><a href="/CLProject/levels/list/${e.id}">Levels</a></td>
			<td><c:out value="${e.imgAddress}"/></td>
			
			
			
	
	</c:forEach>
</table>

</body>
</html>