<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.team7.dao.Class_DAO" %>
<%@ page import="com.team7.vo.DTO_ClubProperties" %>
<%@ page import="com.team7.vo.ClubBean" %>
<%@ page import="com.team7.vo.PhotoBean" %>
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

//ClubBean dto = new ClubBean();
//dto.setAdmin(id);
//List<ClubBean> rlist  = //new ClubService().club_selector_id(dto);
//List<dtos.Class_DTO_ClubProperties2> rlist  = new Class_DAO().club_selectorAll();
	List<ClubBean> rlist = 	(List<ClubBean>) request.getAttribute("rlist");
	List<PhotoBean> plist = (List<PhotoBean>) request.getAttribute("plist");
	String realFolder = "Files/clubsphoto/";//+rlist.get(0).getAdmin()+"_";
	String basicFolder = "img/exc";
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
			<img src="img/heart_and_star/star.png" style="width: 50px;">
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
								<img src="img/heart_and_star/heart35.png"> <span>5000  </span>  &nbsp;<img src="img/heart_and_star/star22.png">  <span>7000</span>
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


     	<%
     	String photo1 ="";
     	String picture00="";
  
     	boolean picYN = false;
  for(int j = 0 ; j < plist.size(); j++){
	  if(plist.get(j).getNo() == rlist.get(i).getNo()){
		  picYN = true;
		  picture00 =plist.get(j).getPicture();
	  }
  
}

     	      if(!picYN){

     	    	  String theme = rlist.get(i).getE_type();
     	    	  if(theme.contains("축구")){
     	    		  photo1 = basicFolder+"/soccer1.jpg";
     	    	  }
     	    	  else if(theme.contains("농구")){
     	    		  photo1 = basicFolder+"/basketball1.png";
     	    	  }
     	    	  else if(theme.contains("등산")){
     	    		  photo1 = basicFolder+"/hiking1.jpg";
     	    	  }
     	    	  if(theme.contains("스케이트")){
     	    		  photo1 = basicFolder+"/skate1.jpg";
     	    	  }
     	    	  else if(theme.contains("요가")){
     	    		  photo1 = basicFolder+"/yoga1.jpg";
     	    	  }
     	    	  else if(theme.contains("자전거")){
     	    		  photo1 = basicFolder+"/cycling1.jpg";
     	    	  }
     	    	  else if(theme.contains("야구")){
     	    		  photo1 = basicFolder+"/baseball2.jpg";
     	    	  }
     	    	  
     	    	  if(photo1.equals("")){
     	    		 photo1 = basicFolder+"/"+"surf1.jpg";
     	    	  }
     	      }
     	      else{
     	    	  photo1 = realFolder+rlist.get(i).getAdmin()+"_"+rlist.get(i).getNo()+"/main/"+picture00;
     	      }
     	
     	%>
		<article class="grid__item ">
			<div class="wrapEn0">
				<div class="overray0 editit" onclick="editClub(this)">소모임 수정하기</div>
				<div class="overray0 deleteit" onclick="deleteClub(this)">소모임 삭제하기</div>
				<div class="wrapEntire" onclick="gotoClub(this)">
					<div class="card">
						<div class="card__img00 fright">
							<img class="card__img01" src="<%=photo1 %>">
						</div>
						<div class="card__content fleft">
							<div class="card__idhere" id="<%=rlist.get(i).getNo()%>"></div>
							<div class="card__header"><%=rlist.get(i).getName() %></div>
							<div class="card__tag00 content_now"><%=rlist.get(i).getMemberJoin() %></div>
							<div class="card__tag00 content_what"> 운동 : <span><%=rlist.get(i).getE_type() %></span></div>
							<div class="card__tag00 content_where"> 장소 : <span><%=rlist.get(i).getArea() %></span></div>
							<div class="card__tag00 content_when"> 시간 : <span><%=rlist.get(i).getMeetingDate() %></span></div>
							<div class="card__heart"> 
								<img src="img/heart_and_star/heart35.png"> <span>000  </span>  &nbsp;<img src="img/heart_and_star/star22.png">  <span>00</span>
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

<form id="createClub" action="_FORWHERE.jsp" method="post">
	<input type="hidden" name="forwhere" value="3club/club_create.jsp">
</form>

<form id="editClub" action="_FORWHERE.jsp" method="post">
	<input type="hidden" name="forwhere" value="3club/club_edit.jsp">
	<input type="hidden" name="clubid" id="clubid">
</form>
<form id="deleteClub" action="Delete.club" method="post">
	<!-- <input type="hidden" name="forwhere" value="clubDelete.club"> -->
	<!-- 딜리트는 갔다가 바로 여기로 돌아올겁ㄴ디ㅏ.  -->
	<input type="hidden" name="clubid" id="clubid2">
</form>
<form id="gotoClub" action="toClubMain.club" method="post">
	<input type="hidden" name="forwhere" value="3club/club_main.jsp">
	<input type="hidden" name="clubid" id="clubid3">
</form>

    "Icon made by Freepik from www.flaticon.com"<br> <br>
    Icons made by Pixel perfect from  www.flaticon.com
</main>

<!-- <script type="text/javascript" src="js/club_whereto.js"></script> -->
<script type="text/javascript">
	
	function createClub(){
	$('#createClub').submit();
}
function editClub(req){
	var id = $(req).parent('.wrapEn0').find('.card__idhere').attr('id');

	$('#editClub').children('#clubid').val(id);

	$('#editClub').submit();
}
function deleteClub(req){
	var id = $(req).parent('.wrapEn0').find('.card__idhere').attr('id');
	$('#deleteClub').children('#clubid2').val(id);
	var confirmE = confirm("해당 소모임을 삭제하시겠습니까? 자신을 제외한 모임원이 존재하지 않아야 합니다.");
	if(confirmE){
		$('#deleteClub').submit();	//페이지 왔다갔다 하는 대신 ajax로 되나? 그런 귀찮은 짓을. 

	}
}
function gotoClub(req){
	var id =$(req).parent('.wrapEn0').find('.card__idhere').attr('id');
	$('#gotoClub').children('#clubid3').val(id);
	$('#gotoClub').submit();
}

function gotoClub2(req){
	var id =$(req).find('.card__idhere').attr('id');
	$('#gotoClub').find('#clubid3').val(id);
	$('#gotoClub').submit();
	
}
function manageClub(req){
	var id = $(req).parent('.wrapEn0').find('.card__idhere').attr('id');

	$('#manageClub').children('#clubid').val(id);

	$('#manageClub').submit();
}

</script>


</body>