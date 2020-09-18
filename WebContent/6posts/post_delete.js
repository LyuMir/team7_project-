


// function cpost_zzim(var )

function deletethispost(req){

  var confi = confirm('정말로 이 포스트를 삭제하시겠습니까?');
  if(confi){
    $(req).next().submit();
  }
}
