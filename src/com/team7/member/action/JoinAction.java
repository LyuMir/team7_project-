package com.team7.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.member.service.JoinService;
import com.team7.vo.ActionForward;
import com.team7.vo.MemberInfo1;

public class JoinAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//근데 사실 저 앞에서 이미 검사가 끝나서 그냥 DB에 넣기만 하면 됨. .....
		
	    String id =request.getParameter("id");
	    String name =request.getParameter("name");
	    String nickname ="nickname"; //닉네임 바꾸기 ! 
	    String email =request.getParameter("email");
	    String pw =request.getParameter("pw");
	    String type =request.getParameter("join_type");
	    String address_num =request.getParameter("sample4_postcode");
	    String address1 =request.getParameter("sample4_roadAddress22"); 
	    String address2 =request.getParameter("sample4_jibunAddress22");  
	    String address3 =request.getParameter("sample4_detailAddress");
	    // String [] address =request.getParameterValues("address");
	    String [] interest =request.getParameterValues("interest");
	    String interest0 = null;
	    if(interest !=null){ // 굿

	        for(int ii = 0 ; ii < interest.length ; ii++){
	            interest0 = interest0 +"_"+ interest[ii];
	        }
	    }
	    
		MemberInfo1 info = new MemberInfo1();
		info.setAddress(address1+address2+address3);
		info.setAddress_num(address_num);
		info.setEmail(email);
		info.setId(id);
		info.setInterest(interest0);
//		info.setJoindate(joindate);
//		info.setLogdate(logdate);
		info.setName(name);
		info.setNickname(nickname);
		info.setPw(pw);
		info.setState("신규회원");
		
		
		new JoinService().joingo(info);
		
		return null;
	}

}