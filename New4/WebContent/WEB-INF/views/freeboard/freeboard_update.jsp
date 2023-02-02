<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<!-- 스마트에디터 2 -->
<script type="text/javascript"
 src="/resources/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>

<!-- <form>태그의 submit을 수행하면 editor에 작성한 내용을 <textarea>에 반영 -->
<script type="text/javascript">
function submitContents( elClickedObj ) {
	
	//에디터의 내용을 #content에 반영한다
	oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
	
	try {
		// <form>태그의 submit 수행
		elClickedObj.form.submit();
	} catch(e) {}
	
}
</script>

<script type="text/javascript">
$(document).ready(function() {
	
	//수정버튼 동작
	$("#btnUpdate").click(function() {
		
		submitContents( $("#btnUpdate") );
		
		$("form").submit();
	});
	
	//취소버튼 동작
	$("#btnCancel").click(function() {
		history.go(-1);
	});
	
	console.log(${boardFile.file_size })
	
	//파일이 없을 경우
	if(${boardFile.file_size }  == 0 ) {
		$("#beforeFile").show();
		$("#afterFile").hide();
	}else{
		$("#beforeFile").hide();
		$("#afterFile").show();
	}
	
	//파일 삭제 버튼(X) 처리
	$("#delFile").click(function() {
		$("#beforeFile").toggle();
		$("#afterFile").toggle();
	})

});
</script>

<style type="text/css">
#content {
/* 	width: 100%; */
	width: 98%;
}
</style>

<div class="container">

<h3>게시글 쓰기</h3>
<hr>

<div>
<form action="/free/update?freeboardno=${freeBoard.free_board_no }" method="post" enctype="multipart/form-data">
<input type="hidden" name="freeboardno" id="freeboardno" value="${freeBoard.free_board_no }"/>
<table class="table table-bordered">
<td class="info">제목</td><td><input type="text" name="title" style="width:100%" value="${freeBoard.free_board_title }"/></td>
<td class="info">닉네임</td><td>${freeBoard.user_nickname }</td>
<tr><td class="info" colspan="4">본문</td></tr>
<tr><td colspan="4"><textarea id="content" name="content">${freeBoard.free_board_content }</textarea></td></tr>
</table>

<!-- 첨부파일 -->
<div>
	<div id="beforeFile">
		기존 첨부파일: 
		<a href="/upload/${boardFile.stored_file_name }" download="${boardFile.original_file_name }">${boardFile.original_file_name }</a>
		<span id="delFile" style="color:red; font-weight: bold; cursor: pointer;">X</span>
	</div>

	<div id="afterFile">
		새 첨부파일:
		<input type="file" name="file" />
	</div>
</div>

<br>
</form>
</div>

<div class="text-center">	
	<button type="button" id="btnUpdate" class="btn btn-info">수정</button>
	<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
</div>
</div>

<!-- .container -->
</div>

<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "content", //에디터가 적용될 <textarea>의 id를 입력
	sSkinURI: "/resources/se2/SmartEditor2Skin.html",
	fCreator: "createSEditor2"
})
</script>
<c:import url="/WEB-INF/views/layout/footer.jsp" />
