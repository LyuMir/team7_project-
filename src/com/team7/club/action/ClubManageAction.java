package com.team7.club.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.club.service.ClubService;
import com.team7.vo.ActionForward;
import com.team7.vo.ClubBean;

public class ClubManageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		ClubBean clubBean = new ClubBean();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("LOG_ID");
		clubBean.setAdmin(id);
		
		List<ClubBean> rlist = new ClubService().club_selector_id(clubBean);
		request.setAttribute("rlist", rlist);
		
		ActionForward forward= new ActionForward();
		forward.setPath("_FORWHERE.jsp?forwhere=3club/club_createNedit.jsp");
		return forward;
	}

}
