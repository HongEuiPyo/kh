<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	//페이지 첫 접속 시 입력창으로 포커스 이동
	$("input").eq(0).focus();
	
	
	//전송 버튼 클릭 시 form submit
	$("#btnSend").click(function() {
		$(this).parents("form").submit();
		alert("메일 발송 완료")
	
	}) 
	
	//취소 버튼 누르면 뒤로가기
	$("#btnCancel").click(function() {
		history.go(-1);
	})
		
	<%-- //메일 발송(테스트 용)
	$("#btnEmail").click(function() {
		 window.open("<%=request.getContextPath() %>./WebContent/WEB-INF/views/login/test_mail.jsp", "", "width=370, height=360, resizable=no, scrollbars=no, status=no");
	}) --%>
	
	
});

</script>
<style>
.content_area {
	margin-top: 100px;
}
</style>

<%-- <script type="text/javascript">
function send_mail(){
	
	
    window.open("<%=request.getContextPath() %>./WebContent/WEB-INF/views/login/test_mail.jsp", "", "width=370, height=360, resizable=no, scrollbars=no, status=no");
}
</script> --%>




<div class="container">

<form action="/kh1/login/find" method="post" class="form-horizontal">

			<div class="form-group">
		<label for="user_email" class="control-label" style="color:black">비밀번호를 찾으려는 이메일 입력</label>
		<input type="email" id="user_email" name="user_email" class="form-control"/>
	</div>
			
			
			<div class="text-center">
		<button type="button" id="btnSend" class="btn btn-primary">비밀번호 전송</button>
		<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
		
		
		
	</div>
	
	<hr>
	
	<!-- <div class="form-group" style="width: 38%; margin: 10px auto;">  
      <button type="button" id="btnEmail" class="btn btn-primary btn-lg btn-block" onclick="send_mail()">보내기</button>
	</div>   -->
	
	


<c:import url="/WEB-INF/views/layout/footer.jsp" />