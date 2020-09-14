<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.team7.vo.ClubBean"%>
<%@ page import="com.team7.vo.CmemberBean"%>
<%@ page import="java.util.List"%>

<link rel="stylesheet" type="text/css" href="css/mainmain88.css">
<link rel="stylesheet" type="text/css" href="css/checkbox__.css">
<link rel="stylesheet" type="text/css" href="css/club_Create.css">

<div class="mainwrap">
	<div class="titler">
		소모임 가입하기.
	</div>
	<%
	request.setCharacterEncoding("UTF-8");
	String clubid = request.getParameter("clubid");
	request.setAttribute("clubid", clubid);
	String clubname = request.getParameter("clubname");

	List<ClubBean> rlist = (List<ClubBean>) request.getAttribute("rlist");
	List<CmemberBean> members = (List<CmemberBean>) request.getAttribute("mlist");
	//request.
	//<%=clubid  % >
	//< % = (String)request.g etAttribute("c lubid" )  >
%>
	<form id="form1" method="" action="enrollgo.club">
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
				<td>대상 소모임 정보:</td>
				<td>소모임 이름 : <%=rlist.get(0).getName()%> , 총 인원수 : <%=members.size()%>
					<br> 인원 : <%
						for (int i = 0; i < members.size(); i++) {
					%> <%=members.get(i).getCmember()%>
					, <%
 	}
 %> <br> 장소 : <%=rlist.get(0).getArea()%> <br>메인 운동
					종류 : <%=rlist.get(0).getE_type()%>
				</td>
			</tr>
			<tr>
				<td>운동 가능 시간대 :</td>
				<td><input type="text" name="etime"></td>
			</tr>
			<tr>
				<td>선호하는 운동 <br> 포지션, 경력, 실력 등
				</td>
				<td><input type="text" name="wanttodo"></td>
			</tr>
			<tr>
				<td>한마디 :</td>
				<td><textarea name="memo"></textarea></td>
			</tr>
		</table>
	</form>
	<button onclick="joinmego()">가입신청하기</button>
	<button onclick="javascript:history.go(-1)">취소 및 뒤로가기</button>
</div>
<script type="text/javascript">

	function joinmego(){
		var zz00 = confirm( '<%=rlist.get(0).getName()%>
	에 가입 신청 하시겠습니까?');
		if (zz00) {
			//alert($('input').eq(1).val());
			//alert($('input').eq(2).val());
			//alert($('textarea').val());
			$('#form1').submit();
		}
	}
</script>
