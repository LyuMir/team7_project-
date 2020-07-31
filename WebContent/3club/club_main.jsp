<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.team7.vo.ClubBean" %>
<%@ page import="java.util.List" %>

    <link rel="stylesheet" type="text/css" href="css/club_main.css">
	<link rel="stylesheet" type="text/css" href="css/photo_modal00.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%

request.setCharacterEncoding("UTF-8");
	String id = (String) session.getAttribute("LOG_ID");
	
	int adminyn=0, joinyn=0;

List<ClubBean> rlist = (List<ClubBean>) request.getAttribute("rlist");
List<ClubBean> rlist00 =  (List<ClubBean>) request.getAttribute("rlist00");
//if(id.equals("null")){
	//out.println(rlist);
	//out.println(rlist00.get(0));
if(id ==null){
	
}else{
	if(id.equals(rlist.get(0).getAdmin())){
		adminyn=1;
	}
}
%>
<!--  가입자 / 구경자 / 관리자에 따라... -->
<!-- 
		찜하기/탈퇴하기 | 	찜하기. 가입신청   | 관리하기 / 가입관리 

		new_write 글쓰기 관리 : 권한없음 (disabled) | 가능  | 삭제까지...?
 -->


	<main class="mainwrap_club">
		<section class="club_left">
			<article class="left_top">
				<select>
					<option>내가 속한 소모임</option>
				</select>
				<select>
					<option>내가 찜한 소모임</option>
				</select>
				<select>
					<option>(소모임)과 가까운 소모임</option>
					<option>엄청나게 긴 글씨가 다 들어가는지 확인하는 작업 </option>
					<option>엄청나게 긴 글씨가 다 들어가는지 확인하는 작업 2</option>
					<option>엄청나게 긴 글씨가 다 들어가는지 확인하는 작업 3</option>
				</select>
			</article>
			<hr>
			<article class="left_main">
				<!-- <div class="profile_img"><img src=""></div> -->
				<img class="profile_img" src="img/이쁜이미지1.jpg">
				<div class="profile_name">
					<%=rlist.get(0).getName() %>
				</div>
	<% if(adminyn == 1){ %>
				<div class="zzim">
					<button id="z_zzim_1" onclick="managego()">관리하기 <img src="img/heart34.png"></button>
					<button id="z_join_1" onclick="joinmanagego()">가입관리 <img src="img/star34.png"></button>
				</div>
	<% }else if(joinyn == 1){ %>
				<div class="zzim">
					<button id="z_zzim1">찜하기 <img src="img/heart34.png"></button>
					<button id="z_join1">탈퇴하기 <img src="img/star_black34.png"></button>
				</div>
	<% }else{ %>
				<div class="zzim">
					<button id="z_zzim1">찜하기 <img src="img/heart34.png"></button>
					<button id="z_join1">가입신청 <img src="img/star34.png"></button>
				</div>
	<% } %>
				<!-- <div class="zzim">
					<button id="z_zzim1">찜취소 <img src="img/heart34.png"></button>
					<button id="z_join1">탈퇴하기 <img src="img/star34.png"></button>
				</div> -->
				<!-- 둘 중에 하나만 나타나게 jsp 처리 할거임.  -->
				<div class="profile_mozip_status">
					<span class="weight500">현재 정원 : </span>/150, <%=rlist.get(0).getMemberJoin() %> 중
				</div>
				<div class="profile_info">
					
					<div><span class="weight500">운동 : </span><span><%=rlist.get(0).getE_type() %></span></div>
					<div><span class="weight500">날짜 : </span><span><%=rlist.get(0).getMeetingDate() %></span></div>
					<div><span class="weight500">장소 : </span><span><%=rlist.get(0).getArea() %></span></div>
				</div>
				<div class="profile_text">
					<%=rlist.get(0).getProfile() %>
				</div>
				<div class="profile_people">
					<div class="pp_admin"><span class="weight500">관리자 : </span><%=rlist.get(0).getAdmin() %></div>
					<div class="pp_p"><span class="weight500">활동명단 : </span> </div>
				</div>
			</article>
		</section>
		<!-- 왼쪽 끝.  -->
		<!-- <section class="club_left2">.</section> -->
		<!-- 왼쪽 부피감? -->

		<section class="club_main">
			<article class="main_head">
				<!-- 사진 크게 넣을거임. ...사진 될까? -->
				<img class="ImageForModal" src="img/이쁜이미지2.jpg" onclick="ImageClickFunction(this)">
				<div class="modal">
					<img class="modal-content">
					<div class="caption">***소모임의 메인 이미지입니다. </div>
				</div>
			</article>
			<hr>
			<article class="new_write">
				<!-- 여기에 새 게시글 올릴 수 있도록.  -->
				<form>
					<textarea placeholder="당신의 운동을 써보세요!"></textarea>
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
						  <div class="caption">이미지가 정말 이쁘쥬? 조보아씨! 여기 등산해봐유! </div>
						</div>
					</div>
					<div class="post_text">
						김밥 한 줄 놓고 갑니다~~~ 오홍홍 @@@@@@@@@@))))))))))); <br>
						김밥 한 줄 놓고 갑니다~~~ 오홍홍 @@@@@@@@@@)))))))))))12345; 
					</div>
					<div class="post_like">
						<img src="img/heart35.png"> 3543
					</div>
					<div class="fclear"></div>
				</article>
				<article>이런 포스트들이 계속 나오는거임. </article>
				<article>이런 포스트들이 계속 나오는거임. </article>
				<article>이런 포스트들이 계속 나오는거임. </article>
				<article>이런 포스트들이 계속 나오는거임. </article>
				<article>이런 포스트들이 계속 나오는거임. </article>
				<article>이런 포스트들이 계속 나오는거임. </article>

			</div>
		</section>
		<div class="fclear">.</div>
