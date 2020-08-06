

//var log_status = (Integer) session.getAttribute("LOG_STATUS");

setTimeout(zzimshow3(),1000);

// setTimeout(zzimshow3_button(),1100);


function zzimshow3(){
    //alert('여기 실행?');
    // $('.zzimSystem').each(function(index,item){
    //     Zzimshow_club($(item));
    // });
    var arrid = new Array();
    var arrcount = new Array();
    var arrzzimed = new Array();
    var datasss = Zzimshow_club();

    for(var i = 0 ; i < datasss.children('div').length; i++){
        arrid[i] = datasss.children('div').eq(i).attr('id');
        arrcount[i] = datasss.children('div').eq(i).data('count');
        arrzzimed[i] = datasss.children('div').eq(i).data('zzimed');
    }


    $('.zzimSystem').each(function(index,item){

        for(var i = 0 ; i < arrid.length; i++){
            if($(item).data('id') == arrid[i]){

                if(arrzzimed[i] == 1){
                    changeHTMLs($(item),1);
                }


                if($(item).children('span') !=null){
                    $(item).children('span').data('target',arrcount[i] + 50);
                }
            }
        }
    });
}

// function zzimshow3_button(){
//     $('#z_zzim1').each(function(index,item){
//         Zzimbuttonshow_club($(item));
//     });
// }

const counters = $('.counter');
const speed = 1000;
counters.each(function(index,item){
    var speed = $(item).data('target');
    // function counter00(){
            function updateCount(){
            var target = +$(item).data('target');
            var count = +$(item).text();

            const inc = target / speed;

            if(count < target -30){
                $(item).text(count + inc);
                setTimeout(updateCount,40);
            }
            else if(count < target-10){
                $(item).text(count + inc);
                setTimeout(updateCount,90);
            }
            else if(count < target){
                $(item).text(count + inc);
                setTimeout(updateCount,180);
            }
            else{
                $(item).text(target);
            }
        }

        updateCount();
    // }


});


// const counters = document.querySelectorAll('.counter');
// const speed = 50; // The lower the slower

// counters.forEach(counter => {
//     const updateCount = () => {
//         const target = +counter.getAttribute('data-target');
//         const count = +counter.innerText;

//         // Lower inc to slow and higher to slow
//         const inc = target / speed;

//         // console.log(inc);
//         // console.log(count);

//         // Check if target is reached
//         if (count < target) {
//             // Add inc to count and output in counter
//             counter.innerText = count + inc;
//             // Call function every ms
//             setTimeout(updateCount, 1);
//         } else {
//             counter.innerText = target;
//         }
//     };

//     updateCount();
// }); // https://morioh.com/p/bd6b4702d394

function Zzimshow_club(){
    var url = "club.zzimshow";
    var datasss;
    $.ajax({
        type:"GET",
        url:url,
        async:false,
        dataType:"html",
        success : function(data){
            datasss = $(data);
        }
    })
    return datasss;
}


// function Zzimbuttonshow_club(req){
//     var url = "clubbutton.zzimshow";
//     var zzimnumber =0;
//     var zzimpeople ="";
//     var youzzim = false;
//     $.ajax({
//         type:"GET",
//         url:url,
//         async:false,
//         dataType:"html",
//         data:{
//           clubid : $(req).data('id'),
//           person : $(req).data('person')
//         },
//         success : function(data){
//             //alert('ajax GET 통신 성공'+data);
//             // alert($(data).data('number'));
//             // alert($(data).data('people'))
//             zzimnumber= $(data).data('number');
//             zzimpeople= $(data).data('people');
//             youzzim = $(data).data('youzzim');
//         },
//     })

//     if(youzzim){
//         changeHTMLs($(req),1);
//     }
//     else if(!youzzim){
//         changeHTMLs($(req),0);
//     }

//     if($(req).children('span.counter') !=null)
//         $(req).children('span').data('target',zzimnumber+50);
// }


function changeHTMLs(req,go =1){
    if(go ==1){
        $('button#z_zzim1:contains("찜하기 ")').html("찜 취소 <img src='img/heart_and_star/heart34.png'>");
        $(req).children('img').attr('src','img/heart_and_star/heart34.png');
        $(req).removeAttr("onclick");
        $(req).attr('onclick',"Zzim_cancle_club(this)");

    }
    else{
        $('button#z_zzim1:contains("취소")').html("찜하기 <img src='img/heart_and_star/heart034.png'>"); //여기서 하는게 아닌가...?
        $(req).children('img').attr('src','img/heart_and_star/heart034.png');
        $(req).removeAttr("onclick");
        $(req).attr('onclick',"Zzim_club(this)");

    }
}

// function sophone(req,youzzim){
//         alert('?'+youzzim);
//         if(youzzim){
//           $(req).children('img').src('img/heart34.png');
//           alert('여기다 여기');
//         }
//         if(youzzim && $(req).text()=="찜하기 <img src='img/heart034.png'>"){
//             $(req).text("찜 취소 <img src='img/heart34.png'>");
//             alert('여기다 여기33');
//         }
//         else if(!youzzim && $(req).text()=="찜 취소 <img src='img/heart34.png'>"){
//             $(req).text("찜하기 <img src='img/heart034.png'>"); //여기서 하는게 아닌가...?
//             alert('여기다 여기44');
//         }
//     }


function Zzim_club(req){
    var url = "club.zzim";
    var zzimnumber = 0 ; 
    //alert('넣는중.. '+$(req).data('id'));

    //alert(log_status+"로그인?? 되었??");
    if(log_status !=1){
        alert('로그인해주세요!!');
    }
    else{


        $.ajax({
            type:"GET",
            url:url,
            dataType:"html",
            data:{
              clubid : $(req).data('id'),
              //person : $(req).data('person')
            },
            success : function(data){
                //alert('ajax GET 통신 성공'+data);
                // alert($(data).data('number'));
                // alert($(data).data('people'))
                // zzimnumber= $(data).data('number');
                // zzimpeople= $(data).data('people');
                // youzzim = $(data).data('youzzim');
            },
        })

        changeHTMLs($(req),1);
    }
}

function Zzim_cancle_club(req){
    var url = "club_drop.zzim";
    $.ajax({
        type:"GET",
        url:url,
        dataType:"html",
        data:{
          clubid : $(req).data('id'),
          //person : $(req).data('person')
        },
        success : function(data){

        },

    })
    changeHTMLs($(req),0);
}