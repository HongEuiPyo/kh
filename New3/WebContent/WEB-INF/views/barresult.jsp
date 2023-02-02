<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/header.jsp"/>

<!--   <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>주변에 마실 곳</title>
  <meta property="og:title" content="주변에 마실곳" />
  <meta property="og:description" content="칵테일바" />
  <meta property="og:image" content="image.jpg" />
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@400;700&display=swap" rel="stylesheet"> -->
  <style>
    * {
    font-family: 'Nanum Gothic', sans-serif;
    }

    .mytitle {
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;

      margin-top: 100px;
    }

    .btn {
      width: 300px;
      height: 40px;

      border: 2px solid #e8344e;
      text-decoration: none;
      text-align: center;

      line-height: 40px;
      color: #e8344e;
      font-weight: bold;
      border-radius: 40px;
    }

    .btn:hover {
      background-color: #e8344e;
      color: white;
    }

    .box {
      width: 1000px;
      display: flex;
      flex-direction: row;
      align-items: center;
      justify-content: center;
	  padding: 5px 10px;
      margin: 40px auto 100px auto;
    }

    .map {
      width: 500px;
      height: 500px;

      margin-right: 30px;
      border-radius: 24px;
    }

    .story {
      width: 450px;
      height: 500px;

    }

    .img {
      width: 450px;
      height: 300px;

      background-image: url('/resources/img/cocktailimg.jpg');
      background-position: center;
      background-size: cover;
      border-radius: 24px;
    }



    .story>h2 {
      margin: 20px 0 0 0;
      color: green;
    }

    .story>h3 {
      margin: 5px 0 0 0;
      font-size: 16px;
      color: grey;

      font-weight: normal;
    }

    .story>p {
      line-height: 24px;
    }

    @media screen and (max-width: 640px) {
      h1 {
        font-size: 26px;
      }

      .box {
        flex-direction: column;
        width: 100%;
      }

      .map {
        width: 100%;
        height: 200px;
        margin: 0;
      }

      .story {
        width: 100%;
        height: auto;

        margin-top: 15px;
        margin-bottom: 10px;
      }

      .img {
        width: 100%;
        height: 200px;
      }


    }
  </style>

</head>

<body>
  <div class="mytitle">
    <h1>추천 칵테일 바</h1>
    <a class="btn" href="https://map.naver.com/v5/search/%EA%B0%95%EB%82%A8%20bar?c=14127958.0057901,4511459.8281494,10,0,0,0,dh" target="_blank">주변 칵테일바 더 보기</a>
  </div>

  <div class="box">
    <div class="map" id="map">

    </div>
		<div class="story">
			<div class="img"></div>
			<h2>노마드</h2>
			<h3>서울특별시 강남구 청담동 128-3 1층</h3>
			<p>0507-1400-1283</p>
			<a href="https://blog.naver.com/bar_nomad">블로그 살펴보기</a>
		</div>

	</div>
  <script type="text/javascript"
    src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=0dbdd109eec260c2f9d9781b16dfb9bc"></script>
  <script>
    var markerPosition = new kakao.maps.LatLng(37.52667886305137, 127.05346855563634)
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
      mapOption = {
        center: markerPosition, // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
      };

    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

    var imageSrc = "https://www.pngall.com/wp-content/uploads/2017/05/Map-Marker-Free-Download-PNG.png";
    var imageSize = new kakao.maps.Size(35, 45);
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

    var marker = new kakao.maps.Marker({
      map: map,
      position: markerPosition,
      image: markerImage
    });

  </script>


<c:import url="/WEB-INF/views/layout/footer.jsp"/>
