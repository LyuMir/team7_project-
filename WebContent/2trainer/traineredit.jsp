<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
    <%@ page import="org.apache.ibatis.session.SqlSession" %>
    <%@ page import="com.team7.vo.PhotoBean" %>
    <%@ page import="com.team7.vo.Trainer_info" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>


<!DOCTYPE html>



<%
request.setCharacterEncoding("UTF-8");
List<Trainer_info> rlist  = (List<Trainer_info>) request.getAttribute("rlist");

%>


      <link rel="stylesheet" type="text/css" href="css/writing.css">

    <div class="ycontainer">
      <h2 class="hero__text ">코치 정보 수정 </h2>


    <div class="container1">
 * 정보 수정 후 '수정하기'를 꼭 눌러주세요.<br>
    </div>
<form action="id_traineredit.trainer" method="post" id="applyer">
  <br><br>
<span class="question">  등록후 최소 6개월간은 데일리 헬스에서 활동을 해주셔야합니다. 동의하십니까?</span><br>
<input type="radio" name="agree" checked disabled> 네, 동의합니다
	<div class="check_font" id="agreedcheck"></div>


<br><br>
<span class="question"> 이름<br></span>
*이름, 성별, 생년월일은 바꿀 수 없습니다. 수정이 필요할 시 관리자에게 문의주세요. <br>
    <%= rlist.get(0).getTname()%>
	<div class="check_font" id="namecheck"></div>


<span class="question"> <br>성별<br></span>
  <%
    String sex = rlist.get(0).getSex();
  if(sex.contains("fe")) sex = "여성";
  else sex="남성";
  %>
  <%=sex %>
	<div class="check_font" id="sexcheck"></div>


<br><br>
<span class="question"> 휴대폰 번호<br></span>
*해당번호로 연락을 드릴 예정이니 정확한 번호를 입력해주세요.<br>
<input type="text" name="coachphone" value="<%=rlist.get(0).getTphone() %>"> <br><br>
	<div class="check_font" id="phonecheck"></div>


<span class="question"> 생년월일<br></span>
<input type="text" name="coachbirth" placeholder="ex)1993-03-20" value="<%=rlist.get(0).getTbirth() %>" readonly>
	<div class="check_font" id="birthcheck"></div>
 <br><br>



<span class="question"> 이메일 주소<br></span>
<input type="text" name="coachemail"  placeholder="aaaa@aaa.com" value="<%=rlist.get(0).getTemail() %>"> <br><br>
	<div class="check_font" id="emailcheck"></div>


<span class="question"> 상담 가능 일시<br></span>
* 홈핏팀과의 1회 대면 미팅 후에 정식으로 활동이 가능합니다. 미팅 가능한 요일 및 시간을 말씀해주세요.<br>
* 미팅은 홈핏 운영 시간 내에 진행됩니다. (운영시간: 평일 9:30~18:30)<br><br>

<%
	List<String> qqq1 = new ArrayList<String>(18);
	for(int i = 0 ; i < 19 ; i++) qqq1.add("");
	String qqq11 = rlist.get(0).getTtime();
	if(qqq1.contains("월요일 오전")) qqq1.add(1, "checked");
	if(qqq1.contains("화요일 오전")) qqq1.add(2, "checked");
	if(qqq1.contains("수요일 오전")) qqq1.add(3, "checked");
	if(qqq1.contains("목요일 오전")) qqq1.add(4, "checked");
	if(qqq1.contains("금요일 오전")) qqq1.add(5, "checked");
	if(qqq1.contains("토요일 오전")) qqq1.add(6, "checked");
	if(qqq1.contains("일요일 오전")) qqq1.add(7, "checked");


	if(qqq1.contains("월요일 오후")) qqq1.add(11, "checked");
	if(qqq1.contains("화요일 오후")) qqq1.add(12, "checked");
	if(qqq1.contains("수요일 오후")) qqq1.add(13, "checked");
	if(qqq1.contains("목요일 오후")) qqq1.add(14, "checked");
	if(qqq1.contains("금요일 오후")) qqq1.add(15, "checked");
	if(qqq1.contains("토요일 오후")) qqq1.add(16, "checked");
	if(qqq1.contains("일요일 오후")) qqq1.add(17, "checked");

