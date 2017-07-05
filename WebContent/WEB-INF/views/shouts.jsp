<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib	prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/CLProject">Home Page</a><br>
	<form:form method="post" modelAttribute="shout">
		<form:errors path="*"/><br>
			<form:input path="text"/><input type="submit" value="Shout">
	</form:form>
	Shouts<br>
	<c:forEach var="s" items="${shouts}">
		<p> ${fn:substring(s.created, 11, 16)} 	${s.user.username}: ${s.text}</p>
	</c:forEach>
</body>
</html>