<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>오늘 뭐 마시지 - </title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/resources/css/mainstyle.css">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
<style>
.carousel-inner>.carousel-item>img {
	width: 569px;
	height: 426.75px;
}
a {
	text-decoration: none;
	color: #000000;
}

a:hover {
	color: #ff0000;
}

/* nav tag */
nav ul {
	padding-top: 10px;
} /*  상단 여백 10px  */
nav ul li {
	display: inline; /*  세로나열을 가로나열로 변경 */
	border-left: 1px solid #999; /* 각 메뉴의 왼쪽에 "|" 표시(분류 표시) */
	font: bold 30px Dotum; /* 폰트 설정 - 12px의 돋움체 굵은 글씨로 표시 */
	padding: 0 10px; /* 각 메뉴 간격 */
}

nav ul li:first-child {
	border-left: none;
} /* 메뉴 분류중 제일 왼쪽의 "|"는 삭제     */
}

</style>

<script type="text/javascript">

 	function selectChange(value){
		$.ajax({
			type: 'post',
			url: '/shopping/order?category=${category}',
			data:{
				'order': value
			},
			dataType: 'json',
			success: function(data){
				var page_html = "";
				console.log("success");
				$.each(data, function(index, item){
				
				
					$('#list').empty();
					page_html += "<div class='col-sm-6 col-md-4' style='float: left;'>";
					
					page_html += "<div class='thumbnail' style='height: 400px;'>";
					
					page_html += "<img src='" + data[index].shopping_img_link + "' style='height: 201.31px;' />";
					page_html += "<div class='caption'>";
					page_html += "<h3>"+data[index].shopping_product_title+"</h3>";
					page_html += "<p>" + data[index].shopping_product_content+"</p>";
					page_html += "<p>가격 : " + data[index].shopping_product_price+"￦</p>";
					page_html += "<p>";
					page_html += "<a href='"+ data[index].shopping_product_link+"'";
					page_html += "class='btn btn-primary' role='button'>구매사이트</a>";
					page_html += "</p>";
					page_html += "</div>";
					page_html +="</div>";
					page_html +="</div>";
					
					$('#list').append(page_html);
				})
			}
		})
	}

 

 


</script>
</head>

<body>
	<div class="wrap">
		<div class="header">
				<ul class="nav">
					<li>
						<div class="header_logo">
							<a href="/main"> <img width=100px;
								src='/resources/img/header_logo2.png' />
							</a>
						</div>
					</li>
					<li><a href="/official/main">칵테일 검색</a></li>
					<li><a href="/custom/main">칵테일 제작</a></li>
					<li><a href="/free/list">자유게시판</a></li>
					<li><a href="/shopping/main">쇼핑</a></li>
					<li><a href="/qna/write">문의하기</a></li>
					<c:if test="${empty login or not login }">
						<li>
							<div class="login">
								<form>
									<button type="reset" onclick='location.href="/kh1/login";'
										class="btn btn-info">로그인</button>
								</form>
							</div>
							<div class="join">
								<button type="reset" onclick='location.href="/kh1/join";'
									class="btn btn-warning">회원가입</button>
							</div>
						</li>
					</c:if>
					<c:if test="${login }">
						<li>
							<div class="login">
							<button type="reset" onclick='location.href="/mypage/main";' 
								class="btn btn-info">마이페이지</button>
							</div>
							<div class="join">
								<form>
									<button type="reset" class="btn btn-warning"
										onclick='location.href="/kh1/logout";'>로그아웃</button>
								</form>
							</div>
						</li>
					</c:if>
				</ul>
		</div>
	</div>

	<div class="content_area">





<div style="width: 80%; height: 90%; margin: 0 auto;">
	<div>

		<nav style="text-align: center;">
			<ul>
				<li><a href="/shopping/list?category=alchol">주류</a></li>
				<li><a href="/shopping/list?category=tool">칵테일 도구</a></li>
				<li><a href="/shopping/list?category=food">음식 재료</a></li>
			</ul>
		</nav>
		<select id="order" value="이름 오름차순" onchange="selectChange(this.value)">
			<option value="name_ASC">이름 오름차순</option>
			<option value="name_DESC">이름 내림차순</option>
			<option value="price_ASC">가격 오름차순</option>
			<option value="price_DESC">가격 내림차순</option>
		</select>
	</div>
	
	<div class="row"  id="list">
		<c:forEach items="${shoppingBoardList}" var="shoppingboard">
			<div class="col-sm-6 col-md-4" style="float: left;">
				<div class="thumbnail" style="height: 400px;">
					<img src="${shoppingboard.shopping_img_link}"
						style="height: 201.31px;" />
					<div class="caption">
						<h3>${shoppingboard.shopping_product_title}</h3>
						<p>${shoppingboard.shopping_product_content}</p>
						<p>가격 : ${shoppingboard.shopping_product_price }￦</p>
						<p>
							<a href="${shoppingboard.shopping_product_link}"
								class="btn btn-primary" role="button">구매사이트</a>
						</p>
						
					</div>
				</div>
			</div>
		</c:forEach>
	</div>


</div>

<c:import url="/WEB-INF/views/layout/footer.jsp" />


