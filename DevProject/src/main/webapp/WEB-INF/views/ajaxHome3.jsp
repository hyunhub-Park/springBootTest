<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX HOME3</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function()
	{
		$("#getBtn").on("click", function()
		{
			let boardNo = $("#boardNo"); 
			let boardNoVal = boardNo.val();
			console.log(boardNoVal);
			
				$.get("/board/" + boardNoVal, function(result)
				{
					console.log("result " + result);
					// 객체로 넘어왔으니, stringify로 변환 필요.
					const obj = JSON.stringify(result);
					// const obj = JSON.parse(result);
					console.log("parse result " + obj);
					//alert("result " + result);
					alert("result " + obj);
				}
			);
		});
	});
</script>

<body>
	<h1>Ajax Home3</h1>
	<form>
		boardNo: <input type="text" name="boardNo" value="" id="boardNo"><br>
		title: <input type="text" name="title" value="" id="title"><br>
		content: <input type="text" name="content" value="" id="content"><br>
		writer: <input type="text" name="writer" value="" id="writer"><br>
	</form>
	<div>
		<button id="getBtn">객체 요청(get type)</button>
	</div>
</body>
</html>