<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/WEB-INF/views/layout/header.jsp" />
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

</style>


<script type="text/javascript">
$(document).ready(function(){
	
	$("#btnsearch").click(function(){
		
		$.ajax({
			type: 'post',
			url: '/shopping/search',
			data:{
				'search': $("#searchshopping").val()
			},
			dataType: 'json',
			success: function(data){
				var page_html = "";
				
				$.each(data, function(index, item){					
					$('#view').empty();
					page_html += "<div class='col-sm-6 col-md-4' style='float: left;'>";
					
					page_html += "<div class='thumbnail' style='height: 400px;'>";
					
					page_html += "<img src='" + data[index].shopping_img_link + "' style='height: 201.31px;' />";
					page_html += "<div class='caption'>";
					page_html += "<h3>"+data[index].shopping_product_title+"</h3>";
					page_html += "<p>" + data[index].shopping_product_content+"</p>";
					page_html += "<p>";
					page_html += "<a href='"+ data[index].shopping_product_link+"'";
					page_html += "class='btn btn-primary' role='button'>구매사이트</a>";
					page_html += "</p>";
					page_html += "</div>";
					page_html +="</div>";
					page_html +="</div>";
					
					$('#view').append(page_html);
				})
				
			}
		})
	})
	
})
</script>


<body>
	<div class="wrap">
		<div class="intro_bg2"
			style="width: 100%; height: 200px; background: black;">
			<div class="header">
				<div class="header_logo">
					<a href="/main"> <img width=100px;
						src='/resources/img/header_logo2.png' />
					</a>
				</div>
				<ul class="nav">
					<li><a href="/official/main">칵테일 검색</a></li>
					<li><a href="/custom/main">칵테일 제작</a></li>
					<li><a href="/free/list">자유게시판</a></li>
					<li><a href="/shopping/main">쇼핑</a></li>
					<li><a href="/searchbar">어디가서 마실까</a></li>
					<li><a href="/qna/write">문의게시판</a></li>
				</ul>

				<div class="navbar_togleBtn">
					<button class="btn btn-success">MENU</button>
				</div>

				<c:if test="${empty login or not login }">
					<div class="login">
						<form>
							<button type="reset" onclick='location.href="/mypage/main";'
								class="btn btn-info">로그인</button>
						</form>
					</div>
					<div class="join">
						<button type="reset" class="btn btn-warning"
							onclick='location.href="/kh1/logout";'>회원가입</button>
					</div>
				</c:if>

				<c:if test="${login }">
					<div class="mypage">
						<button type="reset" onclick='location.href="/mypage/main";'
							class="btn btn-info">마이페이지</button>
					</div>
					<div class="logout">
						<form>
							<button type="reset" class="btn btn-warning"
								onclick='location.href="/kh1/logout";'>로그아웃</button>
						</form>
					</div>
				</c:if>

			</div>
		</div>
	</div>


	<div class="content_area">

		<div style="width: 70%; height: 100%; margin: 0 auto;">
			<div class="navselect">
			<nav style="text-align: center;">
				<ul>
					<li><a href="/shopping/list?category=alchol">주류</a></li>
					<li><a href="/shopping/list?category=tool">칵테일 도구</a></li>
					<li><a href="/shopping/list?category=food">음식 재료</a></li>
				</ul>
			</nav>
			</div>
			<div class="row" id="view">
				<div class="col-sm-6 col-md-4" style="float: left;">
					<div class="thumbnail">
						<img
							src="https://images.pexels.com/photos/1283219/pexels-photo-1283219.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
							style="height: 201.31px;" />
						<div class="caption">
							<h3>주류 목록</h3>
							<p>칵테일에 사용되는 각종 주류들을 보러갑니다</p>
							<p>
								<a href="/shopping/list?category=alchol" class="btn btn-primary"
									role="button">목록 보기</a>
						</div>
					</div>
				</div>

				<div class="col-sm-6 col-md-4" style="float: left;">
					<div class="thumbnail">
						<img
							src="https://images.pexels.com/photos/2611814/pexels-photo-2611814.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
							style="height: 201.31px;" />
						<div class="caption">
							<h3>칵테일 도구</h3>
							<p>칵테일을 만드는데 필요한 각종 도구들을 보러갑니다</p>
							<p>
								<a href="/shopping/list?category=tool" class="btn btn-primary"
									role="button">목록 보기</a>
							</p>
						</div>
					</div>
				</div>

				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img
							src="https://images.pexels.com/photos/3596688/pexels-photo-3596688.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
							style="height: 201.31px;" />
						<div class="caption">
							<h3>음식</h3>
							<p>칵테일과 함께먹기 좋은 음식들을 보러 갑니다</p>
							<p>
								<a href="/shopping/list?category=food" class="btn btn-primary"
									role="button">목록 보기</a>
							</p>
						</div>
					</div>
				</div>

			</div>
			<br>
			<div style="text-align: center;">
				<input type="text" id="searchshopping" />
				<button id=btnsearch>검색</button>
			</div>
		</div>

</div>
</body>

<c:import url="/WEB-INF/views/layout/footer.jsp" />