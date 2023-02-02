<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>게시글 등록</h1>
<hr>

<form action="/board/insert" method="post">

<label>제목<input type="text" name="title" /></label><br>
<label>내용<input type="text" name="content" /></label><br><br>

<button>작성</button>

</form>

</body>
</html>