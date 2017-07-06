<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="http://users.pja.edu.pl/~s7505/main/gra/main.css">
<link href="https://fonts.googleapis.com/css?family=Shadows+Into+Light" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body class="background_${backgroundNr}">
<div class="wrap-all">
<header class="page-header">
    <ul class="menu">
      <li><a href="/CLProject">HOME PAGE</a></li>
      </ul>
      <div class="hp">
      	<p>${user.username}</p>
        <p>HP: ${user.currentHealth}</p>
        <p>Score: ${user.score}</p>
        <p>RP: ${user.rafalPoints}</p>
        
      </div>
</header>
<section class="main">
  <div class="picture_${enemy.id}">
  </div>
  <p class="question"> ${riddle.text}</p>
  <form:form method="post" modelAttribute="dungeonDTO">
			<form:errors path="*"/><br>
				<form:checkboxes path="answersStr" items="${answersStr}"/>
				<input type="submit" value="Save">
	</form:form>
</section>
		
		
		
		
		
				
		
</div>		
</body>
</html>