<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>    
<link rel="stylesheet" type="text/css" href="/resources/css/cards.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
      
</head>

<style>
.nav>li>a {
    position: static;
    display: flex;
    padding: 0;
    font-size: 16px;
}
</style>

<body>
<br><br><br><br><br>
<!-- 검색창 -->
<div class="search-bar">
	<form name="searchForm" action="/custom/list" method="get">
	<select id="category" name="category" value="${category }">
   		<option value="all">전체</option>
   		<option value="title">제목</option>
   		<option value="detail">내용</option>
   		<option value="nickname">글쓴이</option>
  	</select>
	<input type="text" name="search" value="${search }" autocomplete="off" 
	id="search" onkeyup="searchFunction()" placeholder="검색어를 입력하세요">
	<input type="submit" id="btnSearch" value="찾기">
	</form>
</div>


<div class="main">

<!-- 카드보드형태 -->
<div class="cards" id="card">
	<c:forEach var="c" items="${list }">
	<div class="card">
	<div class="card_image" id="card_thumbnail${c.custom_board_no })">
		<!-- 첨부파일이 이미지가 아니거나 없을 경우 -->
		<img src="/resources/img/Dry Martini.jpg" />
	</div>
	<div class="card_title">
		<h3>${c.custom_board_title }</h3>
	</div>
	<div class="card_desc">
		<p>${c.custom_board_content }</p>
	</div>
	<div class="card_info">
		<div>
			<i class="material-icons">thumb_up</i> ${c.custom_board_vote }
			<a>by ${c.user_nickname }</a>
		</div>
		<div>
			<a class="card_link" href="/custom/view?custom_no=${c.custom_board_no }">Read More...</a>
		</div>
	</div>
	</div>
	</c:forEach>
</div>


</div>


</body>

<%-- 맨위로 버튼 --%>
<button id="topButton" onclick="toTheTop()">맨 위로</button>

<!-- 최상단으로 버튼 스크립트 -->
<script type="text/javascript">
var topButton = document.getElementById("topButton");
//스크롤 시 scrollFunction 동작
window.onscroll = function() {
	scrollFunction()	
};
//버튼이 나타나게 함
function scrollFunction(){
	console.log("[TEST] You are scrolling!") //테스트용
	//스크롤을 통해 20줄 이상 내려가면 
	if(document.body.scrollTop > 20 || document.documentElement.scrollTop > 20 ){
		topButton.style.display = "block";	
	} else {
		topButton.style.display = "none";
	}
}
//화면 최상단으로 보내는 기능
function toTheTop(){
	window.scrollTo(0,0);
}

</script>

<c:import url="/WEB-INF/views/layout/custom_paging.jsp" />
<c:import url="/WEB-INF/views/layout/footer.jsp" /> 