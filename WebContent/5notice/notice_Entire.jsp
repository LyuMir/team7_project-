<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.team7.vo.DTO_Notice" %>
<%@ page import="com.team7.vo.PageInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.*" %>
<!-- 
    <link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/mainmain88.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700" rel="stylesheet">
    <link rel="stylesheet" href="css\grt-responsive-menu.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="js\grt-responsive-menu.js?v=<%=System.currentTimeMillis()%>"></script> -->

<%
request.setCharacterEncoding("UTF-8");

    String log_id = (String) session.getAttribute("LOG_ID");
    Integer log_st = (Integer) session.getAttribute("LOG_STATUS");
    
    
//    Date date = new Date();
//	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//    System.out.println(dateFormat.format(date));


	//List<DTO_Notice> rlist  = new Class_DAO().notice_selectorAll();
		List<DTO_Notice> rlist  = (List<DTO_Notice>)request.getAttribute("rlist");

		
	boolean adminyn = false;
	if(log_id == null){
		
	}
	else{
		if(log_id.equals("admin")){
			adminyn = true;
			//out.println("??? 여기까지는 오냐?");
		}
	}

%>

<div class="mainwrap">
	<div class="big_title">
		공지사항
	</div>

	<table>
		<thead>
			<tr>
				<!-- <th>게시번호</th> -->
				<th class="title">제목</th>
				<th>글쓴이</th>
				<th>수정일</th>
			</tr>
		</thead>
<% for(int i = rlist.size()-1 ; i >=0; i--){ // 아시다시피, 최신 것이 위에 나오도록 해야 합니다. %>
				<tr class="rowsOfT oneNotice">
					<td style="display: none;"><%=rlist.get(i).getNo() %></td>
					<td><%=rlist.get(i).getTitle() %></td>
					<td><%=rlist.get(i).getWriter() %></td>
					<td><%= dateFormat.format( rlist.get(i).getNdate() )%>  </td>
					<td style="display: none;">
						<form action="team_FORWHERE.jsp" method="post" data-name="d">
							<input type="hidden" name="forwhere" value="notice_thatone.jsp">
							<input type="hidden" name="no" value="<%=rlist.get(i).getNo() %>">
						</form>
						<!-- 알고 보니 td 사이에 끼어넣었어야.. -->
					</td>
				</tr>
<% } %>
	</table>
	<div class="">
		<span><</span>
		<span>1</span>
		<span>2</span>
		<span>3</span>
		<span>4</span>
		<span>5</span>
		<span>...</span>
		<span>></span>
	</div>
	<!-- 관리자에게만 보이는 div  -->
	<% if(adminyn){ %>
	<div class="">
		<form action="team_FORWHERE.jsp" method="post">
			<input type="hidden" name="forwhere" value="notice_writeNedit_page.jsp">
			<input type="hidden" name="forwhat" value="write">
			<button>글쓰기 </button>
		</form>
	</div>
	<% } %>
</div>

<script type="text/javascript">

	$('tr.oneNotice').each(function(index,item){
		$(item).click(function(){
			//alert('ddd');
			//alert($(this).parent('form').data('name'));
			//alert($(this).children('td').eq(1).text()); //이건 또 잘 잡히네?
			$(this).find('form').submit();
		});
	});
	
	function showthieNotice(req){
		$(req).parent('form').submit();
	}

</script>

<style type="text/css">
	.big_title{
		margin: 30px;
		margin-left: 0;
		font-size: 23px;
	}
	table *{
		/*border: 1px solid silver;*/
		font-size: 15px;
	}
	thead *{
		font-size: 17px;
		font-weight: 900;
		color: black;
	}
	thead tr{
		/*border-top: 2px solid black;*/
		background-color: var(--silver-color-4);
	}
	table{
		/*max-width: 900px;
		width: 100%;
		width: 800px;*/
		min-width: 400px;
	}
	td{
		margin: none;
		height: 45px;
		padding: 0 15px;
		border-bottom: 2px solid silver;
		text-align: center;

	}
	td:first-child{
		text-align: left;
	}
	th:last-child{
		width: 15%;
		max-width: 150px;
	}
	.title{
		padding-left: 15px;
		text-align: left;
		width: 70%;
	}
	.oneNotice{

	}
	.oneNotice:hover{
		background-color: rgba(211,211,211,0.5);
	}
</style>