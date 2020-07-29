<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.team7.dao.Class_DAO" %>
<%@ page import="com.team7.vo.DTO_ClubProperties" %>
<%@ page import="com.team7.vo.ClubBean" %>
<%@ page import="com.team7.club.service.*" %>
<%@ page import="java.util.List" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/gridgrid_new.css">

<body>
	<!-- 바디... main만 있어도 됨.  -->
<%
	request.setCharacterEncoding("UTF-8");

String id = (String) session.getAttribute("LOG_ID");


//String whichNum = request.getParameter("whichNum"); 
// 아직 12345 목록 크기 정하지 않았습니다. 
// dtos.Class_DTO_i iii = new dtos.Class_DTO_i();
// iii.setI(0);	// req로 받아서 넣어 사용하면 되겠네요 

ClubBean dto = new ClubBean();
dto.setAdmin(id);
List<ClubBean> rlist  = new ClubService().club_selector_id(dto);
//List<dtos.Class_DTO_ClubProperties2> rlist  = new Class_DAO().club_selectorAll();
%> 

<main id="main000" class="mainwrap">
	<div class="addSec">
		<div class="transp_back">
			
		</div>
		<div class="transp_front">
			내 소모임 관리 : <%=id %> <br>
			내가 개설한 소모임 : <%=rlist.size() %>개 <br>
			내가 속한 소모임 수 : (##개) , (나열)<br>
		</div>
		<div class="turnitoffPlz">
			<img src="img/star.png" style="width: 50px;">
		</div>
		
	</div>

  <section>
	  <div class="sticky_side_bar fright">
	  	ꓥ  &nbsp; &nbsp; 1 2 3 4 5  … 12 &nbsp; &nbsp;  ꓦ
	  </div>

    <div class="grid">
		<article class="grid__item " onclick="createClub()">
			<div class="wrapEn0">
				<div class="overray0 makeit">새 소모임<br> 생성하기</div>
				<div class="wrapEntire">
					<div class="card">
						<div class="card__img00 fright">
							<img class="card__img01" src="img/이쁜이미지1.jpg" alt="Snowy Mountains">
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
		</article>


 <% for(int i = 0; i < rlist.size(); i++){ %>


		<article class="grid__item ">
			<div class="wrapEn0">
				<div class="overray0 editit" onclick="editClub(this)">소모임 수정하기</div>
				<div class="overray0 deleteit" onclick="deleteClub(this)">소모임 삭제하기</div>
				<div class="wrapEntire" onclick="gotoClub(this)">
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
				</div>
			</div>
		</article>

	<%} %>
    </div><!-- 그리그 끝! -->
  </section>
<!--  post 대신 우선 get으로 살펴보기 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  -->

<form id="createClub" action="team_FORWHERE.jsp" method="post">
	<input type="hidden" name="forwhere" value="club_create_userpage.jsp">
</form>

<form id="editClub" action="team_FORWHERE.jsp" method="post">
	<input type="hidden" name="forwhere" value="club_edit_userpage.jsp">
	<input type="hidden" name="clubid" id="clubid">
</form>
<form id="deleteClub" action="team_FORWHERE.jsp" method="post">
	<input type="hidden" name="forwhere" value="club_delete.jsp">
	<!-- 딜리트는 갔다가 바로 여기로 돌아올겁ㄴ디ㅏ.  -->
	<input type="hidden" name="clubid" id="clubid2">
</form>
<form id="gotoClub" action="team_FORWHERE.jsp" method="post">
	<input type="hidden" name="forwhere" value="club_main.jsp">
	<input type="hidden" name="clubid" id="clubid3">
</form>

    "Icon made by Freepik from www.flaticon.com"<br> <br>
    Icons made by Pixel perfect from  www.flaticon.com
</main>

<script type="text/javascript" src="js/club_whereto.js"></script>


</body>