<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	Member m = (Member) request.getAttribute("result"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원가입 결과</h1>
<hr>

번호 : <%=m.getUserno() %><br>
아이디 : <%=m.getUserid() %><br>
닉네임 : <%=m.getNick() %><br>
이메일 : <%=m.getEmail() %><br><br>

<a href="/member/join">회원가입 페이지로...</a>

</body>
</html>






