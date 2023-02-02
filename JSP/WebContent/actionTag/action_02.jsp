<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>액션태그 테스트</h1>
<h3>forward</h3>
<hr>

<%-- 포워딩 --%>
<%-- <jsp:forward page="./forwarding.jsp"/> --%>

<jsp:forward page="./forwarding.jsp">
	<jsp:param value="Apple" name="nick" />
</jsp:forward>

</body>
</html>