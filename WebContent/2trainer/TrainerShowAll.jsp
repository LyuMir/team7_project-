<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.team7.vo.PhotoBean" %>
<%@ page import="com.team7.vo.Trainer_info" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.*" %>

    <meta charset="utf-8">
    <title>코치찾기</title>
    <link href="https://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
      <link rel="stylesheet" href="css/styleyuncard.css" />
      <link rel="stylesheet" href="css/normalizeyuncard.css">
      <!-- <link rel="stylesheet" href="css/mainyun.css"> -->
      <link rel="stylesheet" type="text/css" href="css/gridgrid88yuncard.css">
      <link rel="stylesheet" type="text/css" href="css/picpiccard.css">


<%
request.setCharacterEncoding("UTF-8");
List<Trainer_info> tser  = (List<Trainer_info>) request.getAttribute("tser"); 
List<PhotoBean> photos = (List<PhotoBean>) request.getAttribute("photos");%>



<body id="top">

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
     <main role="main">


        <div class="container2">
          <div >

            <div class="containertext">
          <h3 > 맞춤 코치찾기 </h3>
          <p class="hero__snippet">  가격 정찰제를 통한 신뢰! </p>
        </div>
      </div>
          </div>

              <div id="buttons"></div>


              <div id="gallery">

                <div class="grid">

     <% for(int i =0 ; i < tser.size() ; i++){ %>

                  <article class="grid__item" data-tags="<%= tser.get(i).getTmajor() %>" onclick="javascript:window.location.href='trainerUserpage.trainer?number=<%= tser.get(i).getNo()%>'">
                    <div class="card">
                      <div class="card__img">
                      <img class="card__img" src="Files/trainer/<%=tser.get(i).getId() %>/1/<%=tser.get(i).getPicture() %>" alt="Snowy Mountains">
                      </div>
                    <div class="card__content">
                      <div class="card__tag00"> <%=tser.get(i).getTname() %></div>
                      <div class="card__header"><%=tser.get(i).getTbigtext() %> </div>
                      <p class="card__text"><%=tser.get(i).getTsmalltext() %></p>
                     <!--  <button class="card__btn card__unshow_">자세히 <span>&rarr;</span></button> 우선 버튼 치우고  -->
                    </div>
                  </div>
                  </article>

                 <!-- <input type="hidden" name="number" value="<%= tser.get(i).getNo() %>"> -->
           <%} %>
              </div>

          <script src="js/filter-tagscard.js"></script>




    </main>


</body>
</html>
