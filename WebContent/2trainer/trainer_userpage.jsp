
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.team7.vo.Trainer_info" %>
<%@ page import="com.team7.vo.PhotoBean" %>
<%@ page import="com.team7.vo.ZZIMBean" %>
<%@ page import="com.team7.vo.PostBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.*" %>
    

    <link rel="stylesheet" type="text/css" href="css/coachprofile.css?ver=4">
    <link rel="stylesheet" type="text/css" href="css/club_main.css"><!-- 흠... -->
<%
request.setCharacterEncoding("UTF-8");
List<Trainer_info> tser  = (List<Trainer_info>) request.getAttribute("tser"); 
List<PhotoBean> photoBean = (List<PhotoBean>) request.getAttribute("photoBean");
List<PostBean> posts = (List<PostBean>) request.getAttribute("posts");
List<ZZIMBean> tpostzzim = (List<ZZIMBean>) request.getAttribute("tpostzzim");

List<ZZIMBean> zyn2 = (List<ZZIMBean>) request.getAttribute("zzimYN");
boolean zyn = false;
if(zyn2 !=null){
	zyn = true;
}


String id = (String) session.getAttribute("LOG_ID");
int imtrainer = 0;
if(id ==null){
	id="";
}
if(id.equals(tser.get(0).getId()))
	imtrainer = 1;

String picSource1 = "img/aaas.jpeg";
if(photoBean !=null && photoBean.size()>0)
	picSource1 = "Files/trainer/"+tser.get(0).getId()+"/1/"+photoBean.get(0).getPicture();
String picSource2 = null;
String picSource3 = null;
if(photoBean !=null && photoBean.size()>1){
	picSource2 = "Files/trainer/"+tser.get(0).getId()+"/1/"+photoBean.get(1).getPicture();
	if(photoBean.size()>2){
		picSource3 = "Files/trainer/"+tser.get(0).getId()+"/1/"+photoBean.get(2).getPicture();
	}
}
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
				<% if(picSource2 !=null){ %>
				<img class="profile_img" src="<%=picSource2%>">
				<%}else{ %>
				<img class="profile_img" src="img/trainer.jpeg">
				<%} %>
				<div class="profile_name">
					<h3><%=tser.get(0).getTname() %> 코치</h3>
					<hr>
					<span class="a_text"> <%=tser.get(0).getTbigtext() %></span>
					<span> </span>
				</div>
				<div class="zzim" style="width: 100%;">
	<% if(zyn){ %>
					<button data-id2="<%=tser.get(0).getNo() %>"  class="hero__btn1" onclick="zzimThis2_C(this)">찜 취소 <img src="img/heart_and_star/heart34.png"></button>
	<% }else{ %>
					<button data-id2="<%=tser.get(0).getNo() %>"  class="hero__btn1" onclick="zzimThis2(this)">찜하기 <img src="img/heart_and_star/heart034.png"></button>
	<% } %>
					<button class="hero__btn1">1:1 상담요청 <img src="img/heart_and_star/heart34.png"></button>
					<button class="hero__btn1">바로 등록하기 <img src="img/heart_and_star/star34.png"></button>
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
				<img class="ImageForModal" src="<%=picSource1 %>" onclick="ImageClickFunction(this)">

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


<div class="detail_pan">
<img src="img/time.png" class="littleimg">	<p class="label">수업지역</p>
</div>




<p style="font-size: 13px; margin:0 0;">●<%= tser.get(0).getTwhere() %></p>




<div class="detail_pan">
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

<div class="detail_pan">
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
	<li><a href="#coach2">경력사항 및 활동</a></li>
	<li><a href="#program">프로그램소개</a></li>
	<li><a href="#review">후기 및 문의사항</a></li>
</ul>
</nav>


<div class="coachprofile info">
	<br><br>
	<p class="hg" id="coach1">코치정보</p> <!-- 11111111111111111111111111111111111 -->
	<img class="profile_img2" src="<%=picSource1%>">
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
	<p class="hg" id="review">후기 및 문의사항</p><br>
		<!-- 포스트는 여기 뒤에.  -->
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
				if(pc.contains("전체"))
					pcon = 1;
				else if(pc.contains("비밀"))
					pcon = 0;
			int showme = 1;
			if(pcon ==0){
				showme = 0;
			}
			if(imtrainer == 1 || id.equals(posts.get(i).getWriter())){
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
	<% 
		//삭제창
		if(posts.get(i).getWriter().equals(id) ||  imtrainer ==1){
	
	%>
          <div class="deleter fright">
            <img style="width:10px; margin-top:5px; cursor:pointer;" src="img/icons/close33.png" onclick="deletethispost(this)">
            <form action="delete.post" style="display:none;"><input name="tpostno" value="<%=posts.get(i).getNo()%>"></form>
          </div>
					<%}
		boolean heartgood = true;
		for(int l = 0 ; l < tpostzzim.size(); l++){
			boolean zzimed = false;		
			if(tpostzzim.get(l).getCpost() == posts.get(i).getNo()){
				int zcount = tpostzzim.get(l).getCount();
				if(tpostzzim.get(l).getZzimed()==1){
	%>
					<div class="post_like fright" onclick="tpost_z_cancel(this)" data-no="<%=posts.get(i).getNo()%>">
						<img src="img/heart_and_star/heart35.png"> 
	<%			}else{ %>
					<div class="post_like fright" onclick="tpost_z(this)" data-no="<%=posts.get(i).getNo()%>">
						<img src="img/heart_and_star/heart034.png"> 
	<%			} %>
						<span><%=zcount %></span>
	<%
				heartgood = false;
			} 
		}
		if(heartgood){	
	%>
					<div class="post_like fright" onclick="tpost_z(this)" data-no="<%=posts.get(i).getNo()%>">
						<img src="img/heart_and_star/heart034.png"> <span>0</span> 
	<% } %>
					</div>
				<div class="post_writer fright"> by <%= posts.get(i).getWriter() %></div>
			<% if(pcon == 1){ %>
				<div class="post_conceal fright">전체 공개된 포스트. </div>
			<%}else if(pcon==0){ %>
				<div class="post_conceal fright">트레이너에게만 공개된 포스트. </div>
			<%} %>
				<div class="fclear"></div>
			</article>
<%}} %>

		</div>
