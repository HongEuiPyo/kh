<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원가입 페이지</h1>
<hr>

<form action="/member/join" method="post">
<table>
<tr>
	<td><label for="userid">회원 아이디</label></td>
	<td><input type="text" id="userid" name="userid" /><td>
</tr>
<tr>
	<td><label for="nick">닉네임</label></td>
	<td><input type="text" id="nick" name="nick" /><td>
</tr>
<tr>
	<td><label for="email">이메일</label></td>
	<td><input type="text" id="email" name="email" /><td>
</tr>
<tr>
	<td></td>
	<td><button>가입</button>
</tr>
</table>
</form>

</body>
</html>





