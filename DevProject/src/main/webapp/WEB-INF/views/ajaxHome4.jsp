<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX HOME4</title>
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
			
				$.ajax (
				{
					type : "get",
					url : "/board/" + boardNoVal,
					headers : {"Accept" : "application/json"},
					success : function (result)
					{
						console.log("result : " + result);
						alert(JSON.stringify(result));
					}
				});
		});
	});
</script>

<body>
	<h1>Ajax Home4</h1>
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