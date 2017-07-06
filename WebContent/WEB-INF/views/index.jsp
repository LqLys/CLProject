<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
    <%@	taglib	prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://users.pja.edu.pl/~s7505/CLcss/style.css">
</head>
<body>
hello ${loggedUser.username} 
	<c:choose>
		<c:when test="${loggedUser.loggedIn==true }">
			<a href="users/logout" class="nav">Logout</a>
		</c:when>
		<c:otherwise>
			<a href="users/login" class="nav">Login</a>		<a href="users/register" class="nav">Register</a>
		</c:otherwise>
	</c:choose>
	<a href="users/list" class="nav">Users</a>
	<a href="enemies/list">Manage Stuff</a>
	
	<div class="shoutbox">
	<c:forEach var="s" items="${shouts}">
			<p>${fn:substring(s.created, 11, 16)}: ${s.user.username}: ${s.text}<p>
	</c:forEach>
	</div>
	<c:if test = "${loggedUser.loggedIn==true}">
	    <form:form method="post" modelAttribute="shout" action="shouts">
			<form:errors path="*"/><br>
				<form:input path="text"/><input type="submit" value="Shout">
		</form:form>
	</c:if>
	<a href="dungeons/theBackEnd"><img src="http://users.pja.edu.pl/~s7505/images/penguin.png" title="Enter the Backend"/></a>
	<a href="dungeons/frontEnd""><img src="http://users.pja.edu.pl/~s7505/images/penguin.png" title="Enter the frontend"/></a>
	<div class="loggedInUsers">
	<p>Logged in users</p>
	<c:forEach var="u" items="${loggedInUsers}">
			${u.username} 
	</c:forEach>
	</div>
</body>
</html>