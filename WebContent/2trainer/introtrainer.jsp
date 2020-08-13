<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="java.util.List" %>
<%@ page import="com.team7.vo.PhotoBean" %>
<%@ page import="com.team7.vo.Trainer_info" %>

    <!-- <link rel="stylesheet" href="css/introhealth.css"> -->
    <link rel="stylesheet" type="text/css" href="css/introhealth.css?ver=111">
    
    
    
<%
	List<Trainer_info> rlist = (List<Trainer_info>) request.getAttribute("rlist");
	List<PhotoBean> photoBean = (List<PhotoBean>) request.getAttribute("photoBean");

	String id = (String)session.getAttribute("LOG_ID");
	
	boolean hasE = false;
	if(rlist == null || rlist.size()<1){
		
	}
	else{
		hasE = true;
	}
	
%>
    
    
    
<main>

  <section class="hero">
    <!-- <div class="wrap__pic__00"> -->
    <div class="main_pic_w">
      <img src="img\intro.jpg" class="main_pic_01">
    </div>
<!-- 
<div class="sidenav">
  <p class="hero__snippet1"> 이미 등록되어있나요?</p>
  <a href="id_mypage.trainer">▶나의 메인페이지 보기</a>
</div>
 -->


      <div class="text">
  <% if(!hasE){ %>
        <h1 class="hero__title">프리랜서 등록을 해보세요!</h1>
        <p class="hero__snippet">수수료 0원! 데일리 헬스니까!</p>
        <ul class="btn-list">
            <li class="btn-list__item"><a class="hero__btn  btn" href="">사업소개</a></li>
            <li class="btn-list__item"><a class="hero__btn  btn" href="id_coachapply.trainer">등록하기</a></li>
	<% }else{%>
        <h1 class="hero__title">든든한 파트너 <br>데일리헬스!</h1>
        <p class="hero__snippet">평균 등록인원 000명! 데일리 헬스니까!</p>
        <ul class="btn-list">
            <li class="btn-list__item"><a class="hero__btn  btn" href="">사업소개</a></li>
            <li class="btn-list__item"><a class="hero__btn  btn" href="">내 정보 관리</a></li>
	<% if(true){ %>
            <li class="btn-list__item"><a class="hero__btn  btn" href="">예약관리</a></li>
	<% }}%>
        </ul>
      </div>
<div class="main_with_main">
<% if(!hasE){ //등록 안 되어있는 사람 %>

아직 등록을 안 하셨군요! 저희의 장점은....
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


  <div><a href="id_mypage.trainer">▶나의 트레이너 페이지 보러가기</a></div>
  

  <div>
    올리신 트레이너 사진들 : 
  		<%for(int i = 0 ; i < photoBean.size(); i++){ %>
        <img src="Files/trainer/<%=id%>/1/<%=photoBean.get(i).getPicture() %>">
      <%} %>
  </div>
  <div><a href="">▶올린 사진 수정하기</a></div>
  <div><a href="">▶내 트레이너 정보 수정하기</a></div>

<% if(true){	//여기는 예약을 받은 사람만 보인다.  %>
	<div>
    	<div class="j_title">당신이 받은 예약 : </div><br>
		...어쩌구 저저구... 클릭. 
	
	</div>


<%} } %>

</div>
  </section>


    </main>

    <style type="text/css">
.main_with_main{
  position: absolute;
  top: 510px;
    color: 987c67;
    text-shadow: none;
    /*font-weight: 550;*/
    width: 99%;
    padding: 15px;
    font-size: 15px;
  text-align: left;
}
.main_with_main a{
  color: #987c67;

}
.j_title{
  font-size: 17px;
  color: black;
  padding: 3px;
  margin: 3px;
  border-bottom: 2px solid silver;
  display: inline-block;
}
    </style>