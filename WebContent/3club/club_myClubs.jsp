<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="daos.Class_DAO" %>
<%@ page import="dtos.Class_DTO_ClubProperties" %>
<%@ page import="java.util.List" %>
<html>
<head>
	<title>소모임 전체보기...</title>
	<link rel="stylesheet" type="text/css" href="css/gridgrid_new.css">
</head>
<body>
	<!-- 바디... main만 있어도 됨.  -->
<%
request.setCharacterEncoding("UTF-8");

//String whichNum = request.getParameter("whichNum"); 
// 아직 12345 목록 크기 정하지 않았습니다. 
dtos.Class_DTO_String id00 = new dtos.Class_DTO_String();
		//String id = (String) session.getAttribute("id");
//현재 아이디 대신 아무 아이디로 하고 있습니다. ffefsfev
String id = (String) session.getAttribute("LOG_ID");

id00.setS1(id);	// req로 받아서 넣어 사용하면 되겠네요 
List<dtos.Class_DTO_ClubProperties2> rlist  = new Class_DAO().club_selector_id(id00);
//List<dtos.Class_DTO_ClubProperties2> rlist  = new Class_DAO().club_selectorAll();

%>

<main id="main000" class="mainwrap">

  <section>
	  <div class="sticky_side_bar fright">
	  	ꓥ  &nbsp; &nbsp; 1 2 3 4 5  … 12 &nbsp; &nbsp;  ꓦ
	  </div>
내가 속한 소모임 . 
    <div class="grid">
		<!-- <article class="grid__item " onclick="createClub()">
			<div class="wrapEn0">
				<div class="makeit"><span> 새 소모임<br> 생성하기 </span></div>
				<div class="wrapEntire">
					<div class="card">
						<div class="card__img00 fright">
							<img class="" src="img/이쁜이미지1.jpg" alt="Snowy Mountains">
						</div>
						<div class="card__content fleft">
							<div class="card__header">내 멋진 소모임!</div>
							<div class="card__tag00 content_now">모집중 ! hot!</div>
							<div class="card__tag00 content_what"> 운동 : <span>...</span></div>
							<div class="card__tag00 content_where"> 장소 : <span>...</span></div>
							<div class="card__tag00 content_when"> 시간 : <span>...</span></div>
							<div class="card__heart"> 
								<img src="img/heart35.png"> <span>5000  </span>  &nbsp;<img src="img/star22.png">  <span>7000</span>
							</div>
						</div>
						<div class="card__bottomContent">
							<div class="card__text">나만의 소모임을 만들어 나와 잘 맞는 운동메이트를 찾아보세요!  </div>
						</div>
					</div>
				</div>
			</div>
		</article> -->
		
		   
     <% for(int i = 0; i < rlist.size(); i++){ %>
		<article class="grid__item" onclick="gotoClub2(this)">
			<div class="card">
				<div class="card__img00 fright">
					<img class="card__img01" src="img/이쁜이미지1.jpg" alt="Snowy Mountains">
				</div>
				<div class="card__content fleft">
					<div class="card__idhere" id="<%=rlist.get(i).getNo()%>"></div>
					<div class="card__header"><%=rlist.get(i).getName() %></div>
					<div class="card__tag00 content_now"><%=rlist.get(i).getMemberJoin() %></div>
					<div class="card__tag00 content_what"> 운동 : <span><%=rlist.get(i).getE_type() %></span></div>
					<div class="card__tag00 content_where"> 장소 : <span><%=rlist.get(i).getArea() %></span></div>
					<div class="card__tag00 content_when"> 시간 : <span><%=rlist.get(i).getMeetingDate() %></span></div>
					<div class="card__heart"> 
						<img src="img/heart35.png"> <span>000  </span>  &nbsp;<img src="img/star22.png">  <span>00</span>
					</div>
				</div>
				<div class="card__bottomContent">
					<div class="card__text"><%=rlist.get(i).getProfile() %></div>
				</div>
			</div>
		</article>
		<%} %>

<!-- 
<form id="gotoClub" action="team_FORWHERE.jsp" method="post" style="display:none;">
	<input type="hidden" name="forwhere" value="club_main.jsp">
	<input type="hidden" name="clubid" id="clubid3">
</form> -->
<form id="gotoClub" action="toMain.club" method="post" style="display:none;">
	<!-- <input type="hidden" name="forwhere" value="club_main.jsp"> -->
	<input type="hidden" name="clubid" id="clubid3">
</form>


    "Icon made by Freepik from www.flaticon.com"<br> <br>
    Icons made by Pixel perfect from  www.flaticon.com0
    </div><!-- 그리그 끝! -->
  </section>
</main>

<script type="text/javascript" src="js/club_whereto.js"></script>
<script type="text/javascript">
	function gotoClub2(req){
	var id =$(req).find('.card__idhere').attr('id');
	$('#gotoClub').find('#clubid3').val(id);
	$('#gotoClub').submit();
	
}
</script>


</body>
</html>