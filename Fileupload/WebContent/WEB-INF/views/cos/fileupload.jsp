<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>���� ���ε�</h1>
<h3>COS Fileupload</h3>
<hr>

<form action="/cos/fileupload" method="post">

<label>����<input type="text" name="title" /></label><br>
<label>�г���<input type="text" name="nick" /></label><br><br>

<label>����<input type="file" name="upfile" /></label><br><br>

<button>����</button>

</form>


</body>
</html>