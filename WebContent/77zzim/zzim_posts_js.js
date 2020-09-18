


// function cpost_zzim(var )




function changeHTMLsforpostzzim(req,go =1){ // 그 안에 img 랑 span 안의 값.
    if(go ==1){
        // $('button#z_zzim1:contains("찜하기 ")').html("찜 취소 <img src='img/heart_and_star/heart34.png'>");
        $(req).children('img').attr('src','img/heart_and_star/heart34.png');
        $(req).removeAttr("onclick");
        $(req).attr('onclick',"cpost_z_cancel(this)");
        var countt = $(req).children('span');
        var count00 = countt.text();
        countt.text(count00 + 1);

    }
    else{
        // $('button#z_zzim1:contains("취소")').html("찜하기 <img src='img/heart_and_star/heart034.png'>"); //여기서 하는게 아닌가...?
        $(req).children('img').attr('src','img/heart_and_star/heart034.png');
        $(req).removeAttr("onclick");
        $(req).attr('onclick',"cpost_z(this)");
        var countt = $(req).children('span');
        var count00 = countt.text();
        countt.text(count00 - 1);

    }
}

function cpost_z(req){
    var url = "cpost.zzim";
    var no = $(req).data('no');
    if(log_status !=1){
        alert('로그인해주세요!!');
    }
    else{
        zzimer(url,no);
        console.log('찜하기 되었음!');
        changeHTMLsforpostzzim(req,1);
    }
}

function cpost_z_cancel(req){
    var url = "cpostC.zzim";
    var no = $(req).data('no');
    zzimer(url,no);
  console.log('찜 취소 되었음!');
  changeHTMLsforpostzzim(req,0);
}

function zzimer(url0, no){
      $.ajax({
          type:"GET",
          url:url0,
          dataType:"html",
          data:{
            no : no,
            //person : $(req).data('person')
          },
          success : function(data){
          },
      })
}
