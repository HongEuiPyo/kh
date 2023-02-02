<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<style>
.popupWrap {
	z-index: 99999;
	width: 100%;
	height: 100%;
	position: absolute;
	top: 0;
	left: 0;
	background-color: rgba(0, 0, 0, 0.6);
}

.popupWrap .popup {
	position: absolute;
	left: 50%;
	top: 50%;
	margin-left: -150px;
	margin-top: -150px;
	width: 300px;
	height: 300px;
	background-color: #fff;
	padding: 1rem;
}

.popupWrap div textarea {
	width: 100%;
}

.popupWrap div .title {
	display: flex;
	align-items: center;
	justify-content: space-between;
}

.hide {
	display: none;
}
</style>
</head>
<body>
	<div>
		<p>다영이</p>
		<div class="popupWrap hide">
			<form action="">
				<div class="popup">
					<div class="title">
						<p>다영이 정보</p>
						<span class="close">❌</span>
					</div>
					<textarea name="" id="" cols="30" rows="10"></textarea>
					<button>보내기</button>
				</div>
			</form>
		</div>
	</div>

	<script>
		$('p').on('click', function() {
			$(this).siblings('div').removeClass('hide');
		});
		$('.close').on('click', function() {
			$(this).parents('.popupWrap').addClass('hide');
		});
	</script>
</body>
</html>