<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.team7.vo.Gym_info" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.*" %>

<!DOCTYPE html>
<html>
<head>
	<title>트레이너 개인페이지</title>

<%
request.setCharacterEncoding("UTF-8");
List<Gym_info> gser  = (List<Gym_info>) request.getAttribute("gser"); 

%>



    <link rel="stylesheet" type="text/css" href="css/gympage.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

	<main class="mainwrap_club">

		<section class="mainwrap">
			<div class="main_head">
				<!-- 사진 크게 넣을거임. ...사진 될까? -->
				<img class="ImageForModal" src="img/gym.png" onclick="ImageClickFunction(this)">

				<div class="modal">
					<img class="modal-content">
					<div class="caption">***트레이너님의 사진입니다. </div>
				</div>
			</div>


<div>

<div class="div1">

<% String imsigtype = gser.get(0).getGtype();
   String [] gtype = imsigtype.split(",");
   
   for(int i =0 ; i< gtype.length ; i++){
	   
   

%>


			 <div class="hero__btn">
				<%= gtype %>
				</div>
		
	<%} %>		
			
			<div class="hero__text">
				<%= gser.get(0).getGname() %>
			</div>
			<p class="a_text">
			<%= gser.get(0).getGsmalltext() %>
			</p>
			<div class="info">


			<div>
			<img src="img/time.png" class="littleimg">	<p class="label">헬스장 주소</p>
			<br><p style="font-size: 13px; margin:0 0;"><%= gser.get(0).getAddress() %></p>
			</div>

			<div>
			<img src="img/effect.png" class="littleimg">	<p class="label">헬스장 전화번호</p>
	<br><p style="font-size: 13px; margin:0 0;"><%= gser.get(0).getGphone() %></p>	
			</div>

			<div>
			<img src="img/when.png" class="littleimg">	<p class="label">헬스장 운영시간</p>
	<br><p style="font-size: 13px; margin:0 0;"><%= gser.get(0).getOpentime() %></p>
			</div>
			</div>
			<br>

</div>
</div>
	</section>

	<div class="btnnew">
				<button class="hero__btn1">헬스장 상담요청 </button>
				<button class="hero__btn1">바로 등록하기</button>
	</div>
<div class="divclean">
	<div class="container1">
	* 아래에 기재해주신것들은 어쩌고저쩌고저저졲고고고오~<br>
	* 아래에 기재해주신것들은 어쩌고저쩌고저저졲고고고오~<br>
	* 아래에 기재해주신것들은 어쩌고저쩌고저저졲고고고오~<br>
	</div>

</div>
	<nav id="findnav" class="bottomupline findwhere">
	<ul >
		<li><a href="#coach1">코치정보</a></li>
		<li><a href="#coach2">경력사항%활동</a></li>
		<li><a href="#program">프로그램소개</a></li>
		<li><a href="#review">후기</a></li>
	</ul>
	</nav>

	<div class="coachprofile info">
		<br><br>
		<p class="hg" id="coach1">헬스장정보</p>
 <span class="a_text"><%= gser.get(0).getGsmalltext() %></span><br><br><br>

		<img class="profile_img2" src="img/trainer.jpeg">
		<img class="profile_img2" src="img/trainer.jpeg">

	<img class="profile_img2" src="img/trainer.jpeg">
		<div class="profile_name">
			<h3 class="hero__info">데일리 헬스의 소개</h3>
			<span class="a_text"><%= gser.get(0).getGsmalltext() %></span><br>
			<span class="a_text1"> 
			<%= gser.get(0).getContents() %>
			</span>
		</div>

	</div>

	<br>
	<div class="career info" >
		<p class="hg2" id="coach2">헬스장 자격증</p><br>
		<p>
			<%= gser.get(0).getGcerti() %>

		</p>
	</div>

	<div class="cert info" >

		<p class="hg2" > 헬스장 가격</p><br>
		<p class="a_text2">1개월권  : 	</p><br>
		<p class="a_text2">3개월권  : 	</p><br>
		<p class="a_text2">6개월권  : 	</p><br>
		<p class="a_text2">12개월권 : 	</p><br>

	</div>

	<div class="cert info" >
		<p class="hg" id="program">프로그램소개</p><br>
		<p>
			<%= gser.get(0).getGprogram() %>
		</p>
	</div>


	<div class="cert info" ><br>
		<p class="hg" id="review">이용후기</p><br>
		<p class="container1">
			※ 헬스장에 관한 문의사항을 또는 후기를 자유롭게 남겨주세요 ^^<br>
   ※근거없는 비방은 상의없이 삭제조치됨을 알려드립니다.
		※사진후기를 올릴시에는 사진파일이 2m 바이트가 넘지않도록 주의하여주세요


	</p><br>
	</div>





	</article>



				<article class="new_write">
					<!-- 여기에 새 게시글 올릴 수 있도록.  -->
					<form style="width:800px">
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


</body>

	<script type="text/javascript" src="js/trainerpagejs.js"></script>

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
		height: 200px;
		padding-top: 20px;
		position: fixed;
		top: 10px;
    margin: 50px 0 200px 20px;
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
		float: left;
		     width: 400px;
	}
	.main_head img{
		width: 400px;
		max-height: 550px;
		    height: 500px;
		margin-top: 50px;

  		object-fit: cover;
	}

	.new_write{
		width: 500px;
		margin : 0 0 25px 0;
	}
	.new_write textarea{
		width: 800px;
		height: 100px;
		border: 3px solid silver;
		resize: none;

	}
	.posts{
		width: 500px;
		/*border: 1px solid silver;*/
	}
	.posts article{

		width: 800px;
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


</html>
