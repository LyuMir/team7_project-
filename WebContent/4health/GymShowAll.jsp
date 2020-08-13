<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.team7.vo.Gym_info" %>
<%@ page import="com.team7.vo.PhotoBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.*" %>

    <meta charset="utf-8">
    <title>헬스장찾기</title>
    <!-- <link href="https://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css"> -->
      <!-- <link rel="stylesheet" href="css/styleyuncard.css" /> -->
      <!-- <link rel="stylesheet" href="css/normalizeyuncard.css"> -->
      <!-- <link rel="stylesheet" href="css/mainyun.css"> -->
      <!-- <link rel="stylesheet" type="text/css" href="css/gridgrid88yuncard.css"> -->
      <link rel="stylesheet" type="text/css" href="css/gridgrid88.css">
      <link rel="stylesheet" type="text/css" href="css/picpiccard.css">
      <link rel="stylesheet" type="text/css" href="css/gridgrid_new.css">
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
List<Gym_info> gser  = (List<Gym_info>) request.getAttribute("gser");
List<PhotoBean> photos = (List<PhotoBean>) request.getAttribute("photos");
%>


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



<div class="dicclean">
</div>

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


  <div id="gallery">

<!-- 태그버튼 여기  -->
  <div id="buttons">
      <div id="buttons0"></div>
      <div id="buttons1"></div>
      <div id="buttons2"></div>
  </div>

<div class="grid">

     <% for(int i =0 ; i < gser.size() ; i++){ %>

  <article class="grid__item" onclick="javascript:location.href='GymUserpage.health?number=<%=gser.get(i).getGid() %>'">
    <div class="card">
      <div class="card__img">
      	<img class="card__img" src="Files/gym/<%=gser.get(i).getOwner()%>/1/<%=photos.get(0).getPicture() %>" alt="<%=gser.get(i).getPicture() %>">
      </div>
      <div class="card__content2">
        <!-- <div class="__tag00"> <%=gser.get(i).getGid()%></div> -->
        <div class="content__header"><%=gser.get(i).getGname()%> </div>
        <div class="content__text"><%=gser.get(i).getGsmalltext()%></div>
        <div class="content_what">서비스 : <span><%= gser.get(i).getGtype() %></span></div>
        <div class="content_where">장소 : <span><%=gser.get(i).getAddress()%></span></div>
      </div>
    </div>
  </article>
    <%} %>
</div>
</div>

<style type="text/css">
  #gallery{
    width: 100%;
    margin: 20px;
    max-width: 900px;
  }
  .card__content2 *{
    font-size: 12px;
    margin: 2.5px;
  }
  .content__header{
    font-size: 14px;
  }
  .grid{
    all:unset;
    display: grid;
    grid-template-columns: repeat(auto-fill, 250px);
  }

  @media only screen and (max-width: 600px){
    .grid{
      grid-template-columns: unset;
      grid-template-columns: repeat(auto-fill,1fr);
    }
  }

</style>

<script src="js/taggings_jay.js?ver=3"></script>
        <!-- <script src="js/filter-tagscard.js"></script> -->
        <!-- <script type="text/javascript"></script> -->
        <!-- <script src="js/" type="text/javascript"></script> -->


  </main>
