<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.team7.vo.MemberInfo1" %>
<%@ page import="com.team7.vo.PostBean" %>
<%@ page import="java.util.List" %>

<title> Mypage </title>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="css/mypage.css?ver=<%=System.currentTimeMillis()%>">

</head>

<%
request.setCharacterEncoding("UTF-8");



List<MemberInfo1> minfo = (List<MemberInfo1>) request.getAttribute("minfo");

List<PostBean> cposts = (List<PostBean>) request.getAttribute("cposts");
%>
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
             <img src="img/asif-mughal.jpg" alt="Asif Mughal" />
           </div>
         </div>
         <div class="row for-name">
           <h3 title="User Name"> <%=minfo.get(0).getName() %> </h3>
           <span class="tagline"> 닉네임 </span>
         </div>
       </div> <!--//col-->
     </span>
   </div> <!--//menu-head-->
   <div class="menu-containers">
    <ul class="menu-items">
      <li class="thisnow"><a href="#1"> <i class="material-icons">widgets</i>  나의 정보페이지 </a></li>
      <li><a href="#1"> <i class="material-icons">bar_chart</i> 최근 본 페이지 </a></li>
      <li class="has-sub"> <span class="dropdown-heading"> <i class="material-icons">collections</i> 나의 관심바구니 </span>
       <ul>
        <li> <a href="myhealthzzim.mypage"> 나의 헬스장 </a> </li>
        <li> <a href="#2"> 나의 트레이너</a> </li>
        <li> <a href="#2"> 나의 소모임</a> </li>

      </ul>
    </li>

    <li> <a href="#1">  <i class="material-icons">color_lens</i>  내가 쓴 글 </a></li>
    <li><hr></li>
    <li> <a href="#1">  <i class="material-icons">pie_chart</i>  로그아웃 </a></li>

  </ul>
</div>
</div>
</article>
<!--End jSide Menu-->

<menu class="myprofile">
  <!--  이 아래부분만 바뀌면 됩니다 -->
  <div class="thunbox">
    <img class="profile_img2" src="a.jpeg">
    <p class="grade">사용자</p>
  </div>

  <h3 class="textmp">김윤영 회원님</h3>
  <br>
  <div class="">
    <div class="myinfo">
      <h4> 성함 : <%=minfo.get(0).getName() %></h4>
      <h4> ID :<%=minfo.get(0).getId() %> </h4>
      <h4> 이메일 :<%=minfo.get(0).getEmail() %> </h4>
      <h4> 주소 :<%=minfo.get(0).getAddress() %> </h4>
      <h4> 관심사 :<%=minfo.get(0).getInterest() %></h4>
      <h4> 가입일 :<%=minfo.get(0).getJoindate() %></h4>

      <button type="button" name="button" class="btn">정보수정</button>

    </div>
  </div>

</menu>

<div class="fclear"></div>
</div>






<!-- jQuery -->
<!--jSide Menu Js-->
<script src="js/jquery.jside.menu.js"></script>
<script>

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

</body>
</html>