<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>EL의 컨텍스트 정보 객체</h1>
<hr>

<% int localData = 100;
	pageContext.setAttribute("pageData", 200);
	request.setAttribute("requestData", 300);
	session.setAttribute("sessionData", 400);
	application.setAttribute("applicationData", 500);
%>



</body>
</html>