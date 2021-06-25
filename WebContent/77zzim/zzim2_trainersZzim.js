


function zzimThis2(req){
	var url = "trainer.zzim";
	// var

	if(log_status !=1){
        alert('로그인해주세요!!');
    }
    else{
    	$.ajax({
            type:"GET",
            url:url,
            dataType:"html",
        	async:false,
            data:{
              'trainerid' : $(req).data('id2'),
              //person : $(req).data('person')
            },
            success : function(res){
            	var res = $(res);		

				changeHTML2(req,1);

            }

    	});

	}
}

function zzimThis2_C(req){
	var url = "trainerC.zzim";
	// var

    	$.ajax({
            type:"GET",
            url:url,
            dataType:"html",
        	async:false,
            data:{
              'trainerid' : $(req).data('id2'),
              //person : $(req).data('person')
            },
            success : function(res){
            	var res = $(res);
				changeHTML2(req,0);

            }

    	});

}


function changeHTML2(req, go =1){
	if(go ==1){
		// $('button#z_zzim2:contains("찜하기 ")').html("찜 취소 <img src='img/heart_and_star/heart34.png'>");
		$(req).children('img').attr('src','img/heart_and_star/heart34.png');
		$(req).removeAttr("onclick");
		$(req).attr('onclick',"zzimThis2_C(this)");
        $(req).html("찜 취소 <img src='img/heart_and_star/heart34.png'>");
	}
	else{
		// $('button#z_zzim2:contains("취소")').html("찜하기 <img src='img/heart_and_star/heart034.png'>"); //여기서 하는게 아닌가...?
		$(req).children('img').attr('src','img/heart_and_star/heart034.png');
		$(req).removeAttr("onclick");
		$(req).attr('onclick',"zzimThis2(this)");
        $(req).html("찜하기 <img src='img/heart_and_star/heart034.png'>");

	}
}