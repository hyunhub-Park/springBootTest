<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ContentType Mapping</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">
document.addEventListener("DOMContentLoaded", function()
		{
	 let postBtn = document.getElementById("postBtn");
	 let putBtn = document.getElementById("putJsonBtn");
	 let putXmlBtn = document.getElementById("putXmlBtn");
	 
	 postBtn.addEventListener("click", function()
			 {
	 let boardNo = document.getElementById("boardNo").value;
	 let title = document.getElementById("title").value;
	 let content = document.getElementById("content").value;
	 let writer = document.getElementById("writer").value;
	 
	 let boardObject = {
	 boardNo: boardNo,
	 title: title,
	 content: content,
	 writer: writer
	 };
	 
	 let xhr = new XMLHttpRequest();
	 let url = "/board/" + boardNo;
	 xhr.open("POST", url, true);
	 xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
	 
	 // 서버로부터 답변 받을 시 작동되는 handler(callback) 함수.
	 xhr.onload = function() {
	 if (xhr.status === 200) {
	 let result = xhr.responseText;
	 console.log("result: " + result);
	 if (result === "SUCCESS") {
	 alert("SUCCESS");
	 } else {
	 // Handle other responses or errors if needed
	 }
	 } else {
	 console.error("Request failed. Status: " + xhr.status);
	 // Handle error scenario if needed
	 }
	 };
	 
	 // 서버로부터 요청 시, 문제점이 발생할 때 callback 함수.
	 xhr.onerror = function() {
	 console.error("Request failed. Network error.");
	 // Handle network errors if needed
	 };
	 
	 xhr.send(JSON.stringify(boardObject));
	 });
	 
	 putJsonBtn.addEventListener("click", function() {
	 let boardNo = document.getElementById("boardNo").value;
	 let title = document.getElementById("title").value;
	 let content = document.getElementById("content").value;
	 let writer = document.getElementById("writer").value;
	 
	 let boardObject =
	 {
		 boardNo: boardNo,
		 title: title,
		 content: content,
		 writer: writer
	 };
	 
	 let xhr = new XMLHttpRequest();
	 let url = "/board/" + boardNo;
	 
	 xhr.open("PUT", url, true);	// true : 비동기식, false : 동기식.
	 xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
	 
	 xhr.onload = function()
	 {
		 if (xhr.status === 200)
		 {
			 let result = xhr.responseText;
			 console.log("result: " + result);
			 if (result === "SUCCESS")
			 {
				 alert("SUCCESS");
			 } else
			 {
				 // Handle other responses or errors if needed
			 }
		 } else
		 {
			 console.error("Request failed. Status: " + xhr.status);
		 	// Handle error scenario if needed
		 }
	 };
	 
	 xhr.onerror = function() {
		 console.error("Request failed. Network error.");
		 // Handle network errors if needed
		 };
		 
		 xhr.send(JSON.stringify(boardObject));
		 });


</script>


<body>
	<h1>Ajax Home</h1>
	<form>
		boardNo: <input type="text" name="boardNo" value="" id="boardNo"><br>
		title: <input type="text" name="title" value="" id="title"><br>
		content: <input type="text" name="content" value="" id="content"><br>
		writer: <input type="text" name="writer" value="" id="writer"><br>
	</form>
	<div>
		<button id="postBtn">수정(post)</button>
		<button id="putBtn">수정(put)</button>
	</div>
</body>

</html>