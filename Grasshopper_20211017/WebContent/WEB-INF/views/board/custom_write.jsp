<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>    
<link rel="stylesheet" type="text/css" href="/resources/css/offcusstyle.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
      
<!-- 스마트에디터2 -->
<script type="text/javascript" src="/resources/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>

<script type="text/javascript">
//<form>태그에 submit이 수행되면 스마트에디터에 작성한 내용을 <textarea>에 반영한다
// ‘저장’ 버튼을 누르는 등 저장을 위한 액션을 했을 때 submitContents가 호출된다고 가정한다.
function submitContents(elClickedObj) {
 	// 에디터의 내용이 textarea에 적용된다. id="content"
 	oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);

 	// 에디터의 내용에 대한 값 검증은 이곳에서
 	// document.getElementById("content").value를 이용해서 처리한다.

 	try {
 	    //<form>태그의 submit을수행 
 		elClickedObj.form.submit();
 	} catch(e) {}
}

$(document).ready(function() {
	
	$("#btnWrite").click(function(){
		
		//스마트 에디터의 내용을 <textara>에 적용
		submitContents( $("#btnWrite"))
		
		$("form").submit();
		
	})
	
	//취소버튼 동작
	$("#btnCancel").click(function() {
		history.go(-1);
	});
	
})

</script>

<style type="text/css">
#content {
/* 	width: 100%; */
	width: 98%;
	height: 300px;
}
</style>

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
		<form action="/custom/write" method="post" name="cmtForm"
			enctype="multipart/form-data" >
			<div class="title-container">
				<input type="text" name="custom_board_title" placeholder="제목을 입력하세요" style="width:100%;font-size: 24px;" />
			</div>

			<div class="body-container">
				<textarea name="content" id="content" placeholder="내용을 입력해주세요"></textarea>
				<input type="hidden" name="user_no" value="${param.user_no }">
			</div>
			<div class="attachment-container">
				  첨부파일 : <input type="file" name="file" />
			</div>
		</form>

		<div class="bottom-buttons text-center">
			<button type="button" id="btnWrite" class="btn">작성완료</button>
			<button type="button" id="btnList" class="btn">목록으로</button>
		</div>

	</div>
</div>

<script>
	//목록으로 버튼 function
	document.getElementById("btnList").addEventListener("click", goList);
	function goList() {
		location.href = "/custom/list";
	}
	//문서편집기 function
	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
	 oAppRef: oEditors,
	 elPlaceHolder: "content",
	 sSkinURI: "/resources/se2/SmartEditor2Skin.html",
	 fCreator: "createSEditor2"
	});

	//본문내용이 2000자 이상일시 컷
	// Get the modal
	var modal = document.getElementById("myModal");

	// Get the button that opens the modal
	var btn = document.getElementById("btnWrite");

	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];

	// When the user clicks on the button, open the modal
	btn.onclick = function() {
		if (document.getElementById("textarea").value.length > 2000) {
			modal.style.display = "block";
			return false;
		}
	}
	// When the user clicks on <span> (x), close the modal (disabled)
	span.onclick = function() {
		modal.style.display = "none";
	}

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
	//modal - end
</script>

<c:import url="/WEB-INF/views/layout/footer.jsp" />     