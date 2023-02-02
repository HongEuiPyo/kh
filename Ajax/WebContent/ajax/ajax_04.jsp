<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<!-- 'httpRequest' 불러오기 -->
<script type="text/javascript"	src="<%=request.getContextPath() %>/resources/js/httpRequest.js"></script>

<script type="text/javascript">

function ajaxToServer() {
	console.log("ajaxToserver() called")
	
	//	전달 파라미터
	var params = 'username=' + document.f.username.value + '<br>' + document.f.content.value;
	
	//	AJAX 요청 보내기
	sendRequest("POST" , "/ajax/ajax_04_ok.jsp" , params , ajaxFromServer);
}

//	서버로부터 AJAX 응답을 받아 처리하는 함수
function ajaxFromServer() {
	console.log("ajaxFromServer() called")
	
	if( httpRequest.readyState == 4 ) {	//	DONE, 응답 완료
		if (httpRequest.status == 200 ) {	//	200 ok. 정상 응답
			console.log("AJAX 정상 응답")
			
			//	응답 데이터를 div에 반영하기
			result.innerHTML = httpRequest.responseText;
			
		} else {
			console.log("AJAX 요청/응답 에러")
		}
	}
}


</script>


</head>
<body>

<h1>AJAX 04</h1>
<hr>

<form name="f">
username : <input type="text" id="username" /><br>
content : <p><textarea id="content" rows="5" cols="25"></textarea></p><br>
<button type="button" onclick="ajaxToServer();">send</button>
</form>

<hr>

<div id="result"></div>

</body>
</html>