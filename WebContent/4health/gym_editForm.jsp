<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
    <%@ page import="org.apache.ibatis.session.SqlSession" %>
    <%@ page import="com.team7.vo.PhotoBean" %>
    <%@ page import="com.team7.vo.Gym_info" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>


<!DOCTYPE html>
    <meta charset="utf-8">

      <%
      request.setCharacterEncoding("UTF-8");
      List<Gym_info> gym  = (List<Gym_info>) request.getAttribute("gym");

      %>



    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

      <link rel="stylesheet" type="text/css" href="css/gymform.css">


    <div class="ycontainer">
      <h2 class="hero__text ">나의 헬스장 수정하기 </h2>


    <div class="container1">
 * 수정 작업 후 꼭 수정하기를 눌러주세요. <br>
 *수정 불가한 항목 수정 혹은 정보 삭제를 원하시는 경우 데일리 헬스 팀에 문의해주세요 . <br> <a href="qna.notice">문의하러가기 </a>  <br>
    </div>
<form action="id_gymcreate.health" method="post" id="form00">
  <br><br>
<span class="question">  등록후 최소 6개월간은 데일리 헬스에서 활동을 해주셔야합니다. 동의하십니까?</span><br>
<input type="radio" name="agree"checked disabled> 네, 동의합니다
	<div class="check_font" id="agreedcheck"></div>


<br><br>
<span class="question"> 헬스장 이름은 수정할 수 없습니다. <br></span>
<br>
<input type="textfield" name="gname" value="<%=gym.get(0).getGname()%>" disabled><br>
	<div class="check_font" id="namecheck"></div>

  <br><br>
  <span class="question"> 헬스장 간단 소개문을 작성해주세요<br></span>
  *헬스장 이름 아래에 표기됩니다.<br>
  <textarea name="gsmalltext" cols="50" rows="5" > <%=gym.get(0).getGsmalltext() %> </textarea>
  	<div class="check_font" id="namecheck"></div>


<br><br>
<span class="question"> 헬스장 전화번호<br></span>
*고객님들께 노출되어지는 번호이니 직장번호로 입력해주세요.<br>
<input type="text" name="gphone"  value="<%=gym.get(0).getGphone()%>" > <br><br>
	<div class="check_font" id="phonecheck"></div>



<span class="question"> 헬스장 홈페이지 & SNS 주소 <br></span>
<input type="text" name="gpage"  placeholder="aaaa@aaa.com"  value="<%=gym.get(0).getGpage()%>" > <br><br>
	<div class="check_font" id="emailcheck"></div>


<span class="question"> 헬스장 운영시간<br></span>
* 고객님에게 노출되어지는 시간입니다.<br>
* 실제 운영시간을 표기해주세요 24시의 경우는 00시로 표기해주세요<br><br>



<div class="container-fluid px-1 px-sm-4 py-5 mx-auto">
    <div class="row d-flex justify-content-center">
        <div class="col-md-10 col-lg-9 col-xl-8">
           <div class="card border-0 ">
                <div class="row px-3 ">
                    <div class="col-sm-10 list">

<%
	
%>
<%=gym.get(0).getOpentime() %>

                       <div class="mb-2 row justify-content-between px-3">
                            <select name="opentime" class="mb-2 mob">
                                <option value="월요일-금요일">월요일-금요일</option>
                                <option value="주말">주말</option>
                                <option value="토요일">토요일</option>
                                <option value="일요일">일요일</option>
                            </select>
                            <div class="mob"> <label class="text-grey mr-1">From</label> <input class="ml-1" type="time" name="fromthistime"> </div>
                            <div class="mob mb-2"> <label class="text-grey mr-4">To</label> <input class="ml-1" type="time" name="tothistime"> </div>


                            <div class="mt-1 cancel fa fa-times text-danger">삭제하기</div>
                        </div>
                    </div>
                </div>
                <div class="row px-3 mt-3">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10">
                        <div class="row px-3">
                            <div class="fa fa-plus-circle text-success add">추가하기</div>
                        </div>
                    </div>
                </div>
             </div>
        </div>
    </div>
</div>




	<div class="check_font" id="timecheck"></div>

<br><br>

<span class="question"> 헬스장 시설체크 (복수 선택 가능)<br></span>
* 심사 이후 개설 가능 종목이 변경될 수 있습니다.<br>
* 통증케어/기능회복의 경우 보편적인 체형 불균형과 경미한 통증이 아닌 중증의 통증 관리를 말하며, 물리치료사/작업치료사 또는 재활 자격증/수료증 3개 이상 있으셔야 합니다. 개선 사례 필수입니다. (이후 추가 심사 필요)<br>

