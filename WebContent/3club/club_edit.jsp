<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@ page import="org.apache.ibatis.session.SqlSession"%>
<%@ page import="com.team7.dao.Class_DAO" %>
<%@ page import="com.team7.vo.DTO_ClubProperties" %>
<%@ page import="com.team7.photo.service.*" %>
<%@ page import="com.team7.vo.ClubBean" %>
<%@ page import="com.team7.vo.PhotoBean" %>
<%@ page import="com.team7.club.service.*" %>
<%@ page import="java.util.List"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/mainmain88.css">
<link rel="stylesheet" type="text/css" href="css/checkbox__.css">


<link rel="stylesheet" type="text/css" href="css/club_Create.css">
<script type="text/javascript" src="js/club_Create_js.js?v=<%=System.currentTimeMillis()%>"></script>
	<%
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("clubid");
		session.setAttribute("clubid",id);
		//String id = "3";
		//Class_DTO_i clubid = new Class_DTO_i();
		//clubid.setI(Integer.parseInt(id));
		ClubBean dto = new ClubBean();
		dto.setNo(Integer.parseInt(id));

		List<ClubBean> theclub = new ClubService().club_selector_no(dto);

		String myid = (String) session.getAttribute("LOG_ID");

		List<PhotoBean> cpho = new PhotoClubService().getfilenames_clubmains(myid, Integer.parseInt(id));
		String cp1 = null;
		String cp2 = null;
		if(cpho.size()>0){
			for(int i = 0 ; i < cpho.size(); i++){
				if(cpho.get(i).getId().contains("main")){
					cp1 = "Files/clubsphoto/"+myid+"_"+id+"/main"+cpho.get(i).getPicture();
				}
				if(cpho.get(i).getId().contains("profile")){
					cp2 = "Files/clubsphoto/"+myid+"_"+id+"/profile"+cpho.get(i).getPicture();
				}
			}
		}

		session.setAttribute("clubid", theclub.get(0).getNo());
	%>

	<main>
		<table>


	<form class="" action="edit.club" enctype="multipart/form-data"  method="post"	id="club_creator_form">
		<input readonly="true" type="hidden" name="no" value="<%=id%>">
			<tr>
				<td>소모임 이름</td>
				<td><input readonly="true" id="" type="text" name="" maxlength="25" placeholder="소모임 이름" value="<%=theclub.get(0).getName()%>">
					<div id="output01">이름은 바꿀 수 없습니다...</div>
					<!-- <span class="white000">.</span> --></td>
			</tr>
			<tr>
				<td>공개성</td>
		<%
			String s1="", s2="", s3="", s4="";
			if(theclub.get(0).getPublicity().equals("open"))	s1="selected";
			else if(theclub.get(0).getPublicity().equals("local_open"))	s2="selected";
			else if(theclub.get(0).getPublicity().equals("friend_only"))		s3="selected";
			else s4="selected";
		%>
				<td><select name="club_publicity" id="meeting_publicity">
						<option>선택하세요.</option>
						<option value="open" <%=s1%>>공개</option>
						<option value="local_open" <%=s2%>>지역공개</option>
						<option value="friend_only" <%=s3%>>친구공개</option>
				</select>	<%-- &emsp;현재 : <%= theclub.get(0).getPublicity() %>&emsp;  --%><span id="meeting_pubText"></span></td>
			</tr>
			<tr>
				<td>모집</td>
				<td>
					<%-- <span class="radioColor">  --%>
						<input type="radio" name="club_memberJoin" id="r1" value="공개 모집"> <label for="r1">공개 모집 </label>
					<%-- </span> --%>
					<input type="radio" name="club_memberJoin" id="r2" value="제한 모집"><label for="r2">공개 제한모집 </label>
					<input type="radio"	name="club_memberJoin" id="r3" value="초대 모집"> <label for="r3">초대 모집 </label>
					<input type="radio" name="club_memberJoin" id="r4" value="모집 중단"> <label for="r4">모집 중단 </label>
					<div id="meeting_memGet">
						<span class="no_displ">멤버를 제한없이 모집합니다. </span> <span class="no_displ">멤버를
							<input type="" name="club_memLimit" style="width: 30px; height: 20px;" value="<%=theclub.get(0).getMemberLimit()%>">
								명 까지 모집하고, 그 후에는 모집을 중단합니다.
						</span> <span class="no_displ">모임의 초대권을 가진 사람만 멤버를 초대할 수 있습니다. </span> <span
							class="no_displ">현재 멤버를 더 모집하지 않습니다. </span>
						<!-- <span>선택하세요. </span> -->
					</div>
					<%-- &emsp;현재 : <%= theclub.get(0).getMemberJoin() %>&emsp; --%>
				</td>
			</tr>
			<tr>
				<td>운동종류</td>
				<td>
					<!-- <input type="text" name="club_exc_type" placeholder=",로 구분하며 여러개 작성" value="<%= theclub.get(0).getE_type() %>"> -->
					<div class="checkme"><input type="checkbox" name="club_exc_type" value="농구"><label>농구</label></div>
					<div class="checkme"><input type="checkbox" name="club_exc_type" value="축구"><label>축구</label></div>
					<div class="checkme"><input type="checkbox" name="club_exc_type" value="배구"><label>배구</label></div>
					<div class="checkme"><input type="checkbox" name="club_exc_type" value="야구"><label>야구</label></div>
					<div class="checkme"><input type="checkbox" name="club_exc_type" value="헬스"><label>헬스</label></div>
					<div class="checkme"><input type="checkbox" name="club_exc_type" value="달리기"><label>달리기</label></div>
					<div class="checkme"><input type="checkbox" name="club_exc_type" value="필라테스"><label>필라테스</label></div>
					<div class="checkme"><input type="checkbox" name="club_exc_type" value="요가"><label>요가</label></div>
					<div class="checkme"><input type="checkbox" name="club_exc_type" value="보드"><label>보드</label></div>
					<div class="checkme"><input type="checkbox" name="club_exc_type" value="자전거"><label>자전거</label></div>
					<div class="checkme"><input type="checkbox" name="club_exc_type" value="족구"><label>족구</label></div>
					<div class="checkme"><input type="checkbox" name="club_exc_type" value="배드민턴"><label>배드민턴</label></div>
					<div class="checkme"><input type="checkbox" name="club_exc_type" value="맨손 체조"><label>맨손 체조</label></div>
					<br> &emsp;현재 : <%= theclub.get(0).getE_type() %>&emsp;
				</td>
			</tr>
			<tr>
				<td>정기모임 <br> 요일 및 시간
				</td>
				<td><select name="meetingDate_select" id="meetingDate_select">
						<option>선택하세요.</option>
						<option value="meeting1">매주 @요일</option>
						<option value="meeting2">매 @번째 주 @요일</option>
						<option value="meeting3">매달 @번째 @요일</option>
				</select>&emsp;|| <span id="meetingDate_week"> <!-- 여기 텍스트 html로 전부
							예 ) 매주 input 요일.
							 --> &emsp; &emsp;
				</span>||&emsp; <input type="hidden" name="club_date"
					id="meetingDate_sender"> <!-- <input type="checkbox" name=""> -->
					<!-- <input class="small_input" type="text" name="">시 ~
						<input class="small_input" type="" name=""> 시 --> <select
					name="club_hour1">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
						<option>13</option>
						<option>14</option>
						<option>15</option>
						<option>16</option>
						<option>17</option>
						<option>18</option>
						<option>19</option>
						<option>20</option>
						<option>21</option>
						<option>22</option>
						<option>23</option>
						<option>24</option>
				</select> 시 ~ <select name="club_hour2">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
						<option>13</option>
						<option>14</option>
						<option>15</option>
						<option>16</option>
						<option>17</option>
						<option>18</option>
						<option>19</option>
						<option>20</option>
						<option>21</option>
						<option>22</option>
						<option>23</option>
						<option>24</option>
				</select> 시
				<br>
				&emsp;현재 : <%= theclub.get(0).getMeetingDate() %>&emsp;
				</td>
			</tr>
			<tr>
				<td>정기모임 장소</td>
				<td><select name='club_area' onchange="areaSelector(this)">
						<option value='전체'>전체</option>
						<option value='서울'>서울</option>
						<option value='부산'>부산</option>
						<option value='대구'>대구</option>
						<option value='인천'>인천</option>
						<option value='광주'>광주</option>
						<option value='대전'>대전</option>
						<option value='울산'>울산</option>
						<option value='경기'>경기</option>
						<option value='강원'>강원</option>
						<option value='충북'>충북</option>
						<option value='충남'>충남</option>
						<option value='전북'>전북</option>
						<option value='전남'>전남</option>
						<option value='경북'>경북</option>
						<option value='경남'>경남</option>
						<option value='제주'>제주</option>
				</select> <select name='county' class=select>
						<option value='전지역'>전지역</option>
				</select>
				<br>
				&emsp;현재 : <%= theclub.get(0).getArea() %>&emsp;
				</td>
			</tr>
			<tr>
				<td>소모임 소개</td>
				<td><textarea rows="2" name="club_profileText"><%= theclub.get(0).getProfile() %></textarea></td>
			</tr>
	</form>
			<tr>
				<td>소모임 사진</td>
				<td>소모임 프로필 사진 <!-- : b ... 소모임 대표 사진 : b // 현재 사진 올리기 기능이 제한되어
					있습니다. 문의사항 : 이재형 0720 -->
					  <span style="color: red; font-weight: 700;">(프로필 사진은 5mb 이하여야 합니다! 업로드 즉시 적용되니 주의하세요!)</span>
					<br>
		<form id="photo_upload" enctype="multipart/form-data" accept-charset="UTF-8" method="post" action="photo_upload.club">
				<input type="file" id="photo1" name="photo1" accept=".jpg,.jpeg,.png,.gif,.bmp,.webm"> 메인 사진 (대문 사진)
		</form> <button onclick="photo_upload()">사진 업로드</button>


		<form id="photo_upload2" enctype="multipart/form-data" accept-charset="UTF-8" method="post" action="photo_upload2.club">
				<input type="file" id="photo2" name="photo2" accept=".jpg,.jpeg,.png,.gif,.bmp,.webm"> 메인 프로필 사진
		</form> 	 <button onclick="photo_upload2()">사진 업로드</button>
						<br>
						현재 메인 사진 :
		<% if(cp1 ==null){ %>
		설정되지 않음. (기본 사진 )
		<%}else{ %>
						<img src="<%=cp1%>">
		<%} %>
						<br>
		<% if(cp2 ==null){ %>
		설정되지 않음. (기본사진)
		<%}else{ %>
						<img src="<%=cp2%>">
		<%} %>
						프로필 :

				</td>
			</tr>
		</table>
	<div class="button00">
		<button onclick="formSender2()">소모임 수정하기</button>
	</div>
	</main>

<%
	//String s11="", s12="", s13="", s14="";
	//String conceality="";
	//if(theclub.get(0).getMemberJoin().contains("공개")) conceality="공개";
	String conceality = theclub.get(0).getMemberJoin();
	String excs = theclub.get(0).getE_type();
	String times = theclub.get(0).getMeetingDate();

%>

	<script type="text/javascript" src="js/club_CRU.js?version=22"></script>


<script type="text/javascript">
	// var
	var conceality = '<%=conceality%>';
	var excs = '<%=excs%>';
	var times = '<%=times%>';

	if(conceality.indexOf("공개") > 0 ) $('input#r1').text('::after');
	else if(conceality.indexOf("제한") > 0 ) $('input#r2').text('::after');
	else if(conceality.indexOf("초대") > 0 ) $('input#r3').text('::after');
	else if(conceality.indexOf("중단") > 0 ) $('input#r4').text('::after');
	// 안먹히나?

</script>
