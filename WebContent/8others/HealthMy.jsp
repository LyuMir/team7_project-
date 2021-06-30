 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.team7.vo.Gym_info" %>
<%@ page import="com.team7.vo.PostBean" %>
<%@ page import="com.team7.vo.PhotoBean" %>
<%@ page import="java.util.List" %>
<%@ page import="com.team7.vo.ZZIMBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%
	request.setCharacterEncoding("UTF-8");
	String id = (String) session.getAttribute("LOG_ID");

	int adminyn=0, joinyn=0;

List<PostBean> cposts = (List<PostBean>) request.getAttribute("cposts");
List<ZZIMBean> cpostzzim = (List<ZZIMBean>) request.getAttribute("cpostzzim");


List<Gym_info> ginfo = (List<Gym_info>) request.getAttribute("ginfo");
List<ZZIMBean> gz = (List<ZZIMBean>) request.getAttribute("gz");


//int j = cpphotos.size() -1 ;
//ArrayList<Integer> ppnum = new ArrayList<Integer>();
//ArrayList<Integer> pp00 = new ArrayList<Integer>();
//int u = j;
//for(int k = j ; k >=0 ; k--){
//	String pid = cpphotos.get(k).getId();
//	int last0 = pid.lastIndexOf("_");
//	pid = pid.substring(last0 + 1);
//	ppnum.add(Integer.parseInt(pid));
//	pp00.add(u--);
//}


%>



<!--End jSide Menu-->
  <!--  이 아래부분만 바뀌면 됩니다 -->
  <!-- 태그 불러오기입니다 -->

 <% boolean heartgood = true;
		
			
	%>
<menu class="myprofile">
  <p class="title">내가 즐겨찾기한 헬스장</p>
  <h1>나와라좀 나와라!!!!!!!!</h1>
  <input style="margin-left: 10px;" type="checkbox" name="" value=""> 
  
  <% 
  boolean hasE = false;
  if(ginfo == null || ginfo.size()<1){

  }
  else{
    hasE = true;
  }

%>
   <% if(!hasE){ %>
   찜목록이 없습니다!
   
   <%}else{ %> 
  <% for(int i = 0 ; i < ginfo.size(); i++){ %>
  <ul>
    <li> </li>
    <li>
        <div class="thunbox">
         <img class="profile_img2" src="img/trainer.jpeg">
         <div class="marginleft">
       
        <h3><%= ginfo.get(i).getGid() %>><%= ginfo.get(i).getGsmalltext() %></h3>
       
        
        <h4><%= ginfo.get(i).getGname() %></h4>
        
        <!-- 태그불러오기입니당 -->
        <% 
String imsitag = ginfo.get(0).getGprogram() ;
String [] major = imsitag.split(",");

for (int k=0 ; k < major.length ; k ++) { 

	if(major[k].equals("")){
	
	}else{

%>
		</h4>
        <h5>#<%= major[k] %></h5>
        <p class="grade"><a href="d">♥</a></p>
      </div>

    </li>
  </ul>
  <% }}}} %>




  <button type="button" name="button" class="btn">삭제하기</button>

</div>
</div>

</menu>

