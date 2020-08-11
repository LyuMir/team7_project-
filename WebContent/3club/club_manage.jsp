<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.team7.vo.ClubBean" %>
<%@ page import="com.team7.vo.C_enroll_Bean" %>
<%@ page import="com.team7.vo.CmemberBean" %>
<%@ page import="java.util.List" %>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<%

request.setCharacterEncoding("UTF-8");
	String id = (String) session.getAttribute("LOG_ID");

List<ClubBean> rlist = (List<ClubBean>) request.getAttribute("rlist");
List<C_enroll_Bean> rlist_e = (List<C_enroll_Bean>) request.getAttribute("rlist_e");
List<CmemberBean> rlist_m = (List<CmemberBean>) request.getAttribute("rlist_m");

session.setAttribute("clubid",rlist.get(0).getNo());
%>



<main class="mainwrap">



	<table>
		<tr>
			<td>소모임 </td>
			<td><%=rlist.get(0).getName() %></td>
		</tr>
		<tr>
			<td>총 인원</td>
			<td><%=rlist_m.size() %></td>
		</tr>
		<tr>
			<td>현재 정회원 명단 </td>
			<td>
				<%for(int i = 0 ; i < rlist_m.size(); i++){ %>
				<%=rlist_m.get(i).getCmember() %> , 
				<%} %>
			</td>
		</tr>
<!-- 		<tr>
			<td>다음 모임일 </td>
			<td><%=rlist.get(0).getMeetingDate() %></td>
		</tr>
		<tr></tr> -->
	</table>
<!-- 	다음 모임일 : 
				<button>확정하기</button> -->
<br>
	<button class="clickhere">모든 구성원에게 알림 쪽지 보내기 </button>
	<div>
		<form>
			제목 <input type="text" name="zz">
	<br>
			내용 <textarea></textarea>
			<select>
				<option>이번주 모임은 </option>
				<option></option>
				<option></option>
				<option></option>
			</select>
		</form>
			<button>보내기 </button>
	</div>


<br>
	소모임 가입 신청자 : 
<form id="joingo00" action="managePro.club" method="post">
	<table>
		<thead>
			<tr>
				<th>신청일</th>
				<th>가입 희망자</th>
				<th>운동가능 시간대</th>
				<th>선호 운동 및 포지션</th>
				<th>한마디</th>
				<th>수락 / 거절</th>
			</tr>
		</thead>
		<% for(int i = 0 ; i < rlist_e.size(); i++){ %>
		<tr>
			<td><%=rlist_e.get(i) %></td>
			<td><%=rlist_e.get(i).getWanttobe() %></td>
			<td><%=rlist_e.get(i).getEtime()%></td>
			<td><%=rlist_e.get(i).getWanttodo() %></td>
			<td><%=rlist_e.get(i).getMemo() %></td>
			<td>
				<input class="jok" name="jok" type="checkbox" value="YouJoin:<%=rlist_e.get(i).getWanttobe() %>">
				<input class="jno" name="jno" type="checkbox" value="Decline:<%=rlist_e.get(i).getWanttobe() %>">
			</td>
		</tr>
		<% }  %>
	</table>
</form>
<form>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>가입일</th>
				<th>이름</th>
				<th>경고 주기</th>
				<th>탈퇴시키기</th>
			</tr>
		</thead>
<% for(int i = 0 ;  i <rlist_m.size(); i++){ %>
		<tr>
			<td><%=i+1 %></td>
			<td>"</td>
			<td><%=rlist_m.get(i).getCmember() %></td>
			<td>
				<input class="gg123" type="checkbox" name="gg123" value="<%=i%>">
			</td>
			<td>
				<input class="bb123" type="checkbox" name="bb123" value="<%=i%>">
			</td>
		</tr>
<%} %>
	</table>
</form>


	<button onclick="saveit()">저장</button>
	<button onclick="cancleit()">취소</button>

	<!-- <button> 관리 페이지로 </button> -->

