<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<link rel="stylesheet" type="text/css" href="css/mainmain88.css">
	<link rel="stylesheet" type="text/css" href="css/checkbox__.css">
<link rel="stylesheet" type="text/css" href="css/club_Create.css">


소모임 가입하기. 
<%
	String clubid = request.getParameter("clubid");
	request.setAttribute("clubid",clubid);
	String clubname = request.getParameter("clubname");
	//request.
	//<%=clubid  % >
		//< % = (String)request.g etAttribute("c lubid" )  >
%>
<form id="form1" method="post" action="enrollgo.club">
	<input type="hidden" name="clubid" value="<%=clubid%>">
	<table>

<!-- 		<thead>
			<td>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
			</td>
		</thead> -->
		<tr>
			<td>원하는 소모임 : </td>
			<td>이름 , 인원 </td>
		</tr>
		<!-- <input type="hidden" name="clubid" value=""> -->
		<tr>
			<td>소모임 :</td>
			<td>어디어디임. <br>무슨무슨임. </td>
		</tr>
		<tr>
			<td>운동 가능 시간대 : </td>
			<td><input type="text" name="etime"></td>
		</tr>
		<tr>
			<td>선호하는 운동 <br> 포지션, 경력, 실력 등 </td>
			<td><input type="text" name="wanttodo"></td>
		</tr>
		<tr>
			<td>한마디 :</td>
			<td><textarea name="memo"></textarea></td>
		</tr>
	</table>
</form>
<button onclick="joinmego()">가입신청하기 </button>
<button onclick="javascript:history.go(-1)">취소 및 뒤로가기 </button>

<script type="text/javascript">
	
	function joinmego(){
		var zz00 = confirm( '<%=clubname%>에 가입 신청 하시겠습니까?');
		if(zz00){

			$('#form1').submit();
		}
	}
</script>
