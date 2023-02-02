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
	
	//	#btnAction에 click 이벤트 리스너 등록
	btnAction.onclick = function() {
		console.log("btnAction clicked")
		
		//AJAX 요청 보내기
		sendRequest("POST", "/ajax/test01", "", callback)
		
	}
	
}

function callback() {
	if(httpRequest.readyState == 4) {
		if(httpRequest.status == 200) {
			console.log("정상적인 AJAX 요청/응답 완료")
			
			//	결과 처리 함수 호출
			printData();
			
		} else {
			console.log("AJAX 요청/응답 실패")
		}
	}
}

//	응답 결과를 처리하는 함수
function printData() {
	console.log("printData called")
	
	//AJAX 응답 데이터
	var respText = httpRequest.responseText;
	console.log("--- respText ---")
	console.log(respText)
	
	//	언마샬링, JSON Text -> JS Data (String)
	var jsData = JSON.parse( respText )
	console.log("--- jsData ---")
	console.log(jsData)
	
	//------------------------------------------------
	
	//	응답 데이터를 변수에 저장 (array)
	var list = JSON.parse( httpRequest.responseText );
	
	//	DOM API를 이용하여 html 구문 작성
	var html = "";
	for( var i=0; i<list.length; i++) {
		html += "<h1>" + list[i].id + ":" + list[i].pw + "</h1>";
	}
	//	완성된 html 구문을 #result에 반영하기
	result.innerHTML = html;
}

 

</script>

</head>
<body>

<h1>AJAX 테스트</h1>
<hr>

<button id="btnAction">AJAX 요청</button>

<div id="result"></div>


</body>
</html>