<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://users.pja.edu.pl/~s7505/main/murzyn/main.css" />
<link href="https://fonts.googleapis.com/css?family=Shadows+Into+Light" rel="stylesheet">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
 <section class="plaza">
    <div class="main">
    <p>Witaj w krainie suchych dowcipów</p>
    <p>Opowiedz dowcip Arkowi</p>
      <p>Current health: ${currentHealth}</p>
      <p>Available Rafal points: ${availableRafals}</p>
      <form:form method="post" modelAttribute="arekDTO">
		<form:errors path="*"/>
			<p>Ile rafalow chcesz uzyć?</p>
		<form:input path="pointsToSpend"/>
		<input type="submit" value="Say the joke!">
	</form:form>
    </div>
    <div class="nigga"></div>
  </section>
	
	
	
	
</body>
</html>