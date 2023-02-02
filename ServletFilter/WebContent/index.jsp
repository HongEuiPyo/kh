<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>메인 페이지</h1>
<h3>Welcome Page</h3>
<hr>

컨텍스트 패스 : <%=request.getContextPath() %>
<hr>

<a href="<%=request.getContextPath() %>/board/insert"><button>입력 페이지</button></a>

<%-- JSP페이지에서 사용하는 모든 상대결로에는
	컨텍스트 패스를 앞에 추가해놓아야 한다 --%>

</body>
</html>