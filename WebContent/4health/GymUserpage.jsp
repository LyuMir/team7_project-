<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.team7.vo.Gym_info" %>
<%@ page import="com.team7.vo.PhotoBean" %>
<%@ page import="com.team7.vo.PostBean" %>
<%@ page import="com.team7.vo.ZZIMBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.*" %>

	<title>헬스장 페이지</title>

<%
String id = (String) session.getAttribute("LOG_ID");
if(id ==null){
	id="";
}


request.setCharacterEncoding("UTF-8");
List<Gym_info> gser  = (List<Gym_info>) request.getAttribute("gser"); 
List<PhotoBean> photoBean = (List<PhotoBean>) request.getAttribute("photoBean");
List<PostBean> posts = (List<PostBean>) request.getAttribute("posts");

List<ZZIMBean> zyn2 = (List<ZZIMBean>) request.getAttribute("zzimYN");
boolean zyn = false;
if(zyn2 !=null){
	zyn = true;
}

int imgymOwner = 0;
if(id.equals(gser.get(0).getOwner())){
	imgymOwner=1;
}
%>



    <link rel="stylesheet" type="text/css" href="css/gympage.css?ver=6">

	<main class="mainwrap_club">

		<section class="mainwrap">
			<div class="main_head">
				<!-- 사진 크게 넣을거임. ...사진 될까? -->
				<img class="ImageForModal" src="Files/gym/<%=gser.get(0).getOwner()%>/1/<%=photoBean.get(0).getPicture() %>" onclick="ImageClickFunction(this)">

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
	<%= gtype[i] %>
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
	<div class="btnnew">
	<% if(zyn){ %>
				<button data-id2="<%=gser.get(0).getGid() %>" id="z_zzim1" class="hero__btn1" onclick="zzimThis1_C(this)">찜취소 <img src="img/heart_and_star/heart34.png"></button>
	<% }else{ %>
				<button data-id2="<%=gser.get(0).getGid() %>" class="hero__btn1" onclick="zzimThis1(this)">찜하기 <img src="img/heart_and_star/heart034.png"></button>
	<% } %>
				<button class="hero__btn1">헬스장 상담요청 </button>
				<button class="hero__btn1">바로 등록하기</button>
	</div>

</div>
</div>
	</section>

<div class="divclean">
	<!-- <div class="container1"> -->
	* 아래에 기재해주신것들은 어쩌고저쩌고저저졲고고고오~<br>
	* 아래에 기재해주신것들은 어쩌고저쩌고저저졲고고고오~<br>
	* 아래에 기재해주신것들은 어쩌고저쩌고저저졲고고고오~<br>
	<!-- </div> -->

