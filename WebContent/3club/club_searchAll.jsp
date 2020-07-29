<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="daos.Class_DAO" %>
<%@ page import="dtos.Class_DTO_ClubProperties" %>
<%@ page import="java.util.List" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/gridgrid_new.css">
	<!-- 바디... main만 있어도 됨.  -->
<%
request.setCharacterEncoding("UTF-8");

//String whichNum = request.getParameter("whichNum"); 
// 아직 12345 목록 크기 정하지 않았습니다. 

List<DTO_ClubProperties2> rlist // = new Class_DAO().club_selectorAll2(iii);
			= ()

//List<dtos.Class_DTO_ClubProperties2> rlist  = new Class_DAO().club_selectorAll();

%>

<main id="main000" class="mainwrap">

  <section>
	  <div class="sticky_side_bar fright">
	  	ꓥ  &nbsp; &nbsp; 1 2 3 4 5  … 12 &nbsp; &nbsp;  ꓦ
	  </div>

    <div class="grid">    
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

<form id="gotoClub" action="toMain.club" method="post" style="display:none;">
	<!-- <input type="hidden" name="forwhere" value="club_main.jsp"> -->
	<input type="hidden" name="clubid" id="clubid3">
</form>

<!-- <script type="text/javascript" src="js/club_whereto.js"></script> -->
<script type="text/javascript">


	function gotoClub2(req){
	var id =$(req).find('.card__idhere').attr('id');
	$('#gotoClub').find('#clubid3').val(id);
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

}
</script>

    </div><!-- 그리그 끝! -->
    "Icon made by Freepik from www.flaticon.com"<br> <br>
    Icons made by Pixel perfect from  www.flaticon.com
  </section>
</main>


