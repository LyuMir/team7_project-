
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.team7.vo.Trainer_info" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.*" %>
    

    <link rel="stylesheet" type="text/css" href="css/coachprofile.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%
request.setCharacterEncoding("UTF-8");
List<Trainer_info> tser  = (List<Trainer_info>) request.getAttribute("tser"); 

%>

	<main class="mainwrap_club">
		<section class="club_right">
			<article class="left_top">
			<ul class="ad_text">
				<li>*코치님의 프로필입니다</li>
				<li>코치 상담요청을 통해</li>
				<li>자세한 상담을 받아보세요 ^^</li>
			</ul>
			</article>

			<article class="left_main">
				<hr>
				<!-- <div class="profile_img"><img src=""></div> -->
				<img class="profile_img" src="img/trainer.jpeg">
				<div class="profile_name">
					<h3><%=tser.get(0).getTname() %> 코치</h3>
					<hr>
					<span class="a_text"> <%=tser.get(0).getTbigtext() %></span>
					<span> </span>
				</div>
				<div class="zzim">
					<button class="hero__btn1">1:1 상담요청 <img src="img/heart34.png"></button>
					<button class="hero__btn1">바로 등록하기 <img src="img/star34.png"></button>
				</div>
				<div class="profile_text">
				</div>

			</article>
		</section>
		<!-- 왼쪽 끝.  -->
		<!-- <section class="club_left2">.</section> -->
		<!-- 왼쪽 부피감? -->
		<section class="">
			<article class="main_head">
				<!-- 사진 크게 넣을거임. ...사진 될까? -->
				<img class="ImageForModal" src="img/aaas.jpeg" onclick="ImageClickFunction(this)">

				<div class="modal">
					<img class="modal-content">
					<div class="caption">***트레이너님의 사진입니다. </div>
				</div>
			</article>
<div class="divclean">

</div>


<article class="mainwrap">

<hr class="line1">


<%

String imsimajors = tser.get(0).getTmajor() ;
String [] major = imsimajors.split(",");

for (int i=0 ; i < major.length ; i ++) { 

	if(major[i].equals("")){
	
	}
	else{

%>

<div class="hero__btn">
<%= major[i] %>
</div>

<%}} %>



<div class="hero__text">
	<%=tser.get(0).getTbigtext() %>
</div>
<p>
<%=tser.get(0).getTsmalltext() %>
</p>
<div class="info">


<div>
<img src="img/time.png" class="littleimg">	<p class="label">수업지역</p>
</div>




<p style="font-size: 13px; margin:0 0;">●<%= tser.get(0).getTwhere() %></p>




<div>
<img src="img/effect.png" class="littleimg">	<p class="label">수업효과</p>
</div>

<%

String majors = tser.get(0).getTmajor() ;
String [] majorss = majors.split(",");

for (int i=0 ; i < major.length ; i ++) { 

String majorinfo ="";

	if(majorss[i].equals("filates")){
		majorinfo += ", 올바른 자세와 코어 강화";
	}
	if(majorss[i].equals("yoga")){
		majorinfo += ", 집중력 향상을 통한 바디 밸런스";
	}
	if(majorss[i].equals("rehab")){
		majorinfo += ", 몸의 근본원인 치유를 통한 재활강화";
	}
	if(majorss[i].equals("weight")){
		majorinfo += ", 근육 강화를 통한 몸의 균형적인 기능 심화";
		
	}
	majorinfo = majorinfo.substring(1);
%>


<p style="font-size: 13px; margin:0 0;">● <%= majorinfo %></p>


<% } %>

<div>
<img src="img/when.png" class="littleimg">	<p class="label">수업가능시간</p>
</div>

<%

String imsitimes = tser.get(0).getTtime() ;
String [] time = imsitimes.split(",");

for (int i=0 ; i < time.length ; i ++) { 

	if(time[i].equals("")){
	
	}
	else{

%>


<p style="font-size: 13px; margin:0 0;">● <%= time[i] %></p>


<% }} %>
<br>

</div>

