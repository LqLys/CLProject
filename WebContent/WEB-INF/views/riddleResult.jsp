<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://users.pja.edu.pl/~s7505/main/last-one/main.css" />
<link href="https://fonts.googleapis.com/css?family=Shadows+Into+Light" rel="stylesheet">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
<section class="main-bg">
    <div class="main">
      <p>your answer is ${riddleResult}</p>
      <p>your score: ${score}</p>
      <p>your remaining health: ${remainingHP}</p>
      <p>your current streak: ${streak}</p>
      <p>your current rafal points: ${RafPoints}</p>
      <c:if test = "${riddleResult==false}">
        	<p>Correct answer was: ${correctStr}</p>
      </c:if>
      
      <div class="buttons">
        <a href="/CLProject/dungeons/theBackEnd" class="button">Neeeeeeext</a>
        <a href="/CLProject/dungeons/arek" class="button">Opowiedz dowcip arkowi</a>
      </div>
    </div>
  </section>
	
</body>
</html>