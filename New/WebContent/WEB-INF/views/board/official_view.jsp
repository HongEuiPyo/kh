<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>    
<link rel="stylesheet" type="text/css" href="/resources/css/offcusstyle.css">
<link rel="stylesheet" type="text/css" href="/resources/css/messagePopup.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">


<div class="container">
	<!-- The Modal -->
	<div id="myModal" class="modal">

		<!-- Modal content -->
		<div class="modal-content">
			<span class="close">&times;</span>
			<h3>코멘트 입력 실패</h3>
			<br>
			<p>코멘트 글자수가 200자 이상입니다.</p>
		</div>

	</div>

	<div class="content-container">
		<div class="title-container">
			<h1 class="entry-title">
				<c:set var="cocktail_title"
					value="${fn:split(viewOfficial.official_cocktail_name,',')}" />
				${ cocktail_title[0]} | ${ cocktail_title[1]}
			</h1>
			<p class="title-sub-container">추천수 :
				${viewOfficial.official_cocktail_vote }</p>
		</div>
	</div>

	<div class="pic-container">
		<img src="/resources/img/official_cocktail/official_cocktail_${viewOfficial.official_cocktail_no }.jpg" />
	</div>

	<div>
		<div class="body-container">
			<br>
			<br>
			<h4 class="semi_title">재료</h4>
			<c:forEach var="split"
				items="${fn:split(viewOfficial.official_cocktail_ingred,',') }">
					${split } <br>
			</c:forEach>
			<br>
			<h4 class="semi_title"></h4>
			<p id="cocktail-detail"></p>
			<br>
			<h4 class="semi_title">제조법</h4>
			<p id="cocktail-recipe"></p>
			<br>
			<h4 class="semi_title">가니쉬</h4>
			<p id="cocktail-garnish"></p>
			<br>
		</div>

		<div class="comment-container">
			<div class="comment-input">
				<form action="/official/comment/write" method="post" name="cmtForm">
					<textarea name="content" id="textarea"
						placeholder="내용을 입력해주세요 (200자)"></textarea>
					<input type="hidden" name="board_no" value="${param.official_no }">
					<button type="submit" name="" id="comment-write-button">댓글달기</button>
				</form>
			</div>
			<div class="comment-loaded">
				<c:forEach var="c" items="${comments }">
					<div class="comment-list comment-show" id="comment-show${ c.official_reply_no }">
						<div id="" style="display: none;">${c.user_no }</div>
						<div class="popupOpen1">닉네임 : ${c.user_nickname }</div> 댓글내용:
						${c.official_reply_content }<br> 작성일시:
						${c.official_reply_date }<br>
						<c:if test="${c.user_no == sessionScope.user_no }">
							<form action="/official/comment/delete" method="get">
							<input type="hidden" name="official_reply_no" value="${c.official_reply_no }">
							<button type="submit" class="comment-button">삭제하기</button>
							</form>
							<button type="button" class="comment-button"
								onclick="updateCommentShow('${c.official_reply_no}')">수정하기</button>
						</c:if>
					</div>
					<div class="comment-input comment-hide" id="comment-input${ c.official_reply_no }">
						<form action="/official/comment/update" method="post" name="cmtUpdate">
							<textarea name="official_reply_content" id="textarea">${c.official_reply_content }</textarea>
							<input type="hidden" name="official_reply_no" value="${c.official_reply_no }">
							<button type="submit" class="comment-button" name="" id="comment-update-button">수정확인</button>
							<button type="button" class="comment-button" name="" id="comment-cancel-button"
								onclick="cancelCommentUpdate('${c.official_reply_no}')">취소하기</button>
						</form>
					</div>
				</c:forEach>
			</div>
		</div>

		<div class="bottom-buttons text-center">
			<button id="btnList" class="btn viewButton">목록으로</button>
		</div>
	</div>
</div>

<div class="popupWrap1 hide1">
	<form action="/customboard/message" method="post">
		<input type="hidden" name="custom_no" value="${param.custom_no }" />
		<div class="popup1">
			<div class="title">
				<p>${viewCustom.user_nickname }</p>
				<span class="close1">❌</span>
			</div>
			<textarea name="message" id="message" cols="30" rows="10"></textarea>
			<div class="btnWrap1">
				<button>보내기</button>
			</div>
		</div>
	</form>
</div>
<script>
	$('.popupOpen1').on('click', function() {
		$('.popupWrap1').removeClass('hide1');
	});
	$('.close1').on('click', function() {
		$(this).parents('.popupWrap1').addClass('hide1');
		$(this).parents('.popup1').children('textarea').val('');
	});

	$(".btnWrap1").click(function() {
		$(this).parents("form").submit();
// 		history.go(-1);
	});
</script>

<script>
	//목록으로 버튼 function
	document.getElementById("btnList").addEventListener("click", goList);
	function goList() {
		location.href = "/official/list";
	}

	//코멘트 200자 이상일 시 스크립트
	
	// Get the modal
	var modal = document.getElementById("myModal");

	// Get the button that opens the modal
	var btn = document.getElementById("comment-write-button");
	
	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];

	// When the user clicks on the button, open the modal
	btn.onclick = function() {
		if (document.getElementById("textarea").value.length >= 200) {
			modal.style.display = "block";
			return false;
		}
	}
	
	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
	  modal.style.display = "none";
	}

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	  if (event.target == modal) {
	    modal.style.display = "none";
	  }
	}
	
	function updateCommentShow(official_reply_no){
		var show = "comment-show" + official_reply_no;
		var input = "comment-input" + official_reply_no;
		
		document.getElementById(show).classList.add("comment-hide");
		document.getElementById(show).classList.remove("comment-show");
		document.getElementById(input).classList.add("comment-show");
		document.getElementById(input).classList.remove("comment-hide");
		return false;
	}
	
	function cancelCommentUpdate(official_reply_no){
		var show = "comment-show" + official_reply_no;
		var input = "comment-input" + official_reply_no;
		
		document.getElementById(show).classList.remove("comment-hide");
		document.getElementById(show).classList.add("comment-show");
		document.getElementById(input).classList.remove("comment-show");
		document.getElementById(input).classList.add("comment-hide");
		return false;
	}
	
	//칵테일 세부내역 나누기
	window.onload = function() {

		var details = "${viewOfficial.official_cocktail_detail }";
		var paragraph1 = details.split('Recipe:');
		detail = paragraph1[0];
		var paragraph2 = paragraph1[1].split('Garnish:');
		recipe = paragraph2[0];
		garnish = paragraph2[1];

		document.getElementById('cocktail-detail').innerHTML = detail;
		document.getElementById('cocktail-recipe').innerHTML = recipe;
		document.getElementById('cocktail-garnish').innerHTML = garnish;
	};
</script>

<c:import url="/WEB-INF/views/layout/footer.jsp" />     