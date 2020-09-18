


setTimeout(fo(),1000);

function fo(){
	$('#club_name').focus();
	// $('#club_name').focusout();
	$('#club_name').blur();
}
var meeting_pubText = "";
var meeting_memGet = $('#meeting_memGet');
var meetinghtml = "";

var greentogo = 0;
var greentogo0 = 0;
var greentogo1 = 0;
var greentogo2 = 0;
var greentogo3 = 0;
var photoed1 = 0;
var photoed2 = 0;
var photook = 0 ;
// var outputs = $(".output01");

var inputs = $('input');
$(document).ready(function(){

	//	alert(	$('#meetingDate_select option:selected').val() );

	$('#meetingDate_select').change(md());
	//	alert($(this).val());
	function md(){
		greentogo1 = 1;
		if($(this).val() == "meeting1"){
			meetinghtml="매주 <select name='meeting_week1'>	<option value='월'>월</option>	<option value='화'>화</option>	<option value='수'>수</option>	<option value='목'>목</option>	<option value='금'>금</option>	<option value='토'>토</option>	<option value='일'>일</option></select>요일";
		}
		else if($(this).val() == "meeting2"){
			meetinghtml="매 <select name='meeting_week1'><option value='1'>1</option><option value='2'>2</option><option value='3'>3</option><option value='4'>4</option></select>번째 주 <select name='meeting_week2'>	<option value='월'>월</option>	<option value='화'>화</option>	<option value='수'>수</option>	<option value='목'>목</option>	<option value='금'>금</option>	<option value='토'>토</option>	<option value='일'>일</option></select>요일";
		}
		else if($(this).val() == "meeting3"){
			meetinghtml="매달 <select name='meeting_week1'><option value='1'>1</option><option value='2'>2</option><option value='3'>3</option><option value='4'>4</option></select>번째 <select name='meeting_week2'>	<option value='월'>월</option>	<option value='화'>화</option>	<option value='수'>수</option>	<option value='목'>목</option>	<option value='금'>금</option>	<option value='토'>토</option>	<option value='일'>일</option></select>요일";
		}
		else{
			meetinghtml = "&emsp; &emsp;&emsp; &emsp;"
			greentogo1 = 0;
		}
		$('#meetingDate_week').html(meetinghtml);
	}

	$('#meeting_publicity').change(mp());

	function mp(){
			greentogo2 = 1;
			if($(this).val() == "open"){
				meeting_pubText = "소모임을 공개합니다. 데일리헬스에 존재하는 회원은 누구나 볼 수 있습니다.  ";
			}
			else if($(this).val() == "local_open"){
				meeting_pubText = "같은 지역의 회원에게 소모임을 공개합니다.  ";
			}
			else if($(this).val() == "friend_only"){
				meeting_pubText = "소모임의 멤버와 친구 추가 된 회원에게만 공개됩니다.  ";
			}
			else{
				meeting_pubText = "공개성을 선택해주세요. ";
				greentogo2=0;
			}
			$('#meeting_pubText').html(meeting_pubText);
	}

	$('input[name=club_memberJoin]').change(function(){
		//alert('sdfsdf');
		if($(this).val()=="공개 모집"){
		// 	meeting_memGet.children().css('display:none');
		// //	meeting_memGet.children().eq(1).css('display',"");
		// 	meeting_memGet.children().eq(1).css('display:inline-block');
		$('#meeting_memGet').children().addClass('no_displ');
		$('#meeting_memGet').children().eq(0).removeClass('no_displ');
		}
		else if($(this).val()=="제한 모집"){
			$('#meeting_memGet').children().addClass('no_displ');
			$('#meeting_memGet').children().eq(1).removeClass('no_displ');
		}
		else if($(this).val()=="초대 모집"){
			$('#meeting_memGet').children().addClass('no_displ');
			$('#meeting_memGet').children().eq(2).removeClass('no_displ');
		}
		else if($(this).val()=="모집 중단"){
			$('#meeting_memGet').children().addClass('no_displ');
			$('#meeting_memGet').children().eq(3).removeClass('no_displ');
		}
		greentogo3=1;
	});

	// $('input[type="file"]').each(function(index,item){
	// 	$(item).change(function(){

	// 	});
	// });

	$('#club_name').focusout(function(){
		greentogo0 = 0 ;

		var thone = $('#club_name').val();
		// alert(thone);
		// alert('sdf');
		var i = 0 ;

		// 중복 이름 확인 절차 ㄱㄱ
		$.ajax({
				url : './9oldjsp/__club_name__validate.jsp', //문서 위치.

				dataType : 'text',

				data : {'input1':thone}, // key : value, key : value , ... 여러개 가능

				dataType : 'text',

				success : function(req){
					if(thone==""){
						dontgo(i);
						noBecause("이름을 입력해주세요.",i);
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
						noBecause("중복되는 소모임이 있습니다. ",i);

					}
					else{
						gogo(i);
						noBecause("소모임 이름 : '"+thone+"' : 사용하실 수 있습니다. ",i,"green");
						greentogo0 = 1;
					}
				}

			});

	});



});


	function dontgo(int0){
		inputs.eq(int0).addClass("borderNO");
		inputs.eq(int0).removeClass("borderOK");
	}

	function gogo(int0){
		inputs.eq(int0).removeClass("borderNO");
		inputs.eq(int0).addClass("borderOK");
	}

	function noBecause(st = "",int0,green = null){
		$('#output01').text(st);
		$('#output01').css('color','red');

		if(green){
			$('#output01').css('color','green');
		}
	}

	function formSender() {
		var sth = $('#meetingDate_week').text();
		$('#meetingDate_sender').text(sth);

		greentogo = greentogo3 * greentogo2 * greentogo1 * greentogo0;


		if(photook != 1){
			alert('..');
			var confirm0 = confirm('사진을 채우지 않고 계속하시겠습니까? 사진을 올린 후 포토 업로드 버튼 누르기를 잊지 마세요. ');
			if(!confirm0){
				return;
			}

		}

		if( greentogo== 1 ){
			$('#club_creator_form').submit();
		}
		else if(greentogo0 == 0 ){
			alert('모임 이름을 정해주세요. ');
		}
		else if(greentogo2 ==0){
			alert('모임 공개성을 선택해주세요. ');
		}
		else if(greentogo3 ==0){
			alert('모임 모집을 선택해주세요. ');
		}
		else if(greentogo1 == 0 ){
			alert('모임 정기모임 시간을 선택해주세요. ');
		}
	}

	function formSender2() {
		var sth = $('#meetingDate_week').text();
		$('#meetingDate_sender').text(sth);

		greentogo = greentogo3 * greentogo2 * greentogo1 * 1;

		if( greentogo== 1 ){
			$('#club_creator_form').submit();
		}
		else if(greentogo2 ==0){
			alert('모임 공개성을 선택해주세요. ');
		}
		else if(greentogo3 ==0){
			alert('모임 모집을 선택해주세요. ');
		}
		else if(greentogo1 == 0 ){
			alert('모임 정기모임 시간을 선택해주세요. ');
		}
		// else if(greentogo0 == 0 ){
		// 	alert('모임 이름을 정해주세요. ');
		// }
	}

	// //$('input[type="checkbox"]').check
	// $('.checkme').each(function(index,item){

	// 	$(item).click(function(){
	// 		if($(item).children('input').attr("checked")){
	// 			$(item).children('input').attr("checked",false);
	// 		}
	// 		else
	// 			$(item).children('input').attr("checked",true);
	// 	});
	// 	//$(this).is(":checked");
	// });

	function photo_upload(){
		var photo1 = $('#photo1');
		// var photo2 = $('#photo2');
		if((photo1.val() ==null || photo1.val() =="") ){

			alert("사진을 넣어주세요!");
			// var confirm0 = confirm('사진을 채우지 않고 계속하시겠습니까?');
			// if(!confirm0){
			// 	return;
			// }
		}
			$('#photo_upload').submit();
			photook=1;
	}


	function photo_upload2(){
		// var photo1 = $('#photo1');
		var photo2 = $('#photo2');
		if((photo2.val() ==null || photo2.val() =="") ){

			alert("사진을 넣어주세요!");
		}
		$('#photo_upload2').submit();
	}
