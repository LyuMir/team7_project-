
// 회원가입 및 로그인 페이지의 js 파일입니다. 

	const container = document.getElementById('joiner_container');

	const nEXTSTEP1 = document.getElementById('NEXTSTEP1');
	const nEXTSTEP11 = document.getElementById('NEXTSTEP1_1');
	const nEXTSTEP12 = document.getElementById('NEXTSTEP1_2');
	const nEXTSTEP2 = document.getElementById('NEXTSTEP2');
	const nEXTSTEP3 = document.getElementById('NEXTSTEP3');
	const nToLogIn = document.getElementById('TOLOGIN');
	const nToJoin = document.getElementById('toJoin');

	var whichtab = 1;

	var joinclass1 = document.getElementById("joinC1");

	var tab_pic = $(".joiner_container_picture");
	var tab1 = $(".joiner_container1");
	var tab2 = $(".joiner_container2");
	var tab3 = $(".joiner_container3");
	var tab4 = $(".joiner_container2_2");
	var tab5 = $(".joiner_container3_2");
	var tab_login = $(".joiner_container00");


	var good_to_go_1 = "0";
	var good_to_go_2 = "0";
	var good_to_go_3 = "0";
	var good_to_go_4 = "0";
	var good_to_go_5 = "0";
	var good_to_go_6 = "0";


		var closeModal = $('#closeModal');
		var modalSystem = $('#my_joiner');

	function goodtogo(){
		good_to_go_1 = go0* go1*go2*go3*go4;
	}
