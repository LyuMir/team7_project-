<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="daos.Class_DAO" %>
<%@ page import="dtos.Class_DTO_ClubProperties" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.*" %>

    <link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/mainmain88.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700" rel="stylesheet">
    <link rel="stylesheet" href="css\grt-responsive-menu.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="js\grt-responsive-menu.js?v=<%=System.currentTimeMillis()%>"></script>

<%
request.setCharacterEncoding("UTF-8");

    String log_id = (String) session.getAttribute("LOG_ID");
    Integer log_st = (Integer) session.getAttribute("LOG_STATUS");
    
    
//    Date date = new Date();
//	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//    System.out.println(dateFormat.format(date));

	
	String no = request.getParameter("no");
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String n22 = request.getParameter("n22");


	dtos.Class_DTO_i iii = new dtos.Class_DTO_i();
	iii.setI(Integer.parseInt(no));
	List<dtos.Class_DTO_Notice> rlist  = new Class_DAO().notice_selectThatone(iii);
	
	
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
	게시글 여기 
	
	<br>
	제목 : <%=rlist.get(0).getTitle() %>
	
	<br>
	작성자 : <%=rlist.get(0).getWriter() %>	
	
	<br>
	일자 : <%=dateFormat.format( rlist.get(0).getNdate() )%>
	
	<br>
	내용 : <%=rlist.get(0).getContent() %>
	
	<br>
	<form action="team_FORWHERE.jsp" method="post">
		<input type="hidden" name="forwhere" value="notice_show_page.jsp">
		<button>뒤로가기 </button>
	</form>
	
	<!-- 관리자에게만 보이는 div  -->
	<% if(adminyn){ %>
	<div class="">
		<form action="team_FORWHERE.jsp" method="post">
			<input type="hidden" name="forwhere" value="notice_writeNedit_page.jsp">
			<input type="hidden" name="title" value="<%=rlist.get(0).getTitle() %>">
			<input type="hidden" name="writer" value="<%=rlist.get(0).getWriter() %>">
			<!-- <input type="hidden" name="content" value=""> -->
			<textarea style="display: none;" name="content"><%=rlist.get(0).getContent() %></textarea>
			<!-- 솔직히 수정페이지 가서 db 접근 해도 되는데 그냥 보내자.. -->
			<input type="hidden" name="no" value="<%=no%>">
			<input type="hidden" name="forwhat" value="edit">
			<button>수정하기 </button>
		</form>
		<form action="notice_delete.jsp" method="post">
			<input type="hidden" name="no" value="<%=no%>">
			<button>삭제하기 </button>
		</form>
	</div>
	<% } %>
	
</div>

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
</style>