package com.team7.club.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.club.service.ClubService;
import com.team7.vo.ActionForward;
import com.team7.vo.ClubBean;
import com.team7.vo.MemberLogInfo;

public class MypageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ClubBean clubBean = new ClubBean();
		HttpSession session = request.getSession();
		clubBean.setAdmin((String)session.getAttribute("LOG_ID"));
		
		List<ClubBean> rlist = new ClubService().club_selector_id(clubBean);
		request.setAttribute("rlist", rlist);
		
		MemberLogInfo id = new MemberLogInfo();
		id.setId((String)session.getAttribute("LOG_ID"));
		List<ClubBean> rlist2 = new ClubService().club_selector_cmember(id);
		
		
		request.setAttribute("rlist2", rlist2);
		
		
		ActionForward forward= new ActionForward();
		forward.setPath("_FORWHERE.jsp?forwhere=3club/club_myClubs.jsp");
		return forward;
	}

}
