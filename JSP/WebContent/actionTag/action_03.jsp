<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>액션태그 테스트</h1>
<h3>include</h3>
<hr>

<jsp:include page="/actionTag/includepage.jsp" />
<hr>

<%-- 전달 파라미터의 한글 인코딩 설정 --%>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:include page="/actionTag/includepage2.jsp">
	<jsp:param value="HELLO! 안녕!" name="data" />
</jsp:include>



</body>
</html>