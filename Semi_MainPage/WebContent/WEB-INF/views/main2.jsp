<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>���� �� ������</title>

<!-- ���� ��Ʈ -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
	
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="/resources/css/mainstyle2.css">

<!-- ��Ʈ��Ʈ�� -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style>
.carousel-inner>.carousel-item>img {
	width: 569px;
	height: 426.75px;
}
</style>
</head>

<body>
	<div class="wrap">
		<div class="intro_bg">
			<div class="video-area">
				<video width="100%" src="/resources/video/cheers02.mp4" autoplay
					muted loop></video>
				<div class="search_area">
					<form>
						<input type="search" placeholder="search" value="���� �� ������"/> <span>�˻�</span>
					</form>
				</div>
			</div>
			<div class="header">
				<div class="header_logo">
					<a href="/main"> <img width=100px;
						src='/resources/img/header_logo2.png' />
					</a>
				</div>
				<ul class="nav">
					<li><a href="/main">Ĭ���� �˻�</a></li>
					<li><a href="/main">Ĭ���� ����</a></li>
					<li><a href="/main">Ŀ�´�Ƽ �Խ���</a></li>
					<li><a href="/main">�����Խ���</a></li>
					<li><a href="/main">����</a></li>
					<li><a href="/main">���ǰԽ���</a></li>
				</ul>

				<c:if test="${not login }">
					<div class="login">
						<form>
							<button class="btn btn-info">�α���</button>
						</form>
					</div>
					<div class="join">
						<button class="btn btn-warning">ȸ������</button>
					</div>
				</c:if>

				<c:if test="${login }">
					<div class="mypage">
						<button>����������</button>
					</div>
					<div class="logout">
						<form>
							<button>�α׾ƿ�</button>
						</form>
					</div>
				</c:if>
				
			</div>
		</div>
	</div>
	
	<div class="main_text0">
		<h1>ABOUT US.</h1>
		<div class="contents"></div>

		<ul class="icons">
			<li>
				<div class="icon_img">
					<img width="200px" src="/resources/img/002.png" />
				</div>
				<div class="contents_bold">Ĭ���� �˻�</div>
				<div class="contents3">Ĭ���� ���� �˻� �������� �̵��մϴ�</div>
				<div class="more">MORE</div>
			</li>
			<li>
				<div class="icon_img">
					<img width="200px" src="/resources/img/004.png" />
				</div>
				<div class="contents_bold">Ĭ���� ����</div>
				<div class="contents3">�������� Ĭ���� �����Ǹ� �����غ�����</div>
				<div class="more">MORE</div>
			</li>
			<li>
				<div class="icon_img">
					<img width="200px" src="/resources/img/003.png" />
				</div>
				<div class="contents_bold">����</div>
				<div class="contents3">Ĭ���Ͽ� ���� ��� ���� �����Ͻ� �� �ֽ��ϴ�</div>
				<div class="more">MORE</div>
			</li>
		</ul>
	</div>

	<div class="main_text1">
		<h1>BEST Ĭ���� ������</h1>
		<div class="contents1">�̹���, ���ƿ䰡 ���� Ĭ���� ������.</div>
		
		<!-- ���� �����̵� 01 -->
		<div class="service">
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
			<div class="photo_slide" style="width: 569px; height: 426.75px">
				<div id="demo" class="carousel slide" data-ride="carousel">
					<div class="carousel-inner">
						<!-- �����̵� �� -->
						<div class="carousel-item active">
							<!--����-->
							<img class="d-block w-100" src="/resources/img/junebug.jpg"
								alt="First slide">
							<div class="carousel-caption d-none d-md-block">
								<h5 style="color: #f0f4f5">�ع�(June Bug)</h5>
							</div>
						</div>
						<div class="carousel-item">
							<img class="d-block w-100" src="/resources/img/junebug.jpg"
								alt="Second slide">
							<div class="carousel-caption d-none d-md-block">
								<h5 style="color: #f0f4f5">�ع�(June Bug)</h5>
							</div>
						</div>
						<div class="carousel-item">
							<img class="d-block w-100" src="/resources/img/junebug.jpg"
								alt="Third slide">
							<div class="carousel-caption d-none d-md-block">
								<h5 style="color: #f0f4f5">�ع�(June Bug)</h5>
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
			<!-- 				<div class="contents3"> -->
			<!-- 					<h2>�ع� (June Bug)</h2> -->
			<!-- 					'6���� ����'��� �ǹ̷�, �ʷ��� �̱׷��� ������ �׾߸��� ���������� �����Ų��. -->
			<!-- 					<br>���, �ٳ���, ���ڳ�, ���ξ���, ���� 5���� ���� ���� ������ ���� ������ Ĭ���� -->
			<!-- 				</div> -->
		</div>
		<div class="main_text1">
			<h1>famous Ĭ���� ������</h1>
			<div class="contents1">�̹���, ���ƿ䰡 ���� �Ϲ��� ������.</div>
			
			<!-- ���� �����̵� 02 -->
			<div class="service">
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
				<div class="photo_slide" style="width: 569px; height: 426.75px">
					<div id="demo2" class="carousel slide" data-ride="carousel">
						<div class="carousel-inner">
							<!-- �����̵� �� -->
							<div class="carousel-item active">
								<!--����-->
								<img class="d-block w-100" src="/resources/img/junebug.jpg"
									alt="First slide">
								<div class="carousel-caption d-none d-md-block">
									<h5 style="color: #f0f4f5">�ع�(June Bug)</h5>
								</div>
							</div>
							<div class="carousel-item">
								<img class="d-block w-100" src="/resources/img/junebug.jpg"
									alt="Second slide">
								<div class="carousel-caption d-none d-md-block">
									<h5 style="color: #f0f4f5">�ع�(June Bug)</h5>
								</div>
							</div>
							<div class="carousel-item">
								<img class="d-block w-100" src="/resources/img/junebug.jpg"
									alt="Third slide">
								<div class="carousel-caption d-none d-md-block">
									<h5 style="color: #f0f4f5">�ع�(June Bug)</h5>
								</div>
							</div>
							<!-- / �����̵� �� �� -->
							<!-- ���� ������ ȭ��ǥ ��ư -->
							<a class="carousel-control-prev" href="#demo2" data-slide="prev">
								<span class="carousel-control-prev-icon" aria-hidden="true"></span>
								<!-- <span>Previous</span> -->
							</a> <a class="carousel-control-next" href="#demo2" data-slide="next">
								<span class="carousel-control-next-icon" aria-hidden="true"></span>
								<!-- <span>Next</span> -->
							</a>
							<!-- / ȭ��ǥ ��ư �� -->
							<!-- �ε������� -->
							<ul class="carousel-indicators">
								<li data-target="#demo2" data-slide-to="0" class="active"></li>
								<!--0�����ͽ���-->
								<li data-target="#demo2" data-slide-to="1"></li>
								<li data-target="#demo2" data-slide-to="2"></li>
							</ul>
							<!-- �ε������� �� -->
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="main_text2">
			<ul>
				<li>
					<div>
						<h1>CONTACT</h1>
					</div>
					<div>1 : 1 ���� �Խ���</div>
					<div class="more2">�� �˾ƺ���</div>
				</li>
				<li><img src="/resources/img/cocktail_bg02.jpg"></li>
			</ul>
		</div>
	</div>


	<!-- �˾� �������� -->
	<div class="popup">
		<h4>���� ���� ���</h4>
		<br>
		<p>�ȳ��ϼ���. ���� �� ������ ���񽺰� �����Ͽ����ϴ�.
				<br>���� ��� ��Ź�帳�ϴ�.
		</p>
		<br>
		<div>
			<input type="checkbox" id="popup"> <label for="popup">�Ϸ�
				�Ⱥ���</label>
		</div>
		<div>
			<button id="close" class="btn btn-info">�ݱ�</button>
		</div>
	</div>

	<!-- �˾� ��ũ��Ʈ -->
	<script type="text/javascript" src="/resources/script/popup_cookie.js"></script>

</body>

<footer>
	<div class="footer_logo">
		<img width=100px; src='/resources/img/header_logo2.png' />
	</div>
	<div class="footer_content">
		COMPANY. ���� �� ������ <br> TEAM. ����, ����ȫ, ������, �̴ٿ�, ������, ȫ��ǥ<br>
		COPYRIGHT 2021. ���� �� ������. ALL RIGHTS RESERVED.
	</div>
</footer>

</html>















