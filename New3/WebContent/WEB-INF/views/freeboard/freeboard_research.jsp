<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp"/>

<script type="text/javascript">
$(document).ready(function() {
	$("#btnwrite").click(function() {
		location.href="/free/write";
	});
	
	$("#btnSearch").click(function(){
		if( $("#btnSearch").val() == null){
			alert("검색어를 입력하세요");
			return ;
		}
		location.href="/free/search";
	})
});
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
	
<div style="width:100%; height: 100%; position: relative;">
<div style="width:60%; margin: 0 auto;">
<h1>자유게시판 - 검색 결과</h1>

<hr>
</div>

<div style="width:60%; margin: 0 auto;">
<table class="table table-striped">
<tr>
	<th style="width:6%; text-align:center;">글번호</th>
	<th style="width:55%;">제목</th>
	<th style="width:12%;">작성자</th>
	<th style="width:6%;">조회수</th>
	<th style="width:13%;">작성일</th>
</tr>

<div style="margin: auto 5%;">
<c:forEach items="${boardList }" var="board">
<tr>
	<td>${board.free_board_no }</td>
	<td>
		<a href="/free/view?freeboardno=${board.free_board_no }">
		${board.free_board_title }
		</a>
	</td>
	<td>${board.user_nickname}</td>
	<td>${board.free_board_hit }</td>
	<td>${board.free_board_date }</td>
</tr>
</c:forEach>

</table>

<button id="btnwrite" class="btn btn-info float-right" style="float:right">글 쓰기</button>
<c:import url="/WEB-INF/views/layout/searchpaging.jsp"/>






<form action="<%=request.getContextPath() %>/free/search" method="get">
<div style="text-align:center">
<select id="type" name="type">
	<option value="title">제목</option>
	<option value="content">본문 내용</option>
	<option value="writer">작성자</option>
</select>
<input type="text" id="search" name="search"/>
<button type="submit" class="btn btn-default btn-sm" id="btnSearch">검색</button>
<input type="hidden" id="searchvalue" value="${searchvalue }"/>
<input type="hidden" id="typevalue" value="${typevalue }"/>
</div>
</form>

</div>
</div>

</body>
<c:import url="/WEB-INF/views/layout/footer.jsp" />