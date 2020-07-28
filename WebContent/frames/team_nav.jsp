<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<nav class="j_follow_nav">

  <div class="menu-container banner " align="center">
    <div class="grt-menu-row">
      <div class="grt-menu-right">
        <div class="menunav  ">
          <button class="grt-mobile-button"><span class="line1"></span><span class="line2"></span><span class="line3"></span></button>
          <ul class="grt-menu ">
         <!--    <li ><a href="team_main.jsp"><img src="img/home.png"></li> -->
            <li class="grt-dropdown" ><a><img src="img/gymcenter.png"></a>
              <ul class="grt-dropdown-list">
                <li onclick="lemmego(this)"><input type="hidden" value=""><a>데일리 헬스란</a></li>
                <li onclick="lemmego(this)"><input type="hidden" value=""><a>헬스장 찾기</a></li>
                <li onclick="lemmego(this)"><input type="hidden" value=""><a>트레이너 찾기</a></li>
              </ul>
            </li>
            <li class="grt-dropdown" ><a><img src="img/lifework.png"></a>
              <ul class="grt-dropdown-list">
                <li onclick="lemmego(this)"><input type="hidden" value=""><a>소모임이란</a></li>
                <li onclick="lemmego(this)"><input type="hidden" value="club_showAll.jsp"><a>소모임 찾기</a></li>
                <li onclick="lemmego(this)" value="1"><input type="hidden" value="club_createNedit.jsp"><a>소모임 개설/관리</a></li>
              </ul>
            </li>
            <li class="grt-dropdown"  ><a><img src="img/myhealth.png"></a>
              <ul class="grt-dropdown-list">
                <li onclick="lemmego(this)" value="1"><input type="hidden" value=""><a>My 헬스장</a></li>
                <li onclick="lemmego(this)" value="1"><input type="hidden" value=""><a>My 트레이너</a></li>
                <li onclick="lemmego(this)" value="1"><input type="hidden" value="club_myClubs.jsp"><a>My 소모임</a></li>
                <li onclick="lemmego(this)" value="1"><input type="hidden" value=""><a>회원정보</a></li>
              </ul>
            </li>
            <li class="grt-dropdown" ><a><img src="img/mymenu.png"></a>
              <ul class="grt-dropdown-list">
                <li onclick="lemmego(this)" value="1"><input type="hidden" value=""><a>헬스장 등록</a></li>
                <li onclick="lemmego(this)" value="1"><input type="hidden" value="coachapply.jsp"><a>트레이너 등록</a></li>
                <li onclick="lemmego(this)" value="1"><input type="hidden" value=""><a>예약 확인</a></li>
              </ul>
            </li>
            <li class="grt-dropdown" ><a><img src="img/mymenu.png"></a>
              <ul class="grt-dropdown-list">
                <li onclick="lemmego(this)"><input type="hidden" value="notice_show_page.jsp"><a>공지시항</a></li>
                <li onclick="lemmego(this)"><input type="hidden" value=""><a>자주 하는 질문</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>

  <form id="gogo" method="post" action="team_FORWHERE.jsp" style="display: none;">
    <input type="hidden" id="forwhere" name="forwhere">
  </form>
  <script type="text/javascript">
  <%

request.setCharacterEncoding("UTF-8");
  String id = (String) session.getAttribute("LOG_ID");
  int logyn = (int) session.getAttribute("LOG_STATUS");
  String forwhere00 = request.getParameter("forwhere");
  %>
       ;;
  //   var id = <%=id %>;
  var logyn = <%=logyn%>;
  var forwhere00 = "<%=forwhere00%>";
      function lemmego(req){
        // alert($(this));
        // alert($(req).val());
        var where00 = $(req).children('input').val();
        // alert('ww : '+where00);
        // alert(logyn);
        
        if(forwhere00 == where00){
        	// 같으면 또 로딩 안시킬거임 ㅡㅡ...
        }else{
	        if($(req).val() == 1){
	          // alert('??');
	          if(logyn !=1 ){
	            $('#gogo').children('#forwhere').val('needLogIn.jsp'); 
	            //로그인이 필요한 기능입니다. 로그인해주세요. 페이지 .
	            $('#gogo').submit();
	          }
	          else{
	            if(where00 != null && where00 !=""){
	              $('#gogo').children('#forwhere').val(where00);
	              $('#gogo').submit();
	            }
	          }
	        }
	        else{
	          if(where00 != null && where00 !=""){
	            $('#gogo').children('#forwhere').val(where00);
	            $('#gogo').submit();
	          }
	
	        }
        }
        // if(where00 != null && where00 !=""){
        //   $('#gogo').children('#forwhere').val(where00);
        //   $('#gogo').submit();
        // }
      }
  </script>
</nav>