// function refresh00(){
// 	document.refresh();
// }
// function ref22(){
// 	alert('과연?');
// 	document.refresh();
// }

		nEXTSTEP11.addEventListener('click', () => {
			goodtogo();
			if(good_to_go_1 != "1")	{
				$('#NEXTSTEP1_1').addClass('borderNO');
				inputs.eq(0).focusout();
				inputs.eq(1).focusout();
				inputs.eq(2).focusout();
				inputs.eq(3).focusout();
				inputs.eq(4).focusout();
				return;
			} 
				$('#NEXTSTEP1_1').removeClass('borderNO');
				$('#NEXTSTEP1_2').removeClass('borderNO');

			tab_to_2();
		});


		nEXTSTEP12.addEventListener('click', () => {
			goodtogo();
			if(good_to_go_1 != "1")	{
				$('#NEXTSTEP1_2').addClass('borderNO');
				inputs.eq(0).focusout();
				inputs.eq(1).focusout();
				inputs.eq(2).focusout();
				inputs.eq(3).focusout();
				inputs.eq(4).focusout();
				return;
			} 
				$('#NEXTSTEP1_2').removeClass('borderNO');
				$('#NEXTSTEP1_1').removeClass('borderNO');

			tab_to_3();
		});

		nEXTSTEP2.addEventListener('click',() => {
		//	tab1.toggleClass('opacity0_7');
			tab_to_4();
		});

		nEXTSTEP3.addEventListener('click',() => {
			tab_to_5();
		});


		function tab_to_2(){
							tab4.removeClass('zbehind');
			if( whichtab == 1){
				tab2.removeClass('zbehind');
					whichtab =2;
				nEXTSTEP11.innerHTML="일반사용자<br>이전으로";
				tab1.addClass('opacity0_7');
				tab1.toggleClass("next_step");
			}
			else if(whichtab ==3){

				nEXTSTEP11.innerHTML="일반사용자<br>이전으로";
				nEXTSTEP12.innerHTML="전문가<br>회원가입";
				tab2.removeClass('zbehind');
				whichtab =2;
			}
			else{
				whichtab =1;
				nEXTSTEP11.innerHTML="일반사용자<br>회원가입";
				tab1.removeClass('opacity0_7');
				tab1.toggleClass("next_step");
			}
		};

		function tab_to_3(){
			if( whichtab ==1){

				tab2.addClass('zbehind');
				tab4.addClass('zbehind');
				nEXTSTEP12.innerHTML="전문가<br>이전으로";
				tab1.addClass('opacity0_7');

				whichtab=3;
				tab1.toggleClass("next_step");
			}
			else if(whichtab ==2){

				nEXTSTEP11.innerHTML="일반사용자<br>회원가입";
				nEXTSTEP12.innerHTML="전문가<br>이전으로";
				tab2.addClass('zbehind');
			// tab2.addClass('next_step');
			// tab2.addClass('zbehind');
				tab3.removeClass('next_step');
				tab4.addClass('zbehind');
				whichtab =3;
			}
			else{
				tab2.removeClass('zbehind');
				tab4.removeClass('zbehind');
				nEXTSTEP12.innerHTML="전문가<br>회원가입";
				tab1.removeClass('opacity0_7');
				whichtab=1;
				tab1.toggleClass("next_step");
			}
		};

		function tab_to_4(){
						if(whichtab==2){
				whichtab=4;

				tab1.addClass('opacity0');
				tab2.addClass('next_step');
				tab2.addClass('opacity0_7');
				nEXTSTEP2.innerHTML="이전 단계로";
			}
			else{
				tab1.removeClass('opacity0');
				tab2.removeClass('next_step');
				tab2.removeClass('opacity0_7');
				whichtab=2;
				nEXTSTEP2.innerHTML="다음 단계로";

			}
		};

		function tab_to_5(){
			tab1.toggleClass('opacity0');
			if(whichtab==3){
				whichtab=5;

				tab2.addClass('opacity0');
				tab3.addClass('next_step');
				tab3.addClass('opacity0_7');
				nEXTSTEP3.innerHTML="이전 단계로";
			}
			else{
				tab2.removeClass('opacity0');
				tab3.removeClass('next_step');
				tab3.removeClass('opacity0_7');
				whichtab=3;
				nEXTSTEP3.innerHTML="다음 단계로";

			}
		};
	function adress_1(){
		$('.joiner_container2').children('h1').text("일반 사용자 ");
		$('.joiner_container2').children('h2').html("<br>주소를 입력해주세요. ");
		$('.joiner_container2').children('span').html("헬스, 건강관리, 소모임... <br> 모든 기능을 자유롭게 이용하실 수 있습니다. ");

	}

	function adress_2(){
		$('.joiner_container2').children('h1').text("전문가 ");
		$('.joiner_container2').children('h2').html("<br>직장주소를 입력해주세요. ");
		$('.joiner_container2').children('span').text("헬스 트레이너, 건강 관리사, 의사, 한의사 등 전문가를 위한 기능을 사용할 수 있습니다.");

	}



	nToLogIn.addEventListener('click', () => {
		tab_pic.addClass("ztop");
		if(tab1.hasClass("next_step")){
			tab1.removeClass("opacity0_7");
			tab1.addClass("opacity0");
		//	tab1.addClass("ztop");
		}
		else{
			tab1.addClass("dismiss");
		}
		if(tab2.hasClass("next_step")){
			tab2.removeClass("opacity0_7");
			tab2.addClass("opacity0");
		}
		else{
			tab2.addClass("dismiss");
		}
		tab3.addClass("dismiss");
		tab4.addClass("dismiss");
		tab5.addClass("dismiss");
	});


	nToJoin.addEventListener('click', () => {

		tab_pic.removeClass("ztop");
		tab_login.removeClass("login_step");
		tab1.removeClass("opacity0");
		tab1.removeClass("dismiss");
	//	tab1.removeClass("ztop");
		tab2.removeClass("opacity0");
		tab2.removeClass("dismiss");
		tab3.removeClass("opacity0");
		tab3.removeClass("dismiss");
		tab4.removeClass("opacity0");
		tab4.removeClass("dismiss");
		tab5.removeClass("dismiss");
		
		if(tab1.hasClass("next_step")){
			tab1.addClass("opacity0_7");
		}

	});

	var inputs = $("input");
	var outputs = $(".output01");


	// inputs.eq(1).focusout(function(){okornot(inputs.eq(1),1);});

	// function okornot(that,num =0 , that2 = false){
	// 	if(that2){
	// 		that.removeClass("borderNO");
	// 		outputs.eq(num).children('.nogo').text("");
	// 	}
	// 	else{
	// 		that.addClass("borderNO");
	// 		outputs.eq(num).children('.nogo').text("이름 어쩌구 저쩌구 ");
	// 	}
	// };
	var go0,go1,go2,go3,go4,go5,go6,go7,go8,go9,go10,go11;

	//good_to_go_1

	//아이디
	var okt0 = true;
	inputs.eq(0).focusout(function(){
		var i = 0 ;
		var thone = inputs.eq(0).val();
		

		// else{
		// 	okt = false;
		// }
		$.ajax({
			url : './9oldjsp/id__validate.jsp' ,  //'id__validate__.jsp',

			data : {'input1':thone}, // key : value, key : value , ... 여러개 가능 

			dataType : 'text',

			success : function(req){
				if(thone==""){
					dontgo(i);
					noBecause("아이디를 입력해주세요.",i);
				}
				else if((thone.length) < 3){
					dontgo(i);
					noBecause("3글자 이상 입력하세요.  ",i);
				}
				else if(thone.length >15){
					dontgo(i);
					noBecause("15자 미만으로 입력하세요.  ",i);
				}
				else if(!req.includes('o')){
					dontgo(i);
					noBecause("중복되는 아이디가 있습니다. ",i);
				}
				else{
					gogo(i);
					noBecause(thone+" : 사용하실 수 있습니다. ",i,"green");	
					go0 = 1; 
				}
			},
		});
		// else if(checkit(/^[a-z][a-z\d]{3,35}$/,thone)){
		// 	dontgo(i);
		// 	noBecause("영문, 숫자, '-','_' 포함 3자 이상 입력해주세요.",i);
		// }
	//	validate_check(thone,'id__validate.jsp');
		// else if(validate_check(thone,'id__validate.jsp')=="ㄱㅊ"){
		// else if(re0=="123"){
		// 	dontgo(i);
		// 	noBecause("중복되는 아이디가 있습니다. ",i);
		// 	//noBecause(okok,i);
		// }
		// else{
		// 	gogo(i);
		// 	noBecause(thone+" : 사용하실 수 있습니다. ",i,"green");	
		// 	go0 = 1; return;
		// }
		go0 = 0;
	});

		//이름
	inputs.eq(1).focusout(function(){
		var i = 1 ;
		var thone = inputs.eq(i).val();
		if(thone==""){
			dontgo(i);
			noBecause("이름을 입력해주세요.",i);
		}
		else if(checkSpace(thone)){
			dontgo(i);
			noBecause("공백을 포함할 수 없습니다.",i);
		}
		else if(checkSpecial(thone)){
			dontgo(i);
			noBecause("특수문자를 포함할 수 없습니다.",i);
		}
		else{
			gogo(i);
			noBecause("환영합니다! "+thone+"님!",i,"green");
			go1 = 1; return;
		}
		go1 = 0;
	});

		//이메일 
	inputs.eq(2).focusout(function(){
		var i = 2 ;
		var thone = inputs.eq(i).val();
		// else if(checkit(/^[a-z][a-z\d]{3,35}$/,thone)){
		// 	dontgo(i);
		// 	noBecause("영문, 숫자, '-','_' 포함 3자 이상 입력해주세요.",i);
		// }
		$.ajax({
			url : './9oldjsp/email__validate.jsp' ,  //'id__validate__.jsp',

			data : {'input1':thone}, // key : value, key : value , ... 여러개 가능 

			dataType : 'text',

			success : function(req){
				if(thone==""){
					dontgo(i);
					noBecause("이메일을 입력해주세요.",i);
				}
				else if(!checkEmail(thone)){
					dontgo(i);
					noBecause("이메일 형식이 아닙니다. ",i);
				}
				else if(!req.includes('o')){
					dontgo(i);
					noBecause("중복되는 이메일이 있습니다. ",i);
				}
				else{
					gogo(i);
					noBecause(thone+" : 사용하실 수 있습니다. ",i,"green");	
					go2 = 1;
				}
			}
		});
		// else{
		// 	gogo(i);
		// 	noBecause(thone+" : 사용하실 수 있습니다. ",i,"green");
		// 	go2 = 1; return;
		// }
		go2 = 0;
	});

		//비밀번호 
	inputs.eq(3).focusout(function(){
		var i = 3 ;
		var thone = inputs.eq(i).val();
		if(thone==""){
			dontgo(i);
			noBecause("비밀번호를 입력해주세요.",i);
		}
		else if(!checkPasswordPattern(thone)){
			dontgo(i);
			noBecause("영문, 숫자, 특수문자 포함 8자 이상 입력해주세요.",i);
		}
		else{
			gogo(i);
			noBecause("",i);
			go3 = 1; return;
		}
		go3 = 0;
	});

		//비밀번호 2
	inputs.eq(4).focusout(function(){
		var i = 4 ;
		var thone = inputs.eq(i).val();
		if(thone ==""){
			dontgo(i);
			noBecause("",i);
		}
		else if(thone!=inputs.eq(3).val()){
			dontgo(i);
			noBecause("비밀번호가 일치하지 않습니다.",i);
		}
		else{
			gogo(i);
			noBecause("비밀번호 일치",i,"green");
			go4 = 1; return;
		}
		go4 = 0;
	});



	function noBecause(st = "",int,green = null){
		outputs.eq(int).children('.nogo').text(st);
			outputs.eq(int).css('color','red');

		if(green){
			outputs.eq(int).css('color','green');
		}
	}

	function dontgo(int){
		inputs.eq(int).addClass("borderNO");
		inputs.eq(int).removeClass("borderOK");
	}

	function gogo(int){
		inputs.eq(int).removeClass("borderNO");
		inputs.eq(int).addClass("borderOK");
	}


	function checkit(okone,thatone){
		if(okone.test(thatone)){
			return true;
		}
		return false;
	}



