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
	
	//	#btnAction�� click �̺�Ʈ ������ ���
	btnAction.onclick = function() {
		console.log("btnAction clicked")
		
		//AJAX ��û ������
		sendRequest("POST", "/ajax/test01", "", callback)
		
	}
	
}

function callback() {
	if(httpRequest.readyState == 4) {
		if(httpRequest.status == 200) {
			console.log("�������� AJAX ��û/���� �Ϸ�")
			
			//	��� ó�� �Լ� ȣ��
			printData();
			
		} else {
			console.log("AJAX ��û/���� ����")
		}
	}
}

//	���� ����� ó���ϴ� �Լ�
function printData() {
	console.log("printData called")
	
	//AJAX ���� ������
	var respText = httpRequest.responseText;
	console.log("--- respText ---")
	console.log(respText)
	
	//	�𸶼���, JSON Text -> JS Data (String)
	var jsData = JSON.parse( respText )
	console.log("--- jsData ---")
	console.log(jsData)
	
	//------------------------------------------------
	
	//	���� �����͸� ������ ���� (array)
	var list = JSON.parse( httpRequest.responseText );
	
	//	DOM API�� �̿��Ͽ� html ���� �ۼ�
	var html = "";
	for( var i=0; i<list.length; i++) {
		html += "<h1>" + list[i].id + ":" + list[i].pw + "</h1>";
	}
	//	�ϼ��� html ������ #result�� �ݿ��ϱ�
	result.innerHTML = html;
}

 

</script>

</head>
<body>

<h1>AJAX �׽�Ʈ</h1>
<hr>

<button id="btnAction">AJAX ��û</button>

<div id="result"></div>


</body>
</html>