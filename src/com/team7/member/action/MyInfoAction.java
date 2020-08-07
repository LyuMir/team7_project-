package com.team7.member.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.member.service.MyInfoService;
import com.team7.post.service.PostClubService;
import com.team7.vo.ActionForward;
import com.team7.vo.CPostBean;
import com.team7.vo.MemberInfo1;
import com.team7.vo.MemberLogInfo;

public class MyInfoAction {

	public void toMyInfoPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String id = (String) request.getSession().getAttribute("LOG_ID");
		
		MemberLogInfo l = new MemberLogInfo();
		l.setId(id);
		
		List<MemberInfo1> minfo = new MyInfoService().myinfo(l);
		
		List<CPostBean> cposts = new PostClubService().getMyCPOSTs(id);
		
		request.setAttribute("minfo", minfo);
		request.setAttribute("cposts", cposts);
		

		RequestDispatcher dispatcher=
				request.getRequestDispatcher("8others/Personal_infomations.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	public void infoEdit(HttpServletRequest request, HttpServletResponse response) {
		
	}

}
