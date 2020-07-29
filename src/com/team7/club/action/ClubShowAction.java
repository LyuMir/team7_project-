package com.team7.club.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.vo.ActionForward;
import com.team7.vo.PageInfo;
import com.team7.club.service.*;

public class ClubShowAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//request.getParameter("");
		

//		rlist = 
		PageInfo pageInfo = new PageInfo();
		
		new ClubService().club_selectorAll2(pageInfo);

		ActionForward forward= new ActionForward();
		forward.setPath("");
		return forward;
	}

}
