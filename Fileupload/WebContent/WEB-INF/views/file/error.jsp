<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">

// alert("${alertMsg}");

// alert("3�� �ڿ� ������ �̵��˴ϴ�");
// setTimeout(function(){
// 	location.href = '${redirectUrl}';
// }, 3000)


</script>


</head>
<body>

<h1 style="color:red;">����������</h1>
<hr>

<h3>${msg }</h3>
<hr>

<a href="/file/list">������� ����</a>
<hr>

<button onclick="history.go(-1)">�ڷΰ���</button>
<hr>

<a href="javasciprt:history.go(-1)">�ڷ� ����</a>

<!-- <a>�±��� href�Ӽ��� URL�� �ƴ� JS�� �ְ� �ʹٸ�
	javascript: ���ξ ���� ���� JS�ڵ带 �ۼ��ϸ� �ȴ� -->


</body>
</html>