// 공백이 있나 없나 체크 
function checkSpace(str) {
	if(str.search(/\s/) != -1) 
		{ return true; } 
	else { return false; } 
}

// 특수 문자가 있나 없나 체크 
function checkSpecial(str) {
	 var special_pattern = /[`~!@#$%^&*|\\\'\";:\/?]/gi; 
 	if(special_pattern.test(str) == true) { 
 		return true; } 
	else { return false; } //문제없음이 F.
}

function checkPasswordPattern(str) { 
	var pattern1 = /[0-9]/; // 숫자 
	var pattern2 = /[a-zA-Z]/; // 문자 
	var pattern3 = /[~!@#$%^&*()_+|<>?:{}]/; // 특수문자 
	if(!pattern1.test(str) || !pattern2.test(str) || !pattern3.test(str) || str.length < 8) { 
	//	alert("비밀번호는 8자리 이상 문자, 숫자, 특수문자로 구성하여야 합니다."); 
		return false; 
	} 
	else { 
		return true; //이건 괜찮다가 T. 
	} 
}
//출처: https://holybell87.tistory.com/30#.Xv6Aa0UzZ7c [K's 개발이야기]

// 이메일이 잘못되었는지 확인하는 함수 

function checkEmail(str)

{                                                 
     var reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
     if(!reg_email.test(str)) {                            
          return false;         
     }                            
     else {                       
          return true;         
     }                            
}                       
//출처: https://doolyit.tistory.com/104 [동해둘리의 IT Study]



	var joinerForm = $("#joinerForm");
//	var loginForm = $("#loginForm");
	var join_type = $('#join_type');
	function cl1join(){
		var agreecheck1 = $('#form_check_ZZZ1');
		join_type.val("일반회원");
			$('#form_check_ZZZ1_bo').removeClass('borderNO');
		if( agreecheck1.is(":checked") ){
			$('#joinerForm').submit();
		}
		else{
			//dontgo(17);
			$('#form_check_ZZZ1_bo').addClass('borderNO');
			alert("정보 제공 동의에 체크하셔야 합니다. ");
		}
	//	gogo(17);

	};

	function cl2join(){
		var agreecheck2 = $('#form_check_ZZZ2');
		join_type.val("전문가 회원");
		var select_field = $('#select_field');
		$('#form_check_ZZZ2_bo').removeClass('borderNO');

		if($("#select_field option:selected").val()=="notthisone"){
			select_field.addClass("borderNO");
			alert("전문 분야를 선택해주세요. ");
		}
		else if( agreecheck2.is(":checked") ){
			$('#joinerForm').submit();
		}
		else{
			dontgo(26);
			$('#form_check_ZZZ2_bo').addClass('borderNO');
			alert("정보 제공 동의에 체크하셔야 합니다.123 ");
		}
		// gogo(26);
			select_field.removeClass("borderNO");
			//$('#form_check_ZZZ2_bo').css('border-bottom','none');


	};

	// function okgo(){
	// 	this.addClass('borderok');
	// };

	function logingo(){

	//	var wanttoL = $('#LOGINplz');
		// wanttoL.text('loginplz');
	//	wanttoL.val('loginplz22');
	var login_id = $('#log_id').val();
	var login_pw = $('#log_pw').val();
		$('#log_id2').val(login_id);
		$('#log_pw2').val(login_pw);

		$('#LOGINFormplz').submit();
	};


	$(window).resize(function(){
		// var height0 = $(window).height();
		var height0 = $('#my_joiner').height();
		var height1 = height0 - 10;
		// $(".my_middler").css('height',height1);
		// $(".my_middler").css('height',height1);


		// var width0 = $(window).width();
		var width0 = $(window).width();
		var width1 = ((width0 - 820) /2);
		var height2 = (((height0 - 600) /2) - 30);

		if(width1 > 0){
			$('.logo_loc').css('right',width1);
		}
		else{
			$('.logo_loc').css('right',0);
		}
		$('.logo_loc').css('top',height2);
		$('#joiner_container').css('top',height2 + 45);

	});
	// window.function(){
	// 	$(".my_middler").css("height:");
	// }

	var output011s =  $(".output011");

	// window.onload = function(){	///huh??
		var width0 = $(window).width();
		var width1 = ((width0 - 820) /2);
		// var height0 = $(window).height();
		var height0 = $('#my_joiner').height();
		var height2 = (((height0 - 600) /2) - 30);
		var height1 = height0 - 10;
		// $(".my_middler").css('height',height1);
		// var height00 = $('#my_joiner').height();
		// $(".my_middler").css('height',height00);

		$('.logo_loc').css('top',height2);
		$('#joiner_container').css('top',height2 + 45);
		if(width1 > 0){
			$('.logo_loc').css('right',width1);
		}
		else{
			$('.logo_loc').css('right',0);
		}
		var height555 = (($('#my_joiner').height() - 600) /2);
		// $('#joiner_container').css('top',height555);

		//alert(fail2);
	//	alert(log_id+"<로그인된 아이디");

		if(fail2 !="null"){
			loginModalgo(fail2);
			// alert(fail2);
			// modalSystem.removeClass('disnoneR');
			// $('#TOLOGIN').click();
			// var i = 5;
			// dontgo(i);
			// noBecause(fail2,i);
		}
		if(whatdo !="null"){
			if(whatdo == "join"){

			}
			else{
				joinModalgo();
				// modalSystem.removeClass('disnoneR');
				// $('#TOLOGIN').click();
			}
		}
		// if(fail2 !="null"){
		// 	$('#toJoin').click();
		// 	var i = 6;
		// 	dontgo(i);
		// 	noBecause(fail2,i);
		// 	//alert("???");
		// }

		// if(fail2 == "비밀번호가 일치하지 않습니다. "){
		// //	$('#toJoin').trigger("click");
		// 	$('#toJoin').click();
		// 	nToJoin.click();
		// 	var i = 6;
		// 	dontgo(i);
		// 	noBecause(fail2,i);
		// }
	// };


		closeModal.click(function(){
			modalSystem.addClass('disnoneR');
		});

		function loginModalgo(fail = ""){
			modalSystem.removeClass('disnoneR');
					if(fail != ""){
						alert(fail);
						$('#TOLOGIN').click();
						var i = 5;
						dontgo(i);
						noBecause(fail,i);
					}
			setTimeout( $('#TOLOGIN').click() , 1500);
		}
		function joinModalgo(){
			modalSystem.removeClass('disnoneR');
			setTimeout( $('#toJoin').click() , 1500);
		}



	// window.onload = function(){
	// 	nToJoin.click();
		
	// }
