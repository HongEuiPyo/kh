<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>로그인 폼</h1>
<hr>

<%-- <% if(session.getAttribute("login") == null)  {%> --%>
<c:if test="${empty login }">
<form action="<%=request.getContextPath() %>/kh1/login" method="post"/>

<label for="userid">ID</label>
<input type="text" id="userid" name="userid" /><br>

<label for="userpw">PASS</label>
<input type="text" id="userpw" name="userpw" /><br>

<button>로그인</button>

</form>

<%-- <% } else if ( (boolean) session.getAttribute("login")) {%>  --%>
</c:if>

<c:if test="${not empty login}">
${loginid }님, 환영합니다<br>
<button onclick="location.href = '/kh1/logout';">로그아웃</button>
</c:if>

<%-- <% } %> --%>

</body>
</html>