<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/resources/css/offcusstyle.css">
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
			<h1 class="entry-title">${viewCustom.custom_board_title }</h1>
			<div class="title-sub-container popupOpen1" style="display:inline-block;">작성자 : ${viewCustom.user_nickname }
				| 조회수 : ${viewCustom.custom_board_hit }</div>
			<!-- 신고 아이콘 -->
			<form class="report-form" action="/custom/report" method="post" name="report_link">
			<input type="hidden" name="board_title" value="${viewCustom.custom_board_title }">
			<span id="report-icon" class="material-icons report-icon">
			report_problem</span>
			</form>
		</div>
	</div>

	<div class="pic-container">
		<!-- JS로 그림파일만 게시되되록 할 예정 -->
		<c:if test="${not empty customFile }">
			<img width="600px" src="/upload/${customFile.stored_file_name }" />
		</c:if>
	</div>

	<div>
		<div class="body-container">
			<h3 class="semi_title"></h3>
			<!-- custom_board_content 에서 키워드로 parsing해서 아래나눠서넣어야함 -->
			${viewCustom.custom_board_content }
			<!-- 			<h3 class="semi_title">재료</h3> -->
			<%-- 			<c:forEach var="split" --%>
			<%-- 				items="${fn:split(viewCustom.custom_cocktail_ingred,',') }"> --%>
			<%-- 					${split } <br> --%>
			<%-- 			</c:forEach> --%>
			<!-- 첨부파일 -->
			<div class="attachment">
				<h5 class="semi_title">첨부파일</h5>
				<c:if test="${not empty customFile }">
					<a href="/upload/${customFile.stored_file_name }"
						download="${customFile.original_file_name }">
						${customFile.original_file_name }</a>
				</c:if>
			</div>
		</div>

		<div class="comment-container">
			<div class="comment-input comment-show">
				<form action="/custom/comment/write" method="post" name="cmtForm">
					<textarea name="content" id="textarea"
						placeholder="내용을 입력해주세요 (200자)"></textarea>
					<input type="hidden" name="board_no" value="${param.custom_no }">
					<button type="submit" name="" id="comment-write-button">댓글달기</button>
				</form>
			</div>
			<div class="comment-loaded">
				<c:forEach var="c" items="${comments }">
					<div class="comment-list comment-show"
						id="comment-show${ c.custom_reply_no }">
						<div id="" style="display: none;">${c.user_no }</div>
						<div class="popupOpen1" style="width: fit-content;">닉네임 : ${c.user_nickname }</div>
						댓글내용: ${c.custom_reply_content }<br>
						작성일시: ${c.custom_reply_date }<br>
						<form class="report-reply-form" action="/custom/report" method="post" name="report_link">
							<input type="hidden" name="reply_content" value="${ c.custom_reply_no }번리플:${c.custom_reply_content }"> 
							<span id="report-reply-icon" class="material-icons report-reply-icon">
							report_problem</span>
						</form>
						<c:if test="${c.user_no == sessionScope.user_no }">
							<form action="/custom/comment/delete" method="get">
								<input type="hidden" name="custom_reply_no"
									value="${c.custom_reply_no }">
								<button type="submit" class="comment-button">삭제하기</button>
							</form>
							<button type="button" class="comment-button"
								onclick="updateCommentShow('${c.custom_reply_no}')">수정하기</button>
						</c:if>
					</div>
					<div class="comment-input comment-hide"
						id="comment-input${ c.custom_reply_no }">
						<form action="/custom/comment/update" method="post"
							name="cmtUpdate">
							<textarea name="custom_reply_content" id="textarea">${c.custom_reply_content }</textarea>
							<input type="hidden" name="custom_reply_no"
								value="${c.custom_reply_no }">
							<button type="submit" class="comment-button" name=""
								id="comment-update-button">수정확인</button>
							<button type="button" class="comment-button" name=""
								id="comment-cancel-button"
								onclick="cancelCommentUpdate('${c.custom_reply_no}')">취소하기</button>
						</form>
					</div>
				</c:forEach>
			</div>
		</div>

		<div class="bottom-buttons text-center">
			<button id="btnUpdate" class="btn">수정하기</button>
			<button id="btnList" class="btn">목록으로</button>
			<button id="btnDelete" class="btn btn-danger">삭제</button>
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


<script type="text/javascript">
//버튼 function
$(document).ready(function() {
						
	//목록버튼 동작
				
	$("#btnList").click(function() {
		$(location).attr("href", "/custom/list");
	});

	//수정버튼 동작
	$("#btnUpdate").click(function() {
		$(location).attr("href","/custom/update?custom_no=${viewCustom.custom_board_no }");
	});

	//삭제버튼 동작
	$("#btnDelete").click(function() {
		if (confirm("게시글을 삭제하시겠습니까?")) {
			$(location).attr("href","/custom/delete?custom_no=${viewCustom.custom_board_no }");
		}
	});
	
	//신고버튼 동작
	$(".report-icon").click(function(){
		if (confirm("게시글을 신고하시겠습니까?")) {
			$(".report-form").submit();
		}
	});
	$(".report-reply-icon").click(function(){
		if (confirm("댓글을 신고하시겠습니까?")) {
			$(".report-reply-form").submit();
		}
	});
});


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

function updateCommentShow(custom_reply_no) {
	var show = "comment-show" + custom_reply_no;
	var input = "comment-input" + custom_reply_no;

	document.getElementById(show).classList.add("comment-hide");
	document.getElementById(show).classList.remove("comment-show");
	document.getElementById(input).classList.add("comment-show");
	document.getElementById(input).classList.remove("comment-hide");
	return false;
}

function cancelCommentUpdate(custom_reply_no) {
	var show = "comment-show" + custom_reply_no;
	var input = "comment-input" + custom_reply_no;

	document.getElementById(show).classList.remove("comment-hide");
	document.getElementById(show).classList.add("comment-show");
	document.getElementById(input).classList.remove("comment-show");
	document.getElementById(input).classList.add("comment-hide");
	return false;
}
</script>

<c:import url="/WEB-INF/views/layout/footer.jsp" />
