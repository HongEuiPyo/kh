<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>파일 업로드</h1>
<h3>COS Fileupload</h3>
<hr>

<form action="/cos/fileupload" method="post">

<label>제목<input type="text" name="title" /></label><br>
<label>닉네임<input type="text" name="nick" /></label><br><br>

<label>파일<input type="file" name="upfile" /></label><br><br>

<button>전송</button>

</form>


</body>
</html>