<%} %>
</div>
	<p class="container1">
	※ 1회 체험에 관한 문의사항을 자유롭게 남겨주세요 ^^<br>
	※코치님이 확인후 연락을드립니다!<br>
	※댓글확인에서 연락까지는 최대 영업일 기준 5일이 소요될수있습니다


</p><br>
			<button onclick="wf1()">문의사항 남기기</button>
			<div id="wf1">
				<article class="new_write">
					<form id="wForm1" method="post" action="trainerPost.post">
						<div >
							<input id="imtitle1" type="text" name="title" class="inputclass" placeholder="제목">
							<input type="hidden" name="trainerid" value="<%=tser.get(0).getNo()%>">
							<input type="hidden" name="pkind" value="문의사항">
							<input type="hidden" name="pcon" value="" id="pco1">
							<select class="selectclass" style="width: 25%;">
								<option value="전체공개">전체공개</option>
								<option value="비밀글">트레이너에게만 공개</option>
							</select>
						</div>
						<textarea id="imtext1" placeholder="문의사항을 남겨주세요!" name="contents"></textarea>
					</form>
						<div class="fright">
							<!-- <button type="reset">리셋</button> -->
							<button onclick="postgo1();">저장</button>
						</div>
						<div class="fclear"></div>
				</article>
			</div>
			<button onclick="wf2()">후기 남기기</button>
			<div id="wf2">
				<article class="new_write">
					<form id="wForm2" method="post" action="trainerPost.post">
						<div >
							<input id="imtitle2" type="text" name="title" class="inputclass" placeholder="제목">
							<input type="hidden" name="trainerid" value="<%=tser.get(0).getNo()%>">
							<input type="hidden" name="pkind" value="후기">
							<input type="hidden" name="pcon" value="" id="pco2">
							<select class="selectclass" style="width: 25%;">
								<option value="전체공개">전체공개</option>
								<option value="비밀글">트레이너에게만 공개</option>
							</select>
						</div>
						<textarea id="imtext2" placeholder="트레이너에게 원하시는게 있나요? 감동받은 사항은요? 후기를 남겨주세요!" name="contents"></textarea>
					</form>
						<div class="fright">
							<!-- <button type="reset">리셋</button> -->
							<button onclick="postgo2();">저장</button>
						</div>
						<div class="fclear"></div>
				</article>
			</div>
		</section>
</article>
	</main>


	<script type="text/javascript" src="6posts/post_delete.js"></script>
	<script type="text/javascript" src="js/photo_modal00.js"></script>

	<script type="text/javascript" src="77zzim/zzim2_trainersZzim.js?ver=5"></script>

	<script type="text/javascript" src="77zzim/zzim_posts_trainer.js?ver=5"></script>

	<script type="text/javascript">

		$('#wf1').slideToggle(300);
		$('#wf2').slideToggle(300);

		function wf1(){
			$('#wf1').slideToggle(300);
		}
		function wf2(){
			$('#wf2').slideToggle(300);
		}

		function postgo1(){
			var wForm1 = $('#wForm1');
			var ti = $('#imtitle1').val();
			var tx = $('#imtext1').val();

			if(ti == null || ti ==""){
				alert('제목을 써 주세요. ');
				return;
			}
			else if(tx == null || tx == ""){
				alert('내용을 써 주세요. ');
				return;
			}
			var dd = wForm1.find('select').val();
			wForm1.find('input').eq(3).val(dd);
			// alert(dd);
			// alert($('#pco1').val());
			// alert('???');
			wForm1.submit();

		}
		function postgo2(){
			var wForm2 = $('#wForm2');
			var ti = $('#imtitle2').val();
			var tx = $('#imtext2').val();

			if(ti == null || ti ==""){
				alert('제목을 써 주세요. ');
				return;
			}
			else if(tx == null || tx == ""){
				alert('내용을 써 주세요. ');
				return;
			}
			var dd = wForm2.find('select').val();
			wForm2.find('input').eq(3).val(dd);
			// alert(dd);
			wForm2.submit();
		}

	</script>

<style type="text/css">
	*{
		box-sizing: border-box;
	}
	.mainwrap_club{
		width: 1000px;
		margin: 0 auto;
	}
	.detail_pan{
		margin-top: 15px;
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
		margin-top: 40px;
  		object-fit: cover;
	}

	.new_write{
		/*width: 500px;
		margin : 0 0 25px 0;*/
		max-width: unset;
		width: 100%;
	}
	.new_write textarea{
		/*width: 600px;*/
		width: 100%;
		height: 100px;
		border: 3px solid silver;
		resize: none;

	}
	.posts{
		/*width: 500px;*/
		/*border: 1px solid silver;*/
		width: unset;
		max-width: unset;
	}
	.posts article{

		/*width: 600px;*/
		width: unset;
		max-width: unset;
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


	#wf1{
		transition: all 0.3s;
	}
	#wf2{
		transition: all 0.3s;
	}




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
		all:unset;
		background-color: silver;
		padding: 8px 15px;
		transition: all 0.2s;
		border-radius: 20px;
		margin: 5px;
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

</script>

