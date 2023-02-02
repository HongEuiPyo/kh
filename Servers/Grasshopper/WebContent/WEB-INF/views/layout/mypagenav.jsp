<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- jQuery 2.2.4 -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>


<style>
* {
	text-decoration: none;
}

ul {
	list-style: none;
	padding: 0;
}

.nav1 {
	padding: 50px 50px 30px;
	display: flex;
	justify-content: space-between;
	align-items: center;
	display: flex;
}

.nav1 ul {
	display: flex;
	align-items: center;
}

.nav1 ul img {
	margin-right: 10px;
	width: 35px;
	height: 35px;
	border-radius: 50%;
}

.content {
	display: flex;
	align-content: center;
	align-items: center;
}

.menu {
	width: 230px;
	text-align: right;
	display: inline-block;
}

.menu h4 {
	font-weight: bold;
	font-size: 20px;
}

.menu span {
	display: block;
}

.contentAreaWrap {
	width: calc(100% - 200px);
}

.profileWrap {
	width: 100%;
	height: 100%;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

.profileWrap img {
	border-radius: 50%;
	width: 150px;
	height: 150px;
}

.menu a {
	color: #000000;
}

.menu a:hover {
	color: #adb5bd;
}

.nav1 a:hover{
	color: #000000;
}

.nav1 a {
	color:  #000000;
}

table {
}
</style>
	<div class="nav1">
		<h1><a href="/mypage/main">마이페이지</a></h1>
	</div>
	<div style="width: 250px; display: inline-block;">
		<ul class="menu">
			<li>
				<h4>프로필 설정</h4>
				<p>
					<a href="/mypage/update">프로필 관리</a>
				</p>
			</li>
			<li>
				<h4>나의 활동</h4>
				<p>
					<a href="/mypage/board/list">내가 쓴 게시글</a>
				</p>
				<p>
					<a href="/mypage/reply/list">내가 쓴 댓글</a>
				</p>
			</li>
			<li>
				<h4>쪽지 확인</h4>
				<p>
					<a href="/mypage/sendmessage">보낸 쪽지 확인</a>
				</p>
				<p>
					<a href="/mypage/recmessage">받은 쪽지 확인</a>
				</p>
			</li>
			<li>
				<h4>나의 문의 내역</h4>
				<p>
					<a href="/qna/write">문의 하기</a>
				</p>
				<p>
					<a href="/qna/list">문의 내역</a>
				</p>
			</li>
			<li>
				<h4>
					<a href="/mypage/unregister">회원 탈퇴</a>
				</h4>
			</li>
		</ul>
	</div>