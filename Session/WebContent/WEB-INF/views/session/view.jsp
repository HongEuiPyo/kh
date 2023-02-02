<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>세션 확인</h1>
<hr>

Session ID : <%=session.getId() %><br>

Creation Time : <%=session.getCreationTime() %><br>

LastAccessed Time : <%=session.getLastAccessedTime() %><br>

MaxInactiveInterval : <%=session.getMaxInactiveInterval() %><br>

isNew : <%=session.isNew() %>

<hr>

test 세션정보 : <%=session.getAttribute("test") %><br>
test 세션정보 : ${test }

<hr>

<a href="./create"><button>세션 정보 생성</button></a>
<a href="./delete"><button>세션 정보 삭제</button></a>

</body>
</html>










