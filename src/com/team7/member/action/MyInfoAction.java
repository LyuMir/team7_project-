package com.team7.member.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.member.service.MyInfoService;
import com.team7.post.service.PostService;
import com.team7.vo.ActionForward;
import com.team7.vo.PostBean;
import com.team7.vo.MemberInfo1;
import com.team7.vo.MemberLogInfo;

public class MyInfoAction {

	public void toMyInfoPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String id = (String) request.getSession().getAttribute("LOG_ID");
		
		MemberLogInfo l = new MemberLogInfo();
		l.setId(id);
		
		List<MemberInfo1> minfo = new MyInfoService().myinfo(l);
		
		List<PostBean> cposts = new PostService().getMyCPOSTs(id);
		
		request.setAttribute("minfo", minfo);
		request.setAttribute("cposts", cposts);
		

		RequestDispatcher dispatcher=
				request.getRequestDispatcher("_FORWHERE.jsp?forwhere=8others/Mypage.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	public void infoEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String postcode = request.getParameter("sample4_postcode22");
		String adress = request.getParameter("adress");
		String dadress = request.getParameter("sample4_detailAddress");
		String interest = request.getParameter("interest");
		
		MemberInfo1 minfo = new MemberInfo1();
		minfo.setAddress(adress+dadress);
		minfo.setAddress_num(postcode);
		minfo.setName(name);
		minfo.setInterest(interest);
		
		new MyInfoService().myinfoedit(minfo);

		RequestDispatcher dispatcher=
				request.getRequestDispatcher("myinfo.log");
		dispatcher.forward(request, response);
	}

}
