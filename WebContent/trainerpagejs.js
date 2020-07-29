// // Get the modal
// var modal = document.getElementById("myModal");
// // 아이디 말고 다른 방식?? 

// // Get the image and insert it inside the modal - use its "alt" text as a caption
// var img = document.getElementById("myImg");
// var modalImg = document.getElementById("img01");
// var captionText = document.getElementById("caption");


// img.onclick = function(){
//   modal.style.display = "block";
//   modalImg.src = this.src;
//   captionText.innerHTML = this.alt;
// }

// // Get the <span> element that closes the modal
// var span = document.getElementsByClassName("close")[0];

// // When the user clicks on <span> (x), close the modal
// span.onclick = function() { 
//   modal.style.display = "none";
// }


// // 다른 곳 클릭 가능? 
// modal.onclick = function(){
// 	modal.style.display = "none";
// }
// var i = 0 ;
			// $('ImageForModal').each(function(){
			// 	$('ImageForModal').eq(i).click(function(){
			// 		alert("d??SDF?A?FD");
			// 		$('.modal').eq(i).css('display','block');
			// 		$('.modal-content').eq(i).attr("src",$(this).attr('src'));
			// 	});
			// 	i = i + 1 ; 
			// });
			// for (var i = 0; i < $('.ImageForModal').length; i++) {

			// for (var i = 0; i < $('.ImageForModal').length; i++) {
			// 	var k = i ;
			// 	$('.ImageForModal').eq(k).click(function(){
			// 		ImageClickFunction(k);
			// 	});
			// }

		// function ImageClickFunction(i){
		// 	alert("d??SDF?A?FD:::"+"몇"+i);
		// 	$('.modal').eq(i).css('display','block');
		// 	$('.modal-content').eq(i).attr("src",$(this).attr('src'));
		// }

		function ImageClickFunction(img0){
			//alert('sdf'+img0);
			$(img0).parent().find('.modal').css('display','block');
			$(img0).parent().find('.modal-content').attr('src',$(img0).attr('src'));
		}

		// $('.ImageForModal').eq(0).click(function(){
		// 	alert("df");
		// 	$('.modal').eq(0).css('display','block');
		// 	$('.modal-content').eq(0).attr("src",$(this).attr('src'));
		// //	$('.caption').eq(0).text($(this).attr('alt'));
		// });
		$('.modal').click(function(){	// 얘는 번째 쓸 필요 없을듯. 
			$(this).css('display','none');
		});