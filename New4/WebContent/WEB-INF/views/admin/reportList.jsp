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

//버튼 전부선택
$(function(){
	$('#selectAll').click(function(){
		//만약에 최상단 체크박스가 체크되면
		if($(this).prop("checked")){
			$('input[name=select_tch]').prop("checked",true); //전체 선택
		}else{ //아니면
			$('input[name=select_tch]').prop("checked",false); //전체 해제
		}
	});

});

</script>

<div class="container">

<h1>신고글 목록</h1>
<hr>

<thead>
<table class="table table-striped table-hover table-condensed">
<tr>
	<th scope="col"><input id="selectAll" type="checkbox" value="selectAll"/></th>
	<th scope="col">신고글번호</th>
	<th scope="col">게시글링크</th>
	<th scope="col">게시글제목</th>
	<th scope="col">처리여부</th>
	
	
</tr>


<c:forEach items="${reportList }" var="report">
<tr>
	<td><input type="checkbox" name="select_tch" id="select_tch" value="${report.report_no}"></td>
	<td>
		<a href="/report/view?user_no=${report.report_no }">
		${report.report_no }
		</a>
	</td>
	<td>${report.report_board_link }</td>
	<td>${report.report_board_title }</td>
	<td>${report.report_board_done }</td>
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

<c:import url="/WEB-INF/views/layout/pagingReportList.jsp" />

<c:import url="/WEB-INF/views/layout/footer.jsp" />
