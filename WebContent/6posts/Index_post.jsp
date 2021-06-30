<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="com.team7.vo.PostBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.*" %>

<% request.setCharacterEncoding("UTF-8"); ;




%>
<div class="container2" style="margin-top: 50px;">
  <!-- <div class="ad_text text3"><img src="img/logo1.png"></div> -->
  <img src="img/logo1.png" style="margin-top: 20px;" width="150">
  <div class="board_en">
    <div class="grid_main_0">
      <div class="board">
        <div class="boardname">오늘의 헬스장 추천</div>
        <div class="boarddiv">
          게시판내용
        </div>
      </div>
      <div class="board">
        <div class="boardname">오늘의 트레이너 추천</div>
        <div class="boarddiv">
          게시판내용
        </div>
      </div>
      <div class="board">
        <div class="boardname">오늘의 소모임 추천</div>
        <div class="boarddiv">
          게시판내용
        </div>
      </div>
    </div>
  </div>
</div>

<style type="text/css">

  .grid_main_0{
    display: grid;
    grid-gap: 15px;
     grid-template-columns: repeat(auto-fit,minmax(220px,1fr));

  }
  .container2{
    max-width: 1080px;
    width: calc(100% - 50px);
    margin: 10px auto;
  }
  .board_en{
    width: 100%;
    min-height: 500px;
    margin-top: 20px;
  }

  .board{
    display: inline-block;
    /*width: 30%;*/
    margin-bottom: 25px;
    border: 2px solid white;
    /*border-radius: 5px;*/
  }
/*  .board *{
    padding: 5px;
  }*/
  .board:hover{
    /*background-color: #fffae6;*/
    border: 2px solid #a7b36b;
    border-radius: 13px 6px 13px 6px;
  }
  .boardname{
    background-color: #7d784b;
    color: white;
    min-height: 50px;
    padding: 7px;
    border-radius: 12px 5px 0 0 ;
  }
  .boarddiv{
    background-color: #fffae6;
    min-height: 125px;
    border-radius: 0 0 12px 5px;
    font-size: 13px;
    padding: 5px;
  }

  .imgright{
    margin-left: 25px;
    margin-right: 25px;
  }
  .imgleft{
    margin-left: 25px;
    margin-right: 25px;
  }

</style>

<script type="text/javascript">
  var boTs = $('.boardname'); /*  */
  var boxs = $('.boarddiv');

 
postGetter();
function postGetter(){
    var url = "indexPosts.post";
    
    var datasss;
    $.ajax({
        type:"GET",
        url:url,
        async:false,
        dataType:"html",
        success : function(data){
            datasss = $(data);
        }
    })

    // return datasss;

     var grid_main_0 = $('.grid_main_0');
    var stmt = "";
    var dd11 = datasss.children('div');
    for (var i = 0; i < dd11.length; i++) {
      stmt += "<div class='board'>";
      if(dd11.eq(i).data('type') == 1) stmt += "<div class='boardname'>최근 등록된 헬스장 후기! </div><div class='boarddiv'>";
      else if(dd11.eq(i).data('type') == 2) stmt += "<div class='boardname'>최근 등록된 트레이너 후기! </div><div class='boarddiv'>";
      else if(dd11.eq(i).data('type') == 3) stmt += "<div class='boardname'>최근 등록된 소모임글! </div><div class='boarddiv'>";
      stmt += "제목 : "+dd11.eq(i).data('title')+"<br>글쓴이 :"+dd11.eq(i).data('author')+"<br>내용 :"+dd11.eq(i).text();
      stmt += "</div></div>";
    } 

    grid_main_0.html(stmt);


      // <div class="board">
      //   <div class="boardname">오늘의 소모임 추천</div>
      //   <div class="boarddiv">
      //     게시판내용
      //   </div>
      // </div>
  // var text550 = datasss.children('div').eq(0).data('author')+'님, ' + datasss.children('div').eq(0).text();

   console.log(datasss.html());

  // boxs.eq(0).text(text550);
  // boxs.eq(1).text(datasss.children('div').eq(1).text());
  // boxs.eq(2).text(datasss.children('div').eq(2).text());


}





</script>