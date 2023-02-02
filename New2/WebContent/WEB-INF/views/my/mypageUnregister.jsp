<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <c:import url="/WEB-INF/views/layout/mypagehd.jsp" /> --%>
<c:import url="/WEB-INF/views/layout/header.jsp" />
<link rel="stylesheet" type="text/css" href="/resources/css/mypage.css">
<style type="text/css">
a:link {
	text-decoration: none;
}
</style>
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





		<div style="width: 400px; height: 400px; margin: 150px auto;">
			<form form action="/mypage/unregister" method="post"
				class="form-horizontal">

				<div class="form-group">
					<label for="email" class="col-sm-2 control-label">Email</label>
					<div class="col-sm-10">
						<p class="form-control-static" id="email">${user_info.user_email }</p>
						<input type=hidden name="password2" id="password2"
							value="${user_info.user_password }">
					</div>
				</div>

				<div class="form-group">
					<label for="password" class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<input type="password" class="form-control"
							placeholder="Password를 다시 입력하세요" id="password" name="password">
					</div>
				</div>

				<div style="text-align: center;">
					<button type="button" id="btnUnregister"
						class="btn btn-primary ml-1">탈퇴</button>
					<button type="button" id="btnCancel" class="btn btn-primary ml-1">취소</button>
				</div>

			</form>

		</div>





		<script type="text/javascript">
			$(document).ready(function() {

				$("#btnUnregister").click(function() {

					if ($("#password").val() == $("#password2").val()) {

						var result = confirm("정말 탈퇴하시겠습니까?");

						if (result == true) {
							$("form").submit();
						}
					} else if ($("#password").val() != $("#password2").val()) {

						alert("비밀번호를 다시 입력해주세요");
						$("#password").val("");
						$("#password").focus();

					}

				});

				$("#btnCancel").click(function() {
					history.go(-1);
				});

			});
		</script>


		<c:import url="/WEB-INF/views/layout/footer.jsp" />