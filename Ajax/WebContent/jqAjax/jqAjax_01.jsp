<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#btnCalc").click(function() {
		console.log("btnCalc clicked")
		
		//	요청 URL
		var url = "/jqAjax/jqAjax_ok.jsp"
		
		//	요청 파라미터 - String 타입
		var data = "n1=" + $("#num1").val()
			+ "&n2=" + $("#num2").val()
			+ "&op=" + $("#oper").val();
		console.log("data", data)
			
		
		//	요청 파라미터 - PlainObject 타입 (JS Object)
		var dataObj = {
			"n1": $("#num1").val()
			, "n2" : $("#num2").val()
			, "op" : $("#oper").val()
		};
		console.log("dataObj", dataObj)
		
		
// 		//	GET방식으로 AJAX요청 보내기
// 		$.get(url, dataObj, function( res ) {
// 			console.log("--- 응답 데이터 ---")
// 			console.log( res )
			
// 			//	응답 데이터 div#resultLayou에 반영하기
// 			$("#resultLayou").html(res);
			
// 			//	입력창 초기화
// 			$("#num1").val("");
// 			$("#num2").val("");
// 			$("#oper").val("add");
			
// 			//	#num1으로 포커스 주기
// 			$("#num1").focus();
			
// 		}, "html")
		
		//	POST방식으로 AJAX요청 보내기
		$.post(url, dataObj, function( res ) {
			console.log("--- 응답 데이터 ---")
			console.log( res )
			
			//	응답 데이터 div#resultLayout에 반영하기
			$("#resultLayout").html(res);
			
			//	입력창 초기화
			$("#num1").val("");
			$("#num2").val("");
			$("#oper").val("add");
			
			//	#num1으로 포커스 주기
			$("#num1").focus();
			
		}, "html")
	})
})



</script>
</head>
<body>

<h1>jQuery AJAX 계산기 01</h1>
<hr>

<input type="text" id="num1" />
<select id="oper">
	<option value="add">더하기</option>
	<option value="sub">빼기</option>
	<option value="mul">곱하기</option>
	<option value="div">나누기</option>
</select>
<input type="text" id="num2" />
<button id="btnCalc">=</button>

<hr>
<div id="resultLayout"></div>
</body>
</html>