<%
	List<String> qq11 = new ArrayList<String>(15);
	for(int i = 0 ; i < 16;i++) qq11.add("");
	if(gym.get(0).getGtype().contains("24")) qq11.set(1, "checked");
	if(gym.get(0).getGtype().contains("샤워")) qq11.set(2, "checked");
	if(gym.get(0).getGtype().contains("운동복")) qq11.set(3, "checked");
	if(gym.get(0).getGtype().contains("G.X")) qq11.set(4, "checked");
	if(gym.get(0).getGtype().contains("웨이트")) qq11.set(5, "checked");
	if(gym.get(0).getGtype().contains("필라테스")) qq11.set(6, "checked");
	if(gym.get(0).getGtype().contains("스피닝")) qq11.set(7, "checked");
	if(gym.get(0).getGtype().contains("복싱")) qq11.set(8, "checked");
	if(gym.get(0).getGtype().contains("줌바")) qq11.set(9, "checked");
	if(gym.get(0).getGtype().contains("폴댄스")) qq11.set(10, "checked");
%>


<input type="checkbox" name="gtype" value="24시" <%=qq11.get(1) %>>24시
<input type="checkbox" name="gtype" value="샤워" <%=qq11.get(2) %>>샤워
<input type="checkbox" name="gtype" value="운동복" <%=qq11.get(3) %>>운동복
<input type="checkbox" name="gtype" value="G.X" <%=qq11.get(4) %>>G.X
<input type="checkbox" name="gtype" value="웨이트" <%=qq11.get(5) %>>웨이트
<input type="checkbox" name="gtype" value="필라테스" <%=qq11.get(6) %>>필라테스
<input type="checkbox" name="gtype" value="스피닝" <%=qq11.get(7) %>>스피닝
<input type="checkbox" name="gtype" value="복싱" <%=qq11.get(8) %>>복싱
<input type="checkbox" name="gtype" value="줌바" <%=qq11.get(9) %>>줌바
<input type="checkbox" name="gtype" value="폴댄스" <%=qq11.get(10) %>>폴댄스
	<div class="check_font" id="majorcheck"></div>


<br><br>

<span class="question"> 헬스장 주소 <br></span>
* 헬스장의 정확한 주소지를 입력해주세요.<br>
<div class="form_adress">
  <div class="oneline_plz">
    <input type="text" id="postcode" placeholder="우편번호" maxlength="6" class="input00"  name="sample4_postcode">
    <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" class="btn">
  </div>
  <input type="text" id="sample4_roadAddress" placeholder="도로명주소" readonly="true" class="address" name="adress1">
  <input type="text" id="sample4_jibunAddress" placeholder="지번주소" readonly="true" class="address" name="adress2"><br>
  <!-- <span id="guide" style="color:#999;display:none; "></span> -->
  <input type="text" id="sample4_detailAddress" placeholder="상세주소" class="address" name="address3">
  <input type="hidden" id="sample4_extraAddress" placeholder="참고항목" class="input00"  >
</div>

</script>

<br><br>




<span class="question"> 헬스장 소개문<br></span>
<textarea name="gcontents" cols="50" rows="5" > <%=gym.get(0).getContents() %> </textarea>
	<div class="check_font" id="profilecheck"></div>

<br><br>




<span class="question"> 자격증 및 수료증 (발급 기관)<br></span>
* 보유하고 계신 자격증 및 수료증을 모두 기재해주세요, 차후 증명단계가 있습니다. 증명이 가능한 자격 사항만 기재해주세요.<br>
<textarea name="gcerti" cols="50" rows="5" > <%=gym.get(0).getGcerti() %> </textarea>
	<div class="check_font" id="certicheck"></div>


<br><br>

<span class="question"> 프로그램을 소개해주세요 !<br></span>
* 각종프로그램에 대해 적어주세요.<br>
<textarea name="gprogram" cols="50" rows="5" > <%=gym.get(0).getGprogram() %> </textarea>
	<div class="check_font" id="storycheck"></div>

<br><br>

