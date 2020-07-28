// <!-- ----
// ===========================

// Radial Menu : https://codepen.io/onlyveen/pen/MVaLoX // 둥그런 메뉴임. 
// =====================  -->




$(function (){
			$('.pointer').css({
				'transform' : 'rotate('+(360/($('.list li').length)*($('.list li.active').index()))+'deg)'
			});
			var angle = 0;
			$(document).on('mouseover','.list > li', function(){
				var len = $('.list li').length;
				var ths = $(this);
				var active = $('.list li.active');
				if (ths.index() >= active.index()){
					if (ths.index() - active.index() < len/2){
						angle = angle + (360/(len)*(ths.index() - active.index()));
						console.log('case-1');
					}
					else{
						angle = angle - (360/(len)*(len - ths.index() + active.index()));
						console.log('case-2');
					}
				}
				else if (ths.index() < active.index()){
					if (active.index() - ths.index() < len/2){
						angle = angle - (360/(len)*(active.index() - ths.index()));
						console.log('case-3');
					}
					else{
						angle = angle + (360/(len)*(len + ths.index() - active.index()));
						console.log('case-4');
					}
				}
				ths.addClass('active').siblings().removeClass('active');
				$('.pointer').css({
					'transform' : 'rotate('+angle+'deg)'
				});
			});
			$('.menu-trig').click(function(){
				$(this).closest('#rad').toggleClass('open');
			});
		});



// <!-- ----
// ===========================

// 사이드 메뉴 애니메이션 : https://codepen.io/flyingcar/pen/yKyVwB
// =====================  -->


// Requires jQuery

$(document).on('click','.js-menu_toggle.closed',function(e){
	e.preventDefault(); $('.list_load, .list_item').stop();
	$(this).removeClass('closed').addClass('opened');

	$('.side_menu').css({ 'left':'0px' });

	var count = $('.list_item').length;
	$('.list_load').slideDown( (count*.6)*100 );
	$('.list_item').each(function(i){
		var thisLI = $(this);
		timeOut = 100*i;
		setTimeout(function(){
			thisLI.css({
				'opacity':'1',
				'margin-left':'0'
			});
		},100*i);
	});
});

$(document).on('click','.js-menu_toggle.opened',function(e){
	e.preventDefault(); $('.list_load, .list_item').stop();
	$(this).removeClass('opened').addClass('closed');

	$('.side_menu').css({ 'left':'-250px' });

	var count = $('.list_item').length;
	$('.list_item').css({
		'opacity':'0',
		'margin-left':'-20px'
	});
	$('.list_load').slideUp(300);
});

// <!-- ----
// ===========================

// 스크롤링 presentation : https://codepen.io/brianhaferkamp/pen/jgydKe
// =====================  -->

// run this function when the window scrolls

$(window).scroll(function () {

	// find the top of each section
	var section1 = $("#section1").offset().top;
	var section2 = $("#section2").offset().top;
	var section3 = $("#section3").offset().top;
	// var section3 = $("#section3").offset().top;
	//왠진 모르겠지만 하여간 잘 안먹는듯 하다... 왜지?? 

	// number of pixels before the section to change image
	var scrollOffset = 300;




  // get the window height on scroll
  var scroll = $(window).scrollTop() + scrollOffset;

  // if scroll hits the top of section 1
  if (scroll < 500) {
    $(".grid-image img").attr(
      "src",
      "img/cssmeme01.jpg"
    );
  }

  // if scroll hits the top of section 2
  if (scroll > section2) {
    $(".grid-image img").attr(
      "src",
      "img/cssmeme02.jpg"
    );
  }

  // if scroll hits the top of section 3
  if (scroll > section3) {
    $(".grid-image img").attr(
      "src",
      "img/cssmeme2.jpg"
    );
  }
});



// <!-- ----
// ===========================

// 메뉴 중 인터렉션 : https://codepen.io/aaroniker/pen/MWgjERQ
// =====================  -->


$('data-menu').each(function() {

    let select = $(this),
        options = select.find('option'),
        menu = $('<div />').addClass('select-menu'),
        button = $('<div />').addClass('button'),
        list = $('<ul />'),
        arrow = $('<em />').prependTo(button);

    options.each(function(i) {
        let option = $(this);
        list.append($('<li />').text(option.text()));
    });

    menu.css('--t', select.find(':selected').index() * -41 + 'px');

    select.wrap(menu);

    button.append(list).insertAfter(select);

    list.clone().insertAfter(button);

});

$(document).on('click', '.select-menu', function(e) {

    let menu = $(this);

    if(!menu.hasClass('open')) {
        menu.addClass('open');
    }

});

$(document).on('click', '.select-menu > ul > li', function(e) {

    let li = $(this),
        menu = li.parent().parent(),
        select = menu.children('select'),
        selected = select.find('option:selected'),
        index = li.index();

    menu.css('--t', index * -41 + 'px');
    selected.attr('selected', false);
    select.find('option').eq(index).attr('selected', true);

    menu.addClass(index > selected.index() ? 'tilt-down' : 'tilt-up');

    setTimeout(() => {
        menu.removeClass('open tilt-up tilt-down');
    }, 500);

});

$(document).click(e => {
    e.stopPropagation();
    if($('.select-menu').has(e.target).length === 0) {
        $('.select-menu').removeClass('open');
    }
});





// <!-- ----
// ===========================

// Select-Boxes : https://codepen.io/radiantshaw/pen/oLdLRW
// =====================  -->
/* ===== Logic for creating fake Select Boxes ===== */
$('.sel').each(function() {
  $(this).children('select').css('display', 'none');
  
  var $current = $(this);
  
  $(this).find('option').each(function(i) {
    if (i == 0) {
      $current.prepend($('<div>', {
        class: $current.attr('class').replace(/sel/g, 'sel__box')
      }));
      
      var placeholder = $(this).text();
      $current.prepend($('<span>', {
        class: $current.attr('class').replace(/sel/g, 'sel__placeholder'),
        text: placeholder,
        'data-placeholder': placeholder
      }));
      
      return;
    }
    
    $current.children('div').append($('<span>', {
      class: $current.attr('class').replace(/sel/g, 'sel__box__options'),
      text: $(this).text()
    }));
  });
});

// Toggling the `.active` state on the `.sel`.
$('.sel').click(function() {
  $(this).toggleClass('active');
});

// Toggling the `.selected` state on the options.
$('.sel__box__options').click(function() {
  var txt = $(this).text();
  var index = $(this).index();
  
  $(this).siblings('.sel__box__options').removeClass('selected');
  $(this).addClass('selected');
  
  var $currentSel = $(this).closest('.sel');
  $currentSel.children('.sel__placeholder').text(txt);
  $currentSel.children('select').prop('selectedIndex', index + 1);
});



