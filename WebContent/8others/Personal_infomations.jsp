<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.team7.vo.MemberInfo1" %>
<%@ page import="com.team7.vo.PostBean" %>
<%@ page import="java.util.List" %>

	<title>회원정보</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript" src="js/DAUM_adress.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<%
	request.setCharacterEncoding("UTF-8");



List<MemberInfo1> minfo = (List<MemberInfo1>) request.getAttribute("minfo");

List<PostBean> cposts = (List<PostBean>) request.getAttribute("cposts");
%>

	<div class="headtitle00">
		<%=minfo.get(0).getName() %> 님의 회원정보 
	</div>
	<div class="infos">
		<div class="buttondiv" id="forMyInfo">내 정보 </div>
		<div class="buttondiv" id="forPostInfo">내가 쓴 글</div>
	</div>
	<div></div>

	<div class="infos" id="MyInfo">
		<div>내 정보</div><br>
		<div class="leftInfo">이름 </div>
		<div class="rightInfo"><%=minfo.get(0).getName() %> </div>
		<div class="leftInfo">아이디</div>
		<div class="rightInfo"><%=minfo.get(0).getId() %> </div>
		<div class="leftInfo">이메일 </div>
		<div class="rightInfo"><%=minfo.get(0).getEmail() %> </div>
		<div class="leftInfo">주소</div>
		<div class="rightInfo"><%=minfo.get(0).getAddress() %> </div>
		<div class="leftInfo">관심사</div>
		<div class="rightInfo"><%=minfo.get(0).getInterest() %> </div>
		<div class="leftInfo">가입일 </div>
		<div class="rightInfo"><%=minfo.get(0).getJoindate() %> </div>

		<div class="buttondiv" id="foredit">수정</div>
	</div>

	<div class="infos edits" id="editmyinfo">
		<form id="editform" method="post" action="editmyinfo.log">
			<div class="leftInfo">이름  </div>
			<input type="" name="name" value="<%=minfo.get(0).getName()%>">
			<!-- <div class="leftInfo">아이디</div>
			<input type="" name="id" readonly="true" value="<%=minfo.get(0).getId()%>">
			<div class="leftInfo">이메일 </div>
			<input type="" name="email" readonly="true" value="<%=minfo.get(0).getEmail()%>"> 
			아이디와 이메일은 수정할 수 없습니다. -->
			<div class="leftInfo">주소</div><div class="rightInfo">
			현재 우편번호 : <%=minfo.get(0).getAddress_num() %>
			<br>
			현재 주소 : <%=minfo.get(0).getAddress() %>
			<br>
			<input type="text" id="sample4_postcode" placeholder="우편번호" maxlength="6" class="input00" name="sample4_postcode22">
			<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" class="input00" >
					<input type="text" id="sample4_roadAddress" placeholder="도로명주소" readonly="true" class="sample4_roadAddress input00" name="adress">
					<input type="text" id="sample4_jibunAddress" placeholder="지번주소" readonly="true" class="sample4_jibunAddress input00" name="adress">
					<!-- <span id="guide" style="color:#999;display:none; "></span> -->
					<input type="text" id="sample4_detailAddress" placeholder="상세주소" class="input00" name="sample4_detailAddress">
					<input type="hidden" id="sample4_extraAddress" placeholder="참고항목" class="input00"  >
			</div>
			<div class="leftInfo">관심사</div>
			<div class="rightInfo">현재 관심사 : <%=minfo.get(0).getInterest() %>
				<br>
			<table>
				<tr>
					<td><input class="c00" type="checkbox" name="interest" value="건강"> 건강 </td>
					<td><input class="c00" type="checkbox" name="interest" value="몸매"> 몸매 </td>
					<td><input class="c00" type="checkbox" name="interest" value="체중관리"> 체중관리</td>
				</tr>
				<tr>
					<td><input class="c00" type="checkbox" name="interest" value="식단조절"> 식단조절  </td>
					<td><input class="c00" type="checkbox" name="interest" value="다이어트"> 다이어트  </td>
					<td><input class="c00" type="checkbox" name="interest" value="근육"> 근육 증가 </td>
				</tr>
			</table>
			</div>
			<div class="buttondiv" onclick="editgo()">저장</div>
		</form>
	</div>
	<div class="infos" id="PostInfo">
		<div class="">내가 쓴 글</div>
		<div class="">... </div>
		<div class=""></div>
		<div class=""></div>
		<div class=""></div>
	</div>

	<script type="text/javascript">
		var myinfoButton = $('#forMyInfo');
		var postButton = $('#forPostInfo');
		var editButton = $('#foredit');

		var myInfo = $('#MyInfo');
		var postInfo = $('#PostInfo');
		var editmyinfo = $('#editmyinfo');

			myInfo.slideToggle(300);
			postInfo.slideToggle(300);
			editmyinfo.slideToggle(300);

		myinfoButton.click(function(){
			myInfo.slideToggle(300);
		});
		postButton.click(function(){
			postInfo.slideToggle(300);
		});
		editButton.click(function(){
			editmyinfo.slideToggle(300);
		});


		function editgo(){
			var confirm01 = confirm('개인정보 수정 저장하시겠습니까?');
			if(confirm01){
				$('#editform').submit();
			}

		}


	</script>


	<style type="text/css">
		.headtitle00{
			font-size: 20px;
			font-weight: 700;
		}

		.infos div{
			display: inline-block;
			transition: all 0.5s;
			/*font-size: 14px;*/
			padding: 3px;
		}
		.infos input:after{
			display: block;
		}
		.infos input{
			width: calc(100% - 245px);
		}
		.c00{
			width: unset !important;
		}

		.leftInfo{
			width: 160px;
			border-right: 3px solid skyblue;
			border-bottom: 2px solid skyblue;
			font-size: 15px;
		}
		.rightInfo{
			width: calc(100% - 245px);
			font-size: 13px;
		}
		.buttondiv{
			padding: 5px;
			border: 1px solid silver;
			background-color: rgb(222,222,222);
			/*font-size: 16px !important;*/
		}
		.buttondiv:hover{
			cursor: pointer;
			background-color: rgb(200,200,200);
		}

		@media screen and (max-width: 700px){
			.leftInfo{
				width: 100%;
			}
			.rightInfo{
				width: 100%;
				margin-bottom: 15px;
			}
		}

	</style>
