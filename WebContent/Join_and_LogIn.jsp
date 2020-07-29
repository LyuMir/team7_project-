<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html>
<head>
	<title></title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/joinpage00.css">
	<link rel="stylesheet" type="text/css" href="css/mainmain88.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="js/DAUM_adress.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>


</head>
<body>

	<div class="logo_loc">
		 <a href="index.jsp"><img src="img/logo1.png"> </a>
	</div>
<div class="my_middler my_joiner">
	<div class="joiner_container" id="joiner_container">
		<form method="post" action="join.log" id="joinerForm">
		<div class="form-joiner_container joiner_container_picture">
			<img src="img/이쁜이미지1.jpg"> <!-- 아무거나 넣음 -->
		</div>
		<div class="form-joiner_container joiner_container1">
			<div class="innerwrap">
				<h1>회원 가입</h1>
				<span>이미 가입되어 있으신가요? <span id="TOLOGIN" class="clicker">로그인</span></span>
				<input class="input00" type="text" placeholder="아이디" name="id" />
				<div class="output01">
					<div class="nogo"></div>
				</div>
				<input class="input00" type="text" placeholder="이름(닉네임)" name="name" />
				<div class="output01">
					<div class="nogo"></div>
				</div>
				<input class="input00" type="email" placeholder="이메일(aa@bb.cc)" name="email" />
				<div class="output01">
					<div class="nogo"></div>
				</div>
				<input class="input00" type="password" placeholder="비밀번호(8자리 이상)" name="pw" />
				<div class="output01">
					<div class="nogo"></div>
				</div>
				<input class="input00" type="password" placeholder="비밀번호 재확인" name="pw2" />
				<div class="output01">
					<div class="nogo"></div>
				</div>
				<div class="oneline_plz">
					<button type="button" class="bt00 " id="NEXTSTEP1_1" >신규 회원가입</button>
					<input type="hidden" name="" id="NEXTSTEP1_2">
				</div>

			</div>
		</div>
		<div class="form-joiner_container joiner_container2">
			<div class="innerwrap">
				<h1>일반 사용자 </h1> <!-- 왼쪽  -->
				<span>헬스, 건강관리, 소모임... <br> 모든 기능을 자유롭게 이용하실 수 있습니다. </span>
				<h2 style="height: 46px;">주소를 입력해주세요. </h2>
				<div class="form_adress">
					<div class="oneline_plz">
						<input type="text" id="sample4_postcode" placeholder="우편번호" maxlength="6" class="input00" style="width: 50%; height: 40px; margin: 0; position: relative; top: -1px;" name="sample4_postcode">
						<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" class="input00" style="width: 48%; height: 40px; margin: 0; padding:5px;">
					</div>
					<input type="text" id="sample4_roadAddress" placeholder="도로명주소" readonly="true" class="sample4_roadAddress input00" name="adress">
					<input type="text" id="sample4_jibunAddress" placeholder="지번주소" readonly="true" class="sample4_jibunAddress input00" name="adress">
					<!-- <span id="guide" style="color:#999;display:none; "></span> -->
					<input type="text" id="sample4_detailAddress" placeholder="상세주소" class="input00" name="sample4_detailAddress">
					<input type="hidden" id="sample4_extraAddress" placeholder="참고항목" class="input00"  >
				</div>
				<button  type="button" class="bt00" id="NEXTSTEP2" style="margin-top: 40px;">다음 단계로</button>
			</div>
		</div>
		<div class="form-joiner_container joiner_container2_2">
			<div class="innerwrap">
				<h1>일반 사용자 </h1> <!-- 왼쪽  -->
				<span>마지막 페이지! <br>회원까지 한 걸음 남았어요...!</span>
				<h2 style="height:46px;"><Br>관심 분야를 선택해주세요.  </h2>
				<div class="oneline_plz" style="margin-top: 0;">
					<table class="mytable00">
						<tr>
							<td><input class="checkbox00" type="checkbox" name="interest" value="건강"> 건강 </td>
							<td><input class="checkbox00" type="checkbox" name="interest" value="몸매"> 몸매 </td>
							<td><input class="checkbox00" type="checkbox" name="interest" value="체중관리"> 체중관리</td>
						</tr>
						<tr>
							<td><input class="checkbox00" type="checkbox" name="interest" value="식단조절"> 식단조절  </td>
							<td><input class="checkbox00" type="checkbox" name="interest" value="다이어트"> 다이어트  </td>
							<td><input class="checkbox00" type="checkbox" name="interest" value="근육"> 근육 증가 </td>
						</tr>
					</table>

				</div>
				<div class="oneline_plz" id="form_check_ZZZ1_bo">
					사용자 정보 제공에 동의합니다. <input class="input00" type="checkbox" name="form_check_ZZZ1" id="form_check_ZZZ1">
				</div>
				<button  type="button" class="bt00" id="" onclick="cl1join()" style="position: absolute; bottom: 60px;">회원가입</button>
			</div>
		</div>
		<div class="form-joiner_container joiner_container3">
			<div class="innerwrap">
				<h1>전문가 </h1> 
				<span>헬스 트레이너, 건강 관리사, 의사, 한의사 등 전문가를 위한 기능을 사용할 수 있습니다. </span>
				<h2 style="height: 46px;">직장주소를 입력해주세요. </h2>
				<div class="form_adress">
					<div class="oneline_plz">
						<input type="text" id="sample4_postcode22" placeholder="우편번호" maxlength="6" class="input00" style="width: 50%; height: 40px; margin: 0; position: relative; top: -1px;" name="sample4_postcode22">
						<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" class="input00" style="width: 48%; height: 40px; margin: 0; padding:5px;">
					</div>
					<input type="text" id="sample4_roadAddress22" placeholder="도로명주소" readonly="true" class="input00" name="sample4_roadAddress22" >
					<input type="text" id="sample4_jibunAddress22" placeholder="지번주소" readonly="true" class="input00" name="sample4_jibunAddress22">
					<!-- <span id="guide22" style="color:#999;display:none;"></span> -->
					<input type="text" id="sample4_detailAddress22" placeholder="상세주소" class="input00" name="sample4_detailAddress22">
					<input type="hidden" id="sample4_extraAddress22" placeholder="참고항목" class="input00"  >
				</div>
				<button  type="button" class="bt00" id="NEXTSTEP3" style="margin-top: 40px;">다음 단계로</button>
			</div>
		</div>
		<div class="form-joiner_container joiner_container3_2">
			<div class="innerwrap">
				<h1>전문가 사용자</h1> <!-- 왼쪽  -->
				<span>헬스 트레이너, 건강 관리사, 의사, 한의사 등 전문가를 위한 기능을 사용할 수 있습니다.  </span>
				<select name="field" id="select_field">
					<option value="notthisone" style="color:red;">전문 분야</option>
					<option value="prof_trainer">헬스 트레이너</option>
					<option value="prof_health">헬스장 소유주</option>
					<option value="prof_doc">의사</option>
					<option value="prof_kdoc">한의사</option>
					<option value="prof_spec">건강관리사</option>
				</select>
				<input class="input00" type="text" placeholder="상호명" name="pname" />
				<!-- <input class="input00" type="text" placeholder="직장 주소" name="padress" /> -->
				<input class="input00" type="text" placeholder="직장 전화번호" name="pphone" />
				<!-- <textarea name="form_proProfile" placeholder="약력 / 소개"></textarea> -->
				<div class="oneline_plz" id="form_check_ZZZ2_bo">
					사용자 정보 제공에 동의합니다. <input class="input00" type="checkbox" name="form_check_ZZZ2" id="form_check_ZZZ2">
				</div>
				<button  type="button" class="bt00" onclick="cl2join()" style="position: absolute; bottom: 50px;">회원가입</button>
			</div>
		</div>
		<div class="form-joiner_container joiner_container00"> <!-- 로그인? -->
			<div class="innerwrap">
				<!-- <form  method="post" action="login_go.jsp" id="loginForm"> -->
					<h1>로그인</h1> <!-- 왼쪽  -->
					<span>아이디가 없으신가요? <span id="toJoin" class="clicker">회원가입 하기</span></span>
					<input class="input00" type="text" placeholder="아이디" name="log_id" id="log_id" />
					<div class="output01 output011">
						<div class="nogo"></div>
					</div>
					<input class="input00" type="password" placeholder="Password" name="log_pw" id="log_pw" />
					<div class="output01 output011">
						<div class="nogo"></div>
					</div>
					<a href="forgot.log">비밀번호를 잊으셨나요?</a><br>
					<input type="hidden" id="join_type" name="join_type">
					<button type="button" class="bt00" onclick="logingo()" style="position: absolute; bottom: 8px;">로그인</button>
				<!-- </form> -->
			</div>
		</div>
		</form>


<%
request.setCharacterEncoding("UTF-8");
    String fail2 =request.getParameter("fail");
    String log_id = (String) session.getAttribute("LOG_ID");
    String whatdo = request.getParameter("whatdo");
    // String fromwhere = request.getParameter("fromwhere");
    // response.setHeader("fromwhere", );
%>
		<form action="login.log" method="post" id="LOGINFormplz">
			<input type="hidden" name="log_id2" id="log_id2">
			<input type="hidden" name="log_pw2" id="log_pw2">
			<!--  fromwhere%>" -->
		</form>
		
		
	</div>

</div>

	<script type="text/javascript">
		var fail2 = "<%=fail2%>";
		var log_id = "<%=log_id%>";
		var whatdo = "<%=whatdo%>";
	</script>

<script type="text/javascript" src="js/joinjoin99.js?v=<%=System.currentTimeMillis()%>"></script>
</body>
</html>