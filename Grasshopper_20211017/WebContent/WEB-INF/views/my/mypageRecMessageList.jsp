<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<h1 style="margin-top: 100px;">내가 받은 쪽지함</h1>
<hr>

<table class="table table-striped">
	<caption>받은 쪽지</caption>
	<tr>
		<th>보낸 사람</th>
		<th>내용</th>
		<th>읽음표시</th>
		<th>날짜</th>
	</tr>
	<c:forEach items="${message }" var="message">
		<tr>
			<td>${message.msg_send }</td>
			<td>${message.msg_content }</td>
			<td>${message.msg_check }</td>
			<td>${message.send_date }</td>
		</tr>
	</c:forEach>
</table>

<c:import url="/WEB-INF/views/layout/footer.jsp" />
