<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="http://users.pja.edu.pl/~s7505/main/tabej/main.css" />
<title>Insert title here</title>
</head>
<body>
<header class="page-header">
    <ul class="menu">
      <li><a href="/CLProject">Home Page</a></li>
		<li><a href="/CLProject/levels/list">Levels</a></li>
		<li><a href="/CLProject/enemies/list">Enemies</a></li>
		<li><a href="/CLProject/riddles/list">Riddles</a></li>
		<li><a href="/CLProject/answers/list">Answers</a></li>
     
      </ul>
</header>
<a href="/CLProject/quotes/add">Add quote</a>
<table>
	<tr>
		<th>Enemy Name</th>
		<th>Quote</th>

		
	</tr>
	<c:forEach var="q" items="${quotes}">
		<tr>
			<td><c:out value="${q.enemy.name}"/></td>
			<td><c:out value="${q.text}"/></td>
			
			
			
	
	</c:forEach>
</table>
</body>
</html>