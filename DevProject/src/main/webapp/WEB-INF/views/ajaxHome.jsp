<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajaxHome Headers Mapping</title>
</head>
<script 
src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">
// 모든 html -> dom 객체 완료 됐을 시, 해당 함수 시작.
$(document).ready(function()
{
	// putBtn 클릭 시, 해당 함수 작동. (서버에 문자열 방식(ajax 비동기식)으로 데이터를 전송한 뒤, 전송 성공 유무를 리턴받아 출력함.)
	$("#putBtn").on("click", function()
{ var boardNo = $("#boardNo"); 
var title = $("#title");
var content = $("#content"); 
var writer = $("#writer");
var boardNoVal = boardNo.val(); 
var titleVal = title.val(); 
var contentVal = content.val(); 
var writerVal = writer.val();
var boardObject = {
boardNo : boardNoVal, 
title : titleVal, 
content : contentVal, 
writer : writerVal
};
$.ajax({
type : "put",
url : "/board/" + boardNoVal,
data : JSON.stringify(boardObject),
contentType : "application/json; charset=utf-8", 
success : function(result) {
console.log("result: " + result); 
if (result === "SUCCESS") {
alert("SUCCESS");
}
}
});
$("#putHeaderBtn").on("click", function()
{ var boardNo = $("#boardNo");
var title = $("#title"); 
var content = $("#content"); 
var writer = $("#writer");
var boardNoVal = boardNo.val(); 
var titleVal = title.val(); 
var contentVal = content.val(); 
var writerVal = writer.val();
var boardObject = {
boardNo : boardNoVal, 
title : titleVal, 
content : contentVal, 
writer : writerVal
};
$.ajax({
	type : "put",
	url : "/board/" + boardNoVal, 
	headers : {
	"X-HTTP-Method-Override" : "PUT"
	},
	data : JSON.stringify(boardObject),
	contentType : "application/json; charset=utf-8", 
	success : function(result) {
	console.log("result: " + result); 
	if (result === "SUCCESS") {
	alert("SUCCESS");
	}
	}
	});
	});
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
		<button id="putBtn">수정(put)</button>
		<button id="putHeaderBtn">수정(put with header)</button>
	</div>
</body>

</html>