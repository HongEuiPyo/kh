<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>부트스트랩Carousel</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style>
.carousel-inner>.carousel-item>img {  width: 569px; height: 426.75px; 
	
}
</style>
</head>
<body>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script> $('.carousel').carousel({ interval: 2000 //기본 5초 }) </script>
	<div style="width: 569px; height: 426.75px">
	<div id="demo" class="carousel slide" data-ride="carousel">
		<div class="carousel-inner">
			<!-- 슬라이드 쇼 -->
			<div class="carousel-item active">
				<!--가로-->
				<img class="d-block w-100"
					src="/resources/img/junebug.jpg"
					alt="First slide">
				<div class="carousel-caption d-none d-md-block">
					<h5>준벅(June Bug)</h5>
					<p>
					'6월의 벌레'라는 의미로, 초록의 싱그러운 색깔이 그야말로 여름벌레를 연상시킨다.
					<br>멜론, 바나나, 코코넛, 파인애플, 레몬 5가지 맛이 나는 도수가 낮은 달콤한 칵테일
					</p>
				</div>
			</div>
			<div class="carousel-item">
				<img class="d-block w-100"
					src="/resources/img/junebug.jpg"
					alt="Second slide">
				<div class="carousel-caption d-none d-md-block">
					<h5>준벅(June Bug)</h5>
					<p>
					'6월의 벌레'라는 의미로, 초록의 싱그러운 색깔이 그야말로 여름벌레를 연상시킨다.
					<br>멜론, 바나나, 코코넛, 파인애플, 레몬 5가지 맛이 나는 도수가 낮은 달콤한 칵테일
					</p>
				</div>
			</div>
			<div class="carousel-item">
				<img class="d-block w-100"
					src="/resources/img/junebug.jpg"
					alt="Third slide">
				<div class="carousel-caption d-none d-md-block">
					<h5>준벅(June Bug)</h5>
					<p>
					'6월의 벌레'라는 의미로, 초록의 싱그러운 색깔이 그야말로 여름벌레를 연상시킨다.
					<br>멜론, 바나나, 코코넛, 파인애플, 레몬 5가지 맛이 나는 도수가 낮은 달콤한 칵테일
					</p>
				</div>
			</div>
			<!-- / 슬라이드 쇼 끝 -->
			<!-- 왼쪽 오른쪽 화살표 버튼 -->
			<a class="carousel-control-prev" href="#demo" data-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<!-- <span>Previous</span> -->
			</a> <a class="carousel-control-next" href="#demo" data-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<!-- <span>Next</span> -->
			</a>
			<!-- / 화살표 버튼 끝 -->
			<!-- 인디케이터 -->
			<ul class="carousel-indicators">
				<li data-target="#demo" data-slide-to="0" class="active"></li>
				<!--0번부터시작-->
				<li data-target="#demo" data-slide-to="1"></li>
				<li data-target="#demo" data-slide-to="2"></li>
			</ul>
			<!-- 인디케이터 끝 -->
		</div>
		</div>
		</div>
</body>
</html>

