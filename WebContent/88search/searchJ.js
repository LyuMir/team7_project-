



// var all_no_arr;

// var search00;


// var delayTimer;
// function doSearch(text) {
//     clearTimeout(delayTimer);
//     delayTimer = setTimeout(function() {
//         // Do the ajax stuff
//     }, 1000); // Will do the ajax stuff after 1000 ms, or 1 s
// }

// search00.change(search(search00.val(),"club","name")); // 왠지 모르게 안먹음. 

var delayTimer;

$('#search_club_name').on("propertychange change keyup paste input",function(){
	var req2 = $(this).val();
	var namedata = article00.data('name');
	// var namearr = $.makeArray(article00.find('.card__header').text());
	var namearr = $.makeArray(namedata);

	// clearTimeout(delayTimer);
	// delayTimer = setTimeout(function(){
			reshowall();
			// if(article00.length<2){}
				// else{
			for (var i = 0; i < article00.length; i++) {
				if(article00.eq(i).data('name').indexOf(req2) < 0 ){ // contains랑 헷갈리지 말자!!
					article00.eq(i).addClass('displaynone');
				}
			}
				// }
	// },1000);

});





// function search_club_name(req){
// 	console.log("잘 될까?"+req);
// 	var req2 = $(req).val();
// 	// var req2 = $(req);
// 	var namearr = $.makeArray(article00.find('.card__header').text());
// 	reshowall();
// 	for (var i = 0; i < article00.length; i++) {
// 		if(article00.eq(i).find('.card__header').text().indexOf(req2) < 0 ){ // contains랑 헷갈리지 말자!!
// 			article00.eq(i).addClass('displaynone');
// 			console.log(i+"번째 지워짐!");
// 		}
// 	}
// }































function unshowall(){
	article00.each(function(index){
		$(this).addClass('displaynone');
	});
}

function reshowall(){
	article00.each(function(index){
		$(this).removeClass('displaynone');
	});
}

function search(req,kind,kind2){
	if(kind =="club" && kind2 =="name"){
		// var req2 = req.val();
		var req2 = $('input#searchone').val();
		var data = {'search':req2};
		console.log(data+"를 보낸다...");
		var datasss = search_name(data);
		var orinos = all_no_arr;
		var thenos = datasss.text().split(','); // now you can use [1,2,3,4,5,...99,] 이렇게.

		thenos = thenos.filter(function(item){
			return !orinos.includes(item);
		});
		unshowall();

		for(var i = 0 ; i < article00.length; i++){
			if(thenos.includes(article00.data('id'))){
				article00.removeClass('displaynone');
			}
		}
	}
}

function search_name(data,what00="clubname"){
    var url = what00+".search";
    var datasss;
    $.ajax({
        type:"post",
        url:url,
        data : data, 
        async:false,
        dataType:"html",
        success : function(data){
            datasss = $(data);
        }
    })
    return datasss;
    alert(datasss);
}