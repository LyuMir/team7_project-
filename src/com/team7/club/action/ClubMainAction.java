package com.team7.club.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.vo.ActionForward;

public class ClubMainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//request.getParameter("");
		
		

		ActionForward forward= new ActionForward();
		forward.setPath("");
		return forward;
	}

}
