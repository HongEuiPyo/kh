<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<style type="text/css">
.content_area {
	margin-top: 85px;
	}
</style>

<script type="text/javascript">

/* $(document).ready(function() {
	
	//글쓰기 버튼 누르면 이동
	$("#btnWrite").click(function() {
		location.href="/board/write";
	});
	
}); */

</script>

<div class="container">

<h1>신고글 목록</h1>
<hr>

<thead>
<table class="table table-striped table-hover table-condensed">
<tr>
	<th scope="col"><input id="allCheck" type="checkbox" onclick="allChk(this);"/></th>
	<th scope="col">회원번호</th>
	<th scope="col">이메일</th>
	<th scope="col">이름</th>
	<th scope="col">활동명</th>
	<th scope="col">제목</th>
	
	
</tr>


<c:forEach items="${memberList }" var="member">
<tr>
	<td class="chk"><input﻿ id="RowCheck" type="checkbox" value="${member.user_no}"/></td>
	<td>
		<a href="/member/view?user_no=${member.user_no }">
		${member.user_no }
		</a>
	</td>
	<td>${member.user_email }</td>
	<td>${member.user_password }</td>
	<td>${member.user_point }</td>
	<td>${member.user_name }</td>
	<td>${member.user_birth }</td>
	<td>${member.user_check }</td>
	<td>${member.user_nickname }</td>
</tr>
</c:forEach>




</table>


<div id="btnBox" class="pull-left">
	<a id="btnOut" class="btn btn-defualt" onclick="memberOut()">답변</a>
</div>


<div id="btnBox" class="pull-left">
	<button id="btnWrite" class="btn btn-defualt">삭제</button>
</div>

<div id="btnBAck" class="pull-left">
	<button id="btnBack" class="btn btn-defualt" onclick="location.href='/kh1/admin'">돌아가기</button>
</div>



<!-- .container -->
</div>

<c:import url="/WEB-INF/views/layout/pagingMemberList.jsp" />

<c:import url="/WEB-INF/views/layout/footer.jsp" />
