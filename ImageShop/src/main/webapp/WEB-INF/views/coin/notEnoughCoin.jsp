<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<jsp:include page="/WEB-INF/views/common/menu.jsp" />
	<div align="center">
		<h2>
			<spring:message code="coin.header.chargeCoin" />
		</h2>

		<p>
			<spring:message code="coin.notEnoughCoin" />
		</p>

		<a href="charge"><spring:message code="coin.charge" /></a>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>