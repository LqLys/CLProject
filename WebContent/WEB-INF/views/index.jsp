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
<link rel="stylesheet" href="http://users.pja.edu.pl/~s7505/CLcss/main.css">
<link href="https://fonts.googleapis.com/css?family=Shadows+Into+Light" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<header class="page-header">
    <ul class="menu">
      <li><a href="users/list">Users</a></li>
      <li><a href="enemies/list">Manage Stuff</a></li>
      <li>
      <c:choose>
		<c:when test="${loggedUser.loggedIn==true }">
			<a href="users/logout">Logout</a>
		</c:when>
		<c:otherwise>
			<a href="users/login">Login</a>		
		</c:otherwise>
	</c:choose>
	    
      </li>
      <c:if test = "${loggedUser.loggedIn==false}">
          <li><a href="users/register">Register</a></li>
      </c:if>
      </ul>
</header>
<section class="shout-box">
  <div class="shout">
  	<c:forEach var="s" items="${shouts}">
			<p>${fn:substring(s.created, 11, 16)}: ${s.user.username}: ${s.text}<p>
	</c:forEach>
  </div>
    <c:if test = "${loggedUser.loggedIn==true}">
	    <form:form method="post" modelAttribute="shout" action="shouts" class="form-main">
			<form:errors path="*"/>
				<form:input path="text"/><br>
				<input type="submit" value="Shout">
		</form:form>
	</c:if>
</section>

<section class="gates">
  <div class="door">
  <a href="dungeons/frontEnd"><img src="http://users.pja.edu.pl/~s7505/images/img/door-575566_1280.png" /></a>
	<a href="dungeons/theBackEnd"><img src="http://users.pja.edu.pl/~s7505/images/img/door-575976_1920.png"/></a>
</div>
<div class="sign">
  <a class="front" href="">front end</a>
  <a href="">back end</a>
</div>
</section>
	
	
</body>
</html>