<br>
<div class="container1">
* 아래에 기재해주신것들은 어쩌고저쩌고저저졲고고고오~<br>
* 아래에 기재해주신것들은 어쩌고저쩌고저저졲고고고오~<br>
* 아래에 기재해주신것들은 어쩌고저쩌고저저졲고고고오~<br>
</div>

<nav id="findnav">
<ul class="findwhere">
	<li><a href="#coach1">코치정보</a></li>
	<li><a href="#coach2">경력사항%활동</a></li>
	<li><a href="#program">프로그램소개</a></li>
	<li><a href="#review">후기</a></li>
</ul>
</nav>


<div class="coachprofile info">
	<br><br>
	<p class="hg" id="coach1">코치정보</p>
	<img class="profile_img2" src="img/trainer.jpeg">
	<div class="profile_name">
		<h3 class="hero__info"><%= tser.get(0).getTname() %> 코치</h3>
		<span class="a_text"><%= tser.get(0).getTsmalltext() %> </span><br>
		<span class="a_text1"><%= tser.get(0).getTstory() %> </span>
	</div>

</div>

<br>
<div class="career info" >
	<p class="hg2" id="coach2">코치경력사항 * 활동내용</p><br>
	<p>
		<%= tser.get(0).getTcareer() %>

	</p>
</div>

<div class="cert info" >
	<p class="hg2" >보유자격증</p><br>
	<p>
	<%= tser.get(0).getTcerti() %>

	</p>
</div>

<div class="cert info" >
	<p class="hg" id="program">프로그램소개</p><br>
	<p>
	<%= tser.get(0).getTprofile() %>

	</p>
</div>


<div class="cert info" ><br>
	<p class="hg" id="review">Q n A</p><br>
	<p class="container1">
		※ 1회 체험에 관한 문의사항을 자유롭게 남겨주세요 ^^<br>
	※코치님이 확인후 연락을드립니다!<br>
	※댓글확인에서 연락까지는 최대 영업기준 5일이 소요될수있습니다


</p><br>
</div>





</article>



			<article class="new_write">
				<!-- 여기에 새 게시글 올릴 수 있도록.  -->
				<form style="width:600px">
					<textarea placeholder="문의사항을 남겨주세요!!"></textarea>
					<div class="fleft">
						<button onclick="post_photo(); return false;">사진업로드</button>
					</div>
					<div class="fright">
						<button type="reset">리셋</button>
						<button onclick="postgo(); return false;">저장</button>
					</div>
					<div class="fclear"></div>
				</form>
			</article>
			<div class="posts">
				<!-- <article class="post"> -->
					<!-- 포스트들이 자꾸 나온다  -->
				<!-- </article> -->
				<article>
					여기서부터 포스트 시작
					<div class="post_img">
						<img class="ImageForModal" src="img/이쁜이미지3.jpg" onclick="ImageClickFunction(this)">
						<div class="modal">
						  <img class="modal-content">
						  <div class="caption">확대사진 </div>
						</div>
					</div>
					<div class="post_text">
					댓글이써집니다 <br>
					무니무니 나무늬
					</div>
					<div class="fclear" id="info"></div>
				</article>
				<article>이런 포스트들이 계속 나오는거임. </article>
				<article>이런 포스트들이 계속 나오는거임. </article>
				<article>이런 포스트들이 계속 나오는거임. </article>
				<article>이런 포스트들이 계속 나오는거임. </article>
				<article>이런 포스트들이 계속 나오는거임. </article>
				<article>이런 포스트들이 계속 나오는거임. </article>

			</div>
		</section>

	</main>


	<script type="text/javascript" src="js/photo_modal00.js"></script>

