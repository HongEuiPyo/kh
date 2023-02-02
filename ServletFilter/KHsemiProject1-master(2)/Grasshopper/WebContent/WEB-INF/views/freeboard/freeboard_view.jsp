<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp"/>
<link rel="stylesheet" type="text/css" href="/resources/css/messagePopup.css">
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
	
	$("#btnlike").click(function(){
		if( "${login }" == false){
			alert("로그인이 필요합니다");
			return false;
		}
		
		$.ajax({
			type:'post',
			url: '/free/likey',
			data: {
				'type': 'free_board',
				'freeboardno': '${freeboard.free_board_no}',
				'btnlike': $("#btnlike").val()
			},
			dataType: 'json', 
			success: function(data){
				
				if(data == "true"){
					$("#btnlike").val() = "true";
					$("#btnlike").attr("disabled", true);
				}else{
					$("#btnlike").val() = "false";
					$("#btnlike").attr("disabled", false);
				}
				
			}
		})
	});
	
	$("#writereply").click(function(){
		if( "${login }" == false){
			alert("로그인이 필요합니다");
			return false;
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
	});
	
	if('${likey }'.equals("false")){
		$("#btnlike").attr("disabled", false);
	}else{
		$("#btnlike").attr("disabled", true);
	}

});


</script>

<br>
<br>
<div style="margin: 0 auto; width:70%; text-align:center;">
<h1>자유게시판</h1>
</div>

<hr>

<div style="margin: 0 auto; width:70%;">
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
	<td class="info">제목</td>
	<td>${freeboard.free_board_title }</td>
	<td class="info">조회수</td><td>${freeboard.free_board_hit }
		<button id="btnreport" style="float:right;" class="btn btn-danger btn-xs">신고하기</button>
	</td>
</tr>

<tr>
<td class="info">닉네임</td><td class="popupOpen1">${freeboard.user_nickname }</td>
<td class="info">작성일</td><td>${freeboard.free_board_date }</td>
</tr>

<tr><td class="info"  colspan="4">본문</td></tr>

<tr><td colspan="4">${freeboard.free_board_content }</td></tr>


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
<button type="button" id="writereply" name="writereply" style="height: 45px; float: right;">댓글 달기</button>
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
<div>
					<div class="popupWrap1 hide1">
						<form action="/freeboard/message" method="post">
						<input type="hidden" name="freeboardno" value="${freeboard.free_board_no }" />
							<div class="popup1">
								<div class="title">
									<p>${freeboard.user_nickname }</p>
									<span class="close1">❌</span>
								</div>
								<textarea name="message" id="message" cols="30" rows="10"></textarea>
								<div class="btnWrap1">
									<button>보내기</button>
								</div>
							</div>
						</form>
					</div>
				</div>

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
<c:import url="/WEB-INF/views/layout/footer.jsp"/>