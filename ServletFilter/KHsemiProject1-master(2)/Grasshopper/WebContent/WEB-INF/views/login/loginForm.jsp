<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
button, input, textarea {
	font-size: 16px;
	padding: 4px;
	margin-bottom: 5px;
	
}

.select {
	margin-bottom: 50px; 
}

#useridchk {
	border: none;
	background-color: #FD9F28;
	color: #fff;
	border-radius: 4px;
	padding: 5px 10px;
	box-shadow: 3px 3px 3px rgba(0,0,0,0.1);
	margin-left: 5px;
}

.btn-area {
	margin-bottom: 20px;
}

#btnJoin, #btnCancel {
	border: none;
	background-color: #FD9F28;
	color: #fff;
	border-radius: 6px;
	padding: 10px 40px;
	box-shadow: 3px 3px 3px rgba(0,0,0,0.1);
}

button:focus, button:active, input:focus, input:active, textarea:focus,
	textarea:active {
	box-shadow: none;
	outline: none;
}

label {
	padding-bottom: 0px;
}

.submail {
	margin-left: 5px;
}

form {
	width: 450px;
	margin: 0 auto;
}

.formid {
	display: flex;
	flex-direction: row;
}

.form-control {
    display: flex;
    width: 80%;
    padding: 10px 5px;
    color: #495057;
    background-color: #fff;
    background-clip: padding-box;
    border: 1px solid #ced4da;
    border-radius: 5px;
    transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
}

</style>

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