<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="java.util.List" %>
<%@ page import="com.team7.vo.PhotoBean" %>
<%@ page import="com.team7.vo.Gym_info" %>

    <link rel="stylesheet" href="css/introhealth.css?ver=502">

<%
  List<Gym_info> rlist = (List<Gym_info>) request.getAttribute("rlist");
  List<PhotoBean> photoBean = (List<PhotoBean>) request.getAttribute("photoBean");

  String id = (String)session.getAttribute("LOG_ID");

  boolean hasE = false;
  if(rlist == null || rlist.size()<1){

  }
  else{
    hasE = true;
  }

%>
<main role="main">

  <section class="hero">
    <div class="main_pic_w">
      <img src="img\intro.jpg" class="main_pic_01">
    </div>
<!--
<div class="sidenav">
  <p class="hero__snippet1"> 이미 등록되어있나요?</p>
  <a href="#about">▶헬스장관리</a>
</div>
  -->


      <div class="text">
  <% if(!hasE){ %>
        <h1 class="hero__title">헬스장을 <br> 등록하세요!</h1>
        <p class="hero__snippet">즉각적인 홍보효과와 마케팅!</p>
        <ul class="btn-list">
            <li class="btn-list__item"><a class="hero__btn  btn" href="">사업소개</a></li>
            <li class="btn-list__item"><a class="hero__btn  btn" href="id_gymapply.health">등록하기</a></li>
  <% }else{%>
        <h1 class="hero__title">헬스장도 역시 <br>데일리헬스!</h1>
        <p class="hero__snippet">평균 등록인원 000명! 데일리 헬스니까!</p>
        <ul class="btn-list">
            <li class="btn-list__item"><a class="hero__btn  btn" href="">사업소개</a></li>
            <li class="btn-list__item"><a class="hero__btn  btn" href="id_editform.health">헬스장 정보 관리</a></li>
  <% if(true){ %>
            <li class="btn-list__item"><a class="hero__btn  btn" href="">예약관리</a></li>
  <% }}%>
        </ul>
      </div>
<div class="main_with_main">
<% if(!hasE){ //등록 안 되어있는 사람 %>

아직 등록을 안 하셨군요! 저희의 장점은 많은 회원수와 빠른 정확성으로....
<br>
<br>

이러저러한 수익 예상을....
<br>
<br>
오래 활동하신 VIP 분들께는 이런 혜택을.........
<br>
<br>
소개.
<br>
<br>
당장 등록하기 > <a class="hero__btn  btn" href="id_coachapply.trainer">등록하기</a>

<% }else{  // 등록 되어있는 사람. %>

  <div><a href="">▶나의 헬스장 페이지 보러가기__</a></div>


  <div>
    올리신 헬스장 사진들 :
      <%for(int i = 0 ; i < photoBean.size(); i++){
         %>
        <img src="Files/gym/<%=id%>/<%=i%>/<%=photoBean.get(i).getPicture() %>">
      <%} %>
  </div>
  <div><a href="">▶올린 사진 수정하기</a></div>
  <div><a href="id_editform.health">▶헬스장 정보 수정하기</a></div>

<% if(true){  //여기는 예약을 받은 사람만 보인다.
   %>
  <div>
      <div class="j_title">당신이 받은 예약 : </div><br>
    ...어쩌구 저저구... 클릭.

  </div>


<%} } %>

</div>
  </section>


    </main>
