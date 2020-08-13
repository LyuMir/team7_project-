


function zzimThis1(req){
	var url = "gym.zzim";
    // alert($(req).data('id')+"랍니다...");
	if(log_status !=1){
        alert('로그인해주세요!!');
    }
    else{
        // alert('왔습니다...'+url);
    	$.ajax({
            type:"post",
            url:url,
            dataType:"html",
        	// async:false,
            data:{
              'gymid' : $(req).data('id2'),
              //person : $(req).data('person')
            },
            success : function(res){
            	// var res = $(res);
                changeHTML1(req,1);
            }

    	})
		

	}
}

function zzimThis1_C(req){
	var url = "gymC.zzim";
	// alert('eeeㄷㄷㄷㄷ');

    	$.ajax({
            type:"post",
            url:"gymC.zzim",
            dataType:"html",
        	async:false,
            data:{
              'gymid' : $(req).data('id2'),
              //person : $(req).data('person')
            },
            success : function(res){
            	// var res = $(res);

                changeHTML1(req,0);
            }

    	});

}


function changeHTML1(req, go =1){
	if(go ==1){
		// $('button#z_zzim1:contains("찜하기")').html("찜 취소 <img src='img/heart_and_star/heart34.png'>");
		$(req).children('img').attr('src','img/heart_and_star/heart34.png');
		$(req).removeAttr("onclick");
		$(req).attr('onclick',"zzimThis1_C(this)");
        $(req).html("찜 취소 <img src='img/heart_and_star/heart34.png'>");
	}
	else{
		// $('button#z_zzim1:contains("취소")').html("찜하기 <img src='img/heart_and_star/heart034.png'>"); //여기서 하는게 아닌가...?
		$(req).children('img').attr('src','img/heart_and_star/heart034.png');
		$(req).removeAttr("onclick");
		$(req).attr('onclick',"zzimThis1(this)");
        $(req).html("찜하기 <img src='img/heart_and_star/heart034.png'>");

	}
}