<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.team7.vo.PhotoBean" %>
<%@ page import="com.team7.vo.Trainer_info" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.*" %>

    <meta charset="utf-8">
    <title>코치찾기</title>
    <!-- <link href="https://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css"> -->
      <!-- <link rel="stylesheet" href="css/styleyuncard.css" /> -->
      <!-- <link rel="stylesheet" href="css/normalizeyuncard.css"> -->
      <!-- <link rel="stylesheet" href="css/mainyun.css"> -->
      <!-- <link rel="stylesheet" type="text/css" href="css/gridgrid88yuncard.css"> -->
      <link rel="stylesheet" type="text/css" href="css/picpiccard.css">
      <link rel="stylesheet" type="text/css" href="css/gridgrid_new.css">


<%
request.setCharacterEncoding("UTF-8");
List<Trainer_info> tser  = (List<Trainer_info>) request.getAttribute("tser"); 
List<PhotoBean> photos = (List<PhotoBean>) request.getAttribute("photos");%>


<div class="container00">
  <img src="img\main3look.jpg" class="pic_000">
  <div class="text00">
    <h1 class="hero__look">지역과 프로그램을 선택하세요</h1>
    <p class="hero__snippet">당신에게 딱 맞는 코치진을 보여드립니다!</p>
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
<main class="mainwrap">

        <div class="container2">
          <div >

            <div class="containertext">
          <h3 > 맞춤 코치찾기 </h3>
          <p class="hero__snippet">  가격 정찰제를 통한 신뢰! </p>
        </div>
      </div>
          </div>

<!-- 태그 여기  -->
  <div id="buttons">
      <div id="buttons0"></div>
      <div id="buttons1"></div>
      <div id="buttons2"></div>
  </div>

<!-- 검색기능 여기  -->
    <div id="searchBar">
        <input id="search_club_name" type="text" name="" placeholder="이름 검색">
    </div>


<div id="gallery">

  <div class="grid">

     <% for(int i =0 ; i < tser.size() ; i++){ %>

      <article class="grid__item" data-tags="<%= tser.get(i).getTmajor() %>" data-name="<%=tser.get(i).getTname() %>" onclick="javascript:window.location.href='trainerUserpage.trainer?number=<%= tser.get(i).getNo()%>'">
        <div class="card">
          <div class="card__img">
<% 

String picwhere = "";
String picalt = "";
  for(int j = 0 ; j < photos.size();j++){
      if(photos.get(j).getId().contains(tser.get(i).getId()+"_")){ 
        picwhere = "Files/trainer/"+tser.get(i).getId()+"/1/"+photos.get(j).getPicture();
        picalt = "tser.get(i).getPicture()";
        break;
      } else{ 
          int k = (int)(Math.random() * 6)+1;
        picwhere = "img/exc/yoga"+k+".jpg";
      }
  } %>

          <img class="card__img" src="Files/trainer/<%=tser.get(i).getId() %>/1/<%=tser.get(i).getPicture() %>" alt="Snowy Mountains">
          <img class="card__img" src="<%=picwhere %>" alt="<%=picalt %>">
        </div>
        <div class="card__content2">
          <div class="content__header"><%=tser.get(i).getTname() %> </div>
          <div class="content__text"><%=tser.get(i).getTsmalltext()%></div>
          <div class="content_what">서비스 : <span><%= tser.get(i).getTmajor() %></span></div>
          <div class="content_where">장소 : <span><%=tser.get(i).getTwhere()%></span></div>
        </div>
      </div>
      </article>
 <%} %>
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
          <!-- <script src="js/filter-tagscard.js"></script> -->
<script src="js/taggings_jay.js?ver=3"></script>

<script type="text/javascript">
  
  var all_no_arr =[];
  var article00 = $('article.grid__item');
  var search00 = $('#searchBar').children('input');
</script>

<script type="text/javascript" src="88search/searchJ.js"></script>


</main>

