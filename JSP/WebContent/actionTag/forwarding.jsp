<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>포워딩된 페이지</h3>
<h5>URL은 바뀌지않고 화면만 전환된다</h5>
<hr>

<%-- request.getAttribute() - 컨텍스트 정보 얻어오기 --%>
attribute : <%=request.getAttribute("nick") %><br>

<%-- request.getParameter() - 요청 데이터(전달 파라미터) 얻어오기 --%>
parameter : <%=request.getParameter("nick") %>

</body>
</html>