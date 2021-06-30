<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="com.team7.vo.PostBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.*" %>
확인용 확인용
<% request.setCharacterEncoding("UTF-8"); ;
List<PostBean> gym = (List<PostBean>) request.getAttribute("gym");

%>
ajax 텍스트 없이 기초jsp활용 합니다

<%= gym %>

<button onclick="postGetter()">자료보기 </button>

<script type="text/javascript">


function postGetter(){
    var url = "TestindexPosts.post";
    
    var datasss;
    $.ajax({
    	alret('먼지참');
    
        type:"GET",
        url:url,
        async:false,
        dataType:"html",
        success : function(data){
            datasss = $(data);
            alret('먼지참');
        }
    })

 </script>   