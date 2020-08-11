"_FORWHERE.jsp?forwhere=4health/gym_Apply.jsp"<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

                  <article class="grid__item" data-tags="<%= tser.get(i).getTmajor() %>">
                    <div class="card">
                      <div class="card__img">
                      <a href = "trainerUserpage.trainer?number=<%= tser.get(i).getNo()%>"> <img class="card__img" src="Files/trainer/<%=tser.get(i).getId() %>/1/<%=tser.get(i).getPicture() %>" alt="Snowy Mountains"></a> 
                      </div>
                    <div class="card__content">
                      <div class="card__tag00"> <%=tser.get(i).getTname() %></div>
                      <div class="card__header"><%=tser.get(i).getTbigtext() %> </div>
                      <p class="card__text"><%=tser.get(i).getTsmalltext() %></p>
                     <!--  <button class="card__btn card__unshow_">자세히 <span>&rarr;</span></button> 우선 버튼 치우고  -->
                    </div>
                  </div>
                  </article>

                 <input type="hidden" name="number" value="<%= tser.get(i).getNo() %>">
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

          <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha384-xBuQ/xzmlsLoJpyjoggmTEz8OWUFM0/RC5BsqQBDX2v5cMvDHcMakNTNrHIW2I5f" crossorigin="anonymous"></script>
          <script src="js/filter-tagscard.js"></script>




    </main>


</body>
</html>
