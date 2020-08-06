





function Zzimshow_club(req){
    var url = "http://localhost:8080/test/club.zzimshow";
    $.ajax({
        type:"GET",
        url:url,
        dataType:"html",
        data:{
        	clubid : req.data('id'),
        	//person : req.data('person')

            //name : $('#ajaxConName').val(),
            //age : $('#ajaxConAge').val()
        },
        success : function(data){
            alert('ajax GET 통신 성공'+data);
            //var $div = $('<div></div>');
            //var text = document.createTextNode(data);
            //$div.append(data);
            //$div.appendTo($('#myDiv'))
        
        },
        // error : function(request,status,error){
        //     alert('code:'+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error); //에러 상태에 대한 세부사항 출력
        //     alert(e);
        // }
    })
    
}


function Zzimshow_club(req){
    var url = "http://localhost:8080/test/club.zzimshow";
    $.ajax({
        type:"GET",
        url:url,
        dataType:"html",
        data:{
        	clubid : req.data('id'),
        },
        success : function(data){
            alert('ajax GET 통신 성공'+data);
        
        },
    })
    
}