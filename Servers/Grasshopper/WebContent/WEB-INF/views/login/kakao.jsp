<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!-- 카카오 스크립트 -->


<!--<ul> -->

<div class="button-group">
	<button type="button" onclick="kakaoLogin(); return false"><a href="javascript:void(0)"><img style="" src ="../resources/img/kakao.jpg" ></a></button>
</div>

      
	
	<!-- <li onclick="kakaoLogout(); return false;">
      <a href="javascript:void(0)">
          <span>카카오 로그아웃</span>
      </a>
	</li>  -->
<!-- </ul> -->

<!-- 카카오 스크립트 -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
Kakao.init('15da5dfa386463a50baf7f8c32fcc0c2'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단
//카카오로그인
function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
        	  console.log(response)
          },
          fail: function (error) {
            console.log(error)
          },
        })
      },
      
      fail: function (error) {
        console.log(error)
      },
    })
  }
  
//카카오로그아웃  
function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
        	console.log(response)
        },
        fail: function (error) {
          console.log(error)
        },
      })
      Kakao.Auth.setAccessToken(undefined)
    }
  }  
</script>