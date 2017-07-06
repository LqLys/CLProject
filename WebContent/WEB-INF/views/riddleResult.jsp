<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	your answer is ${riddleResult}<br>
	your score is ${score}<br>
	your remaining health is ${remainingHP}<br>
	your current streak is ${streak}<br>
	your current rafal points is ${RafPoints}<br>
	<c:if test = "${riddleResult==false}">
        	Correct answer was: ${correctStr}<br>
      </c:if>
	<a href="/CLProject/dungeons/theBackEnd">Neeeeeeext</a>
	<a href="/CLProject/dungeons/arek">Opowiedz dowcip arkowi</a>
</body>
</html>