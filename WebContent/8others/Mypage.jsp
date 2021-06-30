<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.team7.vo.MemberInfo1" %>
<%@ page import="com.team7.vo.PostBean" %>
<%@ page import="java.util.List" %>

<title> Mypage </title>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="css/mypage.css?ver=<%=System.currentTimeMillis()%>">
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="js/DAUM_adress.js"></script>
<%
String choice =request.getParameter("aaa");
String id = (String) session.getAttribute("LOG_ID");
%>
</head>
<!-- Start jside Menu -->
<div class="main">
  <h2>내 프로필</h2>
  <article class="sidenav">
    <div class="menu-body">
      <div class="menu-head">
       <span class="layer">
        <div class="col">
          <div class="row for-pic">
           <div class="profile-pic">
             <img src="img/eye.jpg" alt="Asif Mughal" />
           </div>
         </div>
         <div class="row for-name">
           <h3 title="User Name"><%=id %></h3>
           <span class="tagline"> 닉네임 </span>
         </div>
       </div> <!--//col-->
     </span>
   </div> <!--//menu-head-->
   <div class="menu-containers">
    <ul class="menu-items">
      <li class="thisnow"><a onclick="panelControl(1)"> <i class="material-icons">widgets</i>  나의 정보페이지 </a></li>
      <li><a onclick="panelControl(2)"> <i class="material-icons">bar_chart</i> 최근 본 페이지 </a></li>
      <li class="has-sub"> <span class="dropdown-heading"> <i class="material-icons">collections</i> 나의 관심바구니 </span>
       <ul>
        <li> <a onclick="acyncMovePage('myhealthzzim.mypage')"> 나의 헬스장 </a> </li>
        <li> <a onclick="panelControl(32)"> 나의 트레이너</a> </li>
        <li> <a onclick="panelControl(33)"> 나의 소모임</a> </li>

      </ul>
    </li>

    <li> <a onclick="panelControl(4)">  <i class="material-icons">color_lens</i>  내가 쓴 글 </a></li>
    <li><hr></li>
    <li> <a href="logout.log">  <i class="material-icons">pie_chart</i>  로그아웃 </a></li>

  </ul>
</div>
</div>
</article>
<!--End jSide Menu-->

<div class="myprofile" id="pp11">
  <!--  이 아래부분만 바뀌면 됩니다 -->
<div>

  <%@ include file="myprofile.jsp" %>

</div>
</div>
<div class="myprofile displaynone" id="pp22"> <!-- 최근 본 페이지 -->
  
</div>


<div class="fclear"></div>
</div>

<style type="text/css">
  .middler{
    margin: 0 auto;
    max-width: 91px;
  }
</style>




<!-- jQuery -->
<!--jSide Menu Js-->
<script src="js/jquery.jside.menu.js"></script>
<script>



  var info0 = $('#info0');
  var infoP = $('#infoP');
  infoP.slideToggle(10);

  function editpanel(){
    info0.slideToggle(300);
    infoP.slideToggle(300);
  }
  function editcancel(){
    info0.slideToggle(300);
    infoP.slideToggle(300);
  }
  function editsave(){

    if($('#name000').val()==""){
        alert('이름을 써 주세요!');
    }else $('#editForm').submit();
  }

  var pp1 = $('#pp11');
  var pp2 = $('#pp22');
  var pp31 = $('#pp31');
  var pp32 = $('#pp32');
  var pp33 = $('#pp33');
  var pp4 = $('#pp44');
  
  function acyncMovePage(url){
      // ajax option
      var ajaxOption = {
              url : url,
              async : true,
              type : "POST",
              dataType : "html",
              cache : false
      };
      
      $.ajax(ajaxOption).done(function(data){
          // Contents 영역 삭제
          $('#pp11').children().remove();
          // Contents 영역 교체
          $('#pp11').html(data);
      });
  }

  

  function panelControl(req){

      pp1.addClass('displaynone');
      pp2.addClass('displaynone');
      pp31.addClass('displaynone');
      pp32.addClass('displaynone');
      pp33.addClass('displaynone');
      pp4.addClass('displaynone');

    if(req == 1){ //나의 정보 페이지 
      pp1.removeClass('displaynone');
    }
    else if(req == 2){ // 최근 본 페이지 : 안씀

    }
    else if(req == 31){ // 나의 헬스장
     pp31.removeClass('displaynone');
    
     var url = "myhealthzzim.mypage";
     var datasss;
     var ajaxOption ={
         type:"GET",
         url:url,
         async:false,
         dataType:"html",
         };
     $.ajax(ajaxOption).done(function(data){
    	 
    	 $('#pp11').html(data)
     });

     
   
    }
    else if(req == 32){ // 나의 트레이너
      
      pp32.removeClass('displaynone');
    }
    else if(req == 33){ // 나의 소모임
      
      pp33.removeClass('displaynone');
    }
    else if(req == 4){ // 내가 쓴 글 
      
      pp4.removeClass('displaynone');
    }


  }

