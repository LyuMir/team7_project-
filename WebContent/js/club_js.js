


var meeting_pubText = "";
var meeting_memGet = $('#meeting_memGet');
var meetinghtml = "";



//	alert(	$('#meetingDate_select option:selected').val() );

$('#meetingDate_select').change(function(){
//	alert($(this).val());

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
	}
	$('#meetingDate_week').html(meetinghtml);
});

$('#meeting_publicity').change(function(){
	if($(this).val() == "open"){
		meeting_pubText = "소모임을 공개합니다. 데일리헬스에 회원가입한 누구나 볼 수 있습니다.  ";
	}
	else if($(this).val() == "local_open"){
		meeting_pubText = "같은 지역의 회원에게 소모임을 공개합니다.  ";
	}
	else if($(this).val() == "friend_only"){
		meeting_pubText = "소모임의 멤버와 친구 추가 된 회원에게만 공개됩니다.  ";
	}
	else{
		meeting_pubText = "공개성을 선택해주세요. ";
	}
	$('#meeting_pubText').html(meeting_pubText);
});

$('input[name="club_memberJoin"]').change(function(){
	//alert('sdfsdf');
	if($(this).val()==1){
	// 	meeting_memGet.children().css('display:none');
	// 	alert('sdfff');
	// //	meeting_memGet.children().eq(1).css('display',"");
	// 	meeting_memGet.children().eq(1).css('display:inline-block');
	meeting_memGet.children().addClass('no_displ');
	meeting_memGet.children().eq(0).removeClass('no_displ');
	}
	else if($(this).val()==2){
		meeting_memGet.children().addClass('no_displ');
		meeting_memGet.children().eq(1).removeClass('no_displ');
	}
	else if($(this).val()==3){
		meeting_memGet.children().addClass('no_displ');
		meeting_memGet.children().eq(2).removeClass('no_displ');
	}
	else if($(this).val()==4){
		meeting_memGet.children().addClass('no_displ');
		meeting_memGet.children().eq(3).removeClass('no_displ');
	}
});

//meeting_pubText

// meeting_sender에 미팅데이트 넣고 보내기. 

var greentogo = 1;

function formSender(){
	var sth = $('#meetingDate_week').text();
//alert(sth);
	$('#meetingDate_sender').text(sth);

	if( greentogo== 1 ){
		alert('굿');
		$('#club_creator_form').submit();
	}
	//$('#club_creator_form').
}










 // var cnt = new Array();
 // cnt[0] = new Array('전체');
 // cnt[1] = new Array('전체','강남구','강동구','강북구','강서구','관악구','광진구','구로구','금천구','노원구','도봉구','동대문구','동작구','마포구','서대문구','서초구','성동구','성북구','송파구','양천구','영등포구','용산구','은평구','종로구','중구','중랑구');
 // cnt[2] = new Array('전체','강서구','금정구','남구','동구','동래구','부산진구','북구','사상구','사하구','서구','수영구','연제구','영도구','중구','해운대구','기장군');
 // cnt[3] = new Array('전체','남구','달서구','동구','북구','서구','수성구','중구','달성군');
 // cnt[4] = new Array('전체','계양구','남구','남동구','동구','부평구','서구','연수구','중구','강화군','옹진군');
 // cnt[5] = new Array('전체','광산구','남구','동구','북구','서구');
 // cnt[6] = new Array('전체','대덕구','동구','서구','유성구','중구');
 // cnt[7] = new Array('전체','남구','동구','북구','중구','울주군');
 // cnt[8] = new Array('전체','고양시','과천시','광명시','구리시','군포시','남양주시','동두천시','부천시','성남시','수원시','시흥시','안산시','안양시','오산시','의왕시','의정부시','평택시','하남시','가평군','광주시','김포시','안성시','양주군','양평군','여주군','연천군','용인시','이천군','파주시','포천시','화성시');
 // cnt[9] = new Array('전체','강릉시','동해시','삼척시','속초시','원주시','춘천시','태백시','고성군','양구군','양양군','영월군','인제군','정선군','철원군','평창군','홍천군','화천군','황성군');
 // cnt[10] = new Array('전체','제천시','청주시','충주시','괴산군','단양군','보은군','영동군','옥천군','음성군','진천군','청원군');
 // cnt[11] = new Array('전체','공주시','보령시','서산시','아산시','천안시','금산군','논산군','당진군','부여군','서천군','연기군','예산군','청양군','태안군','홍성군');
 // cnt[12] = new Array('전체','군산시','김제시','남원시','익산시','전주시','정읍시','고창군','무주군','부안군','순창군','완주군','임실군','장수군','진안군');
 // cnt[13] = new Array('전체','광양시','나주시','목포시','순천시','여수시','여천시','강진군','고흥군','곡성군','구례군','담양군','무안군','보성군','신안군','여천군','영광군','영암군','완도군','장성군','장흥군','진도군','함평군','해남군','화순군');
 // cnt[14] = new Array('전체','경산시','경주시','구미시','김천시','문겅시','상주시','안동시','영주시','영천시','포항시','고령군','군위군','봉화군','성주군','영덕군','영양군','예천군','울릉군','울진군','의성군','청도군','청송군','칠곡군');
 // cnt[15] = new Array('전체','거제시','김해시','마산시','밀양시','사천시','울산시','진주시','진해시','창원시','통영시','거창군','고성군','남해군','산청군','양산시','의령군','창녕군','하동군','함안군','함양군','합천군');
 // cnt[16] = new Array('전체','서귀포시','제주시','남제주군','북제주군');

 // // function change(add) {
 // // var sel=document.form.county;
 // //   for (i=sel.length-1; i>=0; i--){
 // //     sel.options[i] = null;
 // //     }
 // //   for (i=0; i < cnt[add].length;i++){                    
 // //                     sel.options[i] = new Option(cnt[add][i], cnt[add][i]);
 // //     }        
 // // }
 // function areaSelector(rr){
 // 	var sel00 = $(this).val();
 // 	for(i = 0 ; i< sel00.length; i++){
 // 		sel00.options[i] = null;
 // 	}
 // 	for (var i = 0; i < cnt[add].length; i++) {
 // 		sel00.options[i] = new Option(cnt[add][i],cnt[add][i]);
 // 	}

 // }