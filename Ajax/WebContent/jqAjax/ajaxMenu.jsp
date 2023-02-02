<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type = "text/css">

.left {
	float: left;
	width: 30%;
	background: #ccc;
}

.right {
	float: right;
	width: 65%;
}



</style>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){

	$("a").click(function() {
		console.log( $(this).attr("href"))
		
		$(".right").load($(this).attr("href"))
		
		
		//	<a>태그의 페이지이동(기본동작) 막기
		return false;
	})

})

</script>
</head>
<body>

<h1>AJAX 메뉴</h1>
<hr>

<div class="left">
	<a href="/ajax/ajax_02.jsp">Ajax 02</a><br><br>
	<a href="/ajax/ajax_02.jsp">Ajax 03</a><br><br>
	<a href="/ajax/ajax_02.jsp">Ajax 04</a>
</div>

<div class="right"></div>

</body>
</html>

















