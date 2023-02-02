<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>��Ʈ��Ʈ��Carousel</title>
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
	<script> $('.carousel').carousel({ interval: 2000 //�⺻ 5�� }) </script>
	<div style="width: 569px; height: 426.75px">
	<div id="demo" class="carousel slide" data-ride="carousel">
		<div class="carousel-inner">
			<!-- �����̵� �� -->
			<div class="carousel-item active">
				<!--����-->
				<img class="d-block w-100"
					src="/resources/img/junebug.jpg"
					alt="First slide">
				<div class="carousel-caption d-none d-md-block">
					<h5>�ع�(June Bug)</h5>
					<p>
					'6���� ����'��� �ǹ̷�, �ʷ��� �̱׷��� ������ �׾߸��� ���������� �����Ų��.
					<br>���, �ٳ���, ���ڳ�, ���ξ���, ���� 5���� ���� ���� ������ ���� ������ Ĭ����
					</p>
				</div>
			</div>
			<div class="carousel-item">
				<img class="d-block w-100"
					src="/resources/img/junebug.jpg"
					alt="Second slide">
				<div class="carousel-caption d-none d-md-block">
					<h5>�ع�(June Bug)</h5>
					<p>
					'6���� ����'��� �ǹ̷�, �ʷ��� �̱׷��� ������ �׾߸��� ���������� �����Ų��.
					<br>���, �ٳ���, ���ڳ�, ���ξ���, ���� 5���� ���� ���� ������ ���� ������ Ĭ����
					</p>
				</div>
			</div>
			<div class="carousel-item">
				<img class="d-block w-100"
					src="/resources/img/junebug.jpg"
					alt="Third slide">
				<div class="carousel-caption d-none d-md-block">
					<h5>�ع�(June Bug)</h5>
					<p>
					'6���� ����'��� �ǹ̷�, �ʷ��� �̱׷��� ������ �׾߸��� ���������� �����Ų��.
					<br>���, �ٳ���, ���ڳ�, ���ξ���, ���� 5���� ���� ���� ������ ���� ������ Ĭ����
					</p>
				</div>
			</div>
			<!-- / �����̵� �� �� -->
			<!-- ���� ������ ȭ��ǥ ��ư -->
			<a class="carousel-control-prev" href="#demo" data-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<!-- <span>Previous</span> -->
			</a> <a class="carousel-control-next" href="#demo" data-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<!-- <span>Next</span> -->
			</a>
			<!-- / ȭ��ǥ ��ư �� -->
			<!-- �ε������� -->
			<ul class="carousel-indicators">
				<li data-target="#demo" data-slide-to="0" class="active"></li>
				<!--0�����ͽ���-->
				<li data-target="#demo" data-slide-to="1"></li>
				<li data-target="#demo" data-slide-to="2"></li>
			</ul>
			<!-- �ε������� �� -->
		</div>
		</div>
		</div>
</body>
</html>

