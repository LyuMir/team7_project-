<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.team7.vo.Gym_info" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.*" %>

    <meta charset="utf-8">
    <title>헬스장찾기</title>
    <link href="https://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
      <link rel="stylesheet" href="css/styleyuncard.css" />
      <link rel="stylesheet" href="css/normalizeyuncard.css">
      <!-- <link rel="stylesheet" href="css/mainyun.css"> -->
      <link rel="stylesheet" type="text/css" href="css/gridgrid88yuncard.css">
      <link rel="stylesheet" type="text/css" href="css/picpiccard.css">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=	21d928db4da229461e099041921f1bbc"></script>
<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(33.450701, 126.570667),
			level: 3
		};


		var map = new kakao.maps.Map(container, options);
		
	</script>

<%
request.setCharacterEncoding("UTF-8");
List<Gym_info> gser  = (List<Gym_info>) request.getAttribute("gser"); %>



<body id="top">
<hr>
<div id="map" style="width:100%;height:350px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=발급받은 APP KEY를 사용하세요"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(33.450701, 126.570667); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);
</script>
<div class="container00">
  <img src="img\main3look.jpg" class="pic_000">
  <div class="text00">
    <h1 class="hero__look">태그에 맞춰 헬스장을 검색하세요!</h1>
    <p class="hero__snippet">당신에게 딱 맞는 헬스장을 추천해드립니다!</p>
      <a class="btn00" href="">사용 방법</a>

    </div>
  </div>



</div>
<div class="dicclean">
</div>

<hr>
<div class="ycontainertxt">

  본 서비스는 어쩌고저쩌고 이렇게 진행이 됩니다알겠죠???   <a href="ddd" class="href">코치검증절차</a>
  <br>여기에다가 공개적인 문구를 넣어줍니다~~~~~~~~~~~~~~~~~~~

</div>
<hr>


<a id="showHere"></a>
<main role="main">


  <div class="container2">
    <div >

      <div class="containertext">
        <h3 > 맞춤 헬스장찾기 </h3>
        <p class="hero__snippet">  가격 정찰제를 통한 신뢰! </p>
      </div>
    </div>
  </div>

  <div id="buttons"></div>


  <div id="gallery">

    <div class="grid">

     <% for(int i =0 ; i < gser.size() ; i++){ %>

     <article class="grid__item" data-tags="<%= gser.get(i).getGname() %>">
      <div class="card">
        <div class="card__img">
          <a href = "GymUserpage.health?number=<%=gser.get(i).getGid()%>"> 
          	<img class="card__img" src="Files/gym/<%=gser.get(i).getOwner()%>/1/<%=gser.get(i).getPicture() %>" alt="<%=gser.get(i).getPicture() %>">
          </a> 
        </div>
        <div class="card__content">
          <div class="card__tag00"> <%=gser.get(i).getGid()%></div>
          <div class="card__header"><%=gser.get(i).getGname()%> </div>
          <p class="card__text"><%=gser.get(i).getGsmalltext()%></p>
          <!--  <button class="card__btn card__unshow_">자세히 <span>&rarr;</span></button> 우선 버튼 치우고  -->
        </div>
      </div>
    </article>

    <input type="hidden" name="number" value="<%=gser.get(i).getGid()%>">
    <%} %>





                <!-- <img src="https://picsum.photos/600/450?image=776" data-tags="Blog" alt="Alt 1" />

                <img src="https://picsum.photos/600/450?image=777" data-tags="Health & Beauty" alt="Alt 2" />

                  <img src="https://picsum.photos/600/450?image=755" data-tags="Business" alt="Alt 3" />

                  <img src="https://picsum.photos/600/450?image=778" data-tags="Blog,Health & Beauty" alt="Alt 4" />
                  <img src="https://picsum.photos/600/450?image=764" data-tags="Business" alt="Alt 5" />

                  <img src="https://picsum.photos/600/450?image=526" data-tags="Blog,Shop" alt="Alt 6" />

                  <img src="https://picsum.photos/600/450?image=668" data-tags="Blog,Megazine" alt="Alt 7" />
                  <img src="https://picsum.photos/600/450?image=660" data-tags="Blog" alt="Alt 8" />

                  <img src="https://picsum.photos/600/450?image=659" data-tags="Blog,Portfolio" alt="Alt 9" />
                  <img src="https://picsum.photos/600/450?image=513" data-tags="Business" alt="Alt 10" />
                  <img src="https://picsum.photos/600/450?image=535" data-tags="Shop" alt="Alt 11" />
                  <img src="https://picsum.photos/600/450?image=531" data-tags="Shop,Blog" alt="Alt 12" /> -->


        </div>

     <!--    <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha384-xBuQ/xzmlsLoJpyjoggmTEz8OWUFM0/RC5BsqQBDX2v5cMvDHcMakNTNrHIW2I5f" crossorigin="anonymous"></script> -->
        <script src="js/filter-tagscard.js"></script>




  </main>


</body>
</html>
