<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<script type="text/javascript" src="/resources/js/httpRequest.js"></script>
<script type="text/javascript">
window.onload = function() {
	btnAction.onclick = function() {
		console.log("btnAction clicked")
		
		sendRequest("POST", "/ajax/test02", "", callback);
	}
}

function callback() {
	if(httpRequest.readyState == 4) {
		if(httpRequest.status == 200 ) {
			console.log("�������� AJAX ��û/���� ����")
			
			printData();
		} else {
			console.log("AJAX ��û/���� ����")
		}
	}
}

function printData() {
	console.log("printData () called")
	
	result.innerHTML = httpRequest.responseText
}
</script>
</head>
<body>

<h1>AJAX �׽�Ʈ 02</h1>
<hr>

<button id="btnAction">AJAX ��û</button>

<div id="result"></div>

</body>
</html>