/*!  Plugin: jSide Menu (Responsive Side Menu)
 *   Dependency: jQuery 3.4.1 & Material Design Iconic Font 2.0
 *   Author: Asif Mughal
 *   GitHub: https://github.com/CodeHimBlog
 *   URL: https://www.codehim.com
 *   License: MIT License
 *   Copyright (c) 2018 - 2019 - Asif Mughal
 */
 /* File: jquery.jside.menu.js */
 (function($){
   $.fn.jSideMenu = function(options){
    var setting = $.extend({
   		   jSidePosition: "position-left", //possible options position-left or position-right
           jSideSticky: true, // menubar will be fixed on top, false to set static
           jSideSkin: "default-skin", // to apply custom skin, just put its name in this string

		   jSideTransition: 400, //Define the transition duration in milliseconds

    }, options);

    return this.each(function() {
      var jSide, target, headHeight, devHeight, arrow, dimBackground;

      target = $(this);

//Accessing DOM
jSide = $(".menu-containers, .menu-head");
devHeight = $(".menu-containers").height();
headHeight = $(".menu-head").height();
dHeading = $(".dropdown-heading");
menuTrigger = $(".menu-trigger");
arrow = $("<i></i>");
dimBackground = $("<div>");

// Set the height of side menu according to the available height of device
// $(target).css({
//   'height' : devHeight-headHeight,

// });
// 딱 봐도 이건 쓸모가 없네요. 

if (setting.jSideSticky == true){
 $(".menubar").addClass("sticky");
}  else{
 $(".menubar").removeClass("sticky");
}

$(".menubar").addClass(setting.jSideSkin);
$(jSide).addClass(setting.jSideSkin).addClass(setting.jSidePosition);

if ($(jSide).hasClass("position-left")){
  $(".menu-trigger").addClass("left").removeClass("right");
}
else{
  $(".menu-trigger").removeClass("left").addClass("right");
}

//Dropdown Arrow
$(arrow).addClass("material-icons d-arrow").html("keyboard_arrow_down").appendTo(dHeading);
//Dim Layer
$(dimBackground).addClass("dim-overlay").appendTo("body");
//Dropdowns
$(dHeading).click(function(){
 $(this).parent().find("ul").slideToggle(setting.jSideTransition);
 $(this).find(".d-arrow").toggleClass("d-down");

});

$(menuTrigger).click(function(){
 $(jSide).toggleClass("open");
 $(dimBackground).show(setting.jSideTransition);
 $(".menu-body").removeClass("visibility");
});

//close menu if user click outside of it
$(window).click(function(e) {
  if ($(e.target).closest('.menu-trigger').length){
   return;}
   if ($(e.target).closest(jSide).length){
     return;}

     $(jSide).removeClass("open");
     if (!$(jSide).hasClass("open")) {
       $(dimBackground).hide(setting.jSideTransition);
     }
     $(".menu-body").addClass("visibility");
   });
});
  };

})(jQuery);
/*   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. */


$(function(){
  $(".menu-containers").jSideMenu({
    jSidePosition: "position-left", //possible options position-left or position-right
    jSideSticky: true, // menubar will be fixed on top, false to set static
    jSideSkin: "default-skin", // to apply custom skin, just put its name in this string
  });
});
</script>
