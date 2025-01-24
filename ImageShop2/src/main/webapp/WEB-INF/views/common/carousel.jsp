<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/test.js"></script>
<script src="https://kit.fontawesome.com/b551008ea2.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/css/carousel.css">
</head>
<body onload="carousel();">
	<div class="slideShow">
		<!-- slideShow안에 3명의 자식. -->
		<!-- onmouseenter="" 안씀. -->
		<div class="slideShow_slides">
			<a href="#"><img src="/image/slide_01.jpg" alt="slide-1"></a> <a
				href="#"><img src="/image/slide_02.jpg" alt="slide-2"></a> <a
				href="#"><img src="/image/slide_01.jpg" alt="slide-3"></a> <a
				href="#"><img src="/image/slide_02.jpg" alt="slide-4"></a>
		</div>

		<!-- 아이콘. -->
		<div class="slideShow_nav">
			<a href="#" class="pre"><i
				class="fa-solid fa-chevron-left fa-2xs"></i></i></a> <a href="#"
				class="next"><i class="fa-solid fa-chevron-right fa-2xs"></i></i></a>
		</div>

		<div class="slideShow_indicator">
			<a href="#" class="active"><i class="fa-solid fa-circle fa-2xs"></i></i></a>
			<a href="#"><i class="fa-solid fa-circle fa-2xs"></i></a> <a href="#"><i
				class="fa-solid fa-circle fa-2xs"></i></a> <a href="#"><i
				class="fa-solid fa-circle fa-2xs"></i></a>
		</div>
	</div>
</body>
</html>