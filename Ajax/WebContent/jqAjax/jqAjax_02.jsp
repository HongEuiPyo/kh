<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#btnCalc").click(function(){
		console.log("btnCalc clicked")
		
		$.ajax({
			type: "get"	//	요청 메소드
			, url: "/jqAjax/jqAjax_ok.jsp"	//	요청 URL
			, data: {	//	전달 파라미터
				n1: $("#num1").val()
				, n2: $("#num2").val()
				, op: $("#oper").val()
			}
			, dataType : "html"	//	응답 데이터 형식
			, success: function() {
				$("resultLayout").html(res)
				
				//	입력창 초기화
				$("#num1").val("");
				$("#num2").val("");
				$("#oper").val("add");
				
				//	#num1으로 포커스 주기
				$("#num1").focus();
				
			}
			, error: function() {
				console.log("에러 발생")
				
				
			}
		})//	ajax() end
		
	})//	click() end
	
})//	ready() end


</script>
</head>
<body>

<h1>jQuery AJAX 계산기 02</h1>
<hr>

<input type="text" id="num1" />
<select id="oper">
	<option value="add">더하기</option>
	<option value="sub">빼기</option>
	<option value="mul">곱하기</option>
	<option value="div">나누기</option>
</select>
<input type="text" id="num2" />

<button id="btnCalc"> = </button>

<hr>
<div id="resultLayout"></div>

</body>
</html>