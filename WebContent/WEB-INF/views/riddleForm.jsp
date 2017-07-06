<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://users.pja.edu.pl/~s7505/form.css" />
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
<header class="page-header">
    <ul class="menu">
      <li><a href="/CLProject">Home Page</a></li>
		<li><a href="/CLProject/levels/list">Levels</a></li>
		<li><a href="/CLProject/quotes/list">Quotes</a></li>
		<li><a href="/CLProject/enemies/list">Enemies</a></li>
		<li><a href="/CLProject/answers/list">Answers</a></li>
     
      </ul>
</header>
<form:form method="post" modelAttribute="riddle">
		<form:errors path="*"/><br>
		
			Name: <form:input path="name"/><br> 
		  	Riddle: <form:input path="text"/><br> 
			
		
		<input type="submit" value="Save">
	</form:form>

</body>
</html>