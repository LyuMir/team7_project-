<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ page import="com.team7.vo.MemberLogInfo" %>

<!DOCTYPE html>

<%
request.setCharacterEncoding("UTF-8");
 MemberLogInfo info = (MemberLogInfo) session.getAttribute("logid");	//오로지 얘를 위해!!
%>


<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">

      <link rel="stylesheet" type="text/css" href="css/writing.css">
    <title></title>
  </head>
  <body>

    <div class="ycontainer">
      <h2 class="hero__text ">코치지원서 </h2>


    <div class="container1">
 * 아래에 기재해 주신 사항들은 모두 고객들에게 노출되는정보입니다.<br>
 * 한번 글을 작성한 뒤에는 수정이 번거롭습니다. <br>
 * 작성하실때 주의를 기울여서 작성해주시길 바랍니다. <br>
    </div>
<form action="trainerapply.trainer" method="post">
  <br><br>
<span class="question">  등록후 최소 6개월간은 데일리 헬스에서 활동을 해주셔야합니다. 동의하십니까?</span><br>
<input type="radio" name="agree"> 네, 동의합니다
	<div class="check_font" id="agreedcheck"></div>


<br><br>
<span class="question"> 이름을 입력해주세요<br></span>
*본명을 입력해주세요<br>
<input type="text" name="coachname" ><br>
	<div class="check_font" id="namecheck"></div>


<span class="question"> <br>성별<br></span>
<input type="radio" name="sex" value="female">여성
<input type="radio" name="sex" value="male">남성
	<div class="check_font" id="sexcheck"></div>


<br><br>
<span class="question"> 휴대폰 번호<br></span>
*해당번호로 연락을 드릴 예정이니 정확한 번호를 입력해주세요.<br>
<input type="text" name="coachphone" > <br><br>
	<div class="check_font" id="phonecheck"></div>


<span class="question"> 생년월일<br></span>
<input type="text" name="coachbirth" placeholder="ex)1993-03-20">
	<div class="check_font" id="birthcheck"></div>
 <br><br>



<span class="question"> 이메일 주소<br></span>
<input type="text" name="coachemail"  placeholder="aaaa@aaa.com"> <br><br>
	<div class="check_font" id="emailcheck"></div>


<span class="question"> 상담 가능 일시<br></span>
* 홈핏팀과의 1회 대면 미팅 후에 정식으로 활동이 가능합니다. 미팅 가능한 요일 및 시간을 말씀해주세요.<br>
* 미팅은 홈핏 운영 시간 내에 진행됩니다. (운영시간: 평일 9:30~18:30)<br><br>
<input type="checkbox" name="availabeltime" value="월요일 오전"> 월요일 오전
<input type="checkbox" name="availabeltime" value="화요일 오전"> 화요일 오전
<input type="checkbox" name="availabeltime" value="수요일 오전"> 수요일 오전 
<input type="checkbox" name="availabeltime" value="목요일 오전"> 목요일 오전
<input type="checkbox" name="availabeltime" value="금요일 오전"> 금요일 오전
<input type="checkbox" name="availabeltime" value="토요일 오전"> 토요일 오전
<input type="checkbox" name="availabeltime" value="일요일 오전"> 일요일 오전 <br>
<input type="checkbox" name="availabeltime" value="월요일 오후"> 월요일 오후 
<input type="checkbox" name="availabeltime" value="화요일 오후"> 화요일 오후 
<input type="checkbox" name="availabeltime" value="수요일 오후"> 수요일 오후 
<input type="checkbox" name="availabeltime" value="목요일 오후"> 목요일 오후 
<input type="checkbox" name="availabeltime" value="금요일 오후"> 금요일 오후 
<input type="checkbox" name="availabeltime" value="토요일 오후"> 토요일 오후 
<input type="checkbox" name="availabeltime" value="일요일 오후"> 일요일 오후

	<div class="check_font" id="timecheck"></div>

<br><br>

<span class="question"> 전문 분야 (복수 선택 가능)<br></span>
* 심사 이후 개설 가능 종목이 변경될 수 있습니다.<br>
* 통증케어/기능회복의 경우 보편적인 체형 불균형과 경미한 통증이 아닌 중증의 통증 관리를 말하며, 물리치료사/작업치료사 또는 재활 자격증/수료증 3개 이상 있으셔야 합니다. 개선 사례 필수입니다. (이후 추가 심사 필요)<br>
<input type="checkbox" name="major" value="weight">웨이트트레이닝
<input type="checkbox" name="major" value="filates">필라테스
<input type="checkbox" name="major" value="yoga">요가
<input type="checkbox" name="major" value="rehab">통증&케어

	<div class="check_font" id="majorcheck"></div>


<br><br>

<span class="question"> 활동 지역<br></span>
* 강사, 트레이너로써 활동 지역을 입력해주세요.<br>
<select name='trainerarea' onchange="areaSelector(this)" >
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

						<select name='county'  class=select>
							<option value='전지역'>전지역</option>
						</select>
	<div class="check_font" id="areacheck"></div>

<br><br>




<span class="question"> 경력사항 / 활동내용 (기간)<br></span>
<textarea name="coachcareer" cols="50" rows="5" > </textarea>
	<div class="check_font" id="profilecheck"></div>

<br><br>




<span class="question"> 자격증 및 수료증 (발급 기관)<br></span>
* 요가, 필라테스, 웨이트, 통증케어/기능회복 중 특정 분야에서 3개 이상의 자격증 및 수료증을 보유하고 계셔야 지원이 가능합니다.<br>
* 보유하고 계신 자격증 및 수료증을 모두 기재해주세요. 미팅 후에 최종 선발된 코치님에게는 해당 자격 내용에 대해 증빙이 필요하니, 증명이 가능한 자격 사항만 기재해주세요.<br>
<textarea name="coachcerti" cols="50" rows="5" > </textarea>
	<div class="check_font" id="certicheck"></div>

<br><br>

<span class="question"> 프로그램을 소개해주세요 !<br></span>
* 코칭하셨던 회원 중 가장 기억에 남는 회원님의 케이스를 함께 기재해주세요.<br>
<textarea name="coachprofile" cols="50" rows="5" > </textarea>
	<div class="check_font" id="profilecheck"></div>

<br><br>

<span class="question"> 코치님의 프로필 소개를 해주세요!<br></span>
* 홈핏 코치는 전문성을 바탕으로 체계적으로 회원님의 건강을 케어하는 일이기 때문에 열정과 책임감을 가지셔야 합니다.<br>
* 왜 데일리헬스 코치가 되고 싶은지 적어주세요.<br>
<textarea name="coachstroy" cols="50" rows="5" > </textarea>
	<div class="check_font" id="storycheck"></div>

 <br><br>
<span class="question">코치님을 더 잘 알 수 있도록 인스타그램 등의 SNS 계정이 있다면 소개해주세요.</span><br><br>
<input type="text" name="coachsns"size="50px" placeholder="없다면 공란으로 두셔도됩니다">

<br><br>


<span class="question"> 데일리헬스를 어떻게 알게 되셨어요?<br></span>
<textarea name="coachhowjoin" cols="50" rows="5" > </textarea> <br>
	<div class="check_font" id="howjoincheck"></div>


<br><br>

<input type="file" name="photos" >


<br><br>

아래 보내기 버튼 클릭 시  <a href="ddd" class="href">이용약관</a> 및  <a href="ddd" class="href">취급방침</a>에 동의한 것으로 간주합니다.
<br><br><br>

<button class="btn" type="submit" name="button">보내기</button>

</form>



    </div>

  </body>
</html>
