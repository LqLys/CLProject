<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" modelAttribute="dungeon">
		<form:errors path="*"/><br>
				
		Level: <form:select path="level" items="${levels}" itemLabel="name" itemValue="id"/><br>
		
	
		
		
		<input type="submit" value="Save">
	</form:form>
</body>
</html>