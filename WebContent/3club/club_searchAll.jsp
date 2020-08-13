<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="java.util.List" %>
<%@ page import="com.team7.vo.ClubBean" %>
<%@ page import="com.team7.vo.PhotoBean" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/gridgrid_new.css?ver=8">
	<!-- 바디... main만 있어도 됨.  -->
<%
request.setCharacterEncoding("UTF-8");

//String whichNum = request.getParameter("whichNum"); 
// 아직 12345 목록 크기 정하지 않았습니다. 
// if(session.getAttribute("LOG_ID"))
// String id = (String) session.getAttribute("LOG_ID");

List<ClubBean> rlist // = new Class_DAO().club_selectorAll2(iii);
			=(List<ClubBean>) request.getAttribute("rlist");

List<PhotoBean> plist = (List<PhotoBean>) request.getAttribute("plist");

//List<dtos.Class_DTO_ClubProperties2> rlist  = new Class_DAO().club_selectorAll();

//		ServletContext context = request.getServletContext();
//		String realFolder=context.getRealPath("/clubsphoto/"+rlist.get(0).getAdmin());
//		String basicFolder=context.getRealPath("/img/exc");
	String realFolder = "Files/clubsphoto/";//+rlist.get(0).getAdmin()+"_";
	String basicFolder = "img/exc";

%>

<main id="main000" class="mainwrap">

  <section>
    <div id="buttons">
      <div id="buttons0"></div>
      <div id="buttons1"></div>
      <div id="buttons2"></div>
    </div>
	  <div class="sticky_side_bar fright">
	  	ꓥ  &nbsp; &nbsp; 1 2 3 4 5  … 12 &nbsp; &nbsp;  ꓦ
	  </div>

    <div class="grid">    
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
		<article class="grid__item" onclick="gotoClub2(this)">
    <!-- <article class="grid__item" > -->
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
            <!-- heart zzim의 관계 설정. ... onclick="Zzimshow_club(this)" -->
            <div class="zzimSystem"  data-id="<%=rlist.get(i).getNo()%>">
              <img src="img/heart_and_star/heart034.png"> <span class="counter" data-target="">0  </span> 
            </div>
						<img src="img/heart_and_star/star22.png">  <span><%=rlist.get(i).getMemberNum() %></span>
					</div>
				</div>
				<div class="card__bottomContent">
					<div class="card__text"><%=rlist.get(i).getProfile() %></div>
				</div>
			</div>
		</article>
		<%} %>

<form id="gotoClub" action="toClubMain.club" method="post" style="display:none;">
	<!-- <input type="hidden" name="forwhere" value="club_main.jsp"> -->
	<input type="hidden" name="clubid" id="clubid3">
</form>


    </div><!-- 그리그 끝! -->
    "Icon made by Freepik from www.flaticon.com"<br> <br>
    Icons made by Pixel perfect from  www.flaticon.com
  </section>
  
<!-- <script type="text/javascript" src="js/club_whereto.js"></script> -->
<script type="text/javascript" src="77zzim/zzim_js.js?ver=4"></script>
<!-- <script type="text/javascript" src="js/grid_move.js"></script> -->
<script type="text/javascript">
var kk = 0 ;
    function gotoClub2(req){
        //alert("112222");
    var id =$(req).find('.card__idhere').attr('id');
    //alert(id);
    $('#gotoClub').find('#clubid3').val(id);
    $('#gotoClub').submit();
    
}
  $('.card__img01').each(function(index,item){
    var pheight = $(item).parent().height();
    var height = $(item).height();
    console.log(pheight);
    $(item).css('bottom',(height - pheight)/2);
  });

</script>
<script src="js/taggings_jay.js?ver=3"></script>

</main>


