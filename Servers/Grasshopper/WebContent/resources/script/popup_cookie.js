
		var myPopup = document.querySelector('.popup'),
			checkbox = document.querySelector('#popup'),
			popupClose = document.querySelector('#close');
		
		//		쿠키 생성
		function setCookie(name, value, day) {
			var date = new Date();
			date.setDate(date.getDate() + day);
			
			var mycookie = '';
			
			mycookie += name + '=' + value + ';'; 
			mycookie += 'Expires=' + date.toUTCString();
			
			document.cookie = mycookie;
		}
// 		setCookie('ABC.com' , 'Main' , 3);
		
		//		쿠키 삭제
		function delCookie(name) {
			var date = new Date();
			
			date.setDate(date.getDate() -1);
			
			var setCookie = '';
			
			setCookie += name + 'Main;';
			setCookie += 'Expires=' + date.toUTCString();
			
			document.cookie = setCookie;
		}
		
		//		쿠키 확인
		function checkCookie(name) {
			var cookies = document.cookie.split(';');
			console.log(cookies);
			var visited = false;	//		방문 거짓
			
			for(var i in cookies) {
				if(cookies[i].indexOf(name) > -1) {
					visited = true;
					console.log(visited);
				}
			}		
			
			if(visited) {
				//		재방문
				myPopup.style.display = 'none';
			} else {
				//		신규 방문				
				myPopup.style.display = 'block';	
			}
		}
		checkCookie('cocktail.com');
		
		popupClose.addEventListener('click', function(){
			//a.checked true false
			if(checkbox.checked) {
				//		팝업을 다시 안 보겠다. 팝업 닫고, 쿠키 생성.
				setCookie('cocktail.com' , 'Main' , 1);
				myPopup.style.display = 'none';
			} else {
				//		팝업을 계속 본다. 팝업 닫고, 쿠키 제거.
				myPopup.style.display = 'none';
				delCookie('cocktail.com');
			}
			
		});
	