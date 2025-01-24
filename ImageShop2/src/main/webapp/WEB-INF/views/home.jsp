<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Image Shop</title>
<!-- <script type="text/javascript" src="/js/test.js"></script> -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<!-- <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin> -->
<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
</head>
<body>
    <jsp:include page="./common/header.jsp" />
    <jsp:include page="./common/menu.jsp" />
    <jsp:include page="./common/carousel.jsp" />    
    <div align="center">
    <br>
    <br>
    <br>
        <h1>
            <spring:message code="common.homeWelcome" />
        </h1>
        <P>${serverTime}</P>
    </div>
    <jsp:include page="./common/footer.jsp" />
</body>
</html>