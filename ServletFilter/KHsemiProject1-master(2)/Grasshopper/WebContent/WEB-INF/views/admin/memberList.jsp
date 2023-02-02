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

//취소 버튼 누르면 뒤로가기
$("#btnBack").click(function() {
	history.go(-1);
})

</script>

<div class="container">

<h1>회원 목록</h1>
<hr>

<thead>
<table class="table table-striped table-hover table-condensed">
<tr>
	<th scope="col"><input id="allCheck" type="checkbox" onclick="allChk(this);"/></th>
	<th scope="col">회원번호</th>
	<th scope="col">이메일</th>
	<th scope="col">비밀번호</th>
	<th scope="col">회원활동포인트</th>
	<th scope="col">이름</th>
	<th scope="col">생년월일</th>
	<th scope="col">홍보성 이메일 수신 동의 여부</th>
	<th scope="col">활동명</th>
	
</tr>


<%-- <tbody> 
      <c:forEach var="result" items="${requestMap.userList}" >
       <tr >
            <td class="text_ct"><input﻿ name="RowCheck" type="checkbox" value="${result.user_id}"/></td>
            <td class="text_ct"><a hrf="#">${result.user_id}</a></td>
            <td class="text_lt text_unline"><a hrf="#"> ${result.user_nm}&nbsp; </a></td>
            <td class="text_ct">${result.duty}&nbsp;</td>
            <td class="text_ct">${result.position_nm}&nbsp;</td>
            <td class="text_ct">${result.email}&nbsp;</td>
            <td class="text_ct">활성</td>
       </tr>
      </c:forEach> 

</tbody>   --%>





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
	<a id="btnOut" class="btn btn-defualt" onclick="memberOut()">회원탈퇴</a>
</div>


<div id="btnBox" class="pull-left">
	<button id="btnWrite" class="btn btn-defualt">메일발송</button>
</div>

<div id="btnBAck" class="pull-left">
	<button id="btnBack" class="btn btn-defualt" onclick="location.href='/kh1/admin'">돌아가기</button>
</div>


<!-- .container -->
</div>

<c:import url="/WEB-INF/views/layout/pagingMemberList.jsp" />

<c:import url="/WEB-INF/views/layout/footer.jsp" />
