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
<a href="/CLProject">Main Page</a><br>
Your received messages<br>
	<c:forEach var="r" items="${receivedMessages}">
		<p>
			From: ${r.sender.username}<br>
			Message<br> 
			${r.text}<br>
			Sent on: ${r.created}<br>
		</p>

	</c:forEach>
	
Your sent messages==========================<br>
	<c:forEach var="s" items="${sentMessages}">
		<p>
			To: ${s.receiver.username}<br>
			Message<br> 
			${s.text}<br>
			Sent on: ${s.created}<br>
		</p>

	</c:forEach>

</body>
</html>