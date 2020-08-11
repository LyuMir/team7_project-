<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.team7.vo.ClubBean" %>
<%@ page import="java.util.List" %>
<!-- <html>
<head>
	<title>소모임 전체보기...</title> -->
	<link rel="stylesheet" type="text/css" href="css/gridgrid_new.css?ver=5">
<!-- </head>
<body> -->
	<!-- 바디... main만 있어도 됨.  -->
<%
request.setCharacterEncoding("UTF-8");

//String whichNum = request.getParameter("whichNum"); 
// 아직 12345 목록 크기 정하지 않았습니다. 
//dtos.Class_DTO_String id00 = new dtos.Class_DTO_String();
		//String id = (String) session.getAttribute("id");
//현재 아이디 대신 아무 아이디로 하고 있습니다. ffefsfev
String id = (String) session.getAttribute("LOG_ID");

//id00.setS1(id);	// req로 받아서 넣어 사용하면 되겠네요 
List<ClubBean> rlist  = //new Class_DAO().club_selector_id(id00);
//List<dtos.Class_DTO_ClubProperties2> rlist  = new Class_DAO().club_selectorAll();
		(List<ClubBean>) request.getAttribute("rlist");

	String realFolder = "Files/clubsphoto/"+rlist.get(0).getAdmin()+"/";
	String basicFolder = "img/exc";

		List<ClubBean> rlist2 = (List<ClubBean>)request.getAttribute("rlist2");
%>

<main id="main000" class="mainwrap">

  <section>
	  <div class="sticky_side_bar fright">
	  	ꓥ  &nbsp; &nbsp; 1 2 3 4 5  … 12 &nbsp; &nbsp;  ꓦ
	  </div>
내가 창설한 소모임 . 
    <div class="grid">

		   
     <% for(int i = 0; i < rlist.size(); i++){ %>


<%
String photo1 ="";
String photo2 ="";

      if(rlist.get(i).getPhoto1() ==null || rlist.get(i).getPhoto1().equals("")){
    	  photo1 = basicFolder+"/"+"surf1.jpg";
    	 // photo1 = rlist.get(i).getPhoto1();
      }
      else{
    	  photo1 = realFolder+"main/"+rlist.get(i).getPhoto1();
      }
      if(rlist.get(i).getPhoto2() ==null || rlist.get(i).getPhoto2().equals("")){
    	  photo2 = basicFolder+"/"+"soccer1.jpg";
    	 // photo1 = rlist.get(i).getPhoto1();
      }
      else{
    	  photo2 = realFolder+"profile/"+rlist.get(i).getPhoto2();
      }

%>
		<article class="grid__item">
			<div class="wrapEn0">
				<div class="overray0 manageit" onclick="manageClub(this)">소모임 관리하기</div>
				<!-- <div class="overray0 deleteit" onclick="deleteClub(this)">소모임 삭제하기</div> -->
				<div class="wrapEntire" onclick="gotoClub2(this)">
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
								            <!-- heart zzim의 관계 설정.  -->
					            <div class="zzimSystem" onclick="Zzimshow_club(this)" data-id="<%=rlist.get(i).getNo()%>">
					              <img src="img/heart_and_star/heart034.png"> <span class="counter" data-target="">0  </span> 
					            </div>
								<img src="img/heart_and_star/star22.png">  <span><%=rlist.get(i).getMemberNum() %></span>
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

		<br> 내가 속한 소모임 

     <% for(int i = 0; i < rlist2.size(); i++){ %>
		<article class="grid__item" onclick="gotoClub2(this)">
			<div class="card">
				<div class="card__img00 fright">
					<img class="card__img01" src="img/이쁜이미지1.jpg" alt="Snowy Mountains">
				</div>
				<div class="card__content fleft">
					<div class="card__idhere" id="<%=rlist2.get(i).getNo()%>"></div>
					<div class="card__header"><%=rlist2.get(i).getName() %></div>
					<div class="card__tag00 content_now"><%=rlist2.get(i).getMemberJoin() %></div>
					<div class="card__tag00 content_what"> 운동 : <span><%=rlist2.get(i).getE_type() %></span></div>
					<div class="card__tag00 content_where"> 장소 : <span><%=rlist2.get(i).getArea() %></span></div>
					<div class="card__tag00 content_when"> 시간 : <span><%=rlist2.get(i).getMeetingDate() %></span></div>
					<div class="card__heart"> 
						<div class="zzimSystem" onclick="Zzimshow_club(this)" data-id="<%=rlist2.get(i).getNo()%>">
							<img src="img/heart_and_star/heart034.png"> <span class="counter" data-target="">0  </span> 
						</div>
						<img src="img/heart_and_star/star22.png">  <span><%=rlist2.get(i).getMemberNum() %></span>
					</div>
				</div>
				<div class="card__bottomContent">
					<div class="card__text"><%=rlist2.get(i).getProfile() %></div>
				</div>
			</div>
		</article>
		<%} %>

<!-- 
<form id="gotoClub" action="team_FORWHERE.jsp" method="post" style="display:none;">
	<input type="hidden" name="forwhere" value="club_main.jsp">
	<input type="hidden" name="clubid" id="clubid3">
</form> -->
<form id="gotoClub" action="toClubMain.club" method="post" style="display:none;">
	<!-- <input type="hidden" name="forwhere" value="club_main.jsp"> -->
	<input type="hidden" name="clubid" id="clubid3">
</form>
<form id="manageClub" action="manage.club" method="post" style="display:none;">
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

var kk = 0 ;
	function gotoClub2(req){
		//alert("112222");
	var id =$(req).find('.card__idhere').attr('id');
	//alert(id);
	$('#gotoClub').find('#clubid3').val(id);
	$('#gotoClub').submit();
	
}
	function manageClub(req){
		//alert("???du");
		var id =$(req).parent().find('.card__idhere').attr('id');
		//alert(id);
		$('#manageClub').find('#clubid3').val(id);
		$('#manageClub').submit();
	}
</script>
<script type="text/javascript" src="77zzim/zzim_js.js?ver=3"></script>

<!-- 
</body>
</html> -->