<span class="question"> 헬스장 월단위 가격을 적어주세요!<br></span>
* 기재한 가격과 다를경우 강제삭제조치 됩니다.<br><br>
● 1개월권 　 <input type="text" name="oneprice"size="10px" placeholder="1만원"  value="<%=gym.get(0).getGprice().split(",")[0] %>"> W<br>
● 3개월권  　<input type="text" name="threeprice"size="10px" placeholder="3만원"  value="<%=gym.get(0).getGprice().split(",")[1] %>"> W<br>
● 6개월권 　 <input type="text" name="sixprice"size="10px" placeholder="6만원"  value="<%=gym.get(0).getGprice().split(",")[2] %>"> W<br>
●12개월권　<input type="text" name="yearprice"size="10px" placeholder="12만원"  value="<%=gym.get(0).getGprice().split(",")[3] %>"> W<br>
	<div class="check_font" id="whycheck"></div>

 <br><br>




<br><br>


</form>


<form id="photogo" formenctype="multipart/form-data" accept-charset="UTF-8" method="post">
  <input type="file" id="photo1" name="photo1" accept=".jpg,.jpeg,.png,.gif,.bmp,.webm">
  <input type="hidden" name="num" value="11">
  <input type="hidden" name="photonum" value="1">
</form> <button onclick="photo_upload(1)">사진 업로드</button>

<form id="photogo2" formenctype="multipart/form-data" accept-charset="UTF-8" method="post">
  <input type="file" id="photo1" name="photo1" accept=".jpg,.jpeg,.png,.gif,.bmp,.webm">
  <input type="hidden" name="num" value="11">
  <input type="hidden" name="photonum" value="2">
</form> <button onclick="photo_upload(2)">사진 업로드</button>
<form id="photogo3" formenctype="multipart/form-data" accept-charset="UTF-8" method="post">
  <input type="file" id="photo1" name="photo1" accept=".jpg,.jpeg,.png,.gif,.bmp,.webm">
  <input type="hidden" name="num" value="11">
  <input type="hidden" name="photonum" value="3">
</form> <button onclick="photo_upload(3)">사진 업로드</button>

<br><br>

아래 보내기 버튼 클릭 시  <a href="ddd" class="href">이용약관</a> 및  <a href="ddd" class="href">취급방침</a>에 동의한 것으로 간주합니다.
<br><br><br>

<button class="btn" type="" name="button" id="button11">보내기</button>




    </div>


<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="js/DAUM_adress.js"></script>
  <script>

    var button11 = $('#button11');

  var photogo = $('#photogo');
  var photo1 = $('#photo1');
  // var data = new FormData();

  button11.click(function(){
    if(true){ // 무엇을 쓰고, 저것을 하고, 이걸 채워야지 서밋 가능함. < 으로 해주세요.

      form00.submit();
    }
  });
    // button11.click(function(){

    //   if(true){ //조건을 달성해야만 다음으로 넘어갈 수 있게 해주세요. <
    //     form00.submit();
    //   }
    // });

  function photo_upload(pp){
  var pform;
  var pdata;
    if(pp == 1){
      pform = $('#photogo')[0];
      pdata = new FormData(pform);
    }
    else if(pp == 2){
      pform = $('#photogo2')[0];
      pdata = new FormData(pform);
    }
    else if(pp == 3){
      pform = $('#photogo3')[0];
      pdata = new FormData(pform);
    }
    $.ajax({
        url : 'gymUpload.photo', //문서 위치.

        data : pdata,

        type : 'post',

        method : 'post',

        enctype:'multipart/form-data',

        processData:false,
        contentType:false,
        cache:false,
        timeout:600000,


        success : function(data){
          // alert(data);
        },
        error:function(data){
          alert('지정하지 않은 형식이거나 파일 크기가 5mb를 넘었습니다. ');
        }

      });
  }

    var button11 = $('button#button11');
    var form00 = $('#form00');



  $(document).ready(function(){

  $('.add').click(function(){
  $(".list").append(
  '<div class="mb-2 row justify-content-between px-3">' +
      '<select class="mob mb-2">' +
          '<option value="opt1">월요일-금요일</option>' +
          '<option value="opt2">주말</option>' +
             '<option value="opt1">토요일</option>' +
             '<option value="opt2">일요일</option>' +
          '</select>' +
      '<div class="mob">' +
          '<label class="text-grey mr-1">From</label>' +
          '<input class="ml-1" type="time" name="from">' +
          '</div>' +
      '<div class="mob mb-2">' +
          '<label class="text-grey mr-4">To</label>' +
          '<input class="ml-1" type="time" name="to">' +
          '</div>' +
      '<div class=" mt-1 cancel fa fa-times text-danger"">'+'삭제하기' +
          '</div>' +
      '</div>');
  });

  $(".list").on('click', '.cancel', function(){
  $(this).parent().remove();
  });

  });



  </script>
