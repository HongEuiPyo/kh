<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>사진 슬라이드</title>

<style type="text/css">
.section > input[id*="slide"] {
	display:none;
}
.section > .slidewrap {
	max-width:1200px;
	margin: 0 auto;
	overflow: hidden;
}
.section > .slidelist {
	white-space:nowrap;
	font-size: 0;
}
.section > slidelist > li {
	display: inline-block;
	vertical-align: middle;
	width: 100%;
	tansition: all .5s;
}
.section > .slidelist > li > a {
	display: block;
	position: relative;
}
.section > .slidelist > li > a > img {
	width: 100%;
}
.section > .slidelist > label {
	position: absolute;
	z-index: 10;
	top: 50%;
	transform:translateY(-50%);
	padding: 50px;
	cursor: pointer;
}
.section > .slidelist > .left {
	left: 30px;
	background:url('./img/left.png') center center / 100% no-repeat;
}

.section > .slidelist > .right {
	left: 30px;
	background:url('./img/right.png') center center / 100% no-repeat;
}

.section > .slide-control [class*="control"] {display:none;}
.section [id="slide01"].checked ~ .slidewrap .control01 {display:block;}
.section [id="slide02"].checked ~ .slidewrap .control01 {display:block;}
.section [id="slide03"].checked ~ .slidewrap .control01 {display:block;}

</style>

</head>
<body>

<div class="section">
	<input type="radio" name="slide01" checked>
	<input type="radio" name="slide02">
	<input type="radio" name="slide03">
	
	<div class="slidewrap">
		<ul class="slidelist">
			<li>
				<a>
					<label for="slide03" class="left"></label>
					<img src="/resources/img/oldpal.jpg">
					<label for="slide02" class="right"></label>
				</a>
			</li>
			<li>
				<a>
					<label for="slide01" class="left"></label>
					<img src="/resources/img/oldpal.jpg">
					<label for="slide03" class="right"></label>
				</a>
			</li>
			<li>
				<a>
					<label for="slide02" class="left"></label>
					<img src="/resources/img/oldpal.jpg">
					<label for="slide01" class="right"></label>
				</a>
			</li>
			
			<div class = "slide-control">
				<div class="control01">
					<label for="slide03" class="left"></label>
					<label for="slide02" class="right"></label>					
				</div>
				<div class="control02">
					<label for="slide01" class="left"></label>
					<label for="slide02" class="right"></label>					
				</div>
				<div class="control03">
					<label for="slide02" class="left"></label>
					<label for="slide01" class="right"></label>					
				</div>	
			</div>
			
			
		</ul>
	
	</div>
	
</div>

</body>
</html>