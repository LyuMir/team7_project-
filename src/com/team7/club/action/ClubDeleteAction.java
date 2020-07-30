package com.team7.club.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.club.service.ClubService;
import com.team7.vo.ActionForward;
import com.team7.vo.ClubBean;

public class ClubDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		String clubid = request.getParameter("clubid");

		ClubBean clubBean = new ClubBean();
		clubBean.setNo(Integer.parseInt(clubid));
		
		new ClubService().club_deletor(clubBean);
		ActionForward forward= new ActionForward();
		forward.setPath("id_Mng.club");
		return forward;
	}

}
