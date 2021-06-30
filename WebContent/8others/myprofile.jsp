<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.team7.vo.MemberInfo1" %>
<%@ page import="com.team7.vo.PostBean" %>
<%@ page import="java.util.List" %>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="css/mypage.css?ver=<%=System.currentTimeMillis()%>">
<%
request.setCharacterEncoding("UTF-8");



List<MemberInfo1> minfo = (List<MemberInfo1>) request.getAttribute("minfo");

List<PostBean> cposts = (List<PostBean>) request.getAttribute("cposts");
%>
 <div class="myinfo">
    <div id="info0">
      <h4> 성함 : <%=minfo.get(0).getName() %></h4>
      <h4> ID : <%=minfo.get(0).getId() %> </h4>
      <h4> 이메일 : <%=minfo.get(0).getEmail() %> </h4>
      <h4> 주소 : <%=minfo.get(0).getAddress() %> </h4>
      <h4> 관심사 : <%=minfo.get(0).getInterest() %></h4>
      <h4> 가입일 : <%=minfo.get(0).getJoindate() %></h4>
      <div class="middler"><button type="button" name="button" class="btn" onclick="editpanel()">정보수정</button></div>
    </div>
    <div id="infoP">
      <form id="editForm" action="edit_info.mypage" method="post">
        <h4>성함 : <input id="name000" type="text" name="name" value="<%=minfo.get(0).getName() %>"> </h4>
        <h4>ID : <%=minfo.get(0).getId() %></h4>
        <!-- <input type="text" name="id" value="<%=minfo.get(0).getId() %>"> 
          아이디는 못 바꾼다. -->
  <% 
    String email = minfo.get(0).getEmail();
    String [] email2 = email.split("@");
    email = email2[0] ;
  %>
        <h4>이메일 : <%=minfo.get(0).getEmail() %></h4><!-- 
        <input type="text" name="email" value="<%=email %>"> @ 
        <select>
          <option></option>
          <option></option>
          <option></option>
        </select> -->
        <h4>주소 : <span id="addressSpan"></span> <br>
          <input type="text" id="sample4_postcode" placeholder="우편번호" maxlength="6" name="sample4_postcode">
          <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" >
          <input type="text" id="sample4_roadAddress" placeholder="도로명주소" readonly="true" class="sample4_roadAddress placeholder_gray" name="adress">
          <input type="text" id="sample4_jibunAddress" placeholder="지번주소" readonly="true" class="sample4_jibunAddress placeholder_gray" name="adress">
          <input type="text" id="sample4_detailAddress" placeholder="상세주소" class="" name="sample4_detailAddress">
        </h4>
        <h4>관심사 : 
          <input type="checkbox" name="interest" value="건강">건강   
          <input type="checkbox" name="interest" value="몸매">몸매  
          <input type="checkbox" name="interest" value="체중관리">체중관리
          <input type="checkbox" name="interest" value="식단조절">식단조절  
          <input type="checkbox" name="interest" value="다이어트">다이어트  
          <input type="checkbox" name="interest" value="근육 증가">근육 증가
        </h4>
      </form>
      <div class="middler">
        <button class="btn" onclick="editcancel()">취소</button>
        <button class="btn" onclick="editsave()">저장하기</button>
      </div>
    </div>
    </div>