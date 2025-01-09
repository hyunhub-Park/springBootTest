<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX HOME 5 & 6</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function()
	{
	
		$("#inputFile").on("change", function(event)
		{
			console.log("change");
			let files = event.target.files;
			let file = files[0]; 
			
			console.log(file);
			console.log(event);
			
			let formData = new FormData(); 
			formData.append("file", file);
			
			$.ajax (
			{
				type : "post",
				url : "/member/uploadAjax", 
				data: formData, 
				dataType:'text', 
				processData: false, 
				contentType: false, 
				success: function(data)
				{
					alert(data);
				}
			});
		});
	});



	/*$(document).ready(function()
	{
		let userObjectArray =
		[
			{
				userId : "name01",
				password : "pw01"
			},
			{
				userId : "name02",
				password : "pw02"
			}
		];

		$.ajax (
		{
			type : "post",
			url : "/member/register06",
			data : JSON.stringify(userObjectArray),
			contentType : "application/json; charset=utf-8",
			success : function(result)
			{
				console.log("result: " + result);

				if (result === "SUCCESS")
				{
					alert("SUCCESS");
				}
			}
		});
	});*/
</script>

<body>
	<h1>Ajax Home 5 & 6</h1>
	<div>
		file : <input type="file" id="inputFile" multiple>
	</div>
</body>
</html>