%>

<input type="checkbox" name="availabeltime" value="월요일 오전" <%=qqq1.get(1) %>> 월요일 오전
<input type="checkbox" name="availabeltime" value="화요일 오전" <%=qqq1.get(2) %>> 화요일 오전
<input type="checkbox" name="availabeltime" value="수요일 오전" <%=qqq1.get(3) %>> 수요일 오전
<input type="checkbox" name="availabeltime" value="목요일 오전" <%=qqq1.get(4) %>> 목요일 오전
<input type="checkbox" name="availabeltime" value="금요일 오전" <%=qqq1.get(5) %>> 금요일 오전
<input type="checkbox" name="availabeltime" value="토요일 오전" <%=qqq1.get(6) %>> 토요일 오전
<input type="checkbox" name="availabeltime" value="일요일 오전" <%=qqq1.get(7) %>> 일요일 오전 <br>
<input type="checkbox" name="availabeltime" value="월요일 오후" <%=qqq1.get(11) %>> 월요일 오후
<input type="checkbox" name="availabeltime" value="화요일 오후" <%=qqq1.get(12) %>> 화요일 오후
<input type="checkbox" name="availabeltime" value="수요일 오후" <%=qqq1.get(13) %>> 수요일 오후
<input type="checkbox" name="availabeltime" value="목요일 오후" <%=qqq1.get(14) %>> 목요일 오후
<input type="checkbox" name="availabeltime" value="금요일 오후" <%=qqq1.get(15) %>> 금요일 오후
<input type="checkbox" name="availabeltime" value="토요일 오후" <%=qqq1.get(16) %>> 토요일 오후
<input type="checkbox" name="availabeltime" value="일요일 오후" <%=qqq1.get(17) %>> 일요일 오후

	<div class="check_font" id="timecheck"></div>

<br><br>

<span class="question"> 전문 분야 (복수 선택 가능)<br></span>
* 심사 이후 개설 가능 종목이 변경될 수 있습니다.<br>
* 통증케어/기능회복의 경우 보편적인 체형 불균형과 경미한 통증이 아닌 중증의 통증 관리를 말하며, 물리치료사/작업치료사 또는 재활 자격증/수료증 3개 이상 있으셔야 합니다. 개선 사례 필수입니다. (이후 추가 심사 필요)<br>
<%
	List<String> qqq2 = new ArrayList<String>(5);
	for(int i = 0 ; i < 6 ; i++) qqq2.add("");
	String qqq12 = rlist.get(0).getTmajor();
	if(qqq12.contains("weight")) qqq2.set(1, "checked");
	if(qqq12.contains("filates")) qqq2.set(2, "checked");
	if(qqq12.contains("yoga")) qqq2.set(3, "checked");
	if(qqq12.contains("rehab")) qqq2.set(4, "checked");
%>

<input type="checkbox" name="major" value="weight" <%=qqq2.get(1) %>>웨이트트레이닝
<input type="checkbox" name="major" value="filates" <%=qqq2.get(2) %>>필라테스
<input type="checkbox" name="major" value="yoga" <%=qqq2.get(3) %>>요가
<input type="checkbox" name="major" value="rehab" <%=qqq2.get(4) %>>통증&케어

	<div class="check_font" id="majorcheck"></div>


<br><br>

<span class="question"> 활동 지역<br></span>
* 강사, 트레이너로써 활동 지역을 입력해주세요.<br>
<select name="trainerarea" >
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
						</select>

	<div class="check_font" id="areacheck"></div>

<br><br>


<span class="question"> 코치님 프로필의 제목을 적어주세요!<br></span>
* 예시) 마음과 몸의 조화를통한 요가  <br>
<input type="text" name="bigtext" placeholder="20자 내외로적어주세요" size="30" value="<%=rlist.get(0).getTbigtext() %>">
	<div class="check_font" id="bigtextcheck"></div>

<br><br>

<span class="question"> 코치님 프로필의 소글귀를 적어주세요!<br></span>
* 예시) 흐트러진 몸과 마음을 하나의 차크라로 모아보는 연습을 통해 우리는 좀더 우리몸에 더욱더 가까워질수있습니다.  <br>
<input type="text" name="smalltext" placeholder="50자 내외로적어주세요" size="60" value="<%=rlist.get(0).getTsmalltext() %>">
	<div class="check_font" id="smalltextcheck"></div>

