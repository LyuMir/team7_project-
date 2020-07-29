<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<%

request.setCharacterEncoding("UTF-8");
	String forwhat = request.getParameter("forwhat");


	String no = request.getParameter("no");
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	boolean editgo = false;
	
	if(forwhat.contains("edit")){
		editgo= true;
	}
%>

<div class="tablewrap">
    <table>
        <tr>
            <td class="tabletd"> 공지사항 쓰기 _</td>
        </tr>
        <tr>
            <td>
	        <% if(!editgo){ %>
            	<form method="post" action="write.notice" id="noticeit">
	                <table class="table2">
	                    <tr>
	                        <td>작성자</td>
	                        <td><input type=text name=writer size=20> </td>
	                    </tr>
	                    <tr>
	                        <td>제목</td>
	                        <td><input type=text name=title size=60></td>
	                    </tr>
	                    <tr>
	                        <td>내용</td>
	                        <td><textarea name=content cols=85 rows=15></textarea></td>
	       	<% }else{ %>
            	<form method="post" action="edit.notice" id="noticeit">
	                <table class="table2">
	                    <tr>
	                        <td>작성자</td>
	                        <td><input type=text name=writer size=20 value="<%=writer%>"> </td>
	                    </tr>
	                    <tr>
	                        <td>제목</td>
	                        <td><input type=text name=title size=60 value="<%=title%>"></td>
	                    </tr>
	                    <tr>
	                        <td>내용</td>
	                        <td><textarea name=content cols=85 rows=15><%=content %></textarea></td>
	       	<%	} %>
	                    </tr>
	                </table>
	                <input type="hidden" name="no" value="<%=no%>">
	                <input type="hidden" name="noticeType" id="noticeType">
            	</form>
            	<% if(forwhat.equals("write")){%>
                <button onclick="writeNotice()">
                	공지 입력
                </button>
                <%}else if(editgo){ %>
                <button onclick="editNotice()">
                	공지 수정
                </button>
                <%} %>
                <button onclick="toNotice()">
                	뒤로가기
                </button>
                <!-- &nbsp;&nbsp;<input type="reset" value="리셋">&nbsp;&nbsp; -->
            </td>
        </tr>
    </table>
</div>
<form style="display: none;" action="team_FORWHERE.jsp" method="post" id="toNotice">
	<input type="text" name="forwhere" value="notice_show_page.jsp">
</form>

<script type="text/javascript">
	
	function writeNotice(){
		$('#noticeType').val('write');
		$('#noticeit').submit();
	}

	function editNotice(){
		$('#noticeType').val('edit');
		$('#noticeit').submit();
	}

	function toNotice(){
		$('#toNotice').submit();
	}
</script>



<style>
    .tablewrap {
        width: 1000px;
        margin: 0 auto;
    }
    .tabletd{
        text-align: center;
        background-color: #ccc;
    }
    table.table2 {
        line-height: 1.5;
        border-top: 1px solid #ccc;
        margin: 20px 10px;
    }
    table.table2 tr {
        font-weight: bold;
        vertical-align: top;
        border-bottom: 1px solid #ccc;
    }
    table.table2 td {
        width: 100px;
        padding: 12px;
        vertical-align: top;
        border-bottom: 1px solid #ccc;
    }
</style>