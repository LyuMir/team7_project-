function createClub(){
	$('#createClub').submit();
}
function editClub(req){
	var id = $(req).parent('.wrapEn0').find('.card__idhere').attr('id');

	$('#editClub').children('#clubid').val(id);

	$('#editClub').submit();
}
function deleteClub(req){
	var id = $(req).parent('.wrapEn0').find('.card__idhere').attr('id');
	$('#deleteClub').children('#clubid2').val(id);
	var confirmE = confirm("해당 소모임을 삭제하시겠습니까?");
	if(confirmE){
		$('#deleteClub').submit();	//페이지 왔다갔다 하는 대신 ajax로 되나 한번 볼꺼임.

		// $(req).closest('article.grid__item').slideToggle(600);
		// alert('??');
		// alert($(req).closest('article.grid__item').find('.editit').text());

		// $.ajax({
		// url : 'club_delete.jsp' ,  //'id__validate__.jsp',

		// data : {'clubid':id}, // key : value, key : value , ... 여러개 가능 

		// dataType : 'text',

		// success : function(req){
		// 	alert('소모임이 삭제되었습니다.');
		// 	},
		// });
	}
}
function gotoClub(req){
	var id =$(req).parent('.wrapEn0').find('.card__idhere').attr('id');
	$('#gotoClub').children('#clubid3').val(id);
	$('#gotoClub').submit();
}

function gotoClub2(req){
	var id =$(req).find('.card__idhere').attr('id');
	$('#gotoClub').find('#clubid3').val(id);
	$('#gotoClub').submit();
	
}


// $('form').css('display','none');