<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@	taglib	prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://users.pja.edu.pl/~s7505/form.css" />
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
hello user<br>

<form:form method="post" modelAttribute="user">
		<form:errors path="*"/><br>
		email: <form:input path="email"/><br>
		password:<form:password path="password"/><br> 
		
		
		
		
		<input type="submit" value="Log in">
	</form:form>

</body>
</html>