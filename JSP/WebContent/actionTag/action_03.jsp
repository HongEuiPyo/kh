<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>�׼��±� �׽�Ʈ</h1>
<h3>include</h3>
<hr>

<jsp:include page="/actionTag/includepage.jsp" />
<hr>

<%-- ���� �Ķ������ �ѱ� ���ڵ� ���� --%>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:include page="/actionTag/includepage2.jsp">
	<jsp:param value="HELLO! �ȳ�!" name="data" />
</jsp:include>



</body>
</html>