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
      <li><a href="/CLProject/">Homepage</a></li>
     
      </ul>
</header>
<table>
	<tr>
		<th>Username</th>
		<th>Email</th>
		<th>Max Health</th>
		<th>Current Health</th>
		<th>Highest Score</th>
		<th>Edit</th>
		<th>Delete</th>

		
	</tr>
	<c:forEach var="u" items="${users}">
		<tr>
			<td><c:out value="${u.username}"/></td>
			<td><c:out value="${u.email}"/></td>
			<td><c:out value="${u.maxHealth}"/></td>
			<td><c:out value="${u.currentHealth}"/></td>
			<td><c:out value="${u.highestScore}"/></td>
			<td><a href="/CLProject/users/edit/${u.id}">Edit User</a></td>
			<td><a href="/CLProject/users/delete/${u.id}">Delete User</a></td>
			<td><a href="/CLProject/messages/send/${u.id}">Send Message</a></td>
			
			
	
	</c:forEach>


</table>
</body>
</html>