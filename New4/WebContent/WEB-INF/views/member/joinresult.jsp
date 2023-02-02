<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<c:import url="/WEB-INF/views/layout/header.jsp" />

<style>
h1 {
	margin-top: 30px;
	margin-bottom: 15px;
}


table, tr, td {
	padding: 8px 10px;
}


.result {
	margin-top: 50px;
	padding: 30px;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
}

#tomain {
	width: 180px;
	height: 35px;
	background-color: #FD9F28;
	color: #fff;
	font-size: 15px;
	border: none;
	border-radius: 20px;
	box-shadow: 3px 3px 3px rgba(0,0,0,0.2);
	
}
</style>
<script type="text/javascript">
$(document).ready(function() {
	
	
//가입 버튼 클릭 시 form submit
$("#tomain").click(function() {
	$(location).attr("href", "/main");
//	window.location.href = '/main';
})

});
</script>

<div class="result">
<c:choose>
<c:when test="${not empty userinfo }">
	<h1>가입이 완료되었습니다</h1>
<hr>
<table>
<tr>
	<td>이름 </td>
	<td>${userinfo.user_name }</td>
</tr>
<tr>
	<td>생년월일 </td>
	<td>${userinfo.user_birth }</td>
</tr>
<tr>
	<td>아이디 </td>
	<td>${userinfo.user_email }</td>
</tr>
<tr>
	<td>닉네임 </td>
	<td>${userinfo.user_nickname }</td>
</tr>
<tr>
	<td>홍보성메일 </td>
	<td>
		<c:choose>
		<c:when test="${userinfo.user_check eq 1}">
		수신동의
		</c:when>
		<c:when test="${userinfo.user_check eq 0}">
		수신거부
		</c:when>
		</c:choose>
	</td>
</tr>

</table>

</c:when>

<c:when test="${ empty userinfo }">
	회원가입에 실패하셨습니다.
</c:when>
</c:choose>
<br>
<br>
<button id="tomain">메인으로 가기</button>

</div>



<c:import url="/WEB-INF/views/layout/footer.jsp" />
