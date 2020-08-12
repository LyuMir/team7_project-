<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>


<div class="container2">
  <div class="ad_text text3"><img src="img/logo1.png"></div>
  <ul >
    <li class="board">
      <div class="boardname">게시판제목</div>
      <div class="boarddiv">
        게시판내용
      </div>
    </li>
    <li class="board">
      <div class="boardname">게시판제목</div>
      <div class="boarddiv">
        게시판내용
      </div>
    </li>
    <li class="board">
      <div class="boardname">게시판제목</div>
      <div class="boarddiv">
        게시판내용
      </div>
    </li>
  </ul>

</div>

<script type="text/javascript">
  var boTs = $('.boardname');
  var boxs = $('.boarddiv');

 
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
    return datasss;
  var text550 = datasss.children('div').eq(0).data('author')+'님, ' + datasss.children('div').eq(0).text();


  boTs.eq(0).text(datasss.children('div').eq(0).data('title'));
  boTs.eq(1).text(datasss.children('div').eq(1).data('title'));
  boTs.eq(2).text(datasss.children('div').eq(2).data('title'));

  boxs.eq(0).text(text550);
  boxs.eq(1).text(datasss.children('div').eq(1).text());
  boxs.eq(2).text(datasss.children('div').eq(2).text());
}
postGetter();





</script>