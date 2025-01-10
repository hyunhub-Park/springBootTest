<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		환영합니다.
		<br>
		<spring:message code="welcome.message" />
		<br>
		<spring:message code="welcome.message" arguments="홍길동" />
	</h1>
	
	<P>The time on the server is ${serverTime}.</P>

	<h1>Spring Boot</h1>
	<div>userId : ${userId}</div>
	<div>password : ${password}</div>
</body>
</html>