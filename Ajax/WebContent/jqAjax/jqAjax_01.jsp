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
		
		//	��û URL
		var url = "/jqAjax/jqAjax_ok.jsp"
		
		//	��û �Ķ���� - String Ÿ��
		var data = "n1=" + $("#num1").val()
			+ "&n2=" + $("#num2").val()
			+ "&op=" + $("#oper").val();
		console.log("data", data)
			
		
		//	��û �Ķ���� - PlainObject Ÿ�� (JS Object)
		var dataObj = {
			"n1": $("#num1").val()
			, "n2" : $("#num2").val()
			, "op" : $("#oper").val()
		};
		console.log("dataObj", dataObj)
		
		
// 		//	GET������� AJAX��û ������
// 		$.get(url, dataObj, function( res ) {
// 			console.log("--- ���� ������ ---")
// 			console.log( res )
			
// 			//	���� ������ div#resultLayou�� �ݿ��ϱ�
// 			$("#resultLayou").html(res);
			
// 			//	�Է�â �ʱ�ȭ
// 			$("#num1").val("");
// 			$("#num2").val("");
// 			$("#oper").val("add");
			
// 			//	#num1���� ��Ŀ�� �ֱ�
// 			$("#num1").focus();
			
// 		}, "html")
		
		//	POST������� AJAX��û ������
		$.post(url, dataObj, function( res ) {
			console.log("--- ���� ������ ---")
			console.log( res )
			
			//	���� ������ div#resultLayout�� �ݿ��ϱ�
			$("#resultLayout").html(res);
			
			//	�Է�â �ʱ�ȭ
			$("#num1").val("");
			$("#num2").val("");
			$("#oper").val("add");
			
			//	#num1���� ��Ŀ�� �ֱ�
			$("#num1").focus();
			
		}, "html")
	})
})



</script>
</head>
<body>

<h1>jQuery AJAX ���� 01</h1>
<hr>

<input type="text" id="num1" />
<select id="oper">
	<option value="add">���ϱ�</option>
	<option value="sub">����</option>
	<option value="mul">���ϱ�</option>
	<option value="div">������</option>
</select>
<input type="text" id="num2" />
<button id="btnCalc">=</button>

<hr>
<div id="resultLayout"></div>
</body>
</html>