<br><br>





<span class="question"> 경력사항 / 활동내용 (기간)<br></span>
<textarea name="coachcareer" cols="50" rows="5" > <%=rlist.get(0).getTcareer() %> </textarea>
	<div class="check_font" id="profilecheck"></div>

<br><br>




<span class="question"> 자격증 및 수료증 (발급 기관)<br></span>
* 요가, 필라테스, 웨이트, 통증케어/기능회복 중 특정 분야에서 3개 이상의 자격증 및 수료증을 보유하고 계셔야 지원이 가능합니다.<br>
* 보유하고 계신 자격증 및 수료증을 모두 기재해주세요. 미팅 후에 최종 선발된 코치님에게는 해당 자격 내용에 대해 증빙이 필요하니, 증명이 가능한 자격 사항만 기재해주세요.<br>
<textarea name="coachcerti" cols="50" rows="5" > <%=rlist.get(0).getTcerti() %> </textarea>
	<div class="check_font" id="certicheck"></div>

<br><br>

<span class="question"> 프로그램을 소개해주세요 !<br></span>
* 코칭하셨던 회원 중 가장 기억에 남는 회원님의 케이스를 함께 기재해주세요.<br>
<textarea name="coachprofile" cols="50" rows="5" > <%=rlist.get(0).getTprofile() %> </textarea>
	<div class="check_font" id="profilecheck"></div>

<br><br>

<span class="question"> 코치님의 프로필 소개를 해주세요!<br></span>
* 홈핏 코치는 전문성을 바탕으로 체계적으로 회원님의 건강을 케어하는 일이기 때문에 열정과 책임감을 가지셔야 합니다.<br>
* 왜 데일리헬스 코치가 되고 싶은지 적어주세요.<br>
<textarea name="coachstroy" cols="50" rows="5" > <%=rlist.get(0).getTstory() %> </textarea>
	<div class="check_font" id="storycheck"></div>

 <br><br>
<span class="question">코치님을 더 잘 알 수 있도록 인스타그램 등의 SNS 계정이 있다면 소개해주세요.</span><br><br>
<input type="text" name="coachsns"size="50px" placeholder="없다면 공란으로 두셔도됩니다" value="<%=rlist.get(0).getTsns() %>">

<br><br>


<span class="question"> 데일리헬스를 어떻게 알게 되셨어요?<br></span>
<textarea name="coachhowjoin" cols="50" rows="5" > <%=rlist.get(0).getThowjoin() %> </textarea> <br>
	<div class="check_font" id="howjoincheck"></div>


<br><br>

</form>
<form id="photogo" formenctype="multipart/form-data" accept-charset="UTF-8" method="post">
	<input type="file" id="photo1" name="photo1" accept=".jpg,.jpeg,.png,.gif,.bmp,.webm">
	<!-- <input type="hidden" name="num" value="1">-->
</form> <button onclick="photo_upload()">사진 업로드</button>

<br><br>

아래 보내기 버튼 클릭 시  <a href="" class="href">이용약관</a> 및  <a href="" class="href">취급방침</a>에 동의한 것으로 간주합니다.
<br><br><br>


<button class="btn" type="" name="button" id="button11">수정하기</button>



    </div>

<script type="text/javascript">


	var button = $('button#button11');


	var aform = $('#applyer');

	var photogo = $('#photogo');
	var photo1 = $('#photo1');
	// var data = new FormData();

	button.click(function(){
		if(true){
			aform.submit();
		}
	});

	function photo_upload(){
	var pform = $('#photogo')[0];
	var pdata = new FormData(pform);
		$.ajax({
				url : 'trainerUpload.photo', //문서 위치.

				data : pdata,

				type : 'post',

				method : 'post',

				enctype:'multipart/form-data',

				processData:false,
				contentType:false,
				cache:false,
				timeout:600000,


				success : function(data){
					alert('사진 올리기 완료 :'+pform.val());
				}

			});

	}


</script>
<!-- <script type="text/javascript" src="js/trainerapply.js"></script> -->