</main>
<script type="text/javascript">
	var joks = $('input.jok');
	var jnos = $('input.jno');
	
	var gg123 = $('input.gg123');
	var bb123 = $('input.bb123');

	joks.each(function(idex,item){
		$(item).click(function(){
			if(	$(this).next().is(":checked") ){
				$(this).next().prop("checked", false);
			}
		});
	});
	jnos.each(function(index,item){
		$(item).click(function(){
			if( $(this).prev().is(":checked")){
				$(this).prev().prop("checked",false);
			}
		})
	});

	gg123.each(function(index,item){
		$(item).change(function(){
			if(this.checked){
				alert('그런가?');
				var con1= confirm('를 ..하시겠습니까?');
				if(con1){
					
				}
				else{
					this.prop("checked",false);
				}
			}
		});
	});


	$('.clickhere').each(function(idex,item){
			$(this).next().slideToggle(300);	//접힌 상태에서 시작 
		$(item).click(function(){
			//alert('d.?');
			//$(this).sibling('.turning');
			$(this).next().slideToggle(300);
		});
	});

	function saveit(){
		var confirmE = confirm("이대로 진행하시겠습니까?");
		if(confirmE){
			$('#joingo00').submit();
		}
	}

	function cancleit(){
		var confirmE = confirm("취소하시겠습니까?");
		if(confirmE){
			// $('form').each(function(){
			// 	this.reset();
			// });
			joks.each(function(){
				$(this).prop("checked",false);
			});
			jnos.each(function(){
				$(this).prop("checked",false);
			});
		}
	}

</script>

<style type="text/css">
	main *{
		font-size: 11.5px;
	}
	table{
		border: 1px solid silver;
	}
	table *{
		text-align: center;
	}
	th{
		/*min-width: 110px;*/
		/*border: 2px solid blue;*/
		max-width: 200px;
	}

	input[type="checkbox"]{

	}


	/* The container */
.container-checkbox {
    display: block;
    position: relative;
    padding-left: 35px;
    margin-bottom: 12px;
    cursor: pointer;
    font-size: 22px;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
}

/* Hide the browser's default checkbox */
.container-checkbox input {
    position: absolute;
    opacity: 0;
    cursor: pointer;
}

/* Create a custom checkbox */
.container-checkbox .checkmark {
    position: absolute;
    top: 0;
    left: 0;
    height: 25px;
    width: 25px;
    background-color: #eee;
}

/* On mouse-over, add a grey background color */
.container-checkbox:hover input ~ .checkmark {
    background-color: #ccc;
}

/* When the checkbox is checked, add a blue background */
.container-checkbox input:checked ~ .checkmark {
    background-color: #2196F3;
}

/* Create the checkmark/indicator (hidden when not checked) */
.container-checkbox .checkmark:after {
    content: "";
    position: absolute;
    display: none;
}

/* Show the checkmark when checked */
.container-checkbox input:checked ~ .checkmark:after {
    display: block;
}

/* Style the checkmark/indicator */
.container-checkbox .checkmark:after {
    left: 9px;
    top: 5px;
    width: 5px;
    height: 10px;
    border: solid white;
    border-width: 0 3px 3px 0;
    -webkit-transform: rotate(45deg);
    -ms-transform: rotate(45deg);
    transform: rotate(45deg);
}


/* The container */
.container-radio {
    display: block;
    position: relative;
    padding-left: 35px;
    margin-bottom: 12px;
    cursor: pointer;
    font-size: 22px;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
}

/* Hide the browser's default radio button */
.container-radio input {
    position: absolute;
    opacity: 0;
    cursor: pointer;
}

/* Create a custom radio button */
.container-radio .checkmark {
    position: absolute;
    top: 0;
    left: 0;
    height: 25px;
    width: 25px;
    background-color: #eee;
    border-radius: 50%;
}

/* On mouse-over, add a grey background color */
.container-radio:hover input ~ .checkmark {
    background-color: #ccc;
}

/* When the radio button is checked, add a blue background */
.container-radio input:checked ~ .checkmark {
    background-color: #2196F3;
}

/* Create the indicator (the dot/circle - hidden when not checked) */
.container-radio .checkmark:after {
    content: "";
    position: absolute;
    display: none;
}

/* Show the indicator (dot/circle) when checked */
.container-radio input:checked ~ .checkmark:after {
    display: block;
}

/* Style the indicator (dot/circle) */
.container-radio .checkmark:after {
 	top: 9px;
	left: 9px;
	width: 8px;
	height: 8px;
	border-radius: 50%;
	background: white;
}
</style>