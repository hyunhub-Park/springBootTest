<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<spring:message code="common.error.defaultErrorOccurred" />
		</h2>

		<a href="javascript:window.history.back();"><spring:message
				code="common.error.backPage" /></a><br> <a href="/"><spring:message
				code="common.error.returnHome" /></a>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>