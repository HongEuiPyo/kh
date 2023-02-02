<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp"/>

</script>
<script type="text/javascript">

function refreshComment(data){
	var page_html="";
	
	$.each(data, function(index, item){
		$('#replyview').empty();
		$('#freereply').val("");
		
		page_html += "<tr>";
		page_html += "<td class='info col-md-1' id='commentWriter'>" + data[index].user_nickname+"</td>";
		page_html += "<td id='comment'>" + data[index].free_reply_content;
		
		if( data[index].user_nickname == "${usernick}" ){
			page_html += "	<a href='#' style='color:red;' onclick='cmDeleteOpen(" + data[index].free_reply_no + ")'>x</a>";
			page_html += "	<input type='hidden' id='replyno' value='" +  data[index].free_reply_no + " '/>";
		}

		page_html += "</td>";
		page_html += "</tr>";
		
		$("#replyview").append(page_html);
					
	})
}
function cmDeleteOpen(free_reply_no){
	var msg = confirm("댓글을 삭제합니다");
	if(msg == true){
		deleteCmt(free_reply_no);
	}
	else{
		return false;
	}
}

function deleteCmt(free_reply_no){
	
	$.ajax({
		type:'post',
		url:'/comment/delete',
		data:{
			'free_reply_no': free_reply_no
			,'freeboardno': '${freeboard.free_board_no }'
		},
		dataType: 'json',
		success: function(data){
			refreshComment(data);
		}
	})
}
$(document).ready(function(){
	
	$("#btnDelete").click(function(){
		if(window.confirm("글을 삭제하시겠습니까?")){
			window.location.replace("/free/delete?freeboardno=${freeboard.free_board_no}");
		}
	})
	
	/* $("#btnlike").click(function(){
		$.ajax({
			type:'post',
			url: '/free/like',
			data: {
				'freeboardno': '${freeboard.free_board_no }',
				'btnlike': $("#btnlike").val()
			},
			success: function(data){
				
				if($("#btnlike").val() == 'false'){
					$("#btnlike").val('true');
					$("#vote").val(data.free_board_vote);
					
				}else{
					$("#btnlike").val('false');
					$("#vote").val(data.free_board_vote);
				}
				
			}
		})
	}) */
	
	$("#writereply").click(function(){
		if( ${login } == false){
			alert("로그인이 필요합니다");
			return ;
		}
		if( $("#freereply").val().length <= 200 && $("#freereply").val().length>0){
			$.ajax({
				type:'post',
				url:'/reply/write',
				data:{
	 				'userno': '${user_no }'
					,'usernick': '${usernick }'
					, 'content': $("#freereply").val()
					, 'freeboardno': '${freeboard.free_board_no }'
				},
				dataType: 'json',
				success: function(data){
					
					refreshComment(data);	
				}
				,error:function(request,status,error){
				    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
	
			})
		}else{
			alert("댓글은 200자 내로 작성해야합니다");
			
		}
	})
	
	/*
	$("#btnreport").click(function(){
		$.ajax({
			type:'post',
			url: '/free/report',
			data:{
				'freeboardno': '${freeboard.free_board_no}',
				
			}
		})
		
	})
	*/
	

});


</script>
<h1>자유게시판</h1>
<h3>게시글 보기</h3>
<hr>

<table class="table table-bordered">
<tr>
<td class="info">글번호</td>
<td colspan="3">${freeboard.free_board_no }
<div style='text-align:center; float:right;'>
<c:choose>
	<c:when test="${user_no eq  freeboard.user_no}">
		<a href="/free/update?freeboardno=${freeboard.free_board_no }"><button>수정하기</button></a>
		<button id="btnDelete" style='color:red'>삭제하기</button>
	</c:when>
</c:choose>
</div>
</td>
</tr>

<tr>
<td class="info">제목</td><td colspan="3">${freeboard.free_board_title } <button id="btnreport" style="float:right;">신고하기</button></td>
</tr>

<tr>
<td class="info">닉네임</td><td>${freeboard.user_nickname }</td>
<td class="info">작성일</td><td>${freeboard.free_board_date }</td>
</tr>

<tr>
<td class="info">조회수</td><td>${freeboard.free_board_hit }</td>
<td class="info" id="vote">추천수</td><td>${freeboard.free_board_vote }
<button type="button" id="btnlike" style="float:right;" value="false"><img src="/resources/img/likebutton.png" style="width:20px; height:20px;"></button></td>
</tr>


<tr><td class="info"  colspan="4">본문</td></tr>

<tr><td colspan="4">${freeboard.free_board_content }</td></tr>
<tr><td colspan="4"></td></tr>

<tr>
<td class="info">첨부파일</td>

<td colspan="3"> 
<c:choose>
	<c:when test="${boardFile.attach_no eq 0}">
	첨부파일 없음
	</c:when>
	<c:when test="${boardFile.attach_no gt 0}">
	<a href="/upload/${boardFile.stored_file_name }" download="${boardFile.original_file_name }">${boardFile.original_file_name }</a>
	</c:when>
</c:choose>
</td>
</tr>
</table>



<!-- 댓글 달기 -->
<form action="/free/reply" method="post" id="form">
<div>
<table class="table table-bordered">
<tr>
<td class="info col-md-1"><label id="usernick">${usernick }</td>
<td colspan="2"><textarea rows="2" cols="100" placeholder="댓글은 200자 안으로..." id="freereply" style="width:90%"></textarea>
<button type="button" id="writereply" style="height: 45px; float: right;">댓글 달기</button>
</td>
</tr>
</table>
</div>
</form>

<div>
<table class="table table-bordered" id="replyview">

<c:forEach var="freeReply" items="${replyList }">
	<tr>
		<td class="info col-md-1" id="commentWriter"><c:out value="${freeReply.user_nickname}"/></td>
		<td id="comment"><c:out value="${freeReply.free_reply_content }"/>
			<c:if test="${usernickname eq $freeReply.user_nickname }"> 
				<a href="#" style="color:red;" onclick="cmDeleteOpen(${freeReply.free_reply_no})">x</a>
				<input type="hidden" id="replyno" value="${freeReply.free_reply_no }"/>
			</c:if>
		</td>
	</tr>
</c:forEach>

</table>
</div>

<c:import url="/WEB-INF/views/layout/footer.jsp"/>