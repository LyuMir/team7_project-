<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.team7.vo.ClubBean" %>
<%@ page import="com.team7.vo.CmemberBean" %>
<%@ page import="com.team7.vo.PostBean" %>
<%@ page import="com.team7.vo.PhotoBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>


    <link rel="stylesheet" type="text/css" href="css/club_main.css?ver=67">
	<link rel="stylesheet" type="text/css" href="css/photo_modal00.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%
	request.setCharacterEncoding("UTF-8");
	String id = (String) session.getAttribute("LOG_ID");
	
	int adminyn=0, joinyn=0;

List<ClubBean> mylist = (List<ClubBean>) request.getAttribute("mylist");
List<ClubBean> mylist2 = (List<ClubBean>) request.getAttribute("mylist2");
List<ClubBean> rlist = (List<ClubBean>) request.getAttribute("rlist");
List<ClubBean> rlist00 =  (List<ClubBean>) request.getAttribute("rlist00");
List<ClubBean> tlist = (List<ClubBean>) request.getAttribute("tlist");
boolean ami = (boolean) request.getAttribute("ami");	//탈퇴 중 tf
boolean ied = (boolean) request.getAttribute("ied");	//가입신청중 tf

List<PostBean> cposts = (List<PostBean>) request.getAttribute("cposts");
List<PhotoBean> cpphotos = (List<PhotoBean>) request.getAttribute("cpphotos");
int j = cpphotos.size() -1 ;
ArrayList<Integer> ppnum = new ArrayList<Integer>();
ArrayList<Integer> pp00 = new ArrayList<Integer>();
int u = j;
for(int k = j ; k >=0 ; k--){
	String pid = cpphotos.get(k).getId();
	int last0 = pid.lastIndexOf("_");
	pid = pid.substring(last0 + 1);
	ppnum.add(Integer.parseInt(pid));
	pp00.add(u--); 
}

int mypostnumber = (Integer) session.getAttribute("mypostnumber");

//if(id.equals("null")){
	//out.println(rlist);
	//out.println(rlist00.get(0));
