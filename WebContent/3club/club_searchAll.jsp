<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="java.util.List" %>
<%@ page import="com.team7.vo.ClubBean" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/gridgrid_new.css?ver=4">
	<!-- 바디... main만 있어도 됨.  -->
<%
request.setCharacterEncoding("UTF-8");

//String whichNum = request.getParameter("whichNum"); 
// 아직 12345 목록 크기 정하지 않았습니다. 
// if(session.getAttribute("LOG_ID"))
// String id = (String) session.getAttribute("LOG_ID");

List<ClubBean> rlist // = new Class_DAO().club_selectorAll2(iii);
			=(List<ClubBean>) request.getAttribute("rlist");

//List<dtos.Class_DTO_ClubProperties2> rlist  = new Class_DAO().club_selectorAll();

//		ServletContext context = request.getServletContext();
//		String realFolder=context.getRealPath("/clubsphoto/"+rlist.get(0).getAdmin());
//		String basicFolder=context.getRealPath("/img/exc");
	String realFolder = "Files/clubsphoto/"+rlist.get(0).getAdmin()+"/";
	String basicFolder = "img/exc";
//String photo1 ="";
//String photo2 ="";
//      if(rlist.get(0).getPhoto1() !=null){
//    	  photo1 = realFolder+"main/"+rlist.get(0).getPhoto1();
//      }
//      else{
//    	  photo1 = basicFolder+"/"+"surf1.jpg";
//      }
//      if(rlist.get(0).getPhoto2() !=null){
//    	  photo2 = realFolder+"profile/"+rlist.get(0).getPhoto2();
//      }
//      else{
//    	  photo2 = basicFolder+"/"+"soccer1.jpg";
//      }

%>

<main id="main000" class="mainwrap">

  <section>
    <div id="buttons"></div>
	  <div class="sticky_side_bar fright">
	  	ꓥ  &nbsp; &nbsp; 1 2 3 4 5  … 12 &nbsp; &nbsp;  ꓦ
	  </div>

    <div class="grid">    
     <% for(int i = 0; i < rlist.size(); i++){ %>
     
     
     	<%
     	String photo1 ="";
  
     	      if(rlist.get(i).getPhoto1() ==null || rlist.get(i).getPhoto1().equals("")){
     	    	  photo1 = basicFolder+"/"+"surf1.jpg";
     	    	 // photo1 = rlist.get(i).getPhoto1();
     	      }
     	      else{
     	    	  photo1 = realFolder+"main/"+rlist.get(i).getPhoto1();
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
<script type="text/javascript" src="77zzim/zzim_js.js"></script>
<!-- <script type="text/javascript" src="js/grid_move.js"></script> -->
<script type="text/javascript">
  $('.card__img01').each(function(index,item){
    var pheight = $(item).parent().height();
    var height = $(item).height();
    console.log(pheight);
    $(item).css('bottom',(height - pheight)/2);
  });

</script>
<script type="text/javascript">


	function gotoClub2(req){
    //alert("dd");
	var id =$(req).find('.card__idhere').attr('id');
	//alert(id);
	$('#gotoClub').find('#clubid3').val(id);
	//alert($('#gotoClub').find('#clubid3').val());
	$('#gotoClub').submit();
	
}


	//태깅 시작 
 (function() {

  var $articles = $('.grid article.grid__item');  // Store all 아티클 --images
  var $buttons = $('#buttons');                   // Store buttons element
  var tagged = {};                                // Create tagged object

  $articles.each(function() {                         // Loop through 아티클이라니까images and
    var article = this;                               // Store img in variable
    //var tags = $(this).data('tags');              // Get this element's tags
    var tags = $(this).find('.content_what').children('span').text()
    var tags2 = $(this).find('.content_where').children('span').text();
                  // Get this element's tags
    //alert(tags);//ㅋㅋ

    if (tags) {                                   // If the element had tags
      tags.split(',').forEach(function(tagName) { // Split at comma and

        if (tagged[tagName] == null) {            // If object doesn't have tag
          tagged[tagName] = [];                   // Add empty array to object
        }
        tagged[tagName].push(article);                // Add the image to the array
      });
    }

    if (tags2) {                                   // If the element had tags
      tags2.split(',').forEach(function(tagName) { // Split at comma and

        if (tagged[tagName] == null) {            // If object doesn't have tag
          tagged[tagName] = [];                   // Add empty array to object
        }
        tagged[tagName].push(article);                // Add the image to the array
      });
    }
  });
  $('<button/>', {                                 // Create empty button
    text: 'Show All',                              // Add text 'show all'
    class: 'active',                               // Make it active
    click: function() {                            // Add onclick handler to
      $(this)                                      // Get the clicked on button
        .addClass('active')                        // Add the class of active
        .siblings()                                // Get its siblings
        .removeClass('active');                    // Remove active from siblings
      $articles.hide(500).slideDown(500);                 // Show all images
    }
  }).appendTo($buttons);                           // Add to buttons

  $.each(tagged, function(tagName) {               // For each tag name
    $('<button/>', {                               // Create empty button
      text: tagName + ' (' + tagged[tagName].length + ')', // Add tag name
      click: function() {                          // Add click handler
        $(this)                                    // The button clicked on
          .addClass('active')                      // Make clicked item active
          .siblings()                              // Get its siblings
          .removeClass('active');                  // Remove active from siblings
        $articles                                      // With all of the images
          .hide(500)                                  // Hide them
          .filter(tagged[tagName])                 // Find ones with this tag
          .fadeIn(300);                                // Show just those images
      }
    }).appendTo($buttons);                         // Add to the buttons
  });

}());

</script>
</main>


