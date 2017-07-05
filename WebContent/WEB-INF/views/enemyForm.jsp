<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form method="post" modelAttribute="enemy">
		<form:errors path="*"/><br>
		
		Name: <form:input path="name"/><br> 
		
		Health Points:<form:input path="healthPoints"/><br> 
		
		Damage: <form:input path="damage"/><br> 
		Image Adress <form:input path="imgAddress"/><br> 
		
		
		<input type="submit" value="Save">
	</form:form>
</body>
</html>