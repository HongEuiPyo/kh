<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

//	AJAX통신 객체인 XMLHttpRequest객체를 생성하는 함수 (크로스브라우징)
function createXHR() {
	
	//	XHR객체 변수
	var xmlReq = null;
	
	if( window.XMLHttpRequest ) {	//	XMLHttpRequest
		//	IE 7.0 이상
		//	IE브라우저가 아닐 때( 크롬, 사파리, 오페라 등등 )
	
		//	XHR객체 생성
		xmlReq = new XMLHttpRequest();
	
	} else if( window.ActiveXObject ) {	//	ActiveXObject내장 객체가 존재할 때
		//	IE 계열 브라우저
		
		try {
			//	비교적 최근 IE브라우저의 XHR객체 생성
			xmlReq = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(e1) {
			
			try {
				//	비교적 예전 버전 IE브라우저의 XHR객체 생성
				xmlReq = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(e2) {
				//	XHR 객체를 사용하지 못 하는 경우
				console.log("AJAX객체 생성 실패")
			}
			
		}
		
	}
	
	//	XHR객체 반환
	return xmlReq;
	
}

</script>

<script type = "text/javascript">

//	AJAX 객체 변수
var xmlHttp = null;

function calc() {
	console.log("calc called")
	
	//	XHR 객체 생성
	xmlHttp = createXHR();
	console.log(xmlHttp)
	
}
	var n1 = num1.


	//--- AJAX 요청 전 설정 ---
	//	요청 URL
	var url = "/ajax/ajax_02_ok.jsp"
	
	//요청 Method
	var method = "POST"
	
	//요청 파라미터
	var params = "num1="+n1+"&num2="+n2+"&oper="+op
	console.log("params", params)
	
	//서버의 응답을 전달받을 때 호출될 콜백함수
	xmlHttp.onreadystatechange = callback;
	
	//--- AJAX요청 준비 ---
// 	xmlHttp.open(method, url + "?" + params) //GET
	xmlHttp.open(method, url) //POST
	
	//요청 데이터 형식(인코딩) 설정
	xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
	
	//--- AJAX요청 보내기 ---
// 	xmlHttp.send(null) //GET
	xmlHttp.send(params) //POST

	
	function callback() {
		console.log("callback called")
		
		if
		
		
	}
	
</script>
</head>
<body>



<h1>계산기 02</h1>
<h3>기본 HTTP통신 (비동기식)</h3>

<input type="text" name="num1">
<select name="oper">
	<option value = "add">더하기</option>
	<option value = "sub">빼기</option>
	<option value = "mul">곱하기</option>
	<option value = "div">나누기</option>
</select>
<input type="text" name="num2">

<button onclick="calc() ">
</form>

</body>
</html>