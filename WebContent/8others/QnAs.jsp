<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<title>자주하는 질문</title>



<div class="qa">

	<div class="t_title">자주 하는 질문</div>
	<div class="ques">
		<div class="q_titles">데일리 헬스는 어떤 사이트인가요?</div>
		<div class="q_texts">헬스, 트레이너를 집 안에서 간편하게 찾을 수 있지 않을까? 하는 물음에서 시작되 사이트입니다.</div>
	</div>
	<div class="ques">
		<div class="q_titles">트레이너, 헬스장 매칭 서비스를 주제로 한 이유는 무엇인가요?</div>
		<div class="q_texts">윤영 씨의 아이디어입니다.</div>
	</div>
	<div class="ques">
		<div class="q_titles">소모임을 만든 이유는 무엇인가요?</div>
		<div class="q_texts">만나서 운동할 사람 찾기가 너무 어렵고 힘들어서, 그냥 같이 운동만 하고
			쿨하게 헤어질 사람을 찾을 수 있다면 좋겠다는 아이디어입니다.</div>
	</div>
	<div class="ques">
		<div class="q_titles">어떠한 사람들이 만들었나요?</div>
		<div class="q_texts">김윤영, 반영인, 이재형이 2개월동안 웹을 배우고 2개월 동안 뚝딱뚝딱
			만들었습니다.</div>
	</div>
	<div class="ques">
		<div class="q_titles">기타 질문사항이 있습니다.</div>
		<div class="q_texts">다음으로 연락 주세요! : 01010101010101010...</div>
	</div>
</div>

<style type="text/css">
.t_title {
	font-size: 17px;
	font-weight: 600;
	color: rgb(150, 75, 0);
}

.qa {
	padding: 25px;
	width: 100%;
	max-width: 1000px;
	margin:25px auto;
	min-height: 800px;
}

.ques {
	padding: 5px;
	width: 100%;
	border-bottom: 1px solid silver;
}

.ques:first-child {
	border-top: 1px solid silver;
}

.q_titles {
	font-size: 15px;
	margin: 5px;
	font-weight: 550;
}

.q_texts {
	font-size: 13px;
	margin: 3px;
}
</style>


<script type="text/javascript">
	var ques = $('.ques');
	var q_ts = $('.q_titles');
	var q_tx = $('.q_texts');

	q_tx.each(function() {
		$(this).slideToggle(300);
	});

	q_ts.each(function() {
		$(this).click(function() {
			if ($(this).next().css('display') == 'none') {
				q_tx.each(function() {
					$(this).slideUp(300)
				});
				$(this).next().slideToggle(300);
			}
		});
	});
</script>