<!-- <form id="sender0" action="team_FORWHERE.jsp" method="post" style="display: none;">
	<input type="hidden" name="forwhere" id="forwhere">
	<input type="hidden" name="clubid" value="=rlist.get(0).getNo()%>">
</form> -->
<form id="form1" action="_FORWHERE.jsp" method="" style="display: none;">
	<input type="hidden" name="forwhere" value="3club/club_edit.jsp">
	<input type="hidden" name="clubid" value="<%= rlist.get(0).getNo() %>">
</form>
<form id="form2" action="manage.club" method="post" style="display: none;">
	<input type="hidden" name="clubid" value="<%=rlist.get(0).getNo()%>">
</form>
	</main>



	<script type="text/javascript" src="js/photo_modal00.js"></script>
<script type="text/javascript">

	//minyn %>;
	//nyn %>; // 0과 1입니다. 

	var z1button = $('#z_zzim_1');
	var z2button = $('#z_join1');

	var sender0 = $('#sender0');
	var forwhere = $('#forwhere');

	function managego(){
		$('#form1').submit();
	}
	function joinmanagego(){
		$('#form2').submit();
	}

	// function zzim1(){
	// 	if(adminyn ==1){
	// 		sender0.children('#forwhere').val('club_createNedit.jsp');
	// 		sender0.submit();
	// 	}
	// 	else{
	// 		//sender0.
	// 		// 이건 ajax로 찜 연결 ㅇㅇ. 
	// 	}
	// }
	function zzim2(){

	}

	//."z_zzim1">찜하기  id="z_join1" 가입하기 
	//$('#')
	// $('#z_zzim1').click(zzimed());
	// $('#z_zzim1').on('click', function(){
	// 	//$(this).html('찜!');
	// 	$(this).zzimed();

	// 	// $(this).zzimed(); 놉
	// });

	// function zzimed(){
	// 	$(this).html('찜!<img src="img/heart34.png">');
	// }
	// function zzimc(){
	// 	$(this).html('찜하기 <img src="img/heart34.png">');
	// }

	function post_photo(){
		
	}

	function postgo(){
		
	}

	// var mainSecHeight = $('section.club_main').outerHeight(true);
	// alert(mainSecHeight);

</script>