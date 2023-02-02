<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/httpRequest.js"></script>

<script type="text/javascript">

//서버로 AJAX요청을 보내는 함수
function ajaxToServer() {
	console.log("ajaxToServer() called")
	
	//전달 파라미터
	var params = "username=" + document.f.username.value;
	
	//AJAX 요청 보내기
	sendRequest("POST", "/ajax/ajax_03_ok.jsp", params, ajaxFromServer);
	
}

//서버로부터 AJAX응답을 받아 처리하는 함수
function ajaxFromServer() {
	console.log("ajaxFromServer() called")

	if( httpRequest.readyState == 4 ) { //DONE, 응답 완료
		if( httpRequest.status == 200 ) { //200 OK. 정상 응답
			console.log("AJAX 정상 응답")
			
			//응답데이터를 div에 반영하기
			result.innerHTML = httpRequest.responseText;
			
		} else {
			console.log("AJAX 요청/응답 에러")
		}
	}
}

</script>
</head>
<body>

<h1>AJAX 03</h1>
<hr>

<form name="f">
	<!-- form태그에 <input type="text">태그가 단독으로 있을 때
		엔터를 입력하면 submit된다 -->
	<input type="text" style="display: none;"/>

	<input type="text" name="username" />

	<button type="button" onclick="ajaxToServer();">입력</button>
</form>

<hr>

<div id="result"></div>

</body>
</html>















