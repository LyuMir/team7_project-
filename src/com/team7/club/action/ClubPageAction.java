package com.team7.club.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.club.service.ClubService;
import com.team7.controller.ClubController;
import com.team7.vo.*;

public class ClubPageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//request.getParameter("");
		
		String club_id = request.getParameter("clubid");
		ClubBean clubBean = new ClubBean();
		clubBean.setNo(Integer.parseInt(club_id));
		
		List<ClubBean> rlist = new ClubService().club_selector_no(clubBean);

		request.setAttribute("rlist", rlist);
		request.setAttribute("rlist00", rlist);
				System.out.println(rlist.get(0).getAdmin());
				System.out.println(rlist.get(0).getMeetingDate());
				
		ActionForward forward= new ActionForward();
		forward.setPath("_FORWHERE.jsp?forwhere=3club/club_main.jsp");
		return forward;
	}

}