if(id ==null){
	
}else{
	if(id.equals(rlist.get(0).getAdmin())){
		adminyn=1;
	}
	for(int i = 0 ; i < mylist.size(); i++){
		if(mylist.get(i).getNo() == rlist.get(0).getNo()){
	joinyn = 1;
		}
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
				<select id="goclub1" onchange="gotoClub(this)">
					<option>내가 속한 소모임</option>
		<% for(int i = 0 ; i < mylist.size(); i++){ %>
					<option data-id="<%= mylist.get(i).getNo() %>"><%=mylist.get(i).getName() %></option>
		<% } %>
				</select>
				<select id="goclub2" onchange="gotoClub(this)">
					<option>내가 찜한 소모임</option>
		<% for(int i = 0 ; i < mylist2.size(); i++){ %>
					<option data-id="<%= mylist2.get(i).getNo() %>"><%=mylist2.get(i).getName() %></option>
		<% } %>
				</select>
				<select id="goclub3" onchange="gotoClub(this)">
					<option><%=rlist.get(0).getName()%>과 가까운 소모임</option>
		<% for(int i = 0 ; i < tlist.size(); i++){ 
				if(tlist.get(i).getNo() == rlist.get(0).getNo()){}else{%>
					<option data-id="<%= tlist.get(i).getNo() %>"><%=tlist.get(i).getName() %></option>
		<% } }%>
					<!-- <option>엄청나게 긴 글씨가 다 들어가는지 확인하는 작업 </option>
					<option>엄청나게 긴 글씨가 다 들어가는지 확인하는 작업 2</option>
					<option>엄청나게 긴 글씨가 다 들어가는지 확인하는 작업 3</option> -->
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
					<button id="z_zzim_1" onclick="managego()">관리하기 <img src="img/heart_and_star/heart34.png"></button>
					<button id="z_join_1" onclick="joinmanagego()">가입관리 <img src="img/heart_and_star/star34.png"></button>
				</div>
	<% }else if(joinyn == 1){ %>
				<div class="zzim">
					<button id="z_zzim1" onclick="Zzim_club(this)" data-id="<%=rlist.get(0).getNo()%>">찜하기 <img src='img/heart_and_star/heart034.png'></button>
					<button id="z_join1" onclick="outme()">탈퇴하기 <img src="img/heart_and_star/star_black34.png"></button>
				</div>
	<% }else{ %>
				<div class="zzim">
					<button id="z_zzim1" onclick="Zzim_club(this)" data-id="<%=rlist.get(0).getNo()%>">찜하기 <img src='img/heart_and_star/heart034.png'></button>
					<button id="z_join1" onclick="joinme()">가입신청 <img src="img/heart_and_star/star34.png"></button>
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
				<!-- 여기에 새 게시글 올릴 수 있도록. 가입자만!! joinyn  -->
<% if(joinyn == 1){ %>
			<article class="new_write">
					<div>
						<input type="text" name="title" class="inputclass" placeholder="제목">
						<select class="selectclass">
							<option value="000" style="color: red;">종류</option>
							<option value="모집">모집</option>
							<option value="후기">후기</option>
							<option value="자랑">자랑</option>
						</select>
						<select class="selectclass" >
							<option value="001" style="color: red;">공개성</option>
							<option value="전체공개" selected="true">전체 공개</option>
							<option value="모임공개">모임공개</option>
							<option value="관리자만">소모임 관리자만</option>
						</select>
					</div>
					<textarea id="imtext" placeholder="당신의 운동을 써보세요!"></textarea>
					<div class="fleft">
						<button onclick="post_photo();">사진업로드</button>
						<span id="photoname"></span>
					</div>
					<div class="fright">
						<button type="reset">리셋</button>
						<button onclick="postgo();">저장</button>
					</div>
					<div class="fclear"></div>
			</article>
<% }else{ %>
			<article class="new_write">
				<div>
					<textarea id="plzjoin_00" readonly="true" placeholder="당신의 운동을 써보세요!"></textarea>
				</div>
			</article>
<% } %>
			<div class="posts">
<% 
	if(cposts ==null || cposts.size() <1){
%>
				<article> 아무도 포스트를 쓰지 않았어요... 당신의 도움이 필요해요! </article>

<% }else{ 
	out.print("oㅐ"+cposts.size());

		for(int i = cposts.size()-1 ; i>=0; i--){
			boolean showme = false;	
			int shst = 0;
		
				if(cposts.get(i).getPcon().contains("관리자만")){
					shst = 3;
					if(adminyn == 1)
						showme = true;
				}else if(cposts.get(i).getPcon().contains("모임")){
					shst = 2;
					if(joinyn == 1)
						showme = true;
				}else{
					showme = true;
				}
		if(showme){
%>
				<article>
					<div class="post_title"><%= cposts.get(i).getTitle() %></div>
					
	<% if(cpphotos.size() >0){ %>
		<% 
		out.print(i+"번째 포스트..");
		for(int k = 0 ;  k < ppnum.size(); k ++){
		out.print(pp00.get(k));	
		
			if(ppnum.get(k) == i ){ %>
					<div class="post_img">
						<img class="ImageForModal" src="Files/clubpost/club_<%=rlist.get(0).getNo() %>/<%=i %>/<%=cpphotos.get(pp00.get(k)).getPicture() %>" onclick="ImageClickFunction(this)">
						<div class="modal">
						  <img class="modal-content">
						  <div class="caption"><%=cpphotos.get(pp00.get(k)).getPicture() %> </div>
						</div>
					</div>
	<%   } %> 
	<%} }%>
					<div class="post_text">
						<%=cposts.get(i).getContents() %>
					</div>
					<div class="post_like fright">
						<img src="img/heart_and_star/heart35.png"> 0
					</div>
					<div class="post_writer fright"> by <%= cposts.get(i).getWriter() %></div>
		<% if(shst == 3){ %>
					<div class="post_conceal fright">관리자에게만 공개된 포스트. <img src="img/icons/password18.png"> </div>
		<% }else if(shst == 2){ %>
					<div class="post_conceal fright">모임 회원에게만 공개된 포스트입니다. <img src="img/icons/password18.png"> </div>
		<% }else{ %>
					<div class="post_conceal fright">전체 공개된 포스트. </div>
		<% } %>
					<div class="fclear"></div>
				</article>

<% } } }  %>


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
<form id="form3" action="id_joinme.club" method="post" style="display: none;">
	<input type="hidden" name="clubid" value="<%=rlist.get(0).getNo()%>">
	<input type="hidden" name="clubname" value="<%=rlist.get(0).getName()%>">
</form>
<form id="form4" action="outme.club" method="post" style="display: none;">
	<input type="hidden" name="clubid" value="<%=rlist.get(0).getNo()%>">
</form>

<form id="postPicture" enctype="multipart/form-data" accept-charset="UTF-8" action="clubPostPhoto.post" method="post" style="display: none;">
	<input type="text" name="mypostnumber" value="111">
	<input type="file" name="photo"  accept=".jpg,.jpeg,.png,.gif,.bmp,.webm">
</form>

<form id="postForm" action="clubPost.post" method="post" style="display: none;">
	<input type="hidden" name="clubid" value="<%=rlist.get(0).getNo()%>">
	<input type="" name="mypostnumber" value="111">
	<input type="text" id="ptitle" name="title" value="">
	<!-- 타이틀, 작성자, 컨텐츠, 포스트 종류, 포스트 공개성 끝.  -->
	<textarea name="contents"></textarea>
	<input type="text" id="ppkind" name="pkind" value="">
	<input type="text" id="ppcon" name="pcon" value="">
</form>


	</main>



	<script type="text/javascript" src="77zzim/zzim_js.js?ver=5"></script>
	<script type="text/javascript" src="js/photo_modal00.js"></script>
<script type="text/javascript">

	//minyn %>;
	//nyn %>; // 0과 1입니다. 
	var ami = false;
	var ied = false;
	var id ="";
	var joinyn = 0;

	id = "<%= id%>";
	ami = <%=ami %>;
	ied = <%=ied %>;
	joinyn = <%=joinyn%>;

	var z1button = $('#z_zzim_1');
	var z2button = $('#z_join1');

	var sender0 = $('#sender0');
	var forwhere = $('#forwhere');

var form000 = $('.new_write');
var postpic = $('#postPicture');
var picpic = postpic.children('input[type="file"]');
var photoname = $('#photoname');
var postpost00 = $('#postForm');
var plzjoin_00 = $('#plzjoin_00');

	function managego(){
		$('#form1').submit();
	}
	function joinmanagego(){
		$('#form2').submit();
	}
	function joinme(){
		//alert($('#form3').children('input').val());
		$('#form3').submit();
	}
	function outme(){
		var confirmE = confirm("탈퇴 버튼을 누르면 일주일(148시간)의 유예 기간을 거친 후 탈퇴 처리됩니다. 유예 기간 동안 탈퇴 신청을 취소할 수 있습니다. 계속하시겠습니까?");
		if(confirmE){
			$('#form4').submit();
		}
	}
	
	
	setTimeout(goinTFs(),1000);
	
	function goinTFs(){
		if(ami){
			goingoutTF();	//탈퇴중인가
			//alert('여기여기??');
		}
		if(ied){
			goinginTF();	//가입중인가.
			//alert('여기 오나?');
		}


		picpic.change(function(){
			var pname = picpic.val().split('/').pop().split('\\').pop();
			photoname.text(pname);
		});
			var pname = picpic.val().split('/').pop().split('\\').pop();
			photoname.text(pname);
	}
	// if(ami){
	//	setTimeout(goingoutTF(),1000);	
	// }
	// if(ied){
	//	setTimeout(goinginTF(),1000);	//가입중인가.
	// }
	
	
	function goingoutTF(){
		if(ami){
			$('button#z_join1').html("탈퇴 중 <img src='img/heart_and_star/star_black34.png'>");
			$('button#z_join1').attr('onclick','outme_cancle()');
		}
		else{
			$('button#z_join1').html("탈퇴하기 <img src='img/heart_and_star/star_black34.png'>");
			$('button#z_join1').attr('onclick','outme()');
		}
	}
	function goinginTF(){
		if(ied){
			$('button#z_join1').html("가입심사 중.. "); //<img src='img/star34.png'>
			//$('button#z_join1').attr('onclick','');
		}
		else{

		}
	}

	function zzim2(){

	}

	function post_photo(){

		if(picpic.val() ==null || picpic.val()==""){
			picpic.click();
		}
		else{
			var confirm0 = confirm('새 사진을 올리면 이전 사진은 지워집니다. 계속 하시겠습니까?');
			if(confirm0){
				picpic.click();
			}
			else{
				return;
			}
		}

		post_photo2();

	}
	// picpic.change(function(){
	// 	post_photo2();
	// });
	function post_photo2(){
		picpic.change(function(){
			var pname = picpic.val().split('/').pop().split('\\').pop();
			photoname.text(pname);
			 postpic.submit();
		});
				 // setTimeout(postpic.submit(),1000);

	}

	function postgo(){

		var title00 = form000.find('input').val();
		var select1 = form000.find('select').eq(0).val();
		var select2 = form000.find('select').eq(1).val();
		var text00 = form000.find('textarea').val();
		// alert(text00);
		postpost00.children('#ptitle').val(title00);
		postpost00.children('#ppkind').val(select1);
		postpost00.children('#ppcon').val(select2);
		postpost00.children('textarea').val(text00);

		if(select1=="000"){
			alert('포스트 종류를 선택하세요!');
			return;
		}
		if(select2 =="001"){
			alert('포스트 공개여부를 선택하세요!');
			return;
		}


		if(title00=="" && text00==""){
			alert('제목과 내용을 입력해주세요. ');
			return;
		}
		// if(picpic.val() ==null || picpic.val()==""){
		// 	var confirm0 = confirm('사진을 올리지 않고 진행하시겠습니까?');
		// 	if(!confirm0){
		// 		return;
		// 	}
		// }

		postpost00.submit();
	}

	plzjoin_00.click(function(){
		//plzjoin_00.focusout();
		if(id==null || id==""|| id=="null"){
			loginModalgo("글쓰기는 로그인이 필요한 기능입니다.");
		}
		else if(joinyn != 1){
			alert('글을 쓰시려면 소모임에 가입하셔야 합니다!');
		}
		// alert('글을 쓰시려면 소모임에 가입하셔야 합니다!');
	});

	function gotoClub(select){
		var goto000 = $(select).children('option:selected').val();
		var gotour = $(select).children('option:selected').data('id');
		// alert(goto000+gotour);
		var confirm000 = confirm(goto000+'로 이동합니다. 계속하시겠습니까?');
		var url = "toClubMain.club?clubid="+gotour;
		if (confirm000) {
			location.href=url;
		}
	}

</script>