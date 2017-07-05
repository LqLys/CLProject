<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="http://users.pja.edu.pl/~s7505/CLcss/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body class="background_${backgroundNr}">
<a href="/CLProject">Home Page</a>
		username: ${user.username}<br>
		HP ${user.maxHealth}/${user.currentHealth}
		
		enemy name: ${enemy.name}
		<img src="${enemy.imgAddress}"/>
		
</body>
</html>