<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<style type="text/css">

.container {
	width: 300vw;
	height: 400px;
	transition: transform 0.5s;
	overflow: hidden;
}

.inner {
	width: 100vw;
	height: 400px;
	float: left;
}

.inner > img {
/*  	width: 100%; */
}

</style>

</head>
<body style="margin: 0">


<div>
	<div class="container">
		<div class="inner">
			<img src="/resources/img/cocktail_bg02.jpg">
		</div>
	<div class="inner">
		<div>
			<img src="/resources/img/cocktail_bg02.jpg">
		</div>
	</div>
	<div class="inner">
		<div>
			<img src="/resources/img/cocktail_bg02.jpg">
		</div>
	</div>
</div>
</div>
<div>
<button class="button1">1</button>
<button class="button2">2</button>
<button class="button3">3</button>
</div>
<script>

// 	버튼2를 누르면
// 	transform: translate(-100vw)
	
	document.querySelector('.button1').addEventListener('click', function(){
		document.querySelector('.container').style.transform = 'translate(0vw)';
	});
	
	document.querySelector('.button2').addEventListener('click', function(){
		document.querySelector('.container').style.transform = 'translate(-100vw)';
	});
	
	document.querySelector('.button3').addEventListener('click', function(){
		document.querySelector('.container').style.transform = 'translate(-200vw)';
	});

</script>

</body>
</html>













