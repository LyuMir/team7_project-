<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


<main class="mainwrap">



	<table>
		<tr>
			<td>소모임 </td>
			<td>11</td>
		</tr>
		<tr>
			<td>총 인원</td>
			<td></td>
		</tr>
		<tr>
			<td>다음 모임일 </td>
			<td></td>
		</tr>
		<tr></tr>
	</table>
	다음 모임일 : 
				<button>확정하기</button>
<br>
				<button>모든 구성원에게 알림 쪽지 보내기 </button>
<br>
	소모임 가입 신청자 : 

	<table>
		<thead>
			<th>신청일</th>
			<th>가입 희망자</th>
			<th>운동가능 시간대</th>
			<th>선호 운동 및 포지션</th>
			<th>한마디</th>
			<th>수락 / 거절</th>
		</thead>
		<%  %>
		<tr>
			<td>1</td>
			<td>2</td>
			<td>3</td>
			<td>4</td>
			<td>5</td>
			<td>
				<input class="jok" type="checkbox" name="YouJoin:<>">
				<input class="jno" type="checkbox" name="Decline:<>">
			</td>
		</tr>
		<%   %>
	</table>



	<button>저장</button>
	<button>취소</button>

	<!-- <button> 관리 페이지로 </button> -->

</main>
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
		min-width: 110px;
		/*border: 2px solid blue;*/
	}
</style>