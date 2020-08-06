<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <link rel="stylesheet" href="css/main.css">
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
		var log_status ;
		<%

			int log_status = (Integer) session.getAttribute("LOG_STATUS");
		%>
		log_status = <%= log_status%>;

    </script>


<%
request.setCharacterEncoding("UTF-8");
//    String fail2 =request.getParameter("fail");	//흠...
//    String log_id = (String) session.getAttribute("LOG_ID");
    Integer log_st = (Integer) session.getAttribute("LOG_STATUS");
//    String whatdo = request.getParameter("whatdo");	//흠.....2


    String forwhere = request.getParameter("forwhere");
    
//    if(forwhere.startsWith("club_") || forwhere.startsWith("__club")){
 //   	forwhere = "3club\\"+forwhere;
//    } //ㅋㅋ 이런 꼼수 너무 좋아... ...근데 안되네..
    

    if(log_st==null){
    	log_st = 0; 
    	session.setAttribute("LOG_STATUS",0);
   %>
   
   <%@ include file="0frame/header.jsp" %>
	<%@ include file="Join_and_LogIn_forModal.jsp" %>
   
   <%
  }
  else if(log_st==0)  { //?? 안 먹나?
  %>
<!-- 헤더를 include로 해봅시다. : 로그인 안 되어있을 시  -->
<%@ include file="0frame/header.jsp" %>
<%@ include file="Join_and_LogIn_forModal.jsp" %>

<%
  }
  else{
  %>
<!-- 헤더를 include로 해봅시다. : 로그인 되어있을 시  -->
<%@ include file="0frame/header2.jsp" %>
<%
  }
%>






<!-- 네비도 include로 할겁니다.  -->
<%@ include file="0frame/nav.jsp" %>
<a id="showHere"></a>

<!-- 메인이 올 자리입니다.  -->
<jsp:include page="<%=forwhere%>" flush="false"/>

<!-- include로 뺀 푸터  -->
<%@ include file="0frame/footer.jsp" %>