</div>
	<nav id="findnav" class="bottomupline findwhere">
	<ul >
		<li><a href="#health1">헬스장 정보</a></li>
		<!-- <li><a href="#health2">경력사항%활동</a></li> -->
		<li><a href="#program">프로그램소개</a></li>
		<li><a href="#review">이용 후기</a></li>
		<!-- <li><a href="#qna">문의사항</a></li> -->
	</ul>
	</nav>

	<div class="coachprofile info" id="health1">
		<br><br>
		<p class="hg">헬스장정보</p>
 <span class="a_text"><%= gser.get(0).getGsmalltext() %></span><br><br><br>
 	<% for(int i = 0 ; i < photoBean.size();i++){ 
 				String pid = photoBean.get(i).getId();
 				String pidn = pid.substring(pid.lastIndexOf("_")+1);
 	%>
		<img class="profile_img2" src="Files/gym/<%=gser.get(0).getOwner()%>/<%=pidn%>/<%=photoBean.get(i).getPicture() %>">
	<% } %>
		<div class="profile_name">
			<h3 class="hero__info">데일리 헬스의 소개</h3>
			<span class="a_text"><%= gser.get(0).getGsmalltext() %></span><br>
			<span class="a_text1"> 
			<%= gser.get(0).getContents() %>
			</span>
		</div>

	</div>

	<br>
	<div class="career info"  id="health2">
		<p class="hg2">헬스장 자격증</p><br>
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


	<div class="cert info"  id="review"><br>
		<p class="hg">이용후기</p><br>
		<!-- <p class="container1"> -->
			<p class="container1_1">
	※ 헬스장에 관한 문의사항을 또는 후기를 자유롭게 남겨주세요 ^^<br>
   	※ 근거없는 비방은 통보없이 삭제조치될 수 있습니다. 	<br>
	※ 사진후기를 올릴시에는 사진파일이 2m 바이트가 넘지않도록 주의하여주세요.


	</p><br>
	</div>





	</article>



				<article class="new_write">
					<form id="wForm" method="post" action="gymPost.post">
						<!-- <div > -->
							<input id="imtitle1" type="text" name="title" class="inputclass" placeholder="제목">
							<input type="hidden" name="gymid" value="<%=gser.get(0).getGid()%>">
							<input type="hidden" name="pkind" value="" id="pki1">
							<input type="hidden" name="pcon" value="" id="pco1">
							<select class="selectclass" >
								<option value="문의사항">문의사항</option>
								<option value="후기">후기</option>
							</select>
							<select class="selectclass" >
								<option value="전체공개">전체공개</option>
								<option value="비밀글">트레이너에게만 공개</option>
							</select>
						<!-- </div> -->
						<textarea id="imtext1" placeholder="문의사항 혹은 후기를 남겨주세요!" name="contents"></textarea>
					</form>
						<div class="fright">
							<!-- <button type="reset">리셋</button> -->
							<button onclick="postgo1();">저장</button>
						</div>
						<div class="fclear"></div>
				</article>
				<div class="posts">
				<!--  포스트 쓰기 여기  --> 
<% 
	if(posts ==null || posts.size() <1){
%>
				<article> 아무도 포스트를 쓰지 않았어요... 당신의 도움이 필요해요! </article>
				<br><br>

<% }else{ %>

		<div class="posts">
<%
		for(int i = 0 ; i < posts.size(); i++){
			int pcon = 99;
			String pc = posts.get(i).getPcon();
				if(pc.equals("전체공개"))
					pcon = 1;
				else if(pc.equals("비밀글"))
					pcon = 0;
			int showme = 0;
			if(imgymOwner ==1 ){
				showme = 1;
			}
			if(pcon ==0){
				showme = 1;
			}
			
			if(showme == 1){
%>
			<article>
				<div class="post_title fleft"><%= posts.get(i).getTitle() %></div>
				<div class="fright"><%=posts.get(i).getPkind() %></div>
				<div class="post_text fclear">
					<%=posts.get(i).getContents() %>
				</div>
				<div class="post_like fright">
					<img src="img/heart_and_star/heart35.png"> 0
				</div>
				<div class="post_writer fright"> by <%= posts.get(i).getWriter() %></div>
			<% if(pcon == 1){ %>
				<div class="post_conceal fright">전체 공개된 포스트. </div>
			<%}else if(pcon==0){ %>
				<div class="post_conceal fright">비공개 포스트. </div>
			<%} %>
				<div class="fclear"></div>
			</article>
<%}} %>

		</div>
<%} %>					



				</div>
			</section>



	</main>


	<script type="text/javascript" src="js/trainerpagejs.js"></script>
	<script type="text/javascript" src="77zzim/zzim1_gymZzim.js?ver=16"></script>
	<link rel="stylesheet" type="text/css" href="css/club_main.css">

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
		width: 800px;
		margin : 0 0 25px 0;
		max-width: unset;
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
		font-size: 13px;
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
		/*background-color: white;*/
		background-color: lightgray;
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


		function postgo1(){
			// alert('여기 오지..?');
			var wForm = $('#wForm');
			var ti = $('#imtitle1').val();
			var tx = $('#imtext1').val();
			var pco1 = $('#pco1');
			var pki1 = $('#pki1');

			if(ti == null || ti ==""){
				alert('제목을 써 주세요. ');
				return;
			}
			else if(tx == null || tx == ""){
				alert('내용을 써 주세요. ');
				return;
			}
			var dd = wForm.find('select').eq(0).val();
			var dd1 = wForm.find('select').eq(1).val();
			pki1.val(dd);
			pco1.val(dd1);
			wForm.submit();

		}
</script>
