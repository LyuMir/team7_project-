<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html class="js">
<head>
    <meta charset="utf-8">
    <title>데일리 헬스</title>
    <!--  넌 문제 맞음... main -->
    <link rel="stylesheet" href="css/main.css?ver=6">
    <link rel="stylesheet" type="text/css" href="css/mainmain88.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700" rel="stylesheet">
    <link rel="stylesheet" href="css\grt-responsive-menu.css">

<!-- Jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="js\grt-responsive-menu.js?v=<%=System.currentTimeMillis()%>"></script>

    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,400,300,700" rel="stylesheet" type='text/css'>

    <script type="text/javascript">
      window.onload = function(){
        var width00 = (2000 - $(window).width()) / 2;
        $('.main_pic_00').css("transform","translate( -"+width00+"px , 0% )");


      }

      $(window).resize(function(){
        var width00 = (2000 - $(window).width()) / 2;
        $('.main_pic_00').css("transform","translate( -"+width00+"px , 0% )");

      }); 

      $(window).scroll(function() {
        if ($(window).scrollTop() > 20) {
          $('.j_follow_nav').addClass('follow_me_00');
        }
        else{
          $('.j_follow_nav').removeClass('follow_me_00');

        }
      });


    </script>

</head>
<body>

<%
request.setCharacterEncoding("UTF-8");
//    String fail2 =request.getParameter("fail");
    //String log_id = (String) session.getAttribute("LOG_ID");
    Integer log_st = (Integer) session.getAttribute("LOG_STATUS");
    //String whatdo = request.getParameter("whatdo");

    if(log_st==null){
      log_st = 0; 
      session.setAttribute("LOG_STATUS",0);
      %>
      
      <%@ include file="header.jsp" %>
   	<%@ include file="../Join_and_LogIn_forModal.jsp" %>
      
      <%
  }
  else if(log_st==0)  { //?? 안 먹나?
  %>
<!-- 헤더를 include로 해봅시다. : 로그인 안 되어있을 시  -->
<%@ include file="header.jsp" %>
   	<%@ include file="../Join_and_LogIn_forModal.jsp" %>

<%
  }
  else{
  %>
<!-- 헤더를 include로 해봅시다. : 로그인 되어있을 시  -->
<%@ include file="header2.jsp" %>
<%
  }
%>



<!-- 네비도 include로 할겁니다.  -->
<%@ include file="nav.jsp" %>
        <a id="showHere"></a>

<main role="main">

  <section class="hero">
    <div class="wrap__pic__00">
      <img src="img\main3.jpg" class="main_pic_00" >
    </div>
      <div class="text">
        <h1 class="hero__title">D a i l y  health.jy</h1>
        <p class="hero__snippet">for better life, better health.</p>
        <ul class="btn-list">
            <li class="btn-list__item"><a class="hero__btn  btn" href="Search.trainer">상담신청</a></li>
            <li class="btn-list__item"><a class="hero__btn  btn" href="Mng.health">사업등록</a></li>
        </ul>
      </div>
  </section>

<%@ include file="../6posts/Testing.jsp" %>
<!-- 최근 게시물 -->
<%@ include file="../6posts/Index_post.jsp" %>

<!-- 추천 게시물  -->
<%@ include file="../6posts/index_recommend.jsp" %>
    </main>

<!-- include로 뺀 푸터  -->
<%@ include file="footer.jsp" %>




</body>
</html>
