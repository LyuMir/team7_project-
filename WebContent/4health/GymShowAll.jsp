<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.team7.vo.Gym_info" %>
<%@ page import="com.team7.vo.PhotoBean" %>
<%@ page import="com.team7.vo.ZZIMBean" %>
<%@ page import="com.team7.vo.PostBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.*" %>

    <meta charset="utf-8">
    <title>헬스장찾기</title>
    <!-- <link href="https://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css"> -->
      <!-- <link rel="stylesheet" href="css/styleyuncard.css" /> -->
      <!-- <link rel="stylesheet" href="css/normalizeyuncard.css"> -->
      <!-- <link rel="stylesheet" href="css/mainyun.css"> -->
      <!-- <link rel="stylesheet" type="text/css" href="css/gridgrid88yuncard.css"> -->
      <!-- <link rel="stylesheet" type="text/css" href="css/gridgrid88.css"> -->
      <link rel="stylesheet" type="text/css" href="css/picpiccard.css"> 
      <link rel="stylesheet" type="text/css" href="css/gridgrid_new.css">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=	21d928db4da229461e099041921f1bbc"></script>
<script>
		var container3 = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(33.450701, 126.570667),
			level: 3
		};

		var map = new kakao.maps.Map(container3, options);

	</script>

<%
request.setCharacterEncoding("UTF-8");
List<Gym_info> gser  = (List<Gym_info>) request.getAttribute("gser");
List<PhotoBean> photos = (List<PhotoBean>) request.getAttribute("photos");
List<ZZIMBean> gymzzim = (List<ZZIMBean>) request.getAttribute("gymzzim");
List<PostBean> posts = (List<PostBean>) request.getAttribute("posts");

if( gymzzim ==null || gymzzim.size() <1 ) gymzzim = new ArrayList<ZZIMBean>();
if( posts ==null || posts.size() <1 ) posts = new ArrayList<PostBean>();
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

  본 서비스는 .....   <a href="" class="href">코치검증절차</a>
  <br>

<hr>


<a id="showHere"></a>
<main class="mainwrap">


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
<!-- 검색기능 여기  -->
    <div id="searchBar">
        <input id="search_club_name" type="text" name="" placeholder="이름 검색">
    </div>

<div class="grid">

     <% for(int i =0 ; i < gser.size() ; i++){ 
     
     %>

  <article style="margin:7px;" class="grid__item" data-name="<%=gser.get(i).getGname()%>" onclick="javascript:location.href='GymUserpage.health?number=<%=gser.get(i).getGid() %>'">
    <div class="card">
      <div class="card__img">
<% 

String picwhere = "";
	for(int j = 0 ; j < photos.size();j++){
      if(!photos.get(j).getPicture().equals("") && 
    		  photos.get(j).getId().contains(gser.get(i).getOwner()+"_")){ 
        picwhere = "Files/gym/"+gser.get(i).getOwner()+"/1/"+photos.get(j).getPicture();
        break;
      } else{ 
      		int k = (int)(Math.random() * 4)+1;
        picwhere = "img/exc/gym"+k+".jpg";
      }
	} %>
        <img class="card__img" src="<%=picwhere %>">
      </div>
      <div class="card__content2">
        <div class="content__header"><%=gser.get(i).getGname()%> </div>
        <div class="content__text"><%=gser.get(i).getGsmalltext()%></div>
        <div class="content_what"> <span><%= gser.get(i).getGtype() %></span></div>
        <div class="content_where">장소 : <span><%=gser.get(i).getAddress()%></span></div>
        <div class="card__heart" style="position:unset;">
            <!-- heart zzim의 관계 설정. ... onclick="Zzimshow_club(this)" -->
            <div class="zzimSystem"  data-id="<%=gser.get(i).getGid()%>">
            
		<%
			int zzim = 0 ;
			for(int k = 0 ; k < gymzzim.size(); k++){
				if(gymzzim.get(k).getGym() == gser.get(i).getGid()){
					zzim++;
				}
			}
			int postnum = 0 ; 
			for(int k= 0 ; k <posts.size(); k++){
				if(posts.get(k).getGym() == gser.get(i).getGid())
					postnum=posts.get(k).getNo();
			}
		%>
              <img src="img/heart_and_star/heart034.png"> <span class="counter" data-target=""> <%=zzim %>  </span>
            </div>
						<img src="img/heart_and_star/star22.png">  <span> <%=postnum %></span>
           
					</div>
      </div>
    </div>
  </article>
    <% }%>
</div>
</div>

<style type="text/css">
  #gallery{
    width: 100%;
    margin: 20px auto;
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
    margin-top: 20px;
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
<script type="text/javascript">
  
  var all_no_arr =[];
  var article00 = $('article.grid__item');
  // var sthgood="hey!";
  // for (var i = 0; i < article00.length; i++) {
  //     // all_no_arr[i]= article00.eq(i).data('id').toString();
  //     all_no_arr[i]= article00.eq(i).data('id');
  // }
  // console.log(all_no_arr);

  var search00 = $('#searchBar').children('input');


</script>
<script type="text/javascript" src="88search/searchJ.js"></script>
        <!-- <script src="js/filter-tagscard.js"></script> -->
        <!-- <script type="text/javascript"></script> -->
        <!-- <script src="js/" type="text/javascript"></script> -->


  </main>