<style type="text/css">
	*{
		box-sizing: border-box;
	}
	.mainwrap_club{
		width: 1000px;
		margin: 0 auto;
	}

	.club_right{
		width: 270px;
		height: 600px;
		padding-top: 20px;
		position: fixed;
		
    margin: 38px 0 200px 620px;
		background-color: inherit;
		background-color: white;
		border: 1px solid #efefef;
		box-sizing: border-box;
		padding: 20px 16px;
		border-radius: 10px;

	}

	.left_top{

	}
	.left_main{

	}
	.left_main div{margin-top: 10px;}
		.profile_img{
			/*max-width: 230px;*/
			width: 230px;
			height: 230px;
			align-items: center;
			margin: 10px auto;
			border-radius: 50%;
			object-fit: cover;
			margin:10px auto 0px auto;
		}



		.profile_name{
			padding: 13px;
			font-size: 18px;
		}
		.zzim{}
		.profile_text{
			font-size: 14px;
		}
		.profile_people{
			font-size: 14px;
		}
		  .pp_admin{}
		  .pp_p{}

	.club_main{
		width: 750px;
		float: left;
		margin-top: 50px;
	}
	.main_head{
		     width: 1070px;
	}
	.main_head img{
		width: 600px;
		max-height: 700px;
		    height: 595px;
		margin-top: 50px;
  		object-fit: cover;
	}

	.new_write{
		width: 500px;
		margin : 0 0 25px 0;
	}
	.new_write textarea{
		width: 600px;
		height: 100px;
		border: 3px solid silver;
		resize: none;

	}
	.posts{
		width: 500px;
		/*border: 1px solid silver;*/
	}
	.posts article{

		width: 600px;
		border: 1px solid silver;
		padding: 10px;
		margin: 10px 0 ;
	}

	.posts img{
		max-height: 350px;
		max-width: 100%;
		margin: 0 auto;
  		object-fit: cover;
	}
	.post_like{
		/*border: 1px solid silver;*/
		/*background-color: var(--silver-color-6);*/
		/*color: var(--silver-color-1);*/
		border-bottom: 1px solid silver;
		padding: 2px 4px;

		cursor: pointer;
		float: left;
		transition: all ease 1s;
	}
	.post_like img{
		transition: all 0.2s;
		width: 10px;
	}
	.post_like:hover img{
		transform: rotate(-360deg);
	}
	.post_like:active img{
		transform: scale(1.9);
	}
	/*.post_like::after {
		content: '';
		display: inline-block;
		clear: both;
	} 왜 안됨???*/






	select{
		/*width: 230px;*/
		width: 100%;
		margin : 0 auto;
		font-size: 14px;
		border: 2px solid silver;
		padding: 8px 5px;
		margin-bottom: 5px;

	}
	select option{
		padding: 5px;
	}
	.zzim button{
		width: 100%;
	}
	button{
		background-color: white;
		padding: 8px 15px;
		transition: all 0.2s;
		border-radius: 20px;
	}
	button img{
		transition: all 0.2s;
	}
	button:hover{
		background-color: var(--silver-color-5);
	}
	button:active{
		background-color: var(--silver-color-6);
		color: white;
		/*background-color: white;*/
		/*border: none;*/
	}
	button:hover img{
		transform: rotate(45deg);
	}
	button:active img{
		transform: scale(1.9);
	}
	button:focus {
		/*outline:1px solid black;*/
		outline: none;
	}


</style>



<script type="text/javascript">





	// 기존 css에서 플로팅 배너 위치(top)값을 가져와 저장한다.
	var floatPosition = $('#findnav').offset().top;
	// 250px 이런식으로 가져오므로 여기서 숫자만 가져온다. parseInt( 값 );

		 $(window).scroll(function(){
		 var scrollTop = $(window).scrollTop();
		 //alert(scrollTop);
		var newPosition = scrollTop + floatPosition + "px";
 		   if (scrollTop > floatPosition ){
 		       $('#findnav').addClass('scrolled');
					 // alert("ddd");
				}
				else {
					$('#findnav').removeClass('scrolled');
				}
				//$('div input.ty').eq(5).addClass
					//"ddd00");

	}).scroll();

	//."z_zzim1">찜하기  id="z_join1" 가입하기
	//$('#')
	// $('#z_zzim1').click(zzimed());
	$('#z_zzim1').on('click', function(){
		//$(this).html('찜!');
		$(this).zzimed();

		// $(this).zzimed(); 놉
	});

	function zzimed(){
		$(this).html('찜!<img src="img/heart34.png">');
	}
	function zzimc(){
		$(this).html('찜하기 <img src="img/heart34.png">');
	}

	function post_photo(){

	}

	function postgo(){

	}
</script>

