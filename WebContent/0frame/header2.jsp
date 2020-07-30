<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- 로그인 했을 때의 헤더입니다.  -->
<% String id = (String) session.getAttribute("LOG_ID"); %>
<header class="a_top00">
  <div class="wrap_big_00">
    <div class="top_left00 fleft"><a href="index.jsp"><img src="img/logo1.png"></a></div>
    <div class="top_right00 fright">
 		<a><%=id %></a>
      <a href="logout.log">로그아웃</a>
      <!-- <a href="">마이 페이지</a>-->
      <a href="id_MainToApply.trainer">코치지원</a>
    </div>
  </div>
</header>
