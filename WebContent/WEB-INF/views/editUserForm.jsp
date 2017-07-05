<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@	taglib	prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" modelAttribute="user">
		<form:errors path="*"/><br>
		
		username: <form:input path="username"/><br> 
		max health: <form:input path="maxHealth"/><br> 
		current health: <form:input path="currentHealth"/><br> 
		
		password:<form:password path="password"/><br> 
		
		email: <form:input path="email"/><br> 
		
		
		<input type="submit" value="Save">
	</form:form>
</body>
</html>