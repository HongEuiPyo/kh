<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<style type="text/css">

.content_area {
	margin-top: 85px;
	}
</style>


<div>
<script>
$(document).ready(function(){
	if(user_email == 'projectkhwork@gmail.com') {
		history.go(-1);
		alert("관리자 로그인이 필요합니다")
	}
});
</script> 



<%//1.한글처리, 파라미터 
request.setCharacterEncoding("UTF-8");
String id = (String) session.getAttribute("user_email");//object를 string으로 다운캐스팅
String name = request.getParameter("user_nickname");
//1-1. id없이는 진입불가, id없는 경우 로그인페이지로 이동

/* if(id == null){
	response.sendRedirect("../login/login.jsp");
} */
%>
<h2>/* <%=id %> */ 관리자님 환영합니다.</h2>
/* <%=name %> */ <br>

<input type="button" class="btn btn-default" value="회원정보관리" onclick="location.href='/kh1/admin/member'">
<input type="button" class="btn btn-default" value="커스텀칵테일관리" onclick="location.href='/kh1/admin/custom'">
<input type="button" class="btn btn-default" value="자유게시판관리" onclick="location.href='/kh1/admin/board'">
<input type="button" class="btn btn-default" value="신고글 관리" onclick="location.href='/kh1/admin/report'">
<input type="button" class="btn btn-default" value="로그아웃" onclick="location.href='/kh1/logout'">

<%-- <!-- 관리자일때만 메뉴확인가능 -->
<% if(id != null){
	if(id.equals("admin")){ %>
	<input type="button" value="회원전체목록(관리자용)" onclick="location.href='memberList.jsp'">
<%
	}
}
%> --%>

</div>

<c:import url="/WEB-INF/views/layout/footer.jsp" />
