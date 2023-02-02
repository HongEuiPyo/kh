<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">

// alert("${alertMsg}");

// alert("3초 뒤에 페이지 이동됩니다");
// setTimeout(function(){
// 	location.href = '${redirectUrl}';
// }, 3000)


</script>


</head>
<body>

<h1 style="color:red;">에러페이지</h1>
<hr>

<h3>${msg }</h3>
<hr>

<a href="/file/list">목록으로 가기</a>
<hr>

<button onclick="history.go(-1)">뒤로가기</button>
<hr>

<a href="javasciprt:history.go(-1)">뒤로 가기</a>

<!-- <a>태그의 href속성에 URL이 아닌 JS를 넣고 싶다면
	javascript: 접두어를 먼저 적고 JS코드를 작성하면 된다 -->


</body>
</html>