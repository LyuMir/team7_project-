$(function(){

	var mainwidthsize01 = $('#main000').width();

// 더보기 위치 맞추기 

	// $('.ubo__nav__dropdown__content').css("left",((widthsize0 - 1000)/2 )+"px");
	// $('.ubo__nav__dropdown__content').css("right",((widthsize0 - 1000)/2 )+"px");

	$('.showmemore').css("left",(mainwidthsize01 - 100)+"px");
	// $('.showmemore').css("left",($( window ).width() - 110)+"px");

});

$(function(){



	$(window).resize(function(){

		var sizeme = $('#sizeme89').width();

		sizeme;

		var showmemore = $('.showmemore');
		showmemore.css("left", (sizeme - 50)+"px");
	});
});