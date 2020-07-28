$(function(){
	var hoverme = $('.ubo__nav__dropdown');
	var outme = $('.ubo__nav__wrap');
	var showme = $('.ubo__nav__dropdown__content');

	var toggler0 = 0 ; 
	var toggler1 = 0 ; 
	var toggler2 = 0 ; 
	var toggler3 = 0 ; 
// querySelectorAll();
	// var sth=0;
	var widthsize0 = $( window ).width();

// 서브메뉴 좌우 크기 넣기 

		$('.ubo__nav__dropdown__content').css("left",((widthsize0 - 1000)/2 )+"px");
		$('.ubo__nav__dropdown__content').css("right",((widthsize0 - 1000)/2 )+"px");

	$(window).resize(function(){
		var widthsize0 = $( window ).width();
		// $('.ubo__nav__dropdown__content').remove('');
		if(widthsize0 > 999){

			$('.ubo__nav__dropdown__content').css("left",((widthsize0 - 1000)/2 )+"px");
			$('.ubo__nav__dropdown__content').css("right",((widthsize0 - 1000)/2 )+"px");
		}
		else if(widthsize0 > 450){

			$('.ubo__nav__dropdown__content').css("left","0");
			$('.ubo__nav__dropdown__content').css("right","0");
		}
		else{

			$('.ubo__nav__dropdown__content').css("left","0");
			$('.ubo__nav__dropdown__content').css("right","-200px");
		}
	})
	

	outme.mouseleave(function(){
		showme.removeClass('showitplease');
	});


	hoverme.eq(0).mouseenter(function(){
		if(toggler1 ==1){
			showme.eq(1).removeClass('showitplease');
			toggler1=0;
		}
		if(toggler2 ==1){
			showme.eq(2).removeClass('showitplease');
			toggler2=0;
		}
		showme.eq(0).addClass('showitplease');
		toggler0 =1;
	});


	hoverme.eq(1).mouseenter(function(){
		if(toggler0 ==1){
			showme.eq(0).removeClass('showitplease');
			toggler0=0;
		}
		if(toggler2 ==1){
			showme.eq(2).removeClass('showitplease');
			toggler2=0;
		}
		showme.eq(1).addClass('showitplease');
		toggler1=1;
	});


	hoverme.eq(2).mouseenter(function(){
		if(toggler0 ==1){
			showme.eq(0).removeClass('showitplease');
			toggler0=0;
		}
		if(toggler1 ==1){
			showme.eq(1).removeClass('showitplease');
			toggler1=0;
		}
		showme.eq(2).addClass('showitplease');
		toggler2=1;
	});


	// hoverme.eq(3).mouseenter(function(){
	// 	if(toggler0 ==1){
	// 		showme.eq(0).removeClass('showitplease');
	// 		toggler0=0;
	// 	}
	// 	if(toggler1 ==1){
	// 		showme.eq(1).removeClass('showitplease');
	// 		toggler1=0;
	// 	}
	// 	showme.eq(3).addClass('showitplease');
	// 	toggler2=1;
	// });
});


        //         window.onscroll = function() {myFunction()};

        // // var navbar = document.getElementById("topmenu1"); masthead
        // // var navbar = document.getElementById("topmenu1");
        // var navbar = document.getElementById("topmenu1");
        // var sticky = navbar.offsetTop;

        // function myFunction() {
        //   if (window.pageYOffset >= sticky+80) {
        //     navbar.classList.add("j_sticky")
        //     // navbar.classList.remove("masthead");
        //     console.log("되냐?");
        //   } else {
        //     navbar.classList.remove("j_sticky");